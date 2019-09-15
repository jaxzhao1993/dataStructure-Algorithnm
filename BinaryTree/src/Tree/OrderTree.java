package Tree;

public class OrderTree extends BinaryTree{
	//������洢�ڶ������У�����ʵ���໥ת��,
	
	//˳�������ͨ��ֻ������ȫ������
	//��n��Ԫ�ص����ӽڵ�Ϊ2n+1,���ӽڵ�Ϊ2n+2
	//��n��Ԫ�صĸ��ڵ� (n-1)/2
	private int[] array;
	
	public OrderTree(int[] array) {
		this.array = array;
	}
	
	public void preOrder(int index){
		//�������Ϊ�գ�����arr.length=0
		if (array==null || array.length==0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		//�����ǰ���Ԫ��
		System.out.println(array[index]);
		//����ݹ����
		if(index*2+1<array.length)
		{
			preOrder(2*index+1);
		}
		//���ҵݹ����
		if(index*2+2<array.length)
		{
			preOrder(index*2+2);
		}
	}
}



