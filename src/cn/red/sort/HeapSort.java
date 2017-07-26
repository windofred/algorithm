package cn.red.sort;

/**
 * 堆分为“最大堆”和“最小堆”，最大堆通常被用来作为“升序”排序；最小堆通常被用来作为“降序”排序
 * 
 * 1.将待排序的数组转化为二叉堆
 * 2.交换数据
 * 
 * 时间复杂度：O(N*lgN)
 * 	遍历的次数就是二叉树的深度
 * 
 * 堆排序是不稳定的排序算法
 * @author red
 *
 */
public class HeapSort {
	
	// 构建最大堆
	public static void maxHeapDown(int[] arr, int start, int end) {
		// 当前节点的位置
		int current = start;
		// 当前节点的大小
		int tmp = arr[current];
		// 左孩子的位置
		int left = 2 * current + 1;
		
		for (; left <= end; current = left,left = 2 * left + 1) {
			// 选择左右孩子中的较大者
			if (left < end && arr[left] < arr[left + 1]) {
				// left记录的是左右孩子中的较大者
				left++;
			}
			if (tmp > arr[left]) {
				// 当前节点比其左右孩子都大，说明调整结束
				break;
			} else {
				arr[current] = arr[left];
				arr[left] = tmp;
			}
			
		}
	}
	
	// 堆排序(从小到大)
	public static void heapSortAsc(int[] arr, int n) {
		int i, tmp;
		for (i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(arr, i, n - 1);
		}
		
		// 从最后一个元素开始调整，不断的缩小调整范围直到第一个元素
		for (i = n - 1; i > 0; i--) {
			tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			maxHeapDown(arr, 0, i - 1);
		}
		
	}
	
	// 测试代码
	public static void main(String[] args) {
		int[] arr = {50, 40, 30, 20, 10};
		HeapSort.heapSortAsc(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	
}
