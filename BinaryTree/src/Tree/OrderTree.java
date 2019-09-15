package Tree;

public class OrderTree extends BinaryTree{
	//将数组存储在二叉树中，可以实现相互转化,
	
	//顺序二叉树通常只考虑完全二叉树
	//第n个元素的左子节点为2n+1,右子节点为2n+2
	//第n个元素的父节点 (n-1)/2
	private int[] array;
	
	public OrderTree(int[] array) {
		this.array = array;
	}
	
	public void preOrder(int index){
		//如果数组为空，或者arr.length=0
		if (array==null || array.length==0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		//输出当前这个元素
		System.out.println(array[index]);
		//向左递归遍历
		if(index*2+1<array.length)
		{
			preOrder(2*index+1);
		}
		//向右递归遍历
		if(index*2+2<array.length)
		{
			preOrder(index*2+2);
		}
	}
}



