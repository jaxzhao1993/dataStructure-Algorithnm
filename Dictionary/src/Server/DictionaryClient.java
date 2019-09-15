package Server;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DictionaryClient extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static String address = "localhost";
		public static int port = 12306;
		Socket socket = null;
		DataOutputStream output;
		DataInputStream input;
		TextField tfTxt = new TextField();
		TextArea content = new TextArea();
		private boolean bConnected = false;
		
		public static void main(String[] args) {
			address = args[0];
			port = Integer.parseInt(args[1]);
			new DictionaryClient().launchFrame();
		}
		
		public void launchFrame() {
			setLocation(400,300);
			this.setSize(300, 300);
			//content.setText(port + address);
			add(tfTxt, BorderLayout.SOUTH);
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
			tfTxt.addActionListener(new TFListener());
			this.setVisible(true);
			connect();
			
			new Thread(new ReceiveThread()).start();
		}
		
		public void connect() {
			try {
				socket = new Socket(address, port);
				content.setText("you are connecting to server,\n if you cannot get response,\n that means you are in the waiting list\n");
//System.out.println("connected!");
				output = new DataOutputStream(socket.getOutputStream());
				input = new DataInputStream(socket.getInputStream());
				bConnected= true;
			} catch (IOException e) {
				content.setText("please start server first");
			}
		}
		
		public void disconnect() 
		{
			try {
				output.close();
				socket.close();
			} catch (IOException e) {
				content.setText(e.toString());
			}
			
		}
		

		private class ReceiveThread implements Runnable{

			@Override
			public void run() {
				try {
					while(bConnected)
					{
						String response = input.readUTF();
						content.setText(content.getText()+response+"\n");
					}
				} catch (IOException e) {
					content.setText("Server might be down");
				}
			}
		}
		
		
		private class TFListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tfTxt.getText();
				tfTxt.setText("");
				try {
					output.writeUTF(str);
					output.flush();
				} catch (IOException e1) {
					content.setText(e1.toString());
				}
			}
			
		}
}
