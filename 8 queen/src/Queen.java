
public class Queen {
    static int max =8 ;
	int[] array = new int[max];
	static int count = 0;
	
	public static void main(String[] args) {
		Queen q = new Queen();
		q.check(0);
	
	}
	
	private void print() {
		for(int i = 0; i<array.length; i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	//当我们放置第n个皇后，就去检测，是否合规
	private boolean isValid(int n) {
		for (int i = 0; i < n; i++) {
			if(array[i]==array[n] || Math.abs(array[n] - array[i]) == n-i )
			{
				return false;
			}
		}
		return true;
	}

	//放置第N个皇后
	private void check(int n)
	{
		if(n==max) //如果n=8，表示找到了一个正确解
		{
			print();
			count++;
			return;
		}
		//依次放入皇后
		for(int i =0; i<max; i++)
		{	//先把当前皇后放在该行第i列
			array[n]=i;
			if (isValid(n)) {
				//接着放n+1个
				check(n+1);
			}//如果不合法，继续执行
		}
	}

	
}
