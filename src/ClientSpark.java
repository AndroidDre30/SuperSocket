import java.net.*;
import java.io.*;
import java.lang.*;
public class ClientSpark {
	public static void main(String args[]) {
		try {
			Socket skt = new Socket("",4444);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			
			while(!in.ready()) {
				System.out.println(in.readLine());
				System.out.println("\n");
				in.close();
				skt.close();
			}
		}
		
		catch(Exception e) {
			System.out.println("Oh man! It didn't work!");
		}
		
	}

}
