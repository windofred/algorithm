package cn.red.offer.second;

public class Problem58 {

	public static void main(String[] args) {
		String str = "I am a student.";
		String reverseSentence = reverseSentence(str);
		System.out.println(reverseSentence);
	}
	
	public static String reverseSentence(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		char[] array = str.toCharArray();
		// 第一步：翻转句子中的所有字符
		reverse(array, 0, array.length - 1);
		// 第二步：翻转每个单词中每个字符的顺序
		// 单词的起始位置
		int start = 0;
		// 单词的终止位置
		int end = 0;
		while (end < str.length()) {
			if (array[end] != ' ') {
				if (end == array.length - 1) {
					reverse(array, start, end);
				}
				end++;
			} else if (array[end] == ' ') {
				// 如果遇到空格，把空格之前的单词翻转，并把start置为end
				reverse(array, start, end - 1);
				end++;
				start = end;
			}
		}
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
