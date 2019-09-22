package KMP;

public class KMP {
	
	//�������ƥ���
	public static int kmp(String str1, String str2) {
		return -1;
	}
	
	/**
	 * @param str1 Դ�ַ���
	 * @param str2 ���ַ���
	 * @return
	 */
	public static int kmpSearch(String str1, String str2) {
		int[] prefix = kmpPrefix(str2);
		 //i��ʾԭ�ַ��������� j��ʾ���ַ�������
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
		//����һ��next���飬���沿��ƥ��ֵ
		int[] prefix = new int[deString.length()];
		//����ַ�������Ϊ1��ƥ��ֵһ����0
		prefix[0] = 0;
		//�ӵڶ����ַ���ʼƥ��
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
					//��ֹԽ��
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

