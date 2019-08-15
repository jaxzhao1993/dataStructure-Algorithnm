
package circleQueue;

public class CircleArrayQueue {
	private int maxSize;
	int front; //头
	int rear; //尾
	
	private int[] array;//用于存放数据，模拟队列
	
	//创建arrayQueue
	public CircleArrayQueue(int maxSize) 
	{
		this.maxSize = maxSize+1;
		array = new int[this.maxSize];
		front = 0; //指向队列头部，指向队列第一个元素
		rear = 0;	//指向队列尾部，最后一个元素
	}
	
	public void showQueue() 
	{	if (isEmpty()) {
		System.err.println("数组空的");
		return;
	}
		
		/*
		 * for (int i = 1; i <= array.length; i++) { System.out.println("第"+ i +"个元素为："
		 * +array[i-1]); }
		 */
		for (int i = front; i < front+ valuableNum(); i++) {
			System.out.println("array["+ i%maxSize+"]=" +array[i%maxSize]);
		}
	
	}
	
	//求出有效元素个数
	public int valuableNum() {
		int num = (rear+maxSize-front) % maxSize;	
		return num;
	}
	
	public void addQueue(int element) 
	{
		if(isFull()) 
		{
			System.err.println("队列满，无法加入数据");
			return;
	}
		array[rear] = element;
		rear = (rear+1) % maxSize;
			
		
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
