package BibliotecaEjemplo;

public class Usuario {
	private String nombre;
	private String CC;
	private String telefono;
	private String tipo;

	public Usuario(String nombre, String CC, String telefono, String tipo) {
		this.nombre = nombre;
		this.CC = CC;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCC(String CC) {
		this.CC = CC;
	}
	public String getCC() {
		return CC;
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
