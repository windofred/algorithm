package cn.red.offer;

/**
 * 测试饿汉式实现单例类
 * @author red
 *
 */
public class TestEagerSingleton {
	public static void main(String[] args) {
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = EagerSingleton.getInstance();
		System.out.println(instance1 == instance2);
	}
}
