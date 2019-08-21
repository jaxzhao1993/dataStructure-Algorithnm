package calculator;

//用数组模拟栈
public class ArrayStack {
	private int maxsize;
	private int[] stack; //数据就放在数组中
	private int top = -1; //表示栈顶，初始化为-1
	
	public ArrayStack(int maxsize) {
		this.maxsize= maxsize;
		stack = new int[this.maxsize];
	}
	
	public void push(int value) {
		if(isFull())
		{
			System.err.println("栈满了");
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
			throw new RuntimeException("栈空");
		}
		else {
			int value = stack[top];
			top--;
			return value; 
			
		}
	}
	
	public char look() {
		return (char)stack[top];
	}
	
	public int looknumber() {
		return stack[top];
	}
	
	public void show() {
		//遍历栈，需要从栈顶开始显示数据
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
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
	//返回运算符的优先级,数字越大，优先级越高
	public int priority(char i) 
	{
		if (i == '*' || i == '/') {
			return 2;
		}
		else if (i == '*' || i == '/') {
			return 1;
		}
		return 1;
	}
//判断是否一个运算符
	public boolean isOp(char value)
	{
		if (value =='*' || value =='/' || value =='+' ||value =='-'  ) {
			return true;
		}else {
			return false;
		}
	}
	
	public int compute(int a, int b, char operator)
	{	int res= 0;
		switch (operator) {
		case '*':
			res = b*a;
			break;
		case '/':
			res = b/a;
			break;
		case '+':
			res = b+a;
			break;
		case '-':
			res = b-a;
			break;
		}
		return res;
	}



















}
