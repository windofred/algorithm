package cn.red.offer.second;

public class Problem4 {
	
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
