package p2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


/*一次写多个字节
 * 
 * public void write(byte[] b) 将b.length字节从指定的字节数组 输出
 * public void write(byte[] b,int off, int length)
 * off开始的index
 * length 写多长
 * */
public class Demo2OutputStream {

	public static void main(String[] args) {
		byte[] bytes = {-65,-55,67,68,69};
//		byte[] getBytes()
		byte[] bytes2 = "你好".getBytes();
		System.out.println(Arrays.toString(bytes2));
		//把字符串转换为字节数组
		try {
			FileOutputStream fos = new FileOutputStream("a.txt");
			fos.write(bytes); // 转化为二进制
			fos.write(bytes,2,3);
			fos.write(bytes2);
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









