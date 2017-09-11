package cn.red.offer.second;

/**
 * 
 * 丑数
 * 
 * @author red
 *
 */
public class Problem49 {

	public static void main(String[] args) {
		
		Problem49 p49 = new Problem49();
		int solution = p49.getUglyNumber_Solution(8);
		System.out.println(solution);
		
	}
	
		
	public int getUglyNumber_Solution(int index) {
		
		if (index < 0) {
			return 0;
		}
		
		if (index == 0) {
			return 0;
		}
		
		int[] uglyArray = new int[index];// 保存丑数的数组
		uglyArray[0] = 1;// 1是第一个丑数
		int m2 = 0;
		int m3 = 0;
		int m5 = 0;
		
		for (int i = 1; i < index; i++) {
			int min = getMin(uglyArray[m2] * 2, uglyArray[m3] * 3, uglyArray[m5] * 5);
			uglyArray[i] = min;
			
			while (uglyArray[m2] * 2 == uglyArray[i]) {
				m2++;
			}
			while (uglyArray[m3] * 3 == uglyArray[i]) {
				m3++;
			}
			while (uglyArray[m5] * 5 == uglyArray[i]) {
				m5++;
			}
		}
		
		return uglyArray[index - 1];
		
	}
	
	// 获得三个数中的最小值
	public int getMin(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		return min < number3 ? min : number3;
	}

}
