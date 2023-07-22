package clase3;

public class CuentaTest {
	public static void main(String[] args) {
		Cuenta c = new Cuenta(200);
		try {
			c.depositar(200);
			System.out.println("El saldo es: " + c.getSaldo());
			c.extraer(300);
			System.out.println("El saldo es: " + c.getSaldo());
			c.extraer(100);
			System.out.println("El saldo es: " + c.getSaldo());
		}
		catch (EValorNegativo e) {
			System.out.println(e.getMessage());
			//System.out.println("Se opera con valor negativo");
		}
		catch (EValorMayorSaldo e) {
			System.out.println(e.getMessage());
			//System.out.println("Se está tratando de sacar más de lo que hay");
		}
	}
}
