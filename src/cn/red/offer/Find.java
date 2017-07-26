package cn.red.offer;

/**
 * 二维数组中的查找
 * 总结查找的过程，我们发现如下规律：
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数组大于要查找的数字，剔除这个数字所在的列；
 * 如果该数字小于要查找的数字，剔除这个数字所在的行。也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围
 * 剔除一行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 * 
 * 1 2 8  9
 * 2 4 9  12
 * 4 7 10 13
 * 6 8 11 15
 * 
 * @author red
 *
 */
public class Find {
	
	public static void main(String[] args) {
		int[][] array = new int[4][4];
		array[0][0] = 1;
		array[0][1] = 1;
		array[0][2] = 1;
		array[0][3] = 1;
		
		array[1][0] = 1;
		array[1][1] = 2;
		array[1][2] = 8;
		array[1][3] = 9;
		
		array[2][0] = 2;
		array[2][1] = 4;
		array[2][2] = 9;
		array[2][3] = 12;
		
		array[3][0] = 4;
		array[3][1] = 7;
		array[3][2] = 10;
		array[3][3] = 13;
		
		boolean find = find(array, 5);
		System.out.println(find);
	}
	
	public static boolean find(int[][] array, int number) {
		if (array == null) {
			return false;
		}
		
		int row = 0;
		int column = array[0].length - 1;
		
		while (row < array.length && column >= 0) {
			if (array[row][column] == number) {
				return true;
			}
			
			if (array[row][column] > number) {
				--column;
			} else {
				++row;
			}
		}
		
		return false;
		
	}
}
