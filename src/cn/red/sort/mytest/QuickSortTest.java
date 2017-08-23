package cn.red.sort.mytest;

/**
 * 快速排序
 * @author red
 *
 */
public class QuickSortTest {
	
	public static void main(String[] args) {
		QuickSortTest qst = new QuickSortTest();
		int[] arr = {30, 40, 60, 10, 20, 50};
		qst.quickSort(arr, 0, arr.length - 1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void quickSort(int[] arr, int left, int right) {
		
		if (arr == null || arr.length <= 0) {
			return;
		}
		
		if (left < right) {
			int i = left;
			int j = right;
			int x = arr[i];// 基准值
			
			while (i < j) {
				while (i < j && arr[j] > x) {// 从右往左查找比x小的值
					j--;
				}
				if (i < j) {
					arr[i++] = arr[j];
				}
				while (i < j && arr[i] < x) {// 从左往右查找比x大的值
					i++;
				}
				if (i < j) {
					arr[j--] = arr[i];
				}
			}
			
			arr[i] = x;// 中间值左边的数都比中间值小；右边的数都比中间值大
			
			// 递归排序
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
	}
	
}
