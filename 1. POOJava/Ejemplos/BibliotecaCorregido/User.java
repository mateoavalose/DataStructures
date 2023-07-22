package BibliotecaCorregido;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String CC;
	private String telefono;
	private String tipo;

	public User(String nombre, String CC, String telefono, String tipo) {
		this.nombre = nombre;
		this.CC = CC;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCC() {
		return CC;
	}

	public void setCC(String cC) {
		CC = cC;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
