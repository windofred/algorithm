package cn.red.leetcode;

enum AccountType {
	SAVING, FIXED,CURRENT;
	private AccountType() {
		System.out.println("It is a account type");
	}
}

public class EnumOne {
	public static void main(String[] args) {
		System.out.println(AccountType.FIXED);
	}
}
