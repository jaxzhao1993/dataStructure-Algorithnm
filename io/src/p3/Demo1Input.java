package p3;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * �ֽ����������˳������Ǳ�ʾ�ֽ��������������೬��
 * 
 * int read() ���������ж�ȡ���ݵ���һ���ֽ�
 * int read(bytes[] b)
 * 
 * ��Ӳ���ļ��е����ݶ�ȡ���ڴ���
 * FileInputStream(String name) �ļ���·��
 * FileInputStream(File file) �ļ�
 
 ���裺
 1.�������󣬹��췽����Ҫ��ȡ������
 2.ʹ�÷���read����ȡ�ļ�
 3.�ͷ���Դ
 
 */
public class Demo1Input {
public static void main(String[] args) throws IOException{
	FileInputStream flS = new FileInputStream("a.txt");
//	int a = flS.read(); //��ȡ�ļ��е�һ���ֽڲ����أ���ȡ���ļ���ĩβ������-1
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
	
		/* ����д����fls.readִ����2��
		 * while(a=flS.read()!=-1) 
		 * { 
		 * System.out.println(fls.read()); 
		 * }
		 */
	
	flS.close();
}
}
