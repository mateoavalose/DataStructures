package BibliotecaEjemplo;

public class LibroNoDisponible extends Exception{
	private static final long serialVersionUID = 1L;

	public LibroNoDisponible() {
		super("El libro no está disponible");
	}
}
