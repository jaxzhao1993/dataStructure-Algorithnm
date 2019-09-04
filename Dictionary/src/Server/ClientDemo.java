package Server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {
	public static final String ipAddress="localhost";
	public static final int port = 12306;
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(ipAddress, port);
		DataInputStream input = new DataInputStream(socket.getInputStream());  
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		String toServer = "apply to connect";
		out.writeUTF(toServer);
		while(true)
		{
			String fromServer = input.readUTF();
			System.out.println("from Server:" + fromServer);
	        
	        toServer =new BufferedReader(new InputStreamReader(System.in)).readLine();
			if (toServer.equals("exit")) {
				out.writeUTF(toServer);
				break;
			}
			out.writeUTF(toServer);
		}
		input.close();
		out.close();
		socket.close();
	}
}
