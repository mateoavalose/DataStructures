package BibliotecaEjemplo;
import java.util.Arrays;

public class Libro {
	private String titulo;
	private String autores;
	private String codigo;
	private String editorial;
	private int edicion;
	private Ejemplar [] ejemplares;
	private int cantDisponible;
	private boolean existencia;

	public Libro(String titulo, String autores, String codigo, String editorial, int edicion) {
		this.titulo = titulo;
		this.autores = autores;
		this.codigo = codigo;
		this.editorial = editorial;
		this.edicion = edicion;
		ejemplares = new Ejemplar[0];
		existencia = false;
	}

	public Libro() {
		super();
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setAutores(String autores){
		this.autores = autores;
	}

	public String getAutores() {
		return autores;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public int getEdicion() {
		return edicion;
	}

	public Ejemplar[] getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Ejemplar[] ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public void addCantDisponible(int cantDisponible) {
		this.cantDisponible += cantDisponible;
	}

	public boolean isExistencia() {
		return existencia;
	}

	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}

	public void addEjemplar(Ejemplar e) {
		ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
		ejemplares[ejemplares.length - 1] = e;
	}

	public Ejemplar buscarEjemplarDisponible() throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && !ejemplares[i].isDisponibilidad()) i++;
		if (i < ejemplares.length) {
			return ejemplares[i];
		} else {
			throw new EjemplarNoDisponible();
		}
	}

	public Ejemplar buscarEjemplarPrestamo() throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && !ejemplares[i].isDisponibilidad()) i++;
		if (i < ejemplares.length && ejemplares[i].isDisponibilidad()) {
			ejemplares[i].setDisponibilidad(false);
			return ejemplares[i];
		} else {
			throw new EjemplarNoDisponible();
		}
	}

	public Ejemplar buscarEjemplar(String codigo) throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if(i < ejemplares.length) {
			return ejemplares[i];
		} else {
			throw new EjemplarNoDisponible();
		}

	}

	public void setDisponibilidadEjemplar(String codigo, boolean edit) throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if (i < ejemplares.length) {
			ejemplares[i].setDisponibilidad(edit);
		} else {
			throw new EjemplarNoDisponible();
		}

	}

	public void setCodigoEjemplar(String codigo, String edit) throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if (i < ejemplares.length) {
		ejemplares[i].setCodigo(edit);
		} else {
			throw new EjemplarNoDisponible();
		}
	}

	public void setExistenciaEjemplar(String codigo, boolean edit) throws EjemplarNoDisponible{
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if (i < ejemplares.length) {
			ejemplares[i].setExistencia(edit);
		} else {
			throw new EjemplarNoDisponible();
		}
	}

	public void eliminarEjemplar(Ejemplar e) {
		int i = 0;
		while (i < ejemplares.length && !ejemplares[i].equals(e)) i++;
		System.arraycopy(ejemplares, i+1, ejemplares, i, ejemplares.length - i - 1);
		ejemplares = Arrays.copyOf(ejemplares, ejemplares.length - 1);
	}

	public void desactivarEjemplar(Ejemplar e) {
		int i = 0;
		while (i < ejemplares.length && !ejemplares[i].equals(e)) i++;
		ejemplares[i].setDisponibilidad(false);
	}

}
