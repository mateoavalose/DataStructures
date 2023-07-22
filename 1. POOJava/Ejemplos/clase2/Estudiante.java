package clase2;


public class Estudiante {

	String nombre;
	double nota1, nota2, nota3;
	private static int cantidad;

	public Estudiante(String nombre, double nota1, double nota2, double nota3) {
		cantidad++;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public double getNota(String nota) {
		return nota.equals("Nota 1")? nota1: nota.equals("Nota 2")? nota2: nota.equals("Nota 3")? nota3: 0;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public char clasEs() {
			double prom = (nota1 + nota2 + nota3)/3;

			 double scale = Math.pow(10, 0);
	         double roundProm = Math.round(prom*scale)/scale;

			return (roundProm == 5 || roundProm == 4)? 'B': (roundProm == 3)? 'R': (roundProm == 2)? 'M': '?';
	}



}
