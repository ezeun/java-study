package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 50000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); //다 열어놓기 
			log("starts...[port:"+PORT+"]");
			
			Socket socket = serverSocket.accept();
			
			try {
				InetSocketAddress inetRemoteSocetAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocetAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocetAddress.getPort();
				
				log("connected by client["+remoteHostAddress+":"+remotePort+"]");				

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				
				while(true) {
					String data = br.readLine();
					if(data == null) {
						log("closed by client");
						break;
					}
					
					log("received:" + data);
					pw.println(data);
				}
			} catch(SocketException e) {
				log("Socket Exception" +e);
			}  catch(IOException e) {
				log("error:"+e);
			}finally {
				try {
					if(serverSocket != null && !serverSocket.isClosed())
						socket.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			log("error:"+e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Echo Server] " + message);
	}
}
