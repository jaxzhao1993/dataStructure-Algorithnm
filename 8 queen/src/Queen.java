
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
	//�����Ƿ��õ�n���ʺ󣬾�ȥ��⣬�Ƿ�Ϲ�
	private boolean isValid(int n) {
		for (int i = 0; i < n; i++) {
			if(array[i]==array[n] || Math.abs(array[n] - array[i]) == n-i )
			{
				return false;
			}
		}
		return true;
	}

	//���õ�N���ʺ�
	private void check(int n)
	{
		if(n==max) //���n=8����ʾ�ҵ���һ����ȷ��
		{
			print();
			count++;
			return;
		}
		//���η���ʺ�
		for(int i =0; i<max; i++)
		{	//�Ȱѵ�ǰ�ʺ���ڸ��е�i��
			array[n]=i;
			if (isValid(n)) {
				//���ŷ�n+1��
				check(n+1);
			}//������Ϸ�������ִ��
		}
	}

	
}
