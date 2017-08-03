package cn.red.sort;

/**
 * 
 * 1.基本思想：
 *         
 *     
 * 2.时间复杂度：
 *     希尔排序的时间复杂度与增量(步长gap)选取有关。例如，当增量为1时，希尔排序退化成了直接插入排序，此时的时间复杂度为O(N*N)
 *     而Hibbard增量的希尔排序的时间复杂度为O(N3/2)
 *     
 *     
 * 3.稳定性：
 *     希尔排序是不稳定的算法，它不满足稳定算法的定义。对于相同的两个数，可能由于分在不同的组中而导致它们的顺序发生变化。
 * 
 * @author red
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		ShellSort ss = new ShellSort();
		int[] tempArray = {80, 30, 60, 70, 50, 10, 20, 40};
		ss.shellSort(tempArray);
		
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i] + " ");
		}
	}
	
	public void shellSort(int[] array) {
		
		int i, gap;
		
		for (gap = array.length / 2; gap > 0; gap = gap / 2) {
			// 对每组执行直接插入排序
			for (i = 0; i < gap; i++) {
				groupSort(array, array.length, i, gap);
			}
		}
		
	}
	
	public void groupSort(int a[], int n, int i, int gap) {
		
		int j;
		
		for (j = i + gap; j < n; j += gap) 
	    {
	        // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
	        if (a[j] < a[j - gap])
	        {
	            int tmp = a[j];
	            int k = j - gap;
	            while (k >= 0 && a[k] > tmp)
	            {
	                a[k + gap] = a[k];
	                k -= gap;
	            }
	            a[k + gap] = tmp;
	        }
	    }
	}
	
}
