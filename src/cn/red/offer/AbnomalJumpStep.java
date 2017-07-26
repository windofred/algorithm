package cn.red.offer;

/**
 * 变态跳台阶问题 在青蛙跳台阶的问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级，此时该青蛙跳上一个n级的台阶
 * 总共有多少种跳法？我们用数学归纳法可以证明 f(n) = 2 ^ (n - 1)
 * 
 * @author red
 *
 */
public class AbnomalJumpStep {

	public static void main(String[] args) {
		AbnomalJumpStep ajs = new AbnomalJumpStep();
		int i = ajs.JumpFloorII(4);
		System.out.println(i);
	}
	
	public int JumpFloorII(int target) {
		int k = 1;
		if (target == 0) {
			return 0;
		}
		while (--target > 0) {
			k *= 2;
		}
		
		return k;
	}

}
