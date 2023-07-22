package BibliotecaEjemplo;

public class Ejemplar {
	private String codigo;
	//Está o no está prestado
	private boolean disponibilidad;
	//Está en la biblioteca para uso público
	private boolean existencia;

	public Ejemplar(String codigo) {
		this.codigo = codigo;
		disponibilidad = false;
		existencia = true;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public boolean isExistencia() {
		return existencia;
	}

	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}


}
