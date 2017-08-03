package cn.red.sort;

/**
 * 
 * 1.基本思想
 *     把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表只包含1个元素，无序表中包含有n-1个元素
 *     排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 *     
 *     将数列分为有序区和无序区，需要做的工作只有两个：
 *         ①取出无序区中的第1个数，并找出它在有序区对应的位置
 *         ②将无序区的数据插入到有序区；若有必要的话，则对有序区中的相关数据进行移位
 *     
 * 2.时间复杂度
 *     直接插入排序的时间复杂度是O(N*N)
 *     假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1！因此，直接插入排序的时间复杂度是O(N*N)
 * 
 * 3.稳定性
 *     直接插入排序是稳定的算法，它满足稳定算法的定义。    
 *         
 * 
 * @author red
 *
 */
public class InsertSort {
	
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		int[] tempArray = {20, 30, 40, 10, 60, 50};
		is.insertSort(tempArray);
		
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i] + " ");
		}
	}
	
	public void insertSort(int[] array) {
		
		if (array == null || array.length <= 0) {
			return;
		}
		
		int i, j, k;
		for (i = 1; i < array.length; i++) {
			
			// 为a[i]在前面的[0...i-1]找一个合适的位置
			for (j = i - 1; j >= 0; j--) {
				// 因为[0...i-1]都是有序的，所以只要array[j] < array[i]，就说明array[i]的当前位置就是合适的位置
				if (array[j] < array[i]) {
					// break的作用是跳出当前循环块(for while do while)或程序块(switch)
					// 在循环块中的作用是跳出当前正在循环的循环体。
					break;
				}
			}
			
			// 如果找到了一个合适的位置
			if (j != i - 1) {// 说明array[i]的合适位置不是当前位置
				// 将比a[i]大的数据向后移(将i和j之间的数据(k)向后移)
				int temp = array[i];
				for (k = i - 1; k > j; k--) {
					array[k + 1] = array[k];
				}
				array[k + 1] = temp;
			}
		}
		
	}
	
}
