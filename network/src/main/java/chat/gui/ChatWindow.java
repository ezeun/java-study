package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import chat.ChatServer;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private Socket socket = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	
	private String nickname="";
	
	public ChatWindow(String name) {
		this.nickname = name;
		frame = new Frame(name); //윈도우창 
		pannel = new Panel(); //아래쪽에 TextField를 포함하는 곳
		buttonSend = new Button("Send"); //전송 버튼
		textField = new TextField(); //아래쪽에 글씨 입력하는 곳(pw에 쓴 것)
		textArea = new TextArea(30, 80); //위쪽에 채팅 뜨는 곳(br로 읽은 것)
	}

	public void show() {
		
		connectServer();
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() { //anonymous 클래스
			@Override
			public void actionPerformed( ActionEvent actionEvent ) { 
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
	}
	
	private void connectServer() {
		try {
			// 1. 서버 연결 작업
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", ChatServer.PORT));
	
			// 2. IO Stream Set 
	        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
	  
			// 3. join 프로토콜
	        pw.println("join:" + nickname);
//	        pw.flush();
	        
			// 4. ChatClientThread 생성
	        new ChatClientThread(br).start();
	        
		}catch (IOException e) {
			System.out.println("error:"+e);
		} 
	}
	
	private void sendMessage() {
		String message = textField.getText();
        pw.println("message:" + message);
//        pw.flush();
		
//        updateTextArea(nickname + ">>" + message);
        
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		try {
			// quit 프로토콜 구현 
	        pw.println("quit:");
//	        pw.flush();
	        if (socket != null && !socket.isClosed()) {
	            socket.close();
	        }
		}catch (IOException e) {
            System.out.println("종료 중 오류 발생: " + e.getMessage());
        }
	        
		// exit java application 
		System.exit(0); // x 클릭하면 창 닫힘
	}
	
	//Thread를 inner class로 만들어야 private updateTextArea()에 접근 가능
	private class ChatClientThread extends Thread {

		BufferedReader br = null;
		
		public ChatClientThread(BufferedReader br) {
			this.br = br;
		}
		
		@Override
		public void run() {
			String line = null;
			try {
				while((line = br.readLine())!=null) {
					updateTextArea(line);
					System.out.println(line);
				}
				if(line == null) {
					System.out.println("closed by server");
					finish();
				}
			} catch (IOException e) {
				System.out.println("error!!! " + e);
			} 
		}
		
	}
	
}
