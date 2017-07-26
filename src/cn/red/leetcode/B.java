package cn.red.leetcode;

class A {
	A() {
		System.out.println("Base");
	}
}

public class B extends A {
	public static void main(String[] args) {
		new B();
		new A();
	}
}


