package cn.red.leetcode;

public class Test2 {
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.test();
	}
	
	public void add(Byte b) {
		b = b++;
	}

	public void test() {
		Byte a = 127;
		Byte b = 127;
		add(++a);
		System.out.print(a + " ");
		add(b);
		System.out.print(b + "");
	}
}
