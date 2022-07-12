import java.net.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.io.*;
import java.lang.*;
public class ServerShock {
	public static void main(String args[]) {
		
		try {
			ServerSocket s = new ServerSocket(4444);
			Stream.generate(()->{
				try {
					return s.accept();
				} catch (IOException e) {					
					e.printStackTrace();
				}
				return null;
			}).forEach((skt)->{
				try {
					Handler(skt);
				} catch (IOException e) {					
					e.printStackTrace();
				}
			});
			
		    
			//Handler(skt);
			//s.close();
		}
		
		catch(Exception e) {
			System.out.println("Oh Man! It didn't work!\n");
			e.printStackTrace();
		}
	}

	private static void Handler(Socket skt) throws IOException {
		String data= "Connection established.";
		System.out.println("connection connected.\n");
		System.out.println (new String(skt.getInputStream().readAllBytes()));
		skt.close();
	}

}
