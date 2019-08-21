package updateCal;

import java.util.ArrayList;

public abstract class updateCalculator {
public static void main(String[] args) {
	String expression = "30*1+4*2*10-10+40/20";
	ArrayStack numStack = new ArrayStack(50);
	ArrayStack opStack = new ArrayStack(50);
	ArrayList<String> list =new ArrayList<String>();
	String str = "";
	int splitIndex =0;
	char ch = ' ';
	char operator=' ';
	String opString = "";
	int num1,num2;
	int res =0;
	for (int i = 0; i < expression.length(); i++) {
		ch = expression.charAt(i);
		if (ch == '*' || ch =='/' || ch =='-' || ch== '+') {
			str = expression.substring(splitIndex, i);
			opString =expression.substring(i, i+1);
			list.add(str);
			list.add(opString);
			splitIndex = i+1;
		}
	}
	str =expression.substring(splitIndex);
	list.add(str);
	System.out.println("分割后");
	System.out.println(list);
	for (int i=0; i< list.size();i++)
	{	String element = list.get(i);
		if(element.equals("*")  || element.equals("-") ||element.equals("+") || element.equals("/") )
		{
			ch = element.charAt(0);
			if(opStack.isEmpty())
			{
				opStack.push(ch);
			}else if (opStack.priority(ch) <= opStack.priority(opStack.look())) {
				num1= numStack.pop();
				num2 =numStack.pop();
				operator = (char)opStack.pop();
				numStack.push(numStack.compute(num1, num2, operator));
				opStack.push(ch);
			}else {
				opStack.push(ch);
			}

		}else {
			int temp = Integer.parseInt(element);
			numStack.push(temp);
		}	

	}
	
	while(true)
	{
		if(opStack.isEmpty())
		{
			break;
		}
		num1 = numStack.pop();
		num2 = numStack.pop();
		operator = (char)opStack.pop();
		res = numStack.compute(num1, num2, operator);
		numStack.push(res);
	}
	
	
	System.out.println("结果"+res);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
