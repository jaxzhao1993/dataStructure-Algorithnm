package queue;

import java.util.Scanner;

//���Ⲣ�Ż������鲻�ܸ���
//�������Ϊѭ������


public class Queue {
public static void main(String[] args) {
	ArrayQueue arrayQueue = new ArrayQueue(3);
	char key = ' ';
	Scanner input = new Scanner(System.in);
	boolean loop = true;
	while(loop)
	{
		System.out.println("s:��ʾ����");
		System.out.println("e:�˳�");
		System.out.println("add:���Ԫ��");
		System.out.println("get:ȡ��Ԫ��");
		key = input.next().charAt(0);
		switch (key) {
		case 's':
			arrayQueue.showQueue();
			break;
		case 'a':
			System.out.println("������һ������");
			int element= input.nextInt();
			arrayQueue.addQueue(element);
			break;
		case 'g':
			try {
				int res = arrayQueue.getQueue();
				System.out.println("ȡ���������ǣ�"+ res);
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
