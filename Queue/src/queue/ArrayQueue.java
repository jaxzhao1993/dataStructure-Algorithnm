package queue;

public class ArrayQueue {
	private int maxSize;
	int front; //ͷ
	int rear; //β
	
	private int[] array;//���ڴ�����ݣ�ģ�����
	
	//����arrayQueue
	public ArrayQueue(int maxSize) 
	{
		this.maxSize = maxSize;
		array = new int[maxSize];
		front = -1; //ָ�����ͷ����ָ�������ǰ�棬��������һ��Ԫ��
		rear = -1;	//ָ�����β�����������һ��Ԫ��
	}
	
	public void showQueue() 
	{	if (isEmpty()) {
		System.err.println("����յ�");
		return;
	}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("��"+i+"��Ԫ��Ϊ��" +array[i]);
		}
	}
	
	public void addQueue(int element) 
	{
		if(isFull()) 
		{
			System.err.println("���������޷���������");
			return;
		}
		else 
		{	rear++;
			array[rear]= element;
		}
	}
	
	public int getQueue() {
		if (isEmpty()) 
		{
			throw new RuntimeException("���пգ��޷��뿪");
//		 System.err.println("���пգ��޷��뿪");	
//		 return -1;				 
		}
		else {
			front++;
			return array[front];
		}
	}
	
	public boolean isFull() {
		return rear==maxSize -1;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
}
