package cn.red.offer;

/**
 * 替换空格
 * @author red
 *
 */
public class ReplaceBlank {
	
	public static void main(String[] args) {
		String s = "we are happy.";
		System.out.println(replaceBlank(s));
	}
	
	public static String replaceBlank(String input) {
		if (input == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				buffer.append("%");
				buffer.append("2");
				buffer.append("0");
			} else {
				buffer.append(String.valueOf(input.charAt(i)));
			}
		}
		return buffer.toString();
	}
	
}
