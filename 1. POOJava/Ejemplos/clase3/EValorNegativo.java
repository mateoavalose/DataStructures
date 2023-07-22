package clase3;

public class EValorNegativo extends Exception{

	//La próxima línea no se necesita, es solo para quitar el Warning
	private static final long serialVersionUID = 1L;

	public EValorNegativo(String s) {
		super(s);
	}
}
