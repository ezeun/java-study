package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {

	BufferedReader br = null;
	public ChatClientThread(BufferedReader br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		String line = null;
		try {
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
