package queue;

import java.util.Scanner;

//问题并优化，数组不能复用
//将数组改为循环数组


public class Queue {
public static void main(String[] args) {
	ArrayQueue arrayQueue = new ArrayQueue(3);
	char key = ' ';
	Scanner input = new Scanner(System.in);
	boolean loop = true;
	while(loop)
	{
		System.out.println("s:显示队列");
		System.out.println("e:退出");
		System.out.println("add:添加元素");
		System.out.println("get:取出元素");
		key = input.next().charAt(0);
		switch (key) {
		case 's':
			arrayQueue.showQueue();
			break;
		case 'a':
			System.out.println("请输入一个数据");
			int element= input.nextInt();
			arrayQueue.addQueue(element);
			break;
		case 'g':
			try {
				int res = arrayQueue.getQueue();
				System.out.println("取出的数据是："+ res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 'e':
			input.close();
			loop = false;
			System.exit(0);
			break;
		}
	}
}
}
