package stack;

import java.util.Scanner;

public class demo {
public static void main(String[] args) {
	ArrayStack arrayStack = new ArrayStack(5);
	String keyString = " ";
	boolean isloop = true;
	Scanner input = new Scanner(System.in);
	
	while(isloop)
	{
		System.out.println("show:��ʾ��ʾջ");
		System.out.println("exit:��ʾ�˳�");
		System.out.println("push:����������");
		System.out.println("pop:��ʾ�ó�������");
		
		keyString = input.nextLine();
		switch (keyString) {
		case "show":
			arrayStack.show();
			break;
		case "exit":
			isloop= false;
			break;
		case "push":
			System.out.println("������Ҫ��ӵ�Ԫ��");
			int value = input.nextInt();
			arrayStack.push(value);
			break;
		case "pop":
			arrayStack.pop();
			break;

		}
	}
}
}
