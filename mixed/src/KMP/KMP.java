package KMP;

public class KMP {
	
	//算出部分匹配表
	public static int kmp(String str1, String str2) {
		return -1;
	}
	
	/**
	 * @param str1 源字符串
	 * @param str2 子字符串
	 * @return
	 */
	public static int kmpSearch(String str1, String str2) {
		int[] prefix = kmpPrefix(str2);
		 //i表示原字符串索引， j表示子字符串索引
		for (int i = 0, j=0; i < str1.length(); i++) {
			
			while (j>0 && str1.charAt(i)!= str2.charAt(j)) {
				j= prefix[j-1];
			}
			
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			
			if (j==str2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}
	
	public static int[] kmpPrefix(String deString) {
		char[] pattern = deString.toCharArray();
		//创建一个next数组，保存部分匹配值
		int[] prefix = new int[deString.length()];
		//如果字符串长度为1，匹配值一定是0
		prefix[0] = 0;
		//从第二个字符开始匹配
		int i = 1;
		//
		int len = 0;
		while (i <deString.length()) {
			if (pattern[i] == pattern[len]) {
				len++;
				prefix[i] = len;
				i++;
			}else {
				if (len>0) {
					//防止越界
					len = prefix[len-1];
				}else {
					prefix[i] = len;
					i++;
				}
			
			}
		}
		return prefix;
	}
}

