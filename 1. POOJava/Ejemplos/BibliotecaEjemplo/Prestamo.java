package BibliotecaEjemplo;
import java.time.LocalDate;

public class Prestamo {
	private Usuario usuario;
	private Ejemplar [] ejemplares;
	private LocalDate fechaEntrega;
	private LocalDate fechaDevolucion;

	public Prestamo(Usuario usuario, Ejemplar[] ejemplares) {
		this.usuario = usuario;
		this.ejemplares = ejemplares;
		fechaEntrega = LocalDate.now();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Ejemplar[] getEjemplar() throws EjemplarNoDisponible{
			return ejemplares;
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


}
