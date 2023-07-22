package Clase10;

public class Persona implements Comparable <Persona>{
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
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

	@Override
	public String toString() {
		return nombre + "-" + edad;
	}
	
	@Override
	public int compareTo(Persona o) {
		//Comparar por Nombre
		//return nombre.compareTo(o.getNombre());
		
		//Comparar por edades
		//return edad-o.getEdad();
		
		//Comparar por Nombre, y si se llaman igual por edad
		return(nombre.compareTo(o.getNombre()) == 0)? edad-o.getEdad(): nombre.compareTo(o.getNombre());
	}
	
	
}
