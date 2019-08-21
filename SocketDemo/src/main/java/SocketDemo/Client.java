package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket =new Socket();
		socket.setSoTimeout(3000);
		
		
		socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);
		System.out.println("�Ѿ�������������ӣ��������������~");
		System.out.println("�ͻ�����Ϣ��"+socket.getLocalAddress()+"  �˿�:"+ socket.getLocalPort());
		System.out.println("�ͻ�����Ϣ��"+socket.getInetAddress()+"  �˿�:"+ socket.getPort());
		try {
			//��������
			todo(socket);
		} catch (Exception e) {
			System.out.println("�����쳣");
		}
		socket.close();
		System.out.println("�ͻ������˳�");
	}
	
	private static void todo(Socket client) throws IOException{
		//��������������
		
		InputStream in = System.in;
		BufferedReader input = new BufferedReader(new InputStreamReader(in));
		
		//�õ�socket���������ת��Ϊ��ӡ��
		OutputStream outputStream = client.getOutputStream();
		PrintStream socketPrintStream = new PrintStream(outputStream);
		
		//���̶�ȡ
		String str = input.readLine();
		socketPrintStream.println(str);
		
	}
}
