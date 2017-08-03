package cn.red.sort.mytest;

public class BubbleSort {
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		//int[] tempArray = {20, 40, 60, 50, 10};
		int[] tempArray = null;
		
		bs.bubbleSort(tempArray);
		
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i] + " ");
		}
	}
	
	public void bubbleSort(int[] array) {
		
		if (array.length <= 0 || array == null) {
			return;
		}
		
		int i, j, flag;
		for (i = array.length - 1; i > 0; i--) {
			
			flag = 0;
			
			for (j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					
					flag = 1;
					
				}
			}
			
			if (flag == 0) {
				break;
			}
			
		}
		
	}
	
}
