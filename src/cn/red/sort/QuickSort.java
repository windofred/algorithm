package cn.red.sort;

import org.junit.Test;

/**
 * 
 * 快速排序使用分治法策略
 * 
 * 快速排序流程：
 *     1.从数列中挑出一个基准值
 *     2.将所有比基准值小的放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置
 *     3.递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序
 *     
 *     [快速排序.jpg]只是给出了第1趟快速排序的流程。在第1趟中，设置x=a[i]，即x=30。
 *	   (01) 从"右 --> 左"查找小于x的数：找到满足条件的数a[j]=20，此时j=4；然后将a[j]赋值a[i]，此时i=0；接着从左往右遍历。
 *	   (02) 从"左 --> 右"查找大于x的数：找到满足条件的数a[i]=40，此时i=1；然后将a[i]赋值a[j]，此时j=4；接着从右往左遍历。
 *     (03) 从"右 --> 左"查找小于x的数：找到满足条件的数a[j]=10，此时j=3；然后将a[j]赋值a[i]，此时i=1；接着从左往右遍历。
 *	   (04) 从"左 --> 右"查找大于x的数：找到满足条件的数a[i]=60，此时i=2；然后将a[i]赋值a[j]，此时j=3；接着从右往左遍历。
 *     (05) 从"右 --> 左"查找小于x的数：没有找到满足条件的数。当i>=j时，停止查找；然后将x赋值给a[i]。此趟遍历结束！

按照同样的方法，对子数列进行递归遍历。最后得到有序数组！
 *     
 * 快速排序稳定性：
 *     快速排序是不稳定的算法，它不满足稳定算法的定义
 *     算法稳定性：假设在数列中存在a[i] = a[j]，若在排序之前a[i]在a[j]前面；而且排序之后，a[i]仍然在a[j]前面，则这个算法是稳定的    
 * 
 * 快速排序时间复杂度
 *     快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 *	        这句话很好理解：假设被排序的数列中有N个数。遍历一次的时间复杂度是O(N)，需要遍历多少次呢？至少lg(N+1)次，最多N次。
 *	       (01) 为什么最少是lg(N+1)次？快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，它需要遍历的次数就是二叉树的深度，
 *		        而根据完全二叉树的定义，它的深度至少是lg(N+1)。因此，快速排序的遍历次数最少是lg(N+1)次。
 *	       (02) 为什么最多是N次？这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N。因此，快读排序的遍历次数最多是N次。
 * 
 * @author red
 *
 */
public class QuickSort {
	
	@Test
	public void test1() {
		int[] array = {30, 40, 60, 10, 20, 50};
		//int[] array = null;
		QuickSort qs = new QuickSort();
		qs.quickSort(array, 0, array.length - 1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public void quickSort(int[] array, int left, int right) {
		if (array == null || array.length == 0) {
			return;
		}
		
		if (left < right) {
			int i = left;
			int j = right;
			int x = array[i];
			
			while (i < j) {
				while (i < j && array[j] > x) {//从右向左查找比x小的数
					j--;
				}
				if (i < j) {
					array[i++] = array[j];//将该值交换到i的位置
				}
				while (i < j && array[i] < x) {//从左向右查找比x大的数
					i++;
				}
				if (i < j) {
					array[j--] = array[i];//将该值交换到j的位置
				}
			}
			
			array[i] = x;//当i >= j时，停止查找，设置a[i] = x
			
			//递归排序
			quickSort(array, left, i - 1);
			quickSort(array, i + 1, right);
		}
		
	}
	
}
