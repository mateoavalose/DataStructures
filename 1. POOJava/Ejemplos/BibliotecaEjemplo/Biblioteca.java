package BibliotecaEjemplo;

import java.time.LocalDate;
import java.util.Arrays;

public class Biblioteca {
	private Libro[] libros = new Libro[0];
	private Usuario [] usuarios = new Usuario[0];
	private Prestamo[] prestamos = new Prestamo[0];

	public Biblioteca() {
	}

	public Libro[] getLibros() {
		return libros;
	}

	public void setLibros(Libro[] libros) {
		this.libros = libros;

	}

	public Usuario[] cargarUsuarios() {
		return usuarios;
	}

	public Prestamo[] getPrestamos() {
		return prestamos;
	}

	public Libro buscarLibro(String t) throws LibroNoExiste{
		int i = 0;
		while(i < libros.length && libros[i].getTitulo().compareTo(t) != 0) i++;
		if(i < libros.length) {
			return libros[i];
		} else {
			throw new LibroNoExiste();
		}
	}

	public void addUsuario(String name, String cc, String tel, String tipo) {
		Usuario u = new Usuario(name, cc, tel, tipo);
		usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
		usuarios[usuarios.length - 1] = u;
	}

	public Usuario buscarUsuario(String cc) throws UsuarioNoExiste{
		int i = 0;
		while (i < usuarios.length && usuarios[i].getCC().compareTo(cc) != 0) i++;
		if(i < usuarios.length) {
			return usuarios[i];
		} else {
			throw new UsuarioNoExiste();
		}
	}

	public int buscarPosicionUsuario(String cc) throws UsuarioNoExiste{
		int i = 0;
		while (i < usuarios.length && usuarios[i].getCC().compareTo(cc) != 0) i++;
		if(i < usuarios.length) {
			return i;
		} else {
			throw new UsuarioNoExiste();
		}
	}

	public void eliminarUsuario(String cc) throws UsuarioNoExiste{
		int i = 0;
		while (i < usuarios.length && usuarios[i].getCC().compareTo(cc) != 0) i++;

		if(i < usuarios.length) {
			System.arraycopy(usuarios, i+1, usuarios, i, usuarios.length - i - 1);
			usuarios = Arrays.copyOf(usuarios, usuarios.length - 1);
		} else {
			throw new UsuarioNoExiste();
		}
	}

