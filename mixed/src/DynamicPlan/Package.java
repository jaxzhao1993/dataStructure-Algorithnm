package DynamicPlan;

public class Package {
	public static void main(String[] args) {
		int[] weight = {1,4,3};//��Ʒ������
		int[] val = {1500,3000,2000};
		
		int max_weight = 4;
		int n =val.length;
		
		//������ά���� , table[i][j]��ʾǰi����Ʒ�У��ܹ�װ�����ļ�ֵ
		int[][] table = new int[n+1][max_weight+1];
		int[][] path = new int[n+1][max_weight+1];
		
		for (int i = 0; i < table.length; i++) {
			//����һ����Ϊ0
			table[i][0] =0;
		}
		for(int i = 0; i<table[0].length;i++) {
			//��һ����ֵΪ0
			table[0][i]=0;
		}
		//��̬�滮
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[i].length; j++) {
				//��ΪI�Ǵ�1��ʼ
				if(weight[i-1]>j) {
					table[i][j]= table[i-1][j];
				}else {
					//Ϊ�˼�¼��Ʒ��ŵ����������
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
		
		
		//���table	
		for (int[] is : table) {
			for (int is2 : is) {
				System.out.print(is2+"\t");
			}
			System.out.println();
		}
		
		int i=  path.length-1; //�е�����±�
		int j = path[0].length-1; // �е�����±�
		while(i>0 && j>0) {
			//��path���ʼ����
			if (path[i][j]==1) {
				System.out.println("��"+i+"����Ʒ����");
				j=j-weight[i-1];
			}
			i--;
		}
	}
}
