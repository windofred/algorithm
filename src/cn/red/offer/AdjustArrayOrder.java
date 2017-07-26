package cn.red.offer;

/**
 * 调整数组的顺序，是所有的奇数位于偶数的前面
 * 
 * 该方法不能保证相对位置不变，因为快排是不稳定的
 * @author red
 *
 */
public class AdjustArrayOrder {
	
	public static void main(String[] args) {
		int[] temp = {1, 2, 3, 4, 5, 6, 7};
		AdjustArrayOrder aao = new AdjustArrayOrder();
		aao.reOrderArray(temp);
		for (int i : temp) {
			System.out.println(i);
		}
	}
	
	public void reOrderArray(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		
		int start = 0;
		int end = array.length - 1;
		
		while (start < end) {
			while (start < end && !isEven(array[start])) {
				start++;
			}
			while (start < end && isEven(array[end])) {
				end--;
			}
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		
		
	}

	private boolean isEven(int n) {
		return n%2 == 0;
	}
	
}
