package circleLinkedList;

import java.util.Iterator;

public class CircleLinkedList {

	private GameBoy firstboy;
	
	public void add(int number) {
		GameBoy curBoy = null;
		if(number< 1)
		{
			System.err.println("���ݲ���ȷ");
			return;
		}
		
		for(int i =1; i<number+1; i++)
		{
			GameBoy boy = new GameBoy(i);
			//����ǵ�һ��С��
			if(i==1)
			{	
				firstboy = boy;
				firstboy.setNextBoy(firstboy); //���ɻ�
				curBoy = firstboy;
			}else {
				curBoy.setNextBoy(boy);
				boy.setNextBoy(firstboy);
				curBoy = boy;
			}
			
		}
	}
	
	public void show() {
		if (firstboy ==null) {
			System.err.println("��");
			return;
		}
		GameBoy tempBoy =firstboy;
		while(true)
		{	System.out.printf("С���ı��%d \t", tempBoy.getNumber() );
			if (tempBoy.getNextBoy()== firstboy) {
				break;
			}
			tempBoy = tempBoy.getNextBoy();
		}
	}

	public void delete(int number) {
		GameBoy curBoy = firstboy;
		while(true)
		{
			if (curBoy.getNextBoy()==firstboy) {
				break;
			}
			curBoy= curBoy.getNextBoy();
		}
		//curBoyָ������������һ��Ԫ��
		GameBoy deletBoy = firstboy;
		while(true)
		{
			if (deletBoy.getNumber()==number) {
				break;
			}
			curBoy = deletBoy;
			deletBoy = deletBoy.getNextBoy();
		}
		System.out.println("deleteboy"+deletBoy);
		firstboy = deletBoy.getNextBoy();
		System.out.println("first"+firstboy);
		curBoy.setNextBoy(deletBoy.getNextBoy());
		System.out.println("cur"+curBoy);
	}

	public void game(int number) {
		int count = number;
		GameBoy startBoy = firstboy;
		int round=1;
		while (true) {
			System.out.println("round"+ round++);
			System.out.println("================");
			if (firstboy.getNextBoy()==firstboy) {
				break;
			}
			System.out.println("startboy������"+startBoy);
			for (int i = 0; i < count-1; i++) {				
				startBoy=startBoy.getNextBoy();	
			}
			System.err.println("Ҫɾ��"+startBoy);
			delete(startBoy.getNumber());
			startBoy = firstboy;
		}
		System.out.println("�������˶��ǣ�" +firstboy);
	}

	public void game2(int count)
	{	
		GameBoy helperBoy = firstboy;
		while(true)
		{
			if (helperBoy.getNextBoy()== firstboy) {
				break;
			}
			helperBoy =helperBoy.getNextBoy();
		}
		
		System.out.println("��Ϸ��ʼʱ");
		System.out.println("��"+firstboy+"��ʼ");
		System.out.println("helperָ��λ��"+helperBoy);		
		//�����������룬����С����Ȧ˳��
		
		GameBoy startBoy = firstboy;
		int round =1;
		while (true) 
		{	if(firstboy.getNextBoy()==firstboy)
			{
				break;
			}
			System.out.println("round:"+round++);
			System.out.println("================");
			for(int i = 0; i<count-1; i++)
			{
				startBoy= startBoy.getNextBoy();
				helperBoy= helperBoy.getNextBoy();
			}
			System.out.println("����̭����:"+startBoy);
				firstboy= startBoy.getNextBoy();
				helperBoy.setNextBoy(firstboy);
				startBoy = firstboy;
		}
		System.err.println("���ʣ�µģ�"+firstboy);
		
		
	}

}
