package p3;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 字节输入流，此抽象类是表示字节输入流的所有类超类
 * 
 * int read() 从输入流中读取数据的下一个字节
 * int read(bytes[] b)
 * 
 * 将硬盘文件中的数据读取到内存中
 * FileInputStream(String name) 文件的路径
 * FileInputStream(File file) 文件
 
 步骤：
 1.创建对象，构造方法绑定要读取的数据
 2.使用方法read，读取文件
 3.释放资源
 
 */
public class Demo1Input {
public static void main(String[] args) throws IOException{
	FileInputStream flS = new FileInputStream("a.txt");
//	int a = flS.read(); //读取文件中的一个字节并返回，读取到文件的末尾，返回-1
//	int b = flS.read();
//	int c = flS.read();
//	int d = flS.read();
//	System.out.println(a);
//	System.out.println(b);
//	System.out.println(c);
//	System.out.println(d);
	int a = 0;
	while((a=flS.read())!=-1)
	{
		System.out.println((char)a);
	}
	
		/* 错误写法，fls.read执行了2次
		 * while(a=flS.read()!=-1) 
		 * { 
		 * System.out.println(fls.read()); 
		 * }
		 */
	
	flS.close();
}
}
