package BibliotecaCorregido;

public class BookNotFound extends Exception{
	private static final long serialVersionUID = 1L;

	public BookNotFound(){
		super("Ejemplar No Disponible");
		}
}
