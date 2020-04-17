package week3.day4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LearnMap {
	
	

	public static void main(String[] args) throws InterruptedException {

		Map<String, String> mp = new LinkedHashMap<String, String>();
		mp.put("ACC001", "Divya");
		mp.put("ACC002", "Dinesh");
		mp.put("ACC003", "Kumar");
		mp.put("ACC004", "Elangovan");
		

		
		for (Entry<String, String> eachItem : mp.entrySet())
		{
		System.out.println(eachItem.getValue());
		}
		

}
}