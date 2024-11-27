package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("> ");
			String s = sc.nextLine();
			if(s.equals("exit")) break;
			
			try {
				InetAddress[] InetAddresses = InetAddress.getAllByName(s);
			
				for(InetAddress inetAddress : InetAddresses) {
					System.out.print(s+" : ");
					System.out.println(inetAddress.getHostAddress());
				}
			
			} catch (UnknownHostException e) {

				e.printStackTrace();
			}
		}
		
		sc.close();
	}

}
