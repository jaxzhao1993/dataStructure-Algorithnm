package circleLinkedList;

import java.util.Iterator;

public class CircleLinkedList {

	private GameBoy firstboy;
	
	public void add(int number) {
		GameBoy curBoy = null;
		if(number< 1)
		{
			System.err.println("数据不正确");
			return;
		}
		
		for(int i =1; i<number+1; i++)
		{
			GameBoy boy = new GameBoy(i);
			//如果是第一个小孩
			if(i==1)
			{	
				firstboy = boy;
				firstboy.setNextBoy(firstboy); //构成环
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
			System.err.println("空");
			return;
		}
		GameBoy tempBoy =firstboy;
		while(true)
		{	System.out.printf("小孩的编号%d \t", tempBoy.getNumber() );
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
		//curBoy指向是链表的最后一个元素
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
			System.out.println("startboy现在是"+startBoy);
			for (int i = 0; i < count-1; i++) {				
				startBoy=startBoy.getNextBoy();	
			}
			System.err.println("要删掉"+startBoy);
			delete(startBoy.getNumber());
			startBoy = firstboy;
		}
		System.out.println("最后的幸运儿是：" +firstboy);
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
		
		System.out.println("游戏开始时");
		System.out.println("从"+firstboy+"开始");
		System.out.println("helper指针位置"+helperBoy);		
		//根据用书输入，计算小孩出圈顺序
		
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
			System.out.println("被淘汰的是:"+startBoy);
				firstboy= startBoy.getNextBoy();
				helperBoy.setNextBoy(firstboy);
				startBoy = firstboy;
		}
		System.err.println("最后剩下的："+firstboy);
		
		
	}

}
