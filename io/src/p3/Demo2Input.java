package p3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;




/*
 * 字节输入流，此抽象类是表示字节输入流的所有类超类
 * 
 * int read() 从输入流中读取数据的下一个字节
 * int read(bytes[] b) // 必须明确byte[] 的作用是什么
 * 返回值Int 是什么
 
 步骤：
 1.创建对象，构造方法绑定要读取的数据
 2.使用方法read，读取文件
 3.释放资源
 
 */
public class Demo2Input {
public static void main(String[] args) throws IOException{
	FileInputStream flS = new FileInputStream("a.txt");
	byte[] byte1= new byte[1024];
	int len;//记录每次读取的有效字节个数
//	while((len=flS.read(byte1))!=-1)
//	{
//		System.out.println(new String(byte1));
//	}
//	
	while(true)
	{
		if ((len=flS.read(byte1)) == -1)
		{
			break;
		}
		System.err.println(new String(byte1));
	}
	
	
	flS.close();
}
}
