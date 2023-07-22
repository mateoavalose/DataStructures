package Ordenamiento;
public class Persona2 implements Comparable<Persona2>{
	private String nombre;
	private int edad;
	private boolean discapacidad;
	private boolean embarazo;
	
	public Persona2(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.discapacidad = false;
		this.embarazo = false;
	}
	
	public Persona2(String nombre, int edad, boolean discapacidad, boolean embarazo) {
		this.nombre = nombre;
		this.edad = edad;
		this.discapacidad = discapacidad;
		this.embarazo = embarazo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean getDiscapacidad() {
		return discapacidad;
	}
	
	public void setDiscapacidad(boolean discapacidad) {
		this.discapacidad = discapacidad;
	}
	
	public boolean getEmbarazo() {
		return embarazo;
	}
	
	public void setEmbarazo(boolean embarazo) {
		this.embarazo = embarazo;
	}

	@Override
	public String toString() {
		return nombre + "-" + edad;
	}
	
	@Override
	public int compareTo(Persona2 o) {
		//Comparar por Nombre
		//return nombre.compareTo(o.getNombre());
		
		//Comparar por edades
		//return edad-o.getEdad();
		
		//Comparar por Nombre, y si se llaman igual por edad
		return(nombre.compareTo(o.getNombre()) == 0)? edad-o.getEdad(): nombre.compareTo(o.getNombre());
	}
}
