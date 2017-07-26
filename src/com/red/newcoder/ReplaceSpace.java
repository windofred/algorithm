package com.red.newcoder;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author red
 *
 */
public class ReplaceSpace {
	
	public static void main(String[] args) {
		String space = ReplaceSpace.replaceSpace(new StringBuffer("We are happy"));
		System.out.println(space);
		
	}
	
	public static String replaceSpace(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			char index = str.charAt(i);
			if (index == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		
		return str.toString();
	}
}
