package cn.red.offer.second;

public class Problem58_2 {

	public static void main(String[] args) {
		String str = "abcdefg";
		String rotateString = leftRotateString(str, 2);
		System.out.println(rotateString);
		
	}
	
	public static String leftRotateString(String str, int n) {
		if (str == null || str.length() < 2 || str.length() <= n) {
			return str;
		}
		
		char[] array = str.toCharArray();
		// 将字符串分为两部分，需要左移的字符和不需要
		// 翻转前n个
		reverse(array, 0, n - 1);
		// 翻转后面的
		reverse(array, n, array.length - 1);
		// 整体翻转
		reverse(array, 0, array.length - 1);
		return String.valueOf(array);
	}
	
	// 翻转一个单词
	public static void reverse(char[] array, int start, int end) {
		char temp = ' ';
		while (start < end) {
			temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
	}

}
