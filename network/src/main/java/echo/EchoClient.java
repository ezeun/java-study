package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.25";
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
		
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));
			
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if(readByteCount == -1) {
				log("closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "utf-8");
			log("received:"+data);
			
		}catch(SocketException e) {
			log("Socket Exception" +e);
		} catch (IOException e) {
			log("error:"+e);
		} finally {
			try {
				if(socket!=null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void log(String message) {
		System.out.println("[Echo Client] " + message);
	}

}
