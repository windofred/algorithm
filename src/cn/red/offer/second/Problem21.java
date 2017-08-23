package cn.red.offer.second;

/**
 * 使所有的奇数位于所有的偶数前面
 * @author red
 *
 */
public class Problem21 {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		Problem21 p21 = new Problem21();
		p21.reorderOddEven(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public void reorderOddEven(int[] a) {
		
		if (a == null || a.length <= 0) {
			return;
		}
		
		int pBegin = 0;
		int pEnd = a.length - 1;
		
		while (pBegin < pEnd) {
			while (pBegin < pEnd && !isEven(a[pBegin])) {
				pBegin++;
			}
			while (pBegin < pEnd && isEven(a[pEnd])) {
				pEnd--;
			}
			if (pBegin < pEnd) {
				int temp = a[pBegin];
				a[pBegin] = a[pEnd];
				a[pEnd] = temp;
			}
		}
	}
	
	public boolean isEven(int n) {
		return (n & 0x1) == 0;
	}
	
}
