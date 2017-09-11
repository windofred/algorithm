package cn.red.offer.second;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 第一个只出现一次的字符
 * @author sala
 *
 */
public class Problem50 {
	
	public static void main(String[] args) {
		String str = "abaccdeff";
		int i = firstRepeatingChar(str);
		System.out.println(str.toCharArray()[i]);
		
	}
	
	public static int firstRepeatingChar(String str) {
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char[] charArray = str.toCharArray();
		
		for (char c : charArray) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for (char c : charArray) {
			if (map.get(c) == 1) {
				return str.indexOf(c);
			}
		}
		
		return -1;
	}
	
}
