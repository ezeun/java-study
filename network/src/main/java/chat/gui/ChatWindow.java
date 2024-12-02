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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name); //윈도우창 
		pannel = new Panel(); //아래쪽에 TextField를 포함하는 곳
		buttonSend = new Button("Send"); //전송 버튼
		textField = new TextField(); //아래쪽에 글씨 입력하는 곳(pw에 쓴 것)
		textArea = new TextArea(30, 80); //위쪽에 채팅 뜨는 곳(br로 읽은 것)
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() { //anonymous 클래스
			@Override
			public void actionPerformed( ActionEvent actionEvent ) { 
				sendMessage();
			}
		});
//		buttonSend.addActionListener( //함수를 파라미터로 넘길 수 없음
//				(ActionEvent actionEvent) -> {}
//		);

		// Textfield
		textField.setColumns(80);

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
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// 1. 서버 연결 작업
		// 2. IO Stream Set 
		// 3. join 프로토콜
		// 4. ChatClientThread 생성
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현!:"+message);
	}
}
