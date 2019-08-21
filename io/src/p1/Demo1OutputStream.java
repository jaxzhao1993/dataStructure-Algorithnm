package p1;

import java.io.FileOutputStream;
import java.io.IOException;

//close() �رմ���������ͷŴ����������ϵͳ��Դ
//flush() ˢ�´��������ǿ���κλ�����ֽ����
//write(byte[] b) ��b.length�ֽڴ�ָ�����ֽ�����д��

public class Demo1OutputStream {
	/*
	 * // fileOutputStream �ļ��ֽ������ 
	 * // filrOutputStram(String name) ����һ��ָ�����Ƶ��ļ�����д��
	 * Ŀ�ĵأ�·�� 
	 * // filrOutputStram(File file) ��һ��ָ��file���� д��
	 *  Ŀ�ĵأ��ļ�
	 *  
	 *  д��ԭ���ڴ�-> Ӳ�̣�
	 *  java -> JVM -> OSϵͳ-> ����д���ݵķ���
	 */
	/*
	 * ���裺
	 * 1.����FileOutputStream ���󣬹��췽����д�����ݵ�Ŀ�ĵ�
	 * 2.����FileOutputStream�����еķ�����write��������д�뵽�ļ��� 
	 * 3.�ͷ���Դ(��ʹ�û�ռ��һ�����ڴ�)
	 */
	public static void main(String[] args) {
	
		try {
			FileOutputStream fos = new FileOutputStream("a.txt");
			fos.write(65); // ת��Ϊ������
			// 1���ֽ�=8������λ 
			//0-127��ѯASCII
			//����ֵ��ѯĬ�ϱ�����ΪGBK��
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
} 









