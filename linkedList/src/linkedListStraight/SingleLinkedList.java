package linkedListStraight;

import java.util.Stack;

public class SingleLinkedList {
	// 顶一个链表来进行管理

	// 先初始化一个头节点,不存放任何具体的数据
	private HeroNode head = new HeroNode(" ", 0, " ");

	/*
	 * 添加节点到单向链表 思路，当不考虑编号顺序： 1.找到当前列表的最后节点 2.将这个节点的next，指向新数据
	 */
	public void Add(HeroNode heroNode) { 
		// 因为head节点不能动，因此需要一个辅助变量
		HeroNode heroTemp = head;
		// 遍历链表，找到最后
	while(true)
	{
		if(heroTemp.next ==null)
			{break;}
		
		heroTemp= heroTemp.next;
	}
		// 循环过后，temp必然是指向链表的最后一个元素
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
			System.err.println("添加失败");
		}
		else {
			heroNode.next = temp.next;
			temp.next =heroNode;
		}
	}
	
	public void update(HeroNode heroNode) {
		if(head.next==null)
		{
			System.err.println("链表为空");
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
			System.err.println("没有找到该数据");
		}
	}
	
	public void list() { // 判断链表是否为空
		if (head.next == null) {
			System.err.println("链表为空");
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
			System.err.println("未找到该元素");
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
	//查找倒数第X个元素
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
			System.err.println("列表为空，无法反转");
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
		HeroNode record = null;//记录遍历到哪里了
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

	