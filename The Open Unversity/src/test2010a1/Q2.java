package test2010a1;

public class Q2 {

	public static class Nat {
		private Nat _pre;

		public Nat() {
			_pre = null;
		}

		public Nat(Nat pre) {
			_pre = pre;
		}

		public boolean isZero() {
			if (_pre == null)
				return true;
			else
				return false;
		}

		public Nat succ() {
			return new Nat(this);
		}

		public static Nat getNat(int n) {
			if (n == 0)
				return new Nat();
			return new Nat(getNat(n - 1));
		}

		public boolean equals(Nat other) {
			if ((_pre == null && other._pre != null) || (_pre != null && other._pre == null)) {
				return false;
			}
			if (_pre == null && other._pre == null) {
				return true;
			}
			return _pre.equals(other._pre);

		}

		public int getNum() {
			if (_pre == null)
				return 0;
			return 1 + _pre.getNum();
		}

		public Nat plus(Nat other) {
			if (other._pre == null)
				return this;
			return succ().plus(other._pre);
		}

		public static void main(String[] args) {
			Nat five = Nat.getNat(5);
			Nat ten = Nat.getNat(10);
			System.out.println(Nat.getNat(35).plus(five).getNum());
		}
	}

}
