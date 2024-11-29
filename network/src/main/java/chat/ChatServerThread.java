package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) throws Exception {
		this.socket = socket;
		this.listWriters = listWriters;
		this.br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8 ));
		this.pw =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8 ), true);
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String request = br.readLine();
				if(request == null) {
					System.out.println("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				}
				else {
					System.out.println("에러: 알 수 없는 요청("+tokens[0]+")");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//입장
	private void doJoin(String nickname, Writer writer) {
	   this.nickname = nickname;
		
	   String data = nickname + "님이 참여하였습니다."; 
	   broadcast( data );
			
	   addWriter( writer );
	}
	private void addWriter( Writer writer ) {
	   synchronized( listWriters ) {
	      listWriters.add( writer );
	   }
	}
	private void broadcast( String data ) {
	   synchronized( listWriters ) {
	      for( Writer writer : listWriters ) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println( data );
				printWriter.flush();
	      }
	   }
	}

	
	//채팅
	private void doMessage(String message) {
	   String data = nickname + ">> " + message; 
	   broadcast( data );
	}
	
	//퇴장
	private void doQuit(Writer writer) {
	   removeWriter( writer );
		
	   String data = nickname + "님이 퇴장 하였습니다."; 
	   broadcast( data );
	}
	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}
}
