package clase2;
import clase2.Producto.day;

public class Principal {

	public static void main(String[] args) {
		//Ejemplo 5 - Trabajadores
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 5: Trabajadores");
		Empresa e = new Empresa();
		e.addTrabajador("Mateo", 500);
		e.addTrabajador("Lucas", 600);
		e.addTrabajador("Santiago", 200);
		e.asignarCantidadDias("Mateo", 15);
		e.asignarCantidadDias("Lucas", 10);
		e.asignarCantidadDias("Santiago", 25);
		String buscarNom = "Lucas";
		System.out.println("El salario de " + e.buscar(buscarNom).getNombre() + " es: " + e.buscar(buscarNom).calcSalario());
		e.removeTrabajador("Lucas");
		System.out.println(e.buscar("Lucas"));


		//Ejemplo 6: Nota Estudiantes
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 6: Nota Estudiantes");
		Estudiante s1 = new Estudiante("Mateo", 4.8, 3.1, 2.1);
		Estudiante s2 = new Estudiante("Laura", 1.8, 3.5, 4.1);
		System.out.println("La calificación de " + s1.getNombre() + " es: " + s1.clasEs());
		System.out.println("La calificación de " + s2.getNombre() + " es: " + s2.clasEs());
		System.out.println("La cantidad de estudiantes creados es: " + Estudiante.getCantidad());


		//Ejemplo 7: Proyectos
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 7: Proyectos");
		e.addProyecto("Viajar");
		e.addHoras("Viajar", 10, "Febrero");
		e.addHoras("Viajar", 12, "Marzo");
		e.addHoras("Viajar", 3, "Julio");
		System.out.println("Febrero: " + e.horasMes("Viajar", "Febrero") + ", Marzo: " +e.horasMes("Viajar", "Marzo"));
		System.out.println("Horas totales del proyecto " + e.buscarP("Viajar").getNombre() + " son: " + e.horasTotal("Viajar"));
		e.addProyecto("Estudiar");
		e.addHoras("Estudiar", 5, "Enero");
		e.addHoras("Estudiar", 15, "Diciembre");
		System.out.println("Enero: " + e.horasMes("Estudiar", "Enero") + ", Diciembre: " + e.horasMes("Estudiar", "Diciembre"));
		System.out.println("Horas totales del proyecto " + e.buscarP("Estudiar").getNombre() + " son: "+ e.horasTotal("Estudiar"));
		System.out.println("Horas totales trabajadas en proyectos: " + e.horasTotalProyectos());


		//Ejemplo 8: Información de Producción
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 8: Información de Producción");
		Fabrica f = new Fabrica();
		f.addProducto("Botellas");
		System.out.println("Producto " + f.buscarProducto("Botellas") + " añadido");
		f.addProduccionDia("Botellas", 10, day.Lunes);
		f.addProduccionDia("Botellas", 3, day.Jueves);
		f.addProduccionDia("Botellas", 12, day.Viernes);
		System.out.println("La producción de " + f.buscarProducto("Botellas") + " el viernes fue: " + f.getProduccionDia("Botellas", day.Viernes));
		f.addProducto("Patinetas");
		System.out.println("Producto " + f.buscarProducto("Patinetas") + " añadido");
		f.addProduccionDia("Patinetas", 5, day.Martes);
		f.addProduccionDia("Patinetas", 15, day.Miercoles);
		System.out.println("La producción de " + f.buscarProducto("Patinetas") + " el martes fue: " + f.getProduccionDia("Patinetas", day.Martes));
		System.out.println("La producción total de " + f.buscarProducto("Botellas") + " es: " + f.getProduccionSemana("Botellas"));
		System.out.println("La producción total de " + f.buscarProducto("Patinetas") + " es: " + f.getProduccionSemana("Patinetas"));
		System.out.println("La producción total de la fabrica fue: " + f.getProduccionTotal());

	}

}
