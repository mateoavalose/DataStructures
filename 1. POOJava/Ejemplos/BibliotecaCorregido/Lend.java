package BibliotecaCorregido;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class Lend implements Serializable{
	private static final long serialVersionUID = 1L;

	private User usuario;
	private Exemplary [] ejemplares;
	private LocalDate fechaEntrega;
	private LocalDate fechaDevolucion;

	public Lend(User usuario, Exemplary[] ejemplares) {
		this.usuario = usuario;
		this.ejemplares = ejemplares;
		fechaEntrega = LocalDate.now();
	}

	public Lend(User usuario, Exemplary[] ejemplares, LocalDate fechaEntrega) {
		this.usuario = usuario;
		this.ejemplares = ejemplares;
		this.fechaEntrega = fechaEntrega;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Exemplary[] getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Exemplary[] ejemplares) {
		this.ejemplares = ejemplares;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Exemplary [] devolucionEjemplar(int j) {
		ejemplares[j].setDisponibilidad(true);
		System.arraycopy(ejemplares, j+1, ejemplares, j, ejemplares.length - j - 1);
		ejemplares = Arrays.copyOf(ejemplares, ejemplares.length - 1);
		return ejemplares;
	}

}
