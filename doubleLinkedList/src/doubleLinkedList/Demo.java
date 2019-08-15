package doubleLinkedList;

public class Demo {
public static void main(String[] args) {
	DoubleLinkedList list = new DoubleLinkedList();
	HeroNode h1 = new HeroNode("宋江", 10, "呼保义");
	HeroNode h2 = new HeroNode("卢俊义", 20, "玉麒麟");
	HeroNode h3 = new HeroNode("吴用", 30, "智多星");
	HeroNode h4 = new HeroNode("公孙胜", 40, "入云龙");
	HeroNode h5 = new HeroNode("大刀", 50, "关胜");
	HeroNode h6 = new HeroNode("XXX", 51, "渣渣辉");

//	list.add(h1);
//	list.add(h5);
//	list.add(h3);
//	list.add(h4);
//	list.add(h2);
	//更改
//	list.change(h6);
//	list.list();
	System.out.println("================");

//	list.delete(2);
//	list.list();
	
	list.addByNumber(h3);
	list.addByNumber(h1);
	list.addByNumber(h5);
	list.addByNumber(h2);
	list.addByNumber(h4);
	list.addByNumber(h6);
	list.list();
}
}
