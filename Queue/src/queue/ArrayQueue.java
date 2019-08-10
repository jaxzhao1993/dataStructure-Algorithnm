package queue;

public class ArrayQueue {
	private int maxSize;
	int front; //头
	int rear; //尾
	
	private int[] array;//用于存放数据，模拟队列
	
	//创建arrayQueue
	public ArrayQueue(int maxSize) 
	{
		this.maxSize = maxSize;
		array = new int[maxSize];
		front = -1; //指向队列头部，指向队列最前面，不包括第一个元素
		rear = -1;	//指向队列尾部，包括最后一个元素
	}
	
	public void showQueue() 
	{	if (isEmpty()) {
		System.err.println("数组空的");
		return;
	}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("第"+i+"个元素为：" +array[i]);
		}
	}
	
	public void addQueue(int element) 
	{
		if(isFull()) 
		{
			System.err.println("队列满，无法加入数据");
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
			throw new RuntimeException("队列空，无法离开");
//		 System.err.println("队列空，无法离开");	
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
