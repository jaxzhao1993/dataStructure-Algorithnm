package linkedListStraight;

public class Demo {
public static void main(String[] args) {
	SingleLinkedList list = new SingleLinkedList();
	HeroNode h1 = new HeroNode("宋江", 1, "呼保义");
	HeroNode h2 = new HeroNode("卢俊义", 2, "玉麒麟");
	HeroNode h3 = new HeroNode("吴用", 3, "智多星");
	HeroNode h4 = new HeroNode("公孙胜", 4, "入云龙");
	HeroNode h5 = new HeroNode("大刀", 5, "关胜");

	list.addByNumber(h1);
	list.addByNumber(h4);
	list.addByNumber(h3);
	list.addByNumber(h2);
	list.addByNumber(h5);
	
//	更改某个元素	
//	list.update(h5);
	list.list();

//	遍历得到链表的长度
//	System.out.println(list.getlength());
	System.out.println("================");
	
	//删除
//	list.delete(1);
//	list.list();
//	System.out.println(list.getlength());
	
	//查找倒数第几个元素
//	System.out.println(list.findReverse(4));
	
//	反转1
//	SingleLinkedList newList = list.reverse();
//	newList.list();
	
// 反转2	
//	SingleLinkedList newList = SingleLinkedList.reverse2(list);
//	newList.list();
	
	
	
//	反转3
//	SingleLinkedList newList = SingleLinkedList.reverse3(list);
//	newList.list();
	
// 用栈进行反转打印
	SingleLinkedList.reversePrint(list);
}
}
