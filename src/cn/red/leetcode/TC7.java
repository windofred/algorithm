package cn.red.leetcode;

public class TC7 {
	static void mathodA( )
	{
		try {
			System.out.println("methodA抛出一个异常");
			throw new RuntimeException();
		}
		finally {
			System.out.println("执行methodA的finally");
		}
	}
	public static void main(String args[])
	{
		try {
			mathodA();
		}
		catch(Exception e) {
			System.out.println("产生异常");
		}
	}
}