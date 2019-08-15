
package circleQueue;

public class CircleArrayQueue {
	private int maxSize;
	int front; //ͷ
	int rear; //β
	
	private int[] array;//���ڴ�����ݣ�ģ�����
	
	//����arrayQueue
	public CircleArrayQueue(int maxSize) 
	{
		this.maxSize = maxSize+1;
		array = new int[this.maxSize];
		front = 0; //ָ�����ͷ����ָ����е�һ��Ԫ��
		rear = 0;	//ָ�����β�������һ��Ԫ��
	}
	
	public void showQueue() 
	{	if (isEmpty()) {
		System.err.println("����յ�");
		return;
	}
		
		/*
		 * for (int i = 1; i <= array.length; i++) { System.out.println("��"+ i +"��Ԫ��Ϊ��"
		 * +array[i-1]); }
		 */
		for (int i = front; i < front+ valuableNum(); i++) {
			System.out.println("array["+ i%maxSize+"]=" +array[i%maxSize]);
		}
	
	}
	
	//�����ЧԪ�ظ���
	public int valuableNum() {
		int num = (rear+maxSize-front) % maxSize;	
		return num;
	}
	
	public void addQueue(int element) 
	{
		if(isFull()) 
		{
			System.err.println("���������޷���������");
			return;
	}
		array[rear] = element;
		rear = (rear+1) % maxSize;
			
		
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
			int get = front -1;
			return array[get];
		}
	}
	
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
}
