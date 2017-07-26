package cn.red.leetcode;

/**
 * 典型的递归问题
 * 思想：对于前一个数，找出相同元素的个数，把个数和该元素存到新的string里
 * @author red
 *
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		String string = countAndSay.countAndSay(5);
		System.out.println(string);
	}
	
	public String countAndSay(int n) {
		if (n < 1) {
			return null;
		}
		
		// n=1时，直接返回"1"
		String result = "1";
		
		// n>=2时，需要解析字符串
		for (int i = 2; i <= n; i++) {
			result = countAndSay(result);
		}
		
		return result;
	}
	
	public String countAndSay(String str) {
		StringBuilder builder = new StringBuilder(128);
		
		// 记录数字重复的个数
		int count = 1;
		// 解析字符串
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				builder.append(count);
				builder.append(str.charAt(i - 1));
				count = 1;
			}
		}
		
		builder.append(count);
		builder.append(str.charAt(str.length() - 1));
		return builder.toString();
	}
}
