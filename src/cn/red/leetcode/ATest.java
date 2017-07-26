package cn.red.leetcode;

public class ATest {
	public static void main(String args[]) {
		Sub sub = new Sub();
		System.out.println(sub.x); // 1:1
		System.out.println(sub.n); // 2:50
		System.out.println(sub.method1()); // 3:1
		System.out.println(sub.method2()); // 4:50
		
		Super supsub = new Sub();
		System.out.println(supsub.x); // 5:1
		System.out.println(supsub.n); // 6:51
		System.out.println(supsub.method1());// 7:1
		System.out.println(supsub.method2());// 8:51
		
		Super sup = new Super();
		System.out.println(sup.x); // 9:1
		System.out.println(sup.n); // 10:50
		System.out.println(sup.method1()); // 11:2
		System.out.println(sup.method2()); // 12:50
	}
	
	
}

class Super {
	int x = 1, y = 2;
	// n是类变量
	static int n = 50;

	int method1() {
		return (x > y) ? x : y;
	}

	static int method2() {
		return n--;
	}
}

class Sub extends Super {
	int method1() {
		return (x < y) ? x : y;
	}

	static int method2() {
		return n++;
	}
}
