package doubleLinkedList;

public class Demo {
public static void main(String[] args) {
	DoubleLinkedList list = new DoubleLinkedList();
	HeroNode h1 = new HeroNode("�ν�", 10, "������");
	HeroNode h2 = new HeroNode("¬����", 20, "������");
	HeroNode h3 = new HeroNode("����", 30, "�Ƕ���");
	HeroNode h4 = new HeroNode("����ʤ", 40, "������");
	HeroNode h5 = new HeroNode("��", 50, "��ʤ");
	HeroNode h6 = new HeroNode("XXX", 51, "������");

//	list.add(h1);
//	list.add(h5);
//	list.add(h3);
//	list.add(h4);
//	list.add(h2);
	//����
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
