package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
	//贪心覆盖问题
	public static void main(String[] args) {
		//创建广播电台，放入map中
		HashMap<String, HashSet<String>> radio = new HashMap<String, HashSet<String>>();
		// 将各个电台放入
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("成都");
		hashSet4.add("天津");

		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		
		//加入map
		radio.put("k1",hashSet1);
		radio.put("k2",hashSet2);
		radio.put("k3",hashSet3);
		radio.put("k4",hashSet4);
		radio.put("k5",hashSet5);
		
		HashSet<String> allAreas = new HashSet<String>();
		for (String area : hashSet1) {
			allAreas.add(area);
		}
		for (String area : hashSet2) {
			allAreas.add(area);
		}
		for (String area : hashSet3) {
			allAreas.add(area);
		}
		for (String area : hashSet4) {
			allAreas.add(area);
		}
		for (String area : hashSet5) {
			allAreas.add(area);
		}
		
		System.out.println(allAreas);
		ArrayList<String> selection = new ArrayList<String>();
		//定义一个临时集合，在遍历的过程中，已经覆盖的地区，和 还没有覆盖地区的交集.
		HashSet<String> tempHashSet = new HashSet<String>();
		//max,保存一次遍历中，能覆盖最多未覆盖地区对应电台的key
		String maxKey = null;
		//如果maxkey不为空，则会加入select中
		while(allAreas.size()!=0) {
			maxKey = null;
			for(String key: radio.keySet()) {
				tempHashSet.clear();
				//当前key能够覆盖的地区
				HashSet<String> areas = radio.get(key);
				tempHashSet.addAll(areas);
				System.out.println(tempHashSet);
				//求出两个集合的交集
				tempHashSet.retainAll(allAreas);
				
				//如果tempset 覆盖的区域，比之前maxkey覆盖的区域大
				if (tempHashSet.size()>0 && (maxKey==null || 
						tempHashSet.size()> radio.get(maxKey).size()) ){
					maxKey = key;
				}
			}
			//将maxkey加入selection中
			if (maxKey!=null) {
				selection.add(maxKey);
				allAreas.removeAll(radio.get(maxKey));
			} 
		}
		
		System.out.println("结果: " + selection );
	}
	
}
