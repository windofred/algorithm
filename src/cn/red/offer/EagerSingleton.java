package cn.red.offer;

/**
 * 饿汉式
 * @author red
 *
 */
public class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton() {}
	
	public static EagerSingleton getInstance() {
		return instance;
	}
	
}
