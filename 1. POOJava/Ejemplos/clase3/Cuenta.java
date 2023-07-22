package clase3;

public class Cuenta {
	private float saldo;

	public Cuenta(float saldoInicial) {
		saldo = saldoInicial;
	}

	public void depositar (float v) throws EValorNegativo {
		if (v>0) {
			saldo += v;
		} else {
			throw new EValorNegativo ("El saldo a depositar debe ser mayor que cero");
		}
	}

	public void extraer (float v) throws EValorNegativo, EValorMayorSaldo {
		if (v>0) {
			if(v<=saldo) {
				saldo -= v;
			} else {
				throw new EValorMayorSaldo();
			}
		} else {
			throw new EValorNegativo("El Saldo a extraer debe ser mayor que cero");
		}
	}

	public float getSaldo() {
		return saldo;
	}
}
