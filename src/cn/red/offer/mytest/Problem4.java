package cn.red.offer.mytest;

import org.junit.Test;

/**
 * 
 * 字符串
 * 
 * 面试题4：替换空格
 * 
 * 
 * 
 * @author red
 *
 */
public class Problem4 {
	
	@Test
	public void test1() {
		String str = "we are happy.";
		Problem4 p4 = new Problem4();
		String space = p4.replaceSpace(str);
		System.out.println(space);
	}

	public String replaceSpace(String str) {
		if (str == null) {
			return null;
		}
		
		StringBuffer outputBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				outputBuffer.append("%");
				outputBuffer.append("2");
				outputBuffer.append("0");
			} else {
				outputBuffer.append(String.valueOf(str.charAt(i)));
			}
		}
		
		return new String(outputBuffer);
	}

}
