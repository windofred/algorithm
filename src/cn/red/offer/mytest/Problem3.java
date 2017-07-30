package cn.red.offer.mytest;

import org.junit.Test;

/**
 * 查找
 * 
 * 面试题3：二维数组中的查找
 * 
 * 查找过程：
 *     首先选取数组中右上角的数字
 *         如果该数字等于要查找的数字，查找过程结束
 *         如果该数字大于要查找的数字，剔除这个数字所在的列
 *         如果该数字小鱼要查找的数字，剔除这个数字所在的行
 *         
 *     也就是说：如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行或一列
 *     这样每一步都可以缩小查找的范围，直到要查找的数字，或者查找范围为空。    
 * 
 * @author red
 *
 */
public class Problem3 {
	
	@Test
	public void test1() {
		int[][] array = new int[4][4];
		array[0][0] = 1;
		array[0][1] = 2;
		array[0][2] = 8;
		array[0][3] = 9;
		array[1][0] = 2;
		array[1][1] = 4;
		array[1][2] = 9;
		array[1][3] = 12;
		array[2][0] = 4;
		array[2][1] = 7;
		array[2][2] = 10;
		array[2][3] = 13;
		array[3][0] = 6;
		array[3][1] = 8;
		array[3][2] = 11;
		array[3][3] = 15;
		
		Problem3 p3 = new Problem3();
		System.out.println(p3.find(array, 5));
	}
	
	public boolean find(int[][] array, int target) {
		if (array == null) {
			return false;
		}
		
		int row = 0;
		int column = array[0].length - 1;
		
		while (row < array.length && column >= 0) {
			if (array[row][column] == target) {
				return true;
			} else if (array[row][column] > target) {
				column--;
			} else {
				row++;
			}
		}
		
		return false;
	}
	
}
