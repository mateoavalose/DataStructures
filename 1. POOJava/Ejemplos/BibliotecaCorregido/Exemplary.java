package BibliotecaCorregido;

import java.io.Serializable;

public class Exemplary implements Serializable{
	private static final long serialVersionUID = 1L;

	private String codigo;
	//Está o no está prestado
	private boolean disponibilidad;
	//Está en la biblioteca para uso público
	private boolean existencia;

	public Exemplary(String codigo) {
		this.codigo = codigo;
		disponibilidad = false;
		existencia = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
