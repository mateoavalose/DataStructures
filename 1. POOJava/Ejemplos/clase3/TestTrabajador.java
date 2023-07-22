package clase3;

public class TestTrabajador {

	public static void main(String[] args) {
		Trabajador t = new Trabajador("Juan Gonzalez", 400, 23);
		//Se ha creado un nuevo trabajador
		System.out.println("El salario es: " + t.salario());

		Trabajador l = new EmpLimpieza("Maria Linares", 250, 19, 50, 40);
		//Se ha creado un nuevo Empeado de Limpieza
		System.out.println("El salario es: " + l.salario());
	}

}
