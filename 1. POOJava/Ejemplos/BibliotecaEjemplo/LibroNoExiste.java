package BibliotecaEjemplo;

public class LibroNoExiste extends Exception{
	private static final long serialVersionUID = 1L;

	public LibroNoExiste() {
		super("El libro no existe");
	}
}