	public void prestamo(String [] titulos, String cc) throws UsuarioNoExiste, LibroNoExiste, EjemplarNoDisponible{
		try {
		Ejemplar [] ejemplares = new Ejemplar[0];

		for(int i = 0; i < titulos.length; i++) {
			ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
			ejemplares[i] = libros[buscarPosicionLibro(titulos[i])].buscarEjemplarPrestamo();
		}
		Prestamo p = new Prestamo(buscarUsuario(cc), ejemplares);
		prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
		prestamos[prestamos.length - 1] = p;
		}
		catch (UsuarioNoExiste u) {
			throw new UsuarioNoExiste();
		}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}
		catch (EjemplarNoDisponible e) {
			throw new EjemplarNoDisponible();
			}
	}

	public void devolucion(String cc) throws UsuarioNoExiste, EjemplarNoDisponible{
		try {
			buscarUsuario(cc);
			int i = 0;
			Ejemplar [] ejemplares = new Ejemplar[0];
			while(i < prestamos.length && prestamos[i].getUsuario().getCC().compareTo(cc) != 0) i++;
			if(i < prestamos.length) {
				ejemplares = prestamos[i].getEjemplar();
//			} else {
//				throw new EjemplarNoDisponible();
			}
			for (Ejemplar ejemplare : ejemplares) {
				int aux = 0;
				int j = 0;
				while(j < libros.length && aux == 0) {
					Ejemplar[] eLibros = libros[j].getEjemplares();
					int k = 0;
					while(k < eLibros.length && !ejemplare.equals(eLibros[k])) k++;
					if (k < eLibros.length) {
						eLibros[k].setDisponibilidad(true);
						libros[j].setEjemplares(eLibros);
						aux = 1;
					}
					j++;
				}
			}
			prestamos[i].setFechaDevolucion(LocalDate.now());
		}
		catch (UsuarioNoExiste u) {
			throw new UsuarioNoExiste();
		}
		catch (EjemplarNoDisponible e) {
			throw new EjemplarNoDisponible();
		}
	}

	public void addLibro(String titulo, String autores, String codigo, String editorial, int edicion) {
		Libro l = new Libro(titulo, autores, codigo, editorial, edicion);
		libros = Arrays.copyOf(libros, libros.length + 1);
		libros[libros.length - 1] = l;
	}

	public void activarLibro(String titulo) throws LibroNoExiste{
		try {
			int i = buscarPosicionLibro(titulo);
			libros[i].setExistencia(true);
		}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}
	}

	public void desactivarLibro(String titulo) {
		try {
			int i = buscarPosicionLibro(titulo);
			libros[i].setExistencia(false);
		}
		catch(LibroNoExiste l) {}
	}

	public void eliminarLibro(String titulo) throws LibroNoExiste{
		try {
			int i = buscarPosicionLibro(titulo);
			System.arraycopy(libros, i+1, libros, i, libros.length - i - 1);
			libros = Arrays.copyOf(libros, libros.length - 1);
		}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}
	}

	public void addEjemplar(String titulo) throws LibroNoExiste{
		int cod = buscarLibro(titulo).getEjemplares().length + 1;
		String codigo = buscarLibro(titulo).getCodigo() + cod;

		Ejemplar e = new Ejemplar(codigo);
		try {
			int i = buscarPosicionLibro(titulo);
			libros[i].addEjemplar(e);
			libros[i].addCantDisponible(1);
		}
		catch (LibroNoExiste l) {}
	}

	public int buscarPosicionLibro(String titulo) throws LibroNoExiste{
		try {
			buscarLibro(titulo);
			int i = 0;
			while(i < libros.length && libros[i].getTitulo().compareTo(titulo) != 0) i++;
				return i;
			}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}
	}

	public void activarEjemplar(String titulo, String codigo) throws LibroNoExiste, EjemplarNoDisponible{
		try {
			buscarLibro(titulo);
			int i = buscarPosicionLibro(titulo);
			libros[i].buscarEjemplar(codigo).setDisponibilidad(true);
		}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}
		catch(EjemplarNoDisponible e) {
			throw new EjemplarNoDisponible();		}
	}

	public void desactivarEjemplar(String titulo, String codigo) throws LibroNoExiste, EjemplarNoDisponible{
		try {
			buscarLibro(titulo);
			int i = buscarPosicionLibro(titulo);
			libros[i].buscarEjemplar(codigo).setDisponibilidad(false);
		}
		catch (LibroNoExiste l) {}
		catch(EjemplarNoDisponible e) {}
	}

	public void eliminarEjemplar(String titulo, String codigo) throws LibroNoExiste, EjemplarNoDisponible{
		try {
			buscarLibro(titulo);
			int i = buscarPosicionLibro(titulo);
			libros[i].buscarEjemplar(codigo).setExistencia(false);
		}
		catch (LibroNoExiste l) {}
		catch(EjemplarNoDisponible e) {}
	}

	public void modificarLibro(String titulo, String casilla, String edit) throws LibroNoExiste{
		try {
			int i = buscarPosicionLibro(titulo);
			switch (casilla) {
			case "Titulo":
				libros[i].setTitulo(edit);
				break;
			case "Autores":
				libros[i].setAutores(edit);
				break;
			case "Codigo":
				libros[i].setCodigo(edit);
				break;
			case "Editorial":
				libros[i].setEditorial(edit);
				break;
			case "Edicion" :
				int aux = Integer.parseInt(edit);
				libros[i].setEdicion(aux);
				break;
			case "Existencia":{
				switch(edit) {
				case "True":
					libros[i].setExistencia(true);
					break;
				case "False":
					libros[i].setExistencia(false);
					break;
				}
			}
		}
		}
		catch (LibroNoExiste l) {
			throw new LibroNoExiste();
		}

	}

	public void modificarEjemplar(String titulo, String codigo, String casilla, String edit) throws LibroNoExiste, EjemplarNoDisponible{
		try {
			int i = buscarPosicionLibro(titulo);
			switch(casilla) {
			case "Codigo":
				libros[i].setCodigoEjemplar(codigo, edit);
				break;
			case "Disponibilidad": {
				switch(edit) {
					case "True":
						libros[i].setDisponibilidadEjemplar(codigo, true);
						break;
					case "False":
						libros[i].setDisponibilidadEjemplar(codigo, false);
						break;
					}
				break;
			}
			case "Existencia": {
				switch(edit) {
				case "True":
					libros[i].setExistenciaEjemplar(codigo, true);
					break;
				case "False":
					libros[i].setExistenciaEjemplar(codigo, false);
					break;
				}
				break;
			}
		}
		}
		catch (LibroNoExiste l) {}
		catch(EjemplarNoDisponible e) {}
	}

	public void modificarUsuario(String cc, String casilla, String edit) throws UsuarioNoExiste{
		try {
			int i = buscarPosicionUsuario(cc);
			switch(casilla) {
			case "CC":
				usuarios[i].setCC(edit);
				break;
			case "Nombre":
				usuarios[i].setNombre(edit);
				break;
			case "Telefono":
				usuarios[i].setTelefono(edit);
				break;
			case "Tipo":
				usuarios[i].setTipo(edit);
				break;
		}
		}
		catch (UsuarioNoExiste u) {}
	}
}
