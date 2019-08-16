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
		System.out.println("show:表示显示栈");
		System.out.println("exit:表示退出");
		System.out.println("push:加入新数据");
		System.out.println("pop:表示拿出新数据");
		
		keyString = input.nextLine();
		switch (keyString) {
		case "show":
			arrayStack.show();
			break;
		case "exit":
			isloop= false;
			break;
		case "push":
			System.out.println("请输入要添加的元素");
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
