package cn.red.sort.mytest;

/**
 * 冒泡排序
 * @author red
 *
 */
public class BubbleSortTest {
	
	public static void main(String[] args) {
		BubbleSortTest bst = new BubbleSortTest();
		int[] arr = {20, 40, 30, 10, 60, 50};
		bst.bubbleSort(arr);
		
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
	}
	
	public void bubbleSort(int[] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		
		int i = 0;
		int j = 0;
		int flag = 0;
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
