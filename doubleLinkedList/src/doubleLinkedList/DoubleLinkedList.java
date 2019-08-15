package doubleLinkedList;

public class DoubleLinkedList {
	// 顶一个链表来进行管理

	// 先初始化一个头节点,不存放任何具体的数据
	private HeroNode head = new HeroNode(" ", 0, " ");

	public HeroNode getHead() {
		return head;
			}
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (temp.next!=null) {
			if (temp.next.number ==heroNode.number) {
				return;
			}
			temp =temp.next;
		}
		
		temp.next = heroNode;
		heroNode.pre =temp;
	}
	
	public void addByNumber(HeroNode heroNode) {
		HeroNode temp = head;
		while(true)
		{	
			if (temp.next==null) {
				break;
			}
			if(temp.next.number> heroNode.number)
			{	
				break;
			}
			if (temp.next.number == heroNode.number) {
				System.out.println("重复元素，添加失败");
				return;
			}
			temp= temp.next;
		}
		
		if (temp.next!=null) {
			heroNode.next = temp.next;
			temp.next.pre = heroNode;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
		
	}
	
	public void change(HeroNode heroNode) {
		HeroNode temp = head;
		boolean isFind = false;
		while (temp.next !=null) {
			temp= temp.next;
			if(temp.number == heroNode.number)
			{	isFind = true;
				break;
			}
		}
		if(isFind)
		{	
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		}else {
			System.out.println("未找到该元素");
		}
		
	}
	
	public void delete(int number) {
		HeroNode temp = head.next;
		boolean isFind = false;
		while(temp !=null)
		{	
			if (temp.number==number) {
				isFind = true;
				break;
			}
			temp = temp.next;
		}
		if(isFind)
		{	
			temp.pre.next = temp.next;
			if(temp.next !=null)
			{	//如果temp是最后一个元素.temp.next为空，temp.next就没有pre
			temp.next.pre = temp.pre;
			}
		}else {
			System.err.println("未找到");
		}
	}
	
	public void list() {
		HeroNode temp = head.next;
		while(temp!=null)
		{
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	public String toString(HeroNode heroNode) {
		return "Hero=["+heroNode.name+"]  number=["+heroNode.number+"]  nickname=["+heroNode.nickName+"]";
	}
	
}

	