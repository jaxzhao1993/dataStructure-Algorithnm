package p2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


/*׷��/��д��ʹ��2�������Ĺ��췽����
 * FileOutputStram(String name, boolean append)
 * FileOutputStram(File file, boolean append)
 * 
 * ���У�д���з���
 *  windows \r\n
 *  mac \r
 *  linux \n
 * 
 * */
public class Demo3OutputStream {

	public static void main(String[] args) {
		byte[] bytes = {-65,-55,67,68,69};
//		byte[] getBytes()
		byte[] bytes2 = "���".getBytes();
		System.out.println(Arrays.toString(bytes2));
		//���ַ���ת��Ϊ�ֽ�����
		try {
			FileOutputStream fos = new FileOutputStream("a.txt", true);
		 for (int i = 0; i < 10; i++) 
		 {
			 fos.write(bytes2);
			 fos.write("\r\n".getBytes());
		}
			
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









