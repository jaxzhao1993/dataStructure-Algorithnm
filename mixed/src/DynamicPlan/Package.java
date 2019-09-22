package DynamicPlan;

public class Package {
	public static void main(String[] args) {
		int[] weight = {1,4,3};//物品的重量
		int[] val = {1500,3000,2000};
		
		int max_weight = 4;
		int n =val.length;
		
		//创建二维数组 , table[i][j]表示前i个物品中，能够装入最大的价值
		int[][] table = new int[n+1][max_weight+1];
		int[][] path = new int[n+1][max_weight+1];
		
		for (int i = 0; i < table.length; i++) {
			//将第一列设为0
			table[i][0] =0;
		}
		for(int i = 0; i<table[0].length;i++) {
			//第一行设值为0
			table[0][i]=0;
		}
		//动态规划
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[i].length; j++) {
				//因为I是从1开始
				if(weight[i-1]>j) {
					table[i][j]= table[i-1][j];
				}else {
					//为了记录商品存放到背包的情况
//					table[i][j]= Math.max(table[i-1][j-weight[i-1]]+val[i-1], table[i-1][j]);
					if(table[i-1][j] <=table[i-1][j-weight[i-1]]+val[i-1]){
						path[i][j] = 1;
						table[i][j]=table[i-1][j-weight[i-1]]+val[i-1];
						}
					else {
						table[i][j]= table[i-1][j];
					}
				}
			}
		}
		
		
		//输出table	
		for (int[] is : table) {
			for (int is2 : is) {
				System.out.print(is2+"\t");
			}
			System.out.println();
		}
		
		int i=  path.length-1; //行的最大下标
		int j = path[0].length-1; // 列的最大下标
		while(i>0 && j>0) {
			//从path最后开始回溯
			if (path[i][j]==1) {
				System.out.println("第"+i+"个商品放入");
				j=j-weight[i-1];
			}
			i--;
		}
	}
}
