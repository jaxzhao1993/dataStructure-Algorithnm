package KMP;

import java.util.Arrays;

public class demo {
	public static void main(String[] args) {
//		String str1 = "���� �й�����й� �й�����й�����";
//		String str2 = "�й�����";
//		
//		int index = ViolenceMatch.violenceMatch(str1, str2);
//		System.out.println(index);
		
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		
		int index = KMP.kmpSearch(str1, str2);
		System.out.println(index);
	}
}
