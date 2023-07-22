package clase2;

import java.util.Arrays;

public class Empresa {

	//Ejercicio 5: Trabajadores

	Trabajador[] trabajadores;

	public Empresa() {
		trabajadores = new Trabajador[0];
	}

	public void addTrabajador(String nombre, float salarioBasico) {
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length + 1);
		trabajadores[trabajadores.length-1] = new Trabajador(nombre, salarioBasico);
	}

	public void removeTrabajador(String nombre) {
		int i = 0;
		while (i < trabajadores.length && trabajadores[i].getNombre().compareTo(nombre) !=0) i++;
		System.arraycopy(trabajadores, i+1, trabajadores, i, trabajadores.length - i - 1);
		trabajadores = Arrays.copyOf(trabajadores, trabajadores.length-1);
	}

	public Trabajador buscar(String nombre) {
		int i = 0;
		while (i < trabajadores.length && trabajadores[i].getNombre().compareTo(nombre) !=0) i++;
		if(i<trabajadores.length) {
		return trabajadores[i];
		} else {
			return null;
		}
		//Buscar Trabajador y retornar Posición
		//public int buscar(String nombre) {
		//	int i = 0;
		//	while (i < trabajadores.length && trabajadores[i].getNombre().compareTo(nombre) !=0) i++;
		//	return (i < trabajadores.length)? i : -1;
		//}
	}

	public void asignarCantidadDias(String nombre, int cantidad) {
		int i = 0;
		while (i < trabajadores.length && trabajadores[i].getNombre().compareTo(nombre) != 0) i++;
		trabajadores[i].setCantDias(cantidad);

		//public void asignarCantidadDias(String nombre, int cantidad) {
		//	int index = buscar(nombre);
		//	if (index != -1) {
		//		trabajadores[index].setCantDias(cantidad);
		//	}
	}

	// Ejercicio 7: Proyectos

	Proyectos [] proyectos = new Proyectos[0];

	public void addProyecto(String nombre) {
		proyectos = Arrays.copyOf(proyectos, proyectos.length + 1);
		proyectos[proyectos.length - 1] = new Proyectos(nombre);
	}

	public Proyectos buscarP(String nombre) {
		int i = 0;
		while (i < proyectos.length && proyectos[i].getNombre().compareTo(nombre) != 0) i++;
		return proyectos[i];
	}

	public void addHoras(String nombre, double horas, String mes) {
		int i = 0;
		while (i < proyectos.length && proyectos[i].getNombre().compareTo(nombre) != 0) i++;
		proyectos[i].addHoras(horas, mes);
	}

	public double horasMes(String nombre, String mes) {
		int i = 0;
		while (i < proyectos.length && proyectos[i].getNombre().compareTo(nombre) != 0) i++;
		return proyectos[i].getHoras(mes);
	}

	public double horasTotal(String nombre) {
		int n = 0;
		while (n < proyectos.length && proyectos[n].getNombre().compareTo(nombre) != 0) n++;
		return proyectos[n].horasTotal();
	}

	public double horasTotalProyectos() {
		double sum = 0;

		for (Proyectos element : proyectos) {
			sum += element.horasTotal();
		} return sum;
	}

}
