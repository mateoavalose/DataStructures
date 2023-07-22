package clase1;

public class Calculadora {

	public static int MCD(int a, int b) {
		while(a!=b) {
			if(a>b) {
				a -= b;
			} else {
				b -= a;
			}
		}
	return a;
	}

	public static int fact(int n) {
		int f = 1;
		for (int i=2; i<=n; i++) {
			f *= i;
		}
		return f;
	}
}
