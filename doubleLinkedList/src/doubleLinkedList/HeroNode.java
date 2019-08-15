package doubleLinkedList;
 //单向链表的分析

/*思路
 * 1.先创建一个head头节点，表示开头
 * 2.每添加一个节点，就直接加入到链表的最后遍历
 * 
 * 遍历：通过一个辅助遍历
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
