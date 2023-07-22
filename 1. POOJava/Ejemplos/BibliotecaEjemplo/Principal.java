package BibliotecaEjemplo;

public class Principal {

	public static void main(String[] args) {

		Biblioteca b = new Biblioteca();

		//Usuarios
		try {
			b.addUsuario("Mateo", "1001011216", "3226137339", "Estudiante");
			System.out.println("El usuario Mateo tiene el teléfono: " + b.buscarUsuario("1001011216").getTelefono());
			System.out.println("\n");
			b.addUsuario("Laura", "1001237842", "3045520655", "Estudiante");
			System.out.println("El usuario Laura es de tipo: " + b.buscarUsuario("1001237842").getTipo());
			System.out.println("\n");
			b.addUsuario("Alida", "43050423", "3153293205", "Administrativo");
			b.addUsuario("Mauricio", "71642614", "3153120419", "Profesor");
			System.out.println("El usuario Mauricio es de tipo: " + b.buscarUsuario("71642614").getTipo());
			System.out.println("\n");

			b.modificarUsuario("1001237842", "Tipo", "Doctora");
			System.out.println("El usuario Laura es de tipo: " + b.buscarUsuario("1001237842").getTipo());
			System.out.println("\n");

			b.eliminarUsuario("71642614");
			System.out.println(b.buscarUsuario("71642614"));
		}
		catch (UsuarioNoExiste u) {
			System.out.println(u.getMessage());
		}

		//Libros
		try {
			System.out.println("-----------------------------------------------");
			b.addLibro("Billy Summers", "Stephen King", "AAA", "A novel", 1);
			System.out.println("Billy Summers tiene existencia: " + b.buscarLibro("Billy Summers").isExistencia());
			b.activarLibro("Billy Summers");
			System.out.println("Billy Summers tiene existencia: " + b.buscarLibro("Billy Summers").isExistencia());
			System.out.println("\n");

			b.addLibro("El Jinete del Dragon", "Cornelia Funke", "AAB", "Siruela", 4);
			b.activarLibro("El Jinete del Dragon");
			System.out.println("El Jinete del Dragon tiene existencia: " + b.buscarLibro("El Jinete del Dragon").isExistencia());
			System.out.println("\n");

			b.addLibro("El Regreso del Joven Principee", "A.G. Roemmers", "AAC", "Planeta", 2);
			b.activarLibro("El Regreso del Joven Principee");
			System.out.println("El Regreso del Joven Principee tiene existencia: " + b.buscarLibro("El Regreso del Joven Principee").isExistencia());
			System.out.println("\n");

			b.addLibro("El Viaje de Teo", "Catherine Clement", "AAD", "Siruela", 64);
			b.activarLibro("El Viaje de Teo");
			System.out.println("El Viaje de Teo tiene existencia: " + b.buscarLibro("El Viaje de Teo").isExistencia());
			System.out.println("\n");

			b.modificarLibro("El Regreso del Joven Principee", "Titulo", "El Regreso del Joven Principe");
			System.out.println("El Regreso del Joven Principee corregido a: " + b.buscarLibro("El Regreso del Joven Principe").getTitulo());

			//b.eliminarLibro("El Regreso del Joven Principe");
			System.out.println(b.buscarLibro("El Regreso del Joven Principe").getTitulo());
		}
		catch (LibroNoExiste l) {
			System.out.println(l.getMessage());
		}

		//Ejemplares
		try{
			System.out.println("-----------------------------------------------");
			b.addEjemplar("Billy Summers");
			System.out.println("El codigo del ejemplar es: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").getCodigo());
			System.out.println("La disponibilidad es: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
			b.activarEjemplar("Billy Summers", "AAA1");
			System.out.println("La disponibilidad es: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
			System.out.println("\n");

			b.addEjemplar("El Viaje de Teo");
			b.activarEjemplar("El Viaje de Teo", "AAD1");
			b.addEjemplar("El Viaje de Teo");
			b.activarEjemplar("El Viaje de Teo", "AAD2");
			System.out.println("El codigo del ejemplar es: " + b.buscarLibro("El Viaje de Teo").buscarEjemplar("AAD2").getCodigo());
			System.out.println("La disponibilidad es: " + b.buscarLibro("El Viaje de Teo").buscarEjemplar("AAD2").isDisponibilidad());
			System.out.println("\n");

			b.desactivarEjemplar("El Viaje de Teo", "AAD2");
			System.out.println("La disponibilidad es: " + b.buscarLibro("El Viaje de Teo").buscarEjemplar("AAD2").isDisponibilidad());
			System.out.println("La existencia del ejemplar es: " + b.buscarLibro("El Viaje de Teo").buscarEjemplar("AAD2").isExistencia());
			b.eliminarEjemplar("El Viaje de Teo", "AAD2");
			System.out.println("La existencia del ejemplar es: " + b.buscarLibro("El Viaje de Teo").buscarEjemplar("AAD2").isExistencia());
		}
		catch (LibroNoExiste l) {
			System.out.println(l.getMessage());
		}
		catch (EjemplarNoDisponible e) {
			System.out.println(e.getMessage());
		}

		//Prestamos
		try {
			System.out.println("-----------------------------------------------");
			String[] prest = {"Billy Summers", "El Viaje de Teo"};
			b.prestamo(prest, "1001011216");
			System.out.println("El usuario " + b.getPrestamos()[0].getUsuario().getNombre() + " alquiló los ejemplares: " + b.getPrestamos()[0].getEjemplar()[0].getCodigo() + " y " + b.getPrestamos()[0].getEjemplar()[1].getCodigo() + ", la fecha " + b.getPrestamos()[0].getFechaEntrega());
			System.out.println("El ejemplar " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").getCodigo() + " tiene disponibilidad: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
			System.out.println("\n");

			String[] prest1 = {"El Viaje de Teo"};
			b.prestamo(prest1, "1001237842");
		}
		catch (UsuarioNoExiste u) {
			System.out.println(u.getMessage());
		}
		catch (LibroNoExiste l) {
			System.out.println(l.getMessage());
		}
		catch (EjemplarNoDisponible e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("-----------------------------------------------");
			b.devolucion("1001011216");
			System.out.println("La devolucion de " + b.getPrestamos()[0].getUsuario().getNombre() + " se hizo el: " + b.getPrestamos()[0].getFechaDevolucion());
			System.out.println("El ejemplar " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").getCodigo() + " tiene disponibilidad: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
			System.out.println("\n");

			b.modificarEjemplar("Billy Summers", "AAA1", "Disponibilidad", "False");
			System.out.println("El ejemplar " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").getCodigo() + " tiene disponibilidad: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
			b.modificarEjemplar("Billy Summers", "AAA1", "Disponibilidad", "True");
			System.out.println("El ejemplar " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").getCodigo() + " tiene disponibilidad: " + b.buscarLibro("Billy Summers").buscarEjemplar("AAA1").isDisponibilidad());
		}
		catch(UsuarioNoExiste u) {
			System.out.println(u.getMessage());
		}
		catch(EjemplarNoDisponible e) {
			System.out.println(e.getMessage());
		}
		catch(LibroNoExiste l) {
			System.out.println(l.getMessage());
		}
	}
}
