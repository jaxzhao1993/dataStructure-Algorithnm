package Calcstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolandNotation {

	public static void main(String[] args) {
		//完成将中缀表达式转后缀表达式
		// 1 + ( ( 2 + 3 ) * 4 ) - 5 => 1 2 3 + 4 * + 5 -
		String expression = "13+((542+3999)*48)-5";
		//讲表达式拆分
		List<String> ls = new ArrayList<String>();
		ls = toList(expression);
		System.err.println("中缀表达式"+ expression);
		List<String> suffixExpression = parseExpression(ls);
		System.out.println("后缀表达式"+suffixExpression);
		System.err.println("结果" + compute(suffixExpression));
		
		
		//为了方便，数字和符号之间用空格隔开
//		String suffixExpression = "3 4 + 5 * 6 -";
//		//先把string分割放入ArrayList
//		//把ArrayList传递给一个方法，配合栈，完成计算
//		List<String> list = getListString(suffixExpression);
//		System.out.println(list);
//		System.out.println("开始运算");
//		//开始计算
//		int res = compute(list);
//		System.out.println(res);
		
		
	}
	
	public static List getListString(String suffixExpression) {

			String[] split = suffixExpression.split(" ");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < split.length; i++) {
				list.add(split[i]);
			}
			return list;
	}
	
	public static int compute(List<String> list) 
	{	
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			//正则表达式，匹配多位数
			if(isNumeric(str)) {
				stack.push(str);
			}else {
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				switch (str) {
				case "+":
					res = num2 + num1;
					break;
				case "-":
					res = num2 - num1;
					break;
				case "*":
					res = num2 * num1;
					break;
				case "/":
					res = num2 / num1;
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + str);
				}
				stack.push(""+res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
	
	public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);           
        if( !isNum.matches() ){               
            return false;
        }  return true;
	}

	public static List<String> toList(String expression) {
		ArrayList<String> ls = new ArrayList<String>();
		char ch = ' ';
		int i = 0;
		String tempString ="";
		do {
			if ( (ch=expression.charAt(i))<'0' || (ch=expression.charAt(i))>'9') {
				ls.add(ch+"");
				i++;
			}else {
				//如果是数字，要考虑多位数
				tempString="";
				while(i<expression.length() 
						&& (ch=expression.charAt(i))>='0' 
						&& (ch=expression.charAt(i))<='9')
				{
					tempString= tempString+ch;
					i++;
				}
				ls.add(tempString);
			}	
		} while (i<expression.length());
		return ls;
	}

	public static ArrayList<String> parseExpression(List<String> list) {
		//定义两个栈
		Stack<String> opStack = new Stack<String>();
		ArrayList<String> resultList = new ArrayList<String>();
		//开始遍历list
		for (String item : list) {
			//如果是数，就加入list
			if(isNumeric(item))
			{
				resultList.add(item);
				//如果是"(" 或者 符号栈为空,直接入符号栈
			}else if (item.equals("(") || opStack.isEmpty()) {
				opStack.push(item);
				//如果是右括号，则依次弹出运算符，直到左括号
			}else if (item.equals(")")){
				while(!opStack.peek().equals("("))
				{
					resultList.add(opStack.pop());
				}
				//抛弃第一个左括号
				opStack.pop();
			}else {
				//当符号栈顶的优先级>item优先级
				//将符号栈顶的运算符加入list
				while(!opStack.isEmpty() && Operation.prioritise(item)<= Operation.prioritise(opStack.peek()))
				{
					resultList.add(opStack.pop());
				}
				opStack.push(item);
			}
		}		
		//将符号栈里剩余的符号弹出，加入list
		while(!opStack.isEmpty())
		{
			resultList.add(opStack.pop());
		}
		return resultList;
	}
}

//编写一个类，可以返回一个运算符的优先级
class Operation{
	private static int ADD=1;
	private static int SUB=1;
	private static int MUL=1;
	private static int DIV=1;
	
	public static int prioritise(String operation)
	{	int result = 0;
		switch (operation) {
		case "+":
		result = 1;
		break;
		case "-":
		result = 1;
		break;
		case "*":
		result = 1;
		break;
		case "/":
		result = 1;
		break;
		default:
			break;
		}
		return result;
	}
	
	
}


