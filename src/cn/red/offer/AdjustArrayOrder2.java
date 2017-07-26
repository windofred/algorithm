package cn.red.offer;

/**
 * 调整数组的顺序，是所有的奇数位于偶数的前面
 * 保证调整后的奇数和奇数，偶数和偶数的相对位置保持不变
 * 
 * 其实，要想保证原有次序，则只能顺次移动或相邻交换。那么依然设置两个指针
 * 首先，start从左向右遍历，找到第一个偶数；
 * 然后，from从start+1开始向后找，直到找到第一个奇数；
 * 接着，将[start,...,from-1]的元素整体后移一位；
 * 最后找到的奇数放入start位置，然后start++。
 * @author red
 *
 */
public class AdjustArrayOrder2 {
	public static void main(String[] args) {
		int[] temp = {1, 2, 3, 4, 5, 6, 7};
		AdjustArrayOrder2 aao2 = new AdjustArrayOrder2();
		aao2.reOrderArray(temp);
		for (int i : temp) {
			System.out.println(i);
		}
	}
	
	public void reOrderArray(int[] array) {
		if (array == null || array.length == 0) {
            return;
        }
        int start = 0, from;
        while (start < array.length) {
            while (start < array.length && !isEven(array[start])) {
                start++;
            }
            from = start + 1;
            while (from < array.length && isEven(array[from])) {
                from++;
            }
            if (from < array.length) {
                int temp = array[from];
                // 将[start,...,from-1]的元素整体后移一位
                for (int i = from - 1; i >= start; i--) {
                    array[i + 1] = array[i];
                }
                // 最后找到的奇数放入start位置，然后start++
                array[start++] = temp;
            } else {
                break;
            }
        }
	}
	
	private boolean isEven(int n) {
		return (n & 1) == 0;
	}
}
