package BibliotecaCorregido;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Library {
	private Book[] libros;
	private User [] usuarios;
	private Lend [] prestamos;

	public Library() {
		super();
		this.libros = new Book[0];
		this.usuarios = new User[0];
		this.prestamos = new Lend[0];
	}

	public Book[] getLibros() {
		return libros;
	}

	public void setLibros(Book[] libros) {
		this.libros = libros;
	}

	public User[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(User[] usuarios) {
		this.usuarios = usuarios;
	}

	public Lend[] getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Lend[] prestamos) {
		this.prestamos = prestamos;
	}

	public void writeLibros(String fichero) throws IOException{
		File f = new File(fichero);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);

		for(Book l:libros) {
			b.write(l.getTitulo()); b.newLine();
			b.write(l.getAutores()); b.newLine();
			b.write(l.getCodigo()); b.newLine();
			b.write(l.getEditorial()); b.newLine();
			b.write(Integer.toString(l.getEdicion())); b.newLine();
			b.write(Integer.toString(l.getCantDisponible())); b.newLine();
			b.write(Boolean.toString(l.isExistencia())); b.newLine();

			for(int i = 0; i < l.getEjemplares().length; i++) {
				b.write(l.getEjemplares()[i].getCodigo()); b.newLine();
			}
			b.write("---"); b.newLine();
		}
		b.close();
		fr.close();
	}

	public Book[] readLibros(String fichero) throws IOException{
		File f = new File(fichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		Book [] libros = new Book[0];

		while((linea=b.readLine()) != null) {
			Exemplary [] ejemplares = new Exemplary[0];
			String titulo = linea;
			String autores = b.readLine();
			String codigo = b.readLine();
			String editorial = b.readLine();
			int edicion = Integer.parseInt(b.readLine());
			int cantDisponible = Integer.parseInt(b.readLine());
			boolean existencia = Boolean.getBoolean(b.readLine());

			String aux = b.readLine();
			while(aux.split("-", 2).length == 1) {
				Exemplary e = new Exemplary(aux);
				ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
				ejemplares[ejemplares.length - 1] = e;
				aux = b.readLine();
			}

			Book l = new Book(titulo, autores, codigo, editorial, edicion, ejemplares,cantDisponible, existencia);
			libros = Arrays.copyOf(libros, libros.length + 1);
			libros[libros.length - 1] = l;
		}
		b.close();
		fr.close();
		this.libros = libros;
		return libros;
	}

	public void writeUsuarios(String fichero) throws IOException{
		File f = new File(fichero);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);

		for(User u: usuarios) {
			b.write(u.getNombre()); b.newLine();
			b.write(u.getCC()); b.newLine();
			b.write(u.getTelefono()); b.newLine();
			b.write(u.getTipo()); b.newLine();
			b.write("---"); b.newLine();

		}
		b.close();
		fr.close();
	}

	public User[] readUsuarios(String fichero) throws IOException{
		File f = new File(fichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		User[] usuarios = new User[0];

		while((linea=b.readLine()) != null) {
			String nombre = linea;
			String cc = b.readLine();
			String tel = b.readLine();
			String tipo = b.readLine();
			b.readLine();

			User u = new User(nombre, cc, tel, tipo);
			usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
			usuarios[usuarios.length - 1]= u;
		}
		b.close();
		fr.close();
		this.usuarios = usuarios;
		return usuarios;
	}

	public void writePrestamos(String fichero) throws IOException{
		File f = new File(fichero);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);

		for(Lend p: prestamos) {
			b.write(p.getUsuario().getCC()); b.newLine();
			b.write(p.getFechaEntrega().toString()); b.newLine();
			for(int i = 0; i < p.getEjemplares().length; i++) {
				b.write(p.getEjemplares()[i].getCodigo()); b.newLine();
			}
			b.write("---"); b.newLine();
		}
		b.close();
		fr.close();
	}

	public Lend[] readPrestamos(String fichero) throws IOException{
		File f = new File(fichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		Lend[] prestamos = new Lend[0];

		while((linea=b.readLine()) != null) {
			Exemplary[] ejemplares = new Exemplary[0];
			String userCC = linea;
			LocalDate fechaEntrega = LocalDate.parse(b.readLine());
			String aux = b.readLine();
			while(aux.split("-", 2).length == 1) {
				Exemplary e = new Exemplary(aux);
				ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
				ejemplares[ejemplares.length - 1] = e;
				aux = b.readLine();
			}

			try {
				Lend p = new Lend(usuarios[buscarUsuario(userCC)], ejemplares, fechaEntrega);
				prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
				prestamos[prestamos.length - 1] = p;
			}
			catch (UserNotFound us) {
			}
		}
		b.close();
		fr.close();
		this.prestamos = prestamos;
		return prestamos;
	}

	public void addLibro(String titulo, String autores, String codigo, String editorial, int edicion) {
		libros = Arrays.copyOf(libros, libros.length + 1);
		libros[libros.length - 1] = new Book(titulo, autores, codigo, editorial, edicion);
	}

	public void addUsuario(String name, String cc, String tel, String tipo) {
		usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		usuarios[usuarios.length - 1] = new User(name, cc, tel, tipo);
	}

	public int buscarUsuario(String cc) throws UserNotFound{
		int i = 0;
		while (i < usuarios.length && usuarios[i].getCC().compareToIgnoreCase(cc) != 0) i++;
		if(i < usuarios.length) {
			return i;
		} else {
			throw new UserNotFound();
		}
	}

	public int buscarLibro(String titulo) {
		int i = 0;
		while (i < libros.length && libros[i].getTitulo().compareToIgnoreCase(titulo) != 0) i++;
		if(i < libros.length) {
			return i;
		} else {
			return -1;
		}
	}

	public void activarLibro(String titulo) {
		if(buscarLibro(titulo) != -1) {
			libros[buscarLibro(titulo)].setExistencia(true);
		}
	}

	public void addEjemplar(String titulo) throws BookNotFound{
		if (buscarLibro(titulo) != -1) {
			int cod = libros[buscarLibro(titulo)].getEjemplares().length + 1;
			String codigo = libros[buscarLibro(titulo)].getCodigo() + cod;

			Exemplary e = new Exemplary(codigo);
			int i = buscarLibro(titulo);
			libros[i].addExemplary(e);
			e.setDisponibilidad(true);
		} else {
			throw new BookNotFound();
		}
	}

	public void activarEjemplar(String titulo, String codigo) throws BookNotFound{
		if(libros[buscarLibro(titulo)].buscarEjemplar(codigo) != null){
			buscarLibro(titulo);
			libros[buscarLibro(titulo)].buscarEjemplar(codigo).setDisponibilidad(true);
		}
	}

	public Exemplary getEjemplarDisponible(String titulo) {
		int i = buscarLibro(titulo);
		if (i != -1){
			if (libros[i].getEjemplarDisponible() != null) {
				Exemplary e = libros[i].getEjemplarDisponible();
				return e;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	public Exemplary[] prestamo(String [] titulos, String cc) throws UserNotFound{
		try {
			Exemplary [] ejemplares = new Exemplary[0];
			for (String element : titulos) {
				if(getEjemplarDisponible(element) != null) {
					ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
					ejemplares[ejemplares.length - 1] = getEjemplarDisponible(element);
					ejemplares[ejemplares.length - 1].setDisponibilidad(false);
				}

			}
			if(ejemplares.length == 0) {
				return null;
			} else {
				Lend p = new Lend(usuarios[buscarUsuario(cc)], ejemplares);
				p.setFechaEntrega(LocalDate.now());
				prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
				prestamos[prestamos.length - 1] = p;
				return ejemplares;
			}
		}
		catch (UserNotFound u) {
			throw new UserNotFound();
		}
	}

	public Exemplary[]devolucionEjemplar(String codigo) {
		int i = 0;
		int j = 0;
		while(i < prestamos.length) {
			j = 0;
			while(j < prestamos[i].getEjemplares().length && prestamos[i].getEjemplares()[j].getCodigo().compareToIgnoreCase(codigo) != 0) j++;
			if(j < prestamos[i].getEjemplares().length && prestamos[i].getEjemplares()[j].getCodigo().compareToIgnoreCase(codigo) == 0) break;
			i++;
		}
		if (i < prestamos.length && j < prestamos[i].getEjemplares().length) {
			Exemplary[] e = prestamos[i].devolucionEjemplar(j);
			return e;
		} else {
			return null;
		}
	}

	public void devolucionTotal(String cc){

	}
}
