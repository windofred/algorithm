package cn.red.offer.second;

/**
 * 最长不含重复字符的子字符串
 * @author sala
 *
 */
public class Problem48 {
	
	public static void main(String[] args) {
		String str = "arabcacfr";
		int i = longestSubstring(str);
		System.out.println(i);
	}
	
	public static int longestSubstring(String str) {
		int curLength = 0;
		int maxLength = 0;
		
		char[] charArray = str.toCharArray();
		
		int[] position = new int[26];
		for (int i = 0; i < 26; i++) {
			position[i] = -1;
		}
		
		for (int i = 0; i < str.length(); i++) {
			int prevIndex = position[charArray[i] - 'a'];
			if (prevIndex < 0 || i - prevIndex > curLength) {
				++curLength;
			} else {
				if (curLength > maxLength) {
					maxLength = curLength;
				}
				curLength = i - prevIndex;
			}
			position[charArray[i] - 'a'] = i;
		}
		
		if (curLength > maxLength) {
			maxLength = curLength;
		}
		
		return maxLength;
	}
	
}
