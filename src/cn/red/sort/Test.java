package cn.red.sort;

public class Test {
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

	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}

}