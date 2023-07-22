package BibliotecaCorregido;
import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;

	private String titulo;
	private String autores;
	private String codigo;
	private String editorial;
	private int edicion;
	private Exemplary [] ejemplares;
	private int cantDisponible;
	private boolean existencia;

	public Book(String titulo, String autores, String codigo, String editorial, int edicion) {
		this.titulo = titulo;
		this.autores = autores;
		this.codigo = codigo;
		this.editorial = editorial;
		this.edicion = edicion;
		ejemplares = new Exemplary[0];
		existencia = false;
		cantDisponible = 0;
	}

	public Book(String titulo, String autores, String codigo, String editorial, int edicion, Exemplary[] ejemplares, int cantDisponible, boolean existencia) {
		this.titulo = titulo;
		this.autores = autores;
		this.codigo = codigo;
		this.editorial = editorial;
		this.edicion = edicion;
		this.ejemplares = ejemplares;
		this.cantDisponible = cantDisponible;
		this.existencia = existencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public Exemplary[] getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Exemplary[] ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	public boolean isExistencia() {
		return existencia;
	}

	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}

	public void addExemplary(Exemplary e) {
		if(ejemplares == null){
			ejemplares = new Exemplary[0];
		} else {
			ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
			ejemplares[ejemplares.length - 1] = e;
			cantDisponible += 1;
		}
	}

	public Exemplary buscarEjemplar(String codigo) {
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if(i < ejemplares.length) {
			return ejemplares[i];
		} else {
			return null;
		}

	}

	public Exemplary getEjemplarDisponible() {
		int i = 0;
		while(i < ejemplares.length && !ejemplares[i].isDisponibilidad()) i++;
		if (i < ejemplares.length){
			return ejemplares[i];
		} else {
			return null;
		}
	}

	public Exemplary getEjemplar(String codigo) {
		int i = 0;
		while (i < ejemplares.length && ejemplares[i].getCodigo().compareTo(codigo) != 0) i++;
		if(i < ejemplares.length) {
			return ejemplares[i];
		} else {
			return null;
		}

	}

}
