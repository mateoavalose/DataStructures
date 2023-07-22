package BibliotecaCorregido;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LibraryFichero {

	public static void main(String[] args) {
		Library b = new Library();

		//Lectura de Usuarios
		System.out.println("----------------------------------------");
		System.out.println("Lectura de Usuarios");
		String ficheroU = "C:\\Users\\mateo\\eclipse-workspace\\POOJava\\Ejemplos\\BibliotecaCorregido\\Usuarios.txt";
		User[] usuarios = null;

		try {
			usuarios = b.readUsuarios(ficheroU);
		}  catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		for(User us: b.getUsuarios())
			System.out.println(us.getCC());
		System.out.println("Se leyeron " + usuarios.length + " usuarios");

		//Lectura de Libros
		System.out.println("----------------------------------------");
		System.out.println("Lectura de Libros");
		String ficheroB = "C:\\Users\\mateo\\eclipse-workspace\\POOJava\\Ejemplos\\BibliotecaCorregido\\Libros.txt";
		Book[] libros = null;

		try {
			libros = b.readLibros(ficheroB);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		for(Book li:b.getLibros())
			System.out.println(li.getTitulo());
		System.out.println("Se leyeron " + libros.length + " libros");

		//Lectura de Préstamos
		System.out.println("----------------------------------------");
		System.out.println("Lectura de Préstamos");
		String ficheroL = "C:\\Users\\mateo\\eclipse-workspace\\POOJava\\Ejemplos\\BibliotecaCorregido\\Prestamos.txt";
		Lend[] prestamos = null;

		try {
			prestamos = b.readPrestamos(ficheroL);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		for(Lend le:b.getPrestamos())
			System.out.println(le.getUsuario().getCC() + " " + le.getEjemplares());
		System.out.println("Se leyeron " + prestamos.length + " prestamos");

		//Añadir Usuarios
//		b.addUsuario("Mateo", "1001011216", "3226137339", "Estudiante");
//		b.addUsuario("Laura", "1001237842", "3045520655", "Estudiante");
//		b.addUsuario("Alida", "43050423", "3153293205", "Administrativo");
//		b.addUsuario("Mauricio", "71642614", "3153120419", "Profesor");

		//Añadir Libros
//		b.addLibro("Billy Summers", "Stephen King", "AAA", "A novel", 1);
//		b.activarLibro("Billy Summers");
//		b.addLibro("El Jinete del Dragon", "Cornelia Funke", "AAB", "Siruela", 4);
//		b.activarLibro("El Jinete del Dragon");
//		b.addLibro("El Regreso del Joven Principee", "A.G. Roemmers", "AAC", "Planeta", 2);
//		b.activarLibro("El Regreso del Joven Principee");
//		b.addLibro("El Viaje de Teo", "Catherine Clement", "AAD", "Siruela", 64);
//		b.activarLibro("El Viaje de Teo");

		//Añadir Ejemplares
//		try {
//			b.addEjemplar("Billy Summers");
//			b.activarEjemplar("Billy Summers", "AAA1");
//			b.addEjemplar("El Viaje de Teo");
//			b.activarEjemplar("El Viaje de Teo", "AAD1");
//			b.addEjemplar("El Viaje de Teo");
//			b.activarEjemplar("El Viaje de Teo", "AAD2");
//		} catch (BookNotFound l) {
//			System.out.println(l.getMessage());
//		}

		//Prestamos
//		try {
//			String[] prest = {"Billy Summers", "El Viaje de Teo"};
//			b.prestamo(prest, "1001011216");
//
//			String[] prest1 = {"El Viaje de Teo"};
//			b.prestamo(prest1, "1001237842");
//		} catch(UserNotFound u) {
//			System.out.println(u.getMessage());
//		}


		//Escritura de Usuarios
		System.out.println("----------------------------------------");
		System.out.println("Escritura Usuarios");
		for(User u:b.getUsuarios())
			System.out.println(u.getNombre());
		try {
			b.writeUsuarios(ficheroU);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		//Escritura de Libros
		System.out.println("----------------------------------------");
		System.out.println("Escritura Libros");
		for(Book l:b.getLibros())
			System.out.println(l.getTitulo());
		try {
			b.writeLibros(ficheroB);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		//Escritura de Préstamos
		System.out.println("----------------------------------------");
		System.out.println("Escritura Préstamos");
		for(Lend e:b.getPrestamos()) {
			System.out.println(e.getUsuario().getCC() + " " + e.getEjemplares());
		}

		try {
			b.writePrestamos(ficheroL);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}
	}

}
