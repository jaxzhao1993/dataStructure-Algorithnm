package doubleLinkedList;
 //��������ķ���

/*˼·
 * 1.�ȴ���һ��headͷ�ڵ㣬��ʾ��ͷ
 * 2.ÿ���һ���ڵ㣬��ֱ�Ӽ��뵽�����������
 * 
 * ������ͨ��һ����������
 * */


public class HeroNode {
	public String name;
	public int number;
	public String nickName;
	public HeroNode next;
	public HeroNode pre;
	
	public HeroNode(String name, int number, String nickName) {
		this.name = name;
		this.number = number;
		this.nickName = nickName;
	}
	

	public String toString() {
		return "Hero=["+name+"]  number=["+number+"]  nickname=["+nickName+"]";
	}

}
