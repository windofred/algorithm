package cn.red.leetcode;

public class MyThread extends Thread {

	public static void main(String[] args) {
		// MyThread t = new MyThread();
		// MyThread s = new MyThread();
		// t.start();
		// System.out.println("one.");
		// s.start();
		// System.out.println("two.");

		// char a = 'a';
		// int b = a % 3;
		// System.out.println(b);

//		boolean returnTest = MyThread.returnTest();
//		System.out.println("hello world...");
//		
//		Float a = 1.0;
		
		Float s = new Float(1.0f);
		Float t = new Float(1.0f);
		System.out.println(s.equals(t));
	}

	public static boolean returnTest() {
		try {
			System.out.println("try before...");
			return true;
		} catch (Exception e) {

		} finally {
			System.out.println("finally before...");
			return false;
		}
	}
	
	public static int returnTest(int a, int b) {
		return 0;
	}

}
