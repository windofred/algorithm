package cn.red.offer.second;

/**
 * 单例模式(DCL)
 * @author sala
 *
 */
public class Problem2 {
	
	private volatile static Problem2 instance = null;
	
	private Problem2() {}
	
	public static Problem2 getInstance() {
		if (instance == null) {
			synchronized (Problem2.class) {
				if (instance == null) {
					instance = new Problem2();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Problem2 instance1 = Problem2.getInstance();
		Problem2 instance2 = Problem2.getInstance();
		System.out.println(instance1 == instance2);
	}
	
}
