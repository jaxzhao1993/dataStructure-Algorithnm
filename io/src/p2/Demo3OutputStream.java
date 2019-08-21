package p2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


/*追加/续写，使用2个参数的构造方法：
 * FileOutputStram(String name, boolean append)
 * FileOutputStram(File file, boolean append)
 * 
 * 换行：写换行符号
 *  windows \r\n
 *  mac \r
 *  linux \n
 * 
 * */
public class Demo3OutputStream {

	public static void main(String[] args) {
		byte[] bytes = {-65,-55,67,68,69};
//		byte[] getBytes()
		byte[] bytes2 = "你好".getBytes();
		System.out.println(Arrays.toString(bytes2));
		//把字符串转换为字节数组
		try {
			FileOutputStream fos = new FileOutputStream("a.txt", true);
		 for (int i = 0; i < 10; i++) 
		 {
			 fos.write(bytes2);
			 fos.write("\r\n".getBytes());
		}
			
			// 1个字节=8个比特位 
			//0-127查询ASCII
			//其他值查询默认表（中文为GBK）
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
} 









