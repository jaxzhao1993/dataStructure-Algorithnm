package KMP;

import java.util.Arrays;

public class demo {
	public static void main(String[] args) {
//		String str1 = "¹è¹è¹È ÉĞ¹è¹ÈÄãÉĞ¹è ÉĞ¹è¹ÈÄãÉĞ¹è¹ÈÄãºÃ";
//		String str2 = "ÉĞ¹è¹ÈÄãºÃ";
//		
//		int index = ViolenceMatch.violenceMatch(str1, str2);
//		System.out.println(index);
		
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		
		int index = KMP.kmpSearch(str1, str2);
		System.out.println(index);
	}
}
