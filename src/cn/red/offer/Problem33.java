package cn.red.offer;

public class Problem33 {
	
	public static void main(String[] args) {
		
	}
	
	private void printMinNumber(int[] array, int start, int end) {
		if (start < end) {
			int mainNumber = array[end];
			int smallCur = array[start];
			for (int j = start; j < end; j++) {
				
			}
		}
	}
	
	private boolean isSmall(String m, String n) {
		String left = m + n;
		String right = n + m;
		boolean result = false;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) < right.charAt(i)) {
				return true;
			} else {
				if (right.charAt(i) < left.charAt(i)) {
					return false;
				}
			}
		}
		return result;
	}
	
}
