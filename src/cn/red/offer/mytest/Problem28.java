package cn.red.offer.mytest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 字符串的排列
 * 
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a、b、c所能排列出来的 所有字符串 abc acb bac
 * bca cab 和 cba
 * 
 * @author red
 *
 */
public class Problem28 {

	private List<String> list = new ArrayList<>();
	private Set<String> set = new TreeSet<>();
	private StringBuffer buffer;

	public static void main(String[] args) {
		String str = "abc";
		Problem28 p28 = new Problem28();
		ArrayList<String> list2 = p28.Permutation(str);
		for (String s : list2) {
			System.out.println(s);
		}
	}
	
	public ArrayList<String> Permutation(String str) {
		if (str == null || str.length() == 0)
			return (ArrayList<String>) list;
		buffer = new StringBuffer(str);
		PermutationCore(0);
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return (ArrayList<String>) list;
	}

	public void PermutationCore(int begin) {
		if (begin == buffer.length() - 1) {
			set.add(buffer.toString());
		}
		for (int i = begin; i < buffer.length(); i++) {
			// if(buffer.charAt(i)==buffer.charAt(begin) && begin!=i) continue;
			swap(begin, i);
			PermutationCore(begin + 1);
			swap(begin, i);
		}
	}

	public void swap(int i, int j) {
		char a = buffer.charAt(i);
		char b = buffer.charAt(j);
		buffer.setCharAt(i, b);
		buffer.setCharAt(j, a);
	}

}
