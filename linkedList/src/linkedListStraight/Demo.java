package linkedListStraight;

public class Demo {
public static void main(String[] args) {
	SingleLinkedList list = new SingleLinkedList();
	HeroNode h1 = new HeroNode("�ν�", 1, "������");
	HeroNode h2 = new HeroNode("¬����", 2, "������");
	HeroNode h3 = new HeroNode("����", 3, "�Ƕ���");
	HeroNode h4 = new HeroNode("����ʤ", 4, "������");
	HeroNode h5 = new HeroNode("��", 5, "��ʤ");

	list.addByNumber(h1);
	list.addByNumber(h4);
	list.addByNumber(h3);
	list.addByNumber(h2);
	list.addByNumber(h5);
	
//	����ĳ��Ԫ��	
//	list.update(h5);
	list.list();

//	�����õ�����ĳ���
//	System.out.println(list.getlength());
	System.out.println("================");
	
	//ɾ��
//	list.delete(1);
//	list.list();
//	System.out.println(list.getlength());
	
	//���ҵ����ڼ���Ԫ��
//	System.out.println(list.findReverse(4));
	
//	��ת1
//	SingleLinkedList newList = list.reverse();
//	newList.list();
	
// ��ת2	
//	SingleLinkedList newList = SingleLinkedList.reverse2(list);
//	newList.list();
	
	
	
//	��ת3
//	SingleLinkedList newList = SingleLinkedList.reverse3(list);
//	newList.list();
	
// ��ջ���з�ת��ӡ
	SingleLinkedList.reversePrint(list);
}
}
