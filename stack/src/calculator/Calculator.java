package calculator;

public class Calculator {
public static void main(String[] args) {
	String expression = "3+2*6-2+6/2-2*1";
	//创建2个栈，一个存数字，一个存符号
	ArrayStack numberStack = new ArrayStack(10);
	ArrayStack opStack = new ArrayStack(10);
	int num1, num2;
	int res = 0;
     //用于扫描字符串
	int index = 0;
	char operator = ' ';
	char ch = ' ';
	for (int i = 0; i < expression.length(); i++) {
		ch = expression.charAt(i);
			if(opStack.isOp(ch))
			{	
				if(opStack.isEmpty())
				{
					opStack.push(ch);
				}else if (opStack.priority(ch)<= opStack.priority(opStack.look())) {
					num1 = numberStack.pop();
					num2 = numberStack.pop();
					operator = (char)opStack.pop();
					numberStack.push(numberStack.compute(num1, num2, operator));
					opStack.push(ch);
				}else {
					opStack.push(ch);
				}
			}else {
				numberStack.push(ch-48);
			}
	}
	
	while(true)
	{
		if(opStack.isEmpty())
		{
			break;
		}
		num1 = numberStack.pop();
		num2 =numberStack.pop();
		operator = (char)opStack.pop();
		res = numberStack.compute(num1, num2, operator);
		numberStack.push(res);
	}
	System.out.println("结束");
	System.out.println(res);
}

}
