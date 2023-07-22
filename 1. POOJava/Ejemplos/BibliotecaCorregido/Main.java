package BibliotecaCorregido;

public class Main {

	public static void main(String[] args) {
		//Crear la Libreria
		Library l = new Library();

		//Añadir Libros y Usuarios
		l.addLibro("Estructuras", "Isis", "AAA", "EIA", 1);
		l.addLibro("Matemáticas", "Isis", "AAB", "EIA", 1);

		l.addUsuario("Santiago", "789456", "3188928792", "Estudiante");
		l.addUsuario("Nicolás", "031456", "3204900585", "Estudiante");

		System.out.println("La posición del libro es: " + l.buscarLibro("estructuras"));

		try {
			System.out.println("La posición del usuario es: " + l.buscarUsuario("031456"));
		}
		catch (UserNotFound u) {
			System.out.println(u.getMessage());
		}

		//Hacer préstamos sin ejemplares
		try {
			System.out.print("\n");
			String [] titulos = {"Estructuras", "matemáticas"};
			System.out.println("El prestamo a 031456 fue: " + l.prestamo(titulos, "031456"));
		}
		catch (UserNotFound u) {
			System.out.println(u.getMessage());
		}

		//Hacer préstamos con ejemplares
		try {
			System.out.print("\n");
			l.addEjemplar("Estructuras");
			l.addEjemplar("Matemáticas");

			String [] titulos = {"estructuras", "matemáticas"};
			System.out.println("El length del prestamo a 789456 fue: " + l.prestamo(titulos, "789456").length);
			System.out.println("Los códigos de los ejemplares son: " + l.getPrestamos()[0].getEjemplares()[0].getCodigo() + " y " + l.getPrestamos()[0].getEjemplares()[1].getCodigo());
		}
		catch (BookNotFound b) {
			System.out.println(b.getMessage());
		}
		catch (UserNotFound u) {
			System.out.println(u.getMessage());
		}

		//Verificar disponibilidad y devolución
		System.out.print("\n");
		System.out.println("La disponibilidad del ejemplar AAA1 es: " + l.getLibros()[l.buscarLibro("estructuras")].getEjemplar("AAA1").isDisponibilidad());
		System.out.println("El usuario " + l.getPrestamos()[0].getUsuario().getNombre() + " tiene " + l.getPrestamos()[0].getEjemplares().length + " libro(s) prestado(s)");
		System.out.println("---");
		System.out.println(l.devolucionEjemplar("AAA"));
		System.out.println("La disponibilidad del ejemplar AAA1 es: " + l.getLibros()[l.buscarLibro("estructuras")].getEjemplar("AAA1").isDisponibilidad());
		System.out.println("El usuario " + l.getPrestamos()[0].getUsuario().getNombre() + " tiene " + l.getPrestamos()[0].getEjemplares().length + " libro(s) prestado(s)");
	}
}