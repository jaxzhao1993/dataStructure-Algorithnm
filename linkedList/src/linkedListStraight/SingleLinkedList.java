package linkedListStraight;

import java.util.Stack;

public class SingleLinkedList {
	// ��һ�����������й���

	// �ȳ�ʼ��һ��ͷ�ڵ�,������κξ��������
	private HeroNode head = new HeroNode(" ", 0, " ");

	/*
	 * ��ӽڵ㵽�������� ˼·���������Ǳ��˳�� 1.�ҵ���ǰ�б�����ڵ� 2.������ڵ��next��ָ��������
	 */
	public void Add(HeroNode heroNode) { 
		// ��Ϊhead�ڵ㲻�ܶ��������Ҫһ����������
		HeroNode heroTemp = head;
		// ���������ҵ����
	while(true)
	{
		if(heroTemp.next ==null)
			{break;}
		
		heroTemp= heroTemp.next;
	}
		// ѭ������temp��Ȼ��ָ����������һ��Ԫ��
		heroTemp.next = heroNode;
		heroNode.next = null;
	}

	
	public void addByNumber(HeroNode heroNode) 
	{	HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if(temp.next == null)
			{	break;
			}
			if(temp.next.number>heroNode.number)
			{
				break;
			}
			if (temp.next.number==heroNode.number) {
				flag=true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.err.println("���ʧ��");
		}
		else {
			heroNode.next = temp.next;
			temp.next =heroNode;
		}
	}
	
	public void update(HeroNode heroNode) {
		if(head.next==null)
		{
			System.err.println("����Ϊ��");
		}
		HeroNode temp = head;
		boolean flag = true;
		while(true)
		{	if (temp.next ==null) 
			{	flag=false;
				break;
			}
			if (temp.next.number == heroNode.number) {
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next.name= heroNode.name;
			temp.next.nickName=heroNode.nickName;
		}else {
			System.err.println("û���ҵ�������");
		}
	}
	
	public void list() { // �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.err.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		  while(true) 
		  {
			  if(temp.next==null)
			  { System.out.println(temp); 
			  	break; 
			  }
		  System.out.println(temp); temp = temp.next; 
		  }
	}
	
	public void delete(int number) {
		HeroNode temp = head;
		boolean flag = true;
		while (true) {
			if(temp.next==null)
			{	flag= false;
				break;}
			if(temp.next.number==number)
			{
				break;
			}
			temp =temp.next;
		}
		if (flag) {
			if(temp.next.next!=null)
			{
				temp.next = temp.next.next;
			}
			else {
				temp.next=null;
			}
		}else {
			System.err.println("δ�ҵ���Ԫ��");
		}

	}

	public int getlength() {
		int count=0;
		HeroNode temp = head;
		while(true)
		{
			if(temp.next==null)
			{
				break;
			}
			count++;
			temp = temp.next;
		}
		return count;
	}

	public HeroNode findReverse(int index) {
	//���ҵ�����X��Ԫ��
		if (index>getlength()&& index<0) {
			return null;
		}
		HeroNode temp = head.next;
		for(int i =0; i<getlength()-index; i++)
		{
			temp =temp.next;
		}
		return temp;
	}

	public SingleLinkedList reverse() {
		HeroNode tempNode = head;
		SingleLinkedList newList = new SingleLinkedList();
		if (tempNode.next==null) {
			System.err.println("�б�Ϊ�գ��޷���ת");
		}
		int loopTime =getlength();
		for(int i =0; i<loopTime;i++)
		{	tempNode = head;
			while (true) {
				if(tempNode.next==null)
				{	
					break;
				}				
				tempNode= tempNode.next;
			}
			newList.Add(tempNode);
			delete(tempNode.number);		
			System.out.println(getlength());
		}
		return newList;
		
	}

	public static SingleLinkedList reverse2(SingleLinkedList before) {
	SingleLinkedList newList = new SingleLinkedList();
	int loopTime = before.getlength();
		for(int i= 1; i<=5;i++)
		{	
			HeroNode s = before.findReverse(i);
//			System.out.println(s);
			newList.Add(s);
		//	System.out.println(before.getlength());
		}
		return newList;
	}
	
	public static SingleLinkedList reverse3(SingleLinkedList before) {
		HeroNode cur = before.head.next;
		HeroNode n = null;
		HeroNode record = null;//��¼������������
		if (cur==null || cur.next==null	) {
			return before;
		}
		SingleLinkedList newlist = new SingleLinkedList();
		while(cur !=null)
		{	
			record = cur.next;
			cur.next = newlist.head.next;
			newlist.head.next= cur;
			cur = record;
		}
		
		return newlist; 
	}
	
	public static void reversePrint(SingleLinkedList before)
	{
		HeroNode first = before.head;
		Stack<HeroNode> stack = new Stack<HeroNode>();
		while(first.next !=null)
		{
			stack.push(first.next);
			first=first.next;
		}
		while(stack.size()!=0)
		{
			System.out.println(stack.pop());
		}
	}
	
}

	