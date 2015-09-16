package test2010a1;

public class Q5 {
	public static class C {
		static int c = 0;
		public C(int n) {
			for (int i = 0; i < n; i++)
				new C(i);
			System.out.println(++c);
		}
	}

	public static class D extends C {
		public D(int n) {
			super(n);
			for (int i = 0; i < n; i++)
				new D(i);
		}
	}

	public static void main(String[] args) { // put the line here
		new D(4);
	}
}
