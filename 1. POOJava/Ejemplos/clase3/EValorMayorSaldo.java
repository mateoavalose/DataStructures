package clase3;

public class EValorMayorSaldo extends Exception{
	//La próxima línea no se necesita, es solo para quitar el Warning
	private static final long serialVersionUID = 1L;

	public EValorMayorSaldo() {
		super("El valor solicitado excede al saldo");
	}
}
