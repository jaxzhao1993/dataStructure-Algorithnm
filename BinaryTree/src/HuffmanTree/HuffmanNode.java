package HuffmanTree;


public class HuffmanNode implements Comparable<HuffmanNode>{
	 Byte dataByte; //存放数据本身 比如'a'=>97 ' '=32
	 int weight; //权值,数据出现的次数
	 HuffmanNode left;
	 HuffmanNode right;
	
	 public HuffmanNode(Byte dataByte, int weight) {
		this.dataByte = dataByte;
		this.weight = weight;
	}

	@Override
	public int compareTo(HuffmanNode o) {
		
		return this.weight-o.weight;
	}

	@Override
	public String toString() {
		return "HuffmanNode [dataByte=" + dataByte + ", weight=" + weight + "]";
	}
	 
	public void preOrder() {
		System.out.println(this);
		if (this.left!=null) {
			this.left.preOrder();
		}
		if (this.right!=null) {
			this.right.preOrder();
		}
	}
	 
	 
}
