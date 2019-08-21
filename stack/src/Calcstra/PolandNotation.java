package Calcstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolandNotation {

	public static void main(String[] args) {
		//��ɽ���׺���ʽת��׺���ʽ
		// 1 + ( ( 2 + 3 ) * 4 ) - 5 => 1 2 3 + 4 * + 5 -
		String expression = "13+((542+3999)*48)-5";
		//�����ʽ���
		List<String> ls = new ArrayList<String>();
		ls = toList(expression);
		System.err.println("��׺���ʽ"+ expression);
		List<String> suffixExpression = parseExpression(ls);
		System.out.println("��׺���ʽ"+suffixExpression);
		System.err.println("���" + compute(suffixExpression));
		
		
		//Ϊ�˷��㣬���ֺͷ���֮���ÿո����
//		String suffixExpression = "3 4 + 5 * 6 -";
//		//�Ȱ�string�ָ����ArrayList
//		//��ArrayList���ݸ�һ�����������ջ����ɼ���
//		List<String> list = getListString(suffixExpression);
//		System.out.println(list);
//		System.out.println("��ʼ����");
//		//��ʼ����
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
			//������ʽ��ƥ���λ��
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
				//��������֣�Ҫ���Ƕ�λ��
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
		//��������ջ
		Stack<String> opStack = new Stack<String>();
		ArrayList<String> resultList = new ArrayList<String>();
		//��ʼ����list
		for (String item : list) {
			//����������ͼ���list
			if(isNumeric(item))
			{
				resultList.add(item);
				//�����"(" ���� ����ջΪ��,ֱ�������ջ
			}else if (item.equals("(") || opStack.isEmpty()) {
				opStack.push(item);
				//����������ţ������ε����������ֱ��������
			}else if (item.equals(")")){
				while(!opStack.peek().equals("("))
				{
					resultList.add(opStack.pop());
				}
				//������һ��������
				opStack.pop();
			}else {
				//������ջ�������ȼ�>item���ȼ�
				//������ջ�������������list
				while(!opStack.isEmpty() && Operation.prioritise(item)<= Operation.prioritise(opStack.peek()))
				{
					resultList.add(opStack.pop());
				}
				opStack.push(item);
			}
		}		
		//������ջ��ʣ��ķ��ŵ���������list
		while(!opStack.isEmpty())
		{
			resultList.add(opStack.pop());
		}
		return resultList;
	}
}

//��дһ���࣬���Է���һ������������ȼ�
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


