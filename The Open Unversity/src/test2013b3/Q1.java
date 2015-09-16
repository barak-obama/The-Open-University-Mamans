package test2013b3;

public class Q1 {
	public static boolean match(int[] a, int[] p){
		return match(a, p, 0, 0 , 0);
	}

	public static boolean match(int[] a, int[] p, int i, int j, int s) {
		if(i==p.length || j == a.length){
			if(i==p.length)
				return true;
			return false;
		}
		if(match(a[j], p[i]))
			return match(a,p, i+1, j+1, s);
		return match(a,p, 0,s+1, s+1);
		
	}

	public static boolean match(int a, int p) {
		if(p == 0)
			return a / 100 == 0;
		
		return a >= Math.pow(10, p-1) && a < Math.pow(10, p);
	}
}
