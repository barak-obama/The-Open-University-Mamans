package test2009b2;

public class Q6 {
	public static boolean f(int n) {
		return g(n, n);
	}

	private static boolean g(int n, int x) {
		if (n > x * x)
			return false;
		if (n < x * x)
			return g(n, x - 1);
		return true;
	}
	public static void main(String[] args) {
		First f = new First();
		Second s = new Second();
		s = (Second) f;
	}
	
	public static class First {}
	public static class Second extends First {}
	
	
}
