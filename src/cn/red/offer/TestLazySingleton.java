package cn.red.offer;

/**
 * 测试懒汉式实现单例模式
 * @author red
 *
 */
public class TestLazySingleton {
	public static void main(String[] args) {
		LazySingleton instance1 = LazySingleton.getInstance();
		LazySingleton instance2 = LazySingleton.getInstance();
		System.out.println(instance1 == instance2);
	}
}
