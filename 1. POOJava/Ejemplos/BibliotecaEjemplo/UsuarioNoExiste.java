package BibliotecaEjemplo;

public class UsuarioNoExiste extends Exception{
	private static final long serialVersionUID = 1L;

	public UsuarioNoExiste() {
		super("El usuario no existe");
	}
}
