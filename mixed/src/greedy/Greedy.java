package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Greedy {
	//̰�ĸ�������
	public static void main(String[] args) {
		//�����㲥��̨������map��
		HashMap<String, HashSet<String>> radio = new HashMap<String, HashSet<String>>();
		// ��������̨����
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("����");
		hashSet1.add("�Ϻ�");
		hashSet1.add("���");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("����");
		hashSet2.add("����");
		hashSet2.add("����");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3.add("����");
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("�ɶ�");
		hashSet4.add("���");

		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("����");
		hashSet5.add("����");
		
		//����map
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
		//����һ����ʱ���ϣ��ڱ����Ĺ����У��Ѿ����ǵĵ������� ��û�и��ǵ����Ľ���.
		HashSet<String> tempHashSet = new HashSet<String>();
		//max,����һ�α����У��ܸ������δ���ǵ�����Ӧ��̨��key
		String maxKey = null;
		//���maxkey��Ϊ�գ�������select��
		while(allAreas.size()!=0) {
			maxKey = null;
			for(String key: radio.keySet()) {
				tempHashSet.clear();
				//��ǰkey�ܹ����ǵĵ���
				HashSet<String> areas = radio.get(key);
				tempHashSet.addAll(areas);
				System.out.println(tempHashSet);
				//����������ϵĽ���
				tempHashSet.retainAll(allAreas);
				
				//���tempset ���ǵ����򣬱�֮ǰmaxkey���ǵ������
				if (tempHashSet.size()>0 && (maxKey==null || 
						tempHashSet.size()> radio.get(maxKey).size()) ){
					maxKey = key;
				}
			}
			//��maxkey����selection��
			if (maxKey!=null) {
				selection.add(maxKey);
				allAreas.removeAll(radio.get(maxKey));
			} 
		}
		
		System.out.println("���: " + selection );
	}
	
}
