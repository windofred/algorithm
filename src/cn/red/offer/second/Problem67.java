package cn.red.offer.second;

/**
 * 把字符串转换成数字
 * @author sala
 *
 */
public class Problem67 {
	
	public static void main(String[] args) {
		String str = "2147483648";
		int toInt = stringToInt(str);
		System.out.println(toInt);
		//int result = toInt + 123;
		//System.out.println(result);
	}
	
	public static int stringToInt(String str) {
		if (str == null || str.length() <= 0) {
			return 0;
		}
		
		char first = str.charAt(0);
		if (first == '-') {
			return parseString(str, 1, false);
		} else if (first == '+') {
			return parseString(str, 1, true);
		} else if (first >= '0' && first <= '9') {
			return parseString(str, 0, true);
		} else {
			throw new NumberFormatException();
		}
	}
	
	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static int parseString(String str, int index, boolean positive) {
		if (index >= str.length()) {
			throw new NumberFormatException();
		}
		
		int result;
		long tmp = 0;
		while (index < str.length() && isDigit(str.charAt(index))) {
			tmp = tmp * 10 + str.charAt(index) - '0';
			if (tmp > 0x80000000L) {
				throw new NumberFormatException();
			}
			index++;
		}
		
		if (positive) {
			if (tmp >= 0x80000000L) {
				throw new NumberFormatException();
			} else {
				return (int) tmp;
			}
		} else {
			if (tmp == 0x80000000L) {
				result = 0x80000000;
			} else {
				result = (int) -tmp;
			}
		}
		
		return result;
	}
	
}
