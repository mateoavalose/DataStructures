package BibliotecaCorregido;

public class UserNotFound extends Exception{
	private static final long serialVersionUID = 1L;

	public UserNotFound() {
		super("El usuario no se encontró");
	}
}
