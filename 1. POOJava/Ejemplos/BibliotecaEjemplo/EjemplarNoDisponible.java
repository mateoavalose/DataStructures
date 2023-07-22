package BibliotecaEjemplo;

public class EjemplarNoDisponible extends Exception{
	private static final long serialVersionUID = 1L;

	public EjemplarNoDisponible() {
		super("No hay ejemplares disponibles");
	}

}
