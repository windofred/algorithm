package cn.red.offer;

public class NumberOfOne {
	
	public static void main(String[] args) {
		NumberOfOne numberOfOne = new NumberOfOne();
		System.out.println(numberOfOne.numberOf1(11));
	}
	
	public int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
		
	}
}
