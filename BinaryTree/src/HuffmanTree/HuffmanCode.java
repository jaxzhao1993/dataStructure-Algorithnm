package HuffmanTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



//按照字符出现的次数作为权值，构建huffman树

//根据huffman树，给各个字符进行编码，向左的路径为0，向右路径为1
//这个编码就是前缀编码
public class HuffmanCode {
	public static void main(String[] args) {
		//压缩字符串
//		String str = "i like like like java do you like a java";
//		byte[] bytes = str.getBytes();
//		System.out.println(Arrays.toString(bytes));
//
//		byte[] after = huffmanZip(bytes);
//		System.out.println(Arrays.toString(after));
//		
//		byte[] afterParse = parse(huffmanCode, after);
//		System.out.println(new String(afterParse));
		
		//压缩文件
//		String srcFile = "d://src.pdf";
//		String dstFile = "d://src.zly";
//		zip(srcFile, dstFile);
		
		//解压缩
		
//		System.out.println("压缩完毕");
//		System.out.println("压缩前：" + bytes.length);
//		
//		List<HuffmanNode> list = getNodes(bytes);
//		System.out.println(list);
//		//
//		System.out.println("创建的huffman树");
//		HuffmanNode node = createHuffmanTree(list);
//		preOrder(node);
//		
////		getCode(node, stringBuilder, "");
//		Map<Byte, String> hufffmanCode = getCode(node);
//		//System.out.println("编码表" + huffmanCode);
//		byte[] after =  zip(bytes, hufffmanCode);
//		System.out.println("huffmancode" + Arrays.toString(after));
	}
	//创建编码表
	/* 思路
	 * 1.放在map中Map《byte，string》
	 * 		32->1  97->100
	 * 2.在生成huffman编码表时，需要去拼接路径, stringbuilder存储
	 * 
	 *  */
	static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	/**
	 * @param bytes 原始字数串对应的字节数组
	 * @return 压缩之后的字节数组
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		List<HuffmanNode> huffmanList = getNodes(bytes);
		HuffmanNode root = createHuffmanTree(huffmanList);
		Map<Byte, String> huffmanMap= getCode(root);
		byte[] bytes2 = zip(bytes, huffmanMap);
		return bytes2;
	}
	
	
	/**
	 * 将传入的node节点的所有huffman编码得到，并放入到huffman code 中
	 * @param node 传入节点
	 * @param stringBuilder 路径：左0右1
	 * @param code
	 * @return 
	 */
	private static Map<Byte, String> getCode(HuffmanNode node) {
		if(node==null)
		{
			return null;
		}
		//处理左子节点
		getCode(node.left, stringBuilder, "0");
		//处理右子节点
		getCode(node.right, stringBuilder, "1");
		return huffmanCode;
	}
	
