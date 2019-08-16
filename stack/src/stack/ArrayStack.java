package stack;

//������ģ��ջ
public class ArrayStack {
	private int maxsize;
	private int[] stack; //���ݾͷ���������
	private int top = -1; //��ʾջ������ʼ��Ϊ-1
	
	public ArrayStack(int maxsize) {
		this.maxsize= maxsize;
		stack = new int[this.maxsize];
	}
	
	public void push(int value) {
		if(isFull())
		{
			System.err.println("ջ����");
			return;
		}
		else {
			top++;
			stack[top]= value;
		}
	}
	
	public int pop() {
		if(isEmpty())
		{
			throw new RuntimeException("ջ��");
		}
		else {
			int value = stack[top];
			top--;
			return value; 
			
		}
	}
	
	public void show() {
		//����ջ����Ҫ��ջ����ʼ��ʾ����
		if (isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		for (int i = top; i>=0; i--) {
			System.out.println("stack["+i+"]= "+stack[i]);
		}
	}
	
	
	public boolean isFull() {
		if (top==maxsize-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (top== -1) {
			return true;
		}
		else {
			return false;
		}
	}
}
