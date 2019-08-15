package doubleLinkedList;

public class DoubleLinkedList {
	// ��һ�����������й���

	// �ȳ�ʼ��һ��ͷ�ڵ�,������κξ��������
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
				System.out.println("�ظ�Ԫ�أ����ʧ��");
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
			System.out.println("δ�ҵ���Ԫ��");
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
			{	//���temp�����һ��Ԫ��.temp.nextΪ�գ�temp.next��û��pre
			temp.next.pre = temp.pre;
			}
		}else {
			System.err.println("δ�ҵ�");
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

	