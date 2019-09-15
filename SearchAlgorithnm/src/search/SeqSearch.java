package search;

public class SeqSearch {
	public static void main(String[] args) {
		int[] array = {1,9,11,-1,34,89};
		int index = seqSearch(array, 89);
		if (index==-1) {
			System.out.println("not found");
		} else {
			System.out.println("找到，下标为： "+index);
		}
	}
	
	/** 找到一个满足条件值，就返回，如果要查找所有，返回一个集合
	 * @param array
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if(array[i]==value)
			{
				return i;
			}
		}
		return -1;
	}
}
