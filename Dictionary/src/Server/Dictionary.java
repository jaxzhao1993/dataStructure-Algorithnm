package Server;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
	public static Map<String, String> dictionaryMap = new HashMap<String, String>();
	static {
		dictionaryMap.put("nihao", "say hello to someone");
		dictionaryMap.put("zaijian", "say goodbye to someone");
		dictionaryMap.put("shenqi", "something amazing");
	}
	
	public static String addNewWord(String wordName, String description) {
	 
		if(dictionaryMap.containsKey(wordName))
		{
			System.out.println(wordName+ "is already in dictionary");
			return "failed,"+wordName+"is already in dictionary";
		}else {
			dictionaryMap.put(wordName, description);
			return "successfully";
		}		
	}

	public static String search(String word) {
		if (dictionaryMap.containsKey(word)) {
			String description = dictionaryMap.get(word);
			return description;
		}else {
			System.err.println(word +" is not included");
			return "sorry, "+word+"is not included";
		}
	}
	
	public static String remove(String word) {
		if (dictionaryMap.containsKey(word)) {
			dictionaryMap.remove(word);
			return "successful";
			
		}else {
			System.err.println(word +" is not included");
			return "failed "+ word +" is not included";
		}
	}
	
	
}
