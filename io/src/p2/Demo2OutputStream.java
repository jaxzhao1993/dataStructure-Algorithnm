package p2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


/*һ��д����ֽ�
 * 
 * public void write(byte[] b) ��b.length�ֽڴ�ָ�����ֽ����� ���
 * public void write(byte[] b,int off, int length)
 * off��ʼ��index
 * length д�೤
 * */
public class Demo2OutputStream {

	public static void main(String[] args) {
		byte[] bytes = {-65,-55,67,68,69};
//		byte[] getBytes()
		byte[] bytes2 = "���".getBytes();
		System.out.println(Arrays.toString(bytes2));
		//���ַ���ת��Ϊ�ֽ�����
		try {
			FileOutputStream fos = new FileOutputStream("a.txt");
			fos.write(bytes); // ת��Ϊ������
			fos.write(bytes,2,3);
			fos.write(bytes2);
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









