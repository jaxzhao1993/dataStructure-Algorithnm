package p1;

import java.io.FileOutputStream;
import java.io.IOException;

//close() 关闭此输出流并释放此流相关联的系统资源
//flush() 刷新此输出流并强制任何缓冲的字节输出
//write(byte[] b) 将b.length字节从指定的字节数组写入

public class Demo1OutputStream {
	/*
	 * // fileOutputStream 文件字节输出流 
	 * // filrOutputStram(String name) 创建一个指定名称的文件，并写入
	 * 目的地：路径 
	 * // filrOutputStram(File file) 像一个指定file对象， 写入
	 *  目的地：文件
	 *  
	 *  写入原理（内存-> 硬盘）
	 *  java -> JVM -> OS系统-> 调用写数据的方法
	 */
	/*
	 * 步骤：
	 * 1.创建FileOutputStream 对象，构造方法中写入数据的目的地
	 * 2.调用FileOutputStream对象中的方法，write，把数据写入到文件中 
	 * 3.释放资源(流使用会占用一定的内存)
	 */
	public static void main(String[] args) {
	
		try {
			FileOutputStream fos = new FileOutputStream("a.txt");
			fos.write(65); // 转化为二进制
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