	private static void getCode(HuffmanNode node, StringBuilder stringBuilder, String code) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			//判断当前node是否是叶子节点
			if (node.dataByte == null) {
				//非叶子节点
				//向左递归
				getCode(node.left, stringBuilder2, "0");
				//向右递归
				getCode(node.right, stringBuilder2, "1");
			}else {
				//找到了叶子节点
				huffmanCode.put(node.dataByte, stringBuilder2.toString());
			}
		}
	}
	
	
	private static void preOrder(HuffmanNode node) {
		if(node == null)
		{
			System.out.println("树为空");
		}else {
			node.preOrder();
		}
	}
	
	private static List<HuffmanNode> getNodes(byte[] bytes) {
		//创建list
		List<HuffmanNode> list = new ArrayList<HuffmanNode>();
		//存储每个byte出现的个数,统计每个bytes出现次数
		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		//
		for (byte b: bytes) {
			Integer count = counts.get(b);
			if (count ==null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//把每个键值对转成一个node 对象
		//遍历map
			for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
				list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
			}
		return list;
	}

	//通过list创建huffman树
	private static HuffmanNode createHuffmanTree(List<HuffmanNode> list) {
		HuffmanNode leftNode;
		HuffmanNode rightNode;
		while (list.size()>1) {
			Collections.sort(list);
			leftNode = list.get(0);
			rightNode = list.get(1);
			HuffmanNode parent = new HuffmanNode(null, leftNode.weight+ rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			list.remove(leftNode);
			list.remove(rightNode);
			list.add(parent);
		}
		return list.get(0);
	}

	//编写一个方法，将字符串对应的byte【】数组，通过生成的huffman编码，返回一个压缩后的byte数组
	private static byte[] zip(byte[] bytes, Map<Byte, String > hufffmanCode) {
		//利用huffmanCode编码表，将bytes数组，转换成huffman对应的字符串
		StringBuilder stringBuilder = new StringBuilder();
		//遍历bytes数组
		for (byte b : bytes) {
			stringBuilder.append(hufffmanCode.get(b));
		}
		//System.out.println("string builder" + stringBuilder.toString());
		//将 10101000111.。。。转成byte【】
		int len;
		if(stringBuilder.length()%8 ==0) {
			len = stringBuilder.length()/8;
		}else {
			len = stringBuilder.length()/8+1;
			}
		//创建存储压缩后的byte数组
		int index = 0;
		byte[] by = new byte[len];
		for (int i = 0; i < stringBuilder.length(); i+=8) { // 每8位对应一个byte，所以步长+8
			String strByte;
			if(i+8> stringBuilder.length()) {
				//不够8位
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			//将strByte转成一个byte,放入到by中
			by[index] = (byte)Integer.parseInt(strByte, 2);
			index ++ ;
		}
				return by;
	}
	
	
	//完成数据的解压
	/* 思路 
	 * 1. 将huffman编码[-88, -65, -56, -65。。。。]转成对应的2进制字符串
	 * 
	 * */
	private static String byteToBitString(Boolean flag, byte b) {
		//使用变量保存b
		int temp = b;
		if (flag) {
			temp |= 256; //按位与256 1 0000 0000 | 0000 0001 => 1 0000 0001
		}
		String str =  Integer.toBinaryString(temp); //返回temp的二进制补码
		if (flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	
	//编写一个方法，完成解码
	/**
	 * @param huffMap 编码表
	 * @param bytes
	 * 返回原来字符串对应的数组
	 * @return 
	 */ 
	private static byte[] parse(Map<Byte, String> huffmanCode, byte[] bytes) {
		//1.先得到bytes对应的二进制字符串
		StringBuilder stringBuilder = new StringBuilder();
		//将byte数组转成二进制字符串
		for(int i =0; i<bytes.length; i++ ){
			boolean flag = (i == bytes.length-1);
			stringBuilder.append(byteToBitString(!flag, bytes[i]));
		}
		System.out.println("解码后：" +stringBuilder.toString());
		//把字符串按照指定编码进行解码
		//把huffmanMap的值和key互换
		Map<String, Byte> parseMap = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry: huffmanCode.entrySet()) {
			parseMap.put(entry.getValue(), entry.getKey());
		}
		System.out.println(parseMap);
		//存放byte
		List<Byte> list = new ArrayList<Byte>();
		for (int i=0; i<stringBuilder.length(); ) {
			int count =1 ; //扫描计数器
			boolean flag = true;
			Byte b = null;
			while (flag) {
				//取出一个字符
				String key = stringBuilder.substring(i,i+count);//i不动，让count移动 ，直到匹配到一个字符
				b= parseMap.get(key);
				if (b!=null){
					flag = false;
				}else {
					count++;
				}
			}
			i = i+count;
			list.add(b);	
		}
		//循环结束后，list就存放了所有的字符
		byte[] byteResult= new byte[list.size()];
		for(int i = 0; i<byteResult.length; i++) {
			byteResult[i] = list.get(i);
		}
		return byteResult;
	}
	
	/**
	 * @param zipFile 要压缩的文件
	 * @param dstFile 压缩到哪里
	 */
	public static void zip(String srcFile, String dstFile) {
		FileInputStream is = null;
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			//创建文件输入流
			is = new FileInputStream(srcFile);
			//创建一个和源文件一样大小的byte[]
			byte[] b = new byte[is.available()];
			//读取文件
			is.read(b);
			//使用huffman编码表
			byte[] after = huffmanZip(b);
			//使用输出流，存放压缩文件
			os = new FileOutputStream(dstFile);
			//创建一个和文件输出流相关联的ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//以对象流的方式写入huffman编码，目的是为了以后我们解压时使用
			//一定要把huffman编码写入压缩文件
			oos.writeObject(after);
			oos.writeObject(huffmanCode);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				os.close();
				oos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void unZip(String zipFile, String dstFile) {
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			//创建文件输入流
			is = new FileInputStream(zipFile);
			//创建object stream
			ois = new ObjectInputStream(is);
			byte[] src = (byte[])ois.readObject();
			//读取huffman编码表
			Map<Byte, String> codeMap = (Map<Byte, String>)ois.readObject();
			//解码
			byte[] bytes = parse(codeMap, src);
			//输出
			os = new FileOutputStream(dstFile);
			os.write(bytes);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
