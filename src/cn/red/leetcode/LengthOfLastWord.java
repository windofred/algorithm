package cn.red.leetcode;

/**
 * 求取字符串最后一个单词的长度
 * @author red
 *
 */
public class LengthOfLastWord {
	
	// 测试
	public static void main(String[] args) {
		LengthOfLastWord ll = new LengthOfLastWord();
		int lengthOfLastWord = ll.lengthOfLastWord("hello world java");
		System.out.println(lengthOfLastWord);
	}
	
	public int lengthOfLastWord(String s) {
		// 如果字符串为""或者"  "
		if (s.trim().equals("") || s.length() == 0) {
			return 0;
		}
		
		// 将字符串以空格分隔
		String[] ss = s.trim().split(" ");
		// 字符串包含的单词的个数
		int len = ss.length;
		// 返回最后一个单词的长度
		return ss[len - 1].length();
		
	}
}
