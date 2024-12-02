package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 50005;
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket= null;
		List<Writer> listWriters;
		try {
			serverSocket = new ServerSocket();
			listWriters = new ArrayList<Writer>();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			System.out.println("연결 기다림...[port:"+PORT+"]");
		
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				System.out.println("[error] socket close" + e);
			}
		}
	}

}
