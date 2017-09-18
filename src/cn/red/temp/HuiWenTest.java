package cn.red.temp;

/**
 * 回文字符串的判定
 * @author sala
 *
 */
public class HuiWenTest {
	
	public static void main(String[] args) {
		String str = "level";
		//reverse(str, 0, str.length() - 1);
		
		boolean huiWen = isHuiWen(str);
		System.out.println(huiWen);
		
	}
	
	public static boolean isHuiWen(String str) {
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.toCharArray()[i] != str.toCharArray()[length - i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	// 判断数字是否是回文数
	/*public static int reverse() {
		
	}*/
	
	/*public static void reverse(String str, int left, int right) {
		char[] charArray = str.toCharArray();
		while (left < right) {
			char temp = charArray[left];
			charArray[left++] = charArray[right];
			charArray[right--] = temp;
		}
		
	}*/
}
