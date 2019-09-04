package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

public class ServerDemo {
	
	private static int port = 12306;
	// Identifies the user number connected
	private static int counter = 0;
	public static void execute() {
		ServerSocketFactory factory = ServerSocketFactory.getDefault();
		try {
			ServerSocket serverSocket = factory.createServerSocket(port);
			System.out.println("Server is waiting for connecting");
			while(true)
			{
				Socket client = serverSocket.accept();
				counter++;
				System.out.println("Client "+counter+": Applying for connection!");				
				// Start a new thread for a connection
				Thread t = new Thread(() -> serveClient(client));
				t.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
}
	private static void serveClient(Socket client) {
		try(Socket clientSocket = client)
		{
			// Input stream
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			// Output Stream
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			String toClient = null;
			String fromClient = null;
			fromClient = input.readUTF();
			System.out.println(fromClient);
			String operation= null;
			while(true)
			{				
				toClient = "welcome to jax's dictionary\n"+ 
						"please input your operation\n"+
						"add:new word\n"+
						"delete: remove a word in dictionary\n"+
						"search: show explaination of a word";
				out.writeUTF(toClient);
				fromClient = input.readUTF();
				if(fromClient.contentEquals("exit"))
				{
					break;
				}
				switch (fromClient) {
				case "add":
					out.writeUTF("what word are you going to add");
					String word = input.readUTF();
					out.writeUTF("«Î ‰»ÎΩ‚ Õ");
					String description = input.readUTF();
					out.writeUTF(Dictionary.addNewWord(word, description));
					break;
				
				case "search":
					out.writeUTF("which word are you searching for");
					String wordName1 = input.readUTF();
					out.writeUTF(Dictionary.search(wordName1));
					break;
				
				case "delete":
					out.writeUTF("word you want to delete");
					String wordName2 = input.readUTF();
					out.writeUTF(Dictionary.remove(wordName2));
					break;
					
				default:
					out.writeUTF("Unexpected value: " + operation);
					break;				
				}
			}
				input.close();
				out.close();
				client.close();
				System.out.println("client exit");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
