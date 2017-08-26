package cn.red.sort.mytest;

public class HeapSort {
	
	public static void main(String[] args) {
		
	}
	
	public void maxHeapDown(int[] a, int start, int end) {
		int current = start;
		int left = 2 * current + 1;
		int temp = a[current];
		
		for (; left <= end; current = left,left = 2 * left + 1) {
			
		}
	}
	
}
