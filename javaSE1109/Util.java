package javaSE1109;

public class Util {
	public static <T> Box3<T> boxing(T t) {
		Box3<T> box = new Box3<T>();
		box.set(t);
		return box;
	}
}
