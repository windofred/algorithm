package cn.red.sort.mytest;

/**
 * 
 * 选择排序
 * 
 * @author red
 *
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int[] array = {30, 40, 60, 10, 20, 50};
		SelectSort ss = new SelectSort();
		ss.selectSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public void selectSort(int[] array) {
		
		if (array == null || array.length <= 0) {
			return;
		}
		
		int i, j, min;
		for (i = 0; i < array.length; i++) {//N次循环
			min = i;
			for (j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {//(N-1)次比较
					min = j;//当前循环的最小值
				}
			}
			
			if (min != i) {//判断是否需要交换
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		
	}
	
}
