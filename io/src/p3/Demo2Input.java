package p3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;




/*
 * �ֽ����������˳������Ǳ�ʾ�ֽ��������������೬��
 * 
 * int read() ���������ж�ȡ���ݵ���һ���ֽ�
 * int read(bytes[] b) // ������ȷbyte[] ��������ʲô
 * ����ֵInt ��ʲô
 
 ���裺
 1.�������󣬹��췽����Ҫ��ȡ������
 2.ʹ�÷���read����ȡ�ļ�
 3.�ͷ���Դ
 
 */
public class Demo2Input {
public static void main(String[] args) throws IOException{
	FileInputStream flS = new FileInputStream("a.txt");
	byte[] byte1= new byte[1024];
	int len;//��¼ÿ�ζ�ȡ����Ч�ֽڸ���
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
