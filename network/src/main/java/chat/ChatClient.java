package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args){
		Scanner sc = null;
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			sc = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", ChatServer.PORT));
	
	        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	  
	        System.out.print("닉네임>>");
	        String nickname = sc.nextLine();
	        pw.println("join:" + nickname);
	        pw.flush();
	        
	        // 서버가 보내준 메세지 읽어서 화면에 출력하기(백그라운드)
	        new ChatClientThread(br).start();
	        
	        while(true) {
	        	String input = sc.nextLine();
	        	
	        	if("quit".equals(input)) {
	                pw.println("quit:");
	                pw.flush();
	                break;
	        	}else {
	                pw.println("message:" + input);
	                pw.flush();
	        	}
	        }
        
		} catch (IOException e) {
			System.out.println("error:"+e);
		} finally {
			try {
				if(sc != null)
					sc.close();
				if(socket!=null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				System.out.println("error " + e);
			}
		}
	}

}
