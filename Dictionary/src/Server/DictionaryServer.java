package Server;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

public class DictionaryServer extends Frame{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static int port = 12306;
	public static int max_client = 2;
	boolean started = false;
	ServerSocket sSocket= null;
	ExecutorService pool = Executors.newFixedThreadPool(max_client);
	TextArea content = new TextArea();
	
	public static void main(String[] args) {
		new DictionaryServer().launchFrame();
	}

	public void launchFrame() {
		setLocation(800,300);
		this.setSize(300, 300);
		add(content, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.addWindowListener(new WindowAdapter() {
		});
		this.setVisible(true);
		start();
	}
	
	
	public void start() {
		try {
			sSocket = new ServerSocket(port);
			content.setText(content.getText() + "Server is started" +"\n");
		}catch (BindException e) {
			JOptionPane.showMessageDialog(null, "port is being used by another program", "error", JOptionPane.ERROR_MESSAGE);
		//	content.setText("port is being used by another program");
			System.exit(0);
		}catch (IOException e) {
			content.setText(e.toString());
		}
			started = true;
			try {
			while (started) {
					Socket socket = sSocket.accept();
					ClientThread newClient = new ClientThread(socket);
					pool.execute(new Thread(newClient));
					//new Thread(newClient).start();
				} 		
			}catch (IOException e) {
				content.setText(e.toString());
			}finally {
				try {
					if (sSocket!=null) {
						sSocket.close();
					}}
				catch (IOException e) {
					content.setText(e.toString());
				}
			}
	}
	
	
	
	class ClientThread implements Runnable{
		private Socket s =null;
		private DataInputStream input =null;
		private DataOutputStream output =null;
		private boolean bConnected = false;
		
		public ClientThread(Socket s) {
			this.s = s;
			try {
				content.setText(content.getText() + "a client connected" +"\n");
				input = new DataInputStream(s.getInputStream());
				output = new DataOutputStream(s.getOutputStream());
				bConnected =true;
			} catch (IOException e) {
				content.setText(e.toString());
			}
		}
		
		
		public void response(String fromClient) {
			try {
				output.writeUTF(fromClient);
			} catch (IOException e) {
				content.setText(e.toString());
			}
		}
		
		
		@Override
		public void run() {
			try 
			{
				while(bConnected) 
				{	String fromClient;
					String toClient;
					toClient = "Connected\n"+
							"welcome to jax's dictionary\n"+ 
							"please input your operation\n"+
							"add:new word\n"+
							"delete: remove a word in dictionary\n"+
							"search: show explaination of a word";
					output.writeUTF(toClient);
					fromClient = input.readUTF();
					content.setText(content.getText() + "client operation is :" +fromClient +"\n");
					/*
					 * if(fromClient.contentEquals("exit")) { break; }
					 */
					switch (fromClient) {
					case "add":
						output.writeUTF("what word are you going to add");
						String word = input.readUTF();
						while(word.equals(""))
						{
							output.writeUTF("word cannot be null, please type again");
							word = input.readUTF();
						}
						content.setText(content.getText() + "client is add a word: " + word +"\n");
						output.writeUTF("please add an explanation");
						String description = input.readUTF();
						while(description.equals(""))
						{
							output.writeUTF("explaination cannot be null, please type again");
							description = input.readUTF();
						}
						content.setText(content.getText() + "client is add a explanation: " + description +"\n");
						output.writeUTF(Dictionary.addNewWord(word, description));
						break;
					
					case "search":
						output.writeUTF("which word are you searching for");
						String wordName1 = input.readUTF();
						while(wordName1.equals(""))
						{
							output.writeUTF("word cannot be null, please type again");
							wordName1 = input.readUTF();
						}
						content.setText(content.getText() + "client is searching: " + wordName1 +"\n");
						output.writeUTF(Dictionary.search(wordName1));
						break;
					
					case "delete":
						output.writeUTF("which word are you going to delete");
						String wordName2 = input.readUTF();
						while(wordName2.equals(""))
						{
							output.writeUTF("word cannot be null, please type again");
							wordName2 = input.readUTF();
						}
						content.setText(content.getText() + "client is deleting: " + wordName2 +"\n");
						output.writeUTF(Dictionary.remove(wordName2));
						break;
						
					default:
						output.writeUTF("Unexpected value: " + fromClient);
						break;				
					}
				}
			}catch (Exception e) {
				content.setText(content.getText() + "Client closed" +"\n");
			}finally {
				try {
					if(input !=null) input.close();
					if(output !=null) output.close();	
					if(s!= null) s.close();
				} catch (IOException e1) {
					content.setText(e1.toString());
				}
			}	
		}
	}
}
