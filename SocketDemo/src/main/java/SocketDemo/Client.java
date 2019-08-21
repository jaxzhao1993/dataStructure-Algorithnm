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
		System.out.println("已经发起服务器连接，并进入后续流程~");
		System.out.println("客户端信息："+socket.getLocalAddress()+"  端口:"+ socket.getLocalPort());
		System.out.println("客户端信息："+socket.getInetAddress()+"  端口:"+ socket.getPort());
		try {
			//发送数据
			todo(socket);
		} catch (Exception e) {
			System.out.println("发生异常");
		}
		socket.close();
		System.out.println("客户端已退出");
	}
	
	private static void todo(Socket client) throws IOException{
		//构建数据输入流
		
		InputStream in = System.in;
		BufferedReader input = new BufferedReader(new InputStreamReader(in));
		
		//得到socket输出流，并转换为打印流
		OutputStream outputStream = client.getOutputStream();
		PrintStream socketPrintStream = new PrintStream(outputStream);
		
		//键盘读取
		String str = input.readLine();
		socketPrintStream.println(str);
		
	}
}
