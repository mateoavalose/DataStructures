package clase2;

public class Proyectos {
	String nombre;
	double [] horasTrabajadas = new double[12];


	public Proyectos(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void addHoras(double cantidadHoras, String mes) {
		int pos = (mes.equals("Enero"))? 0: (mes.equals("Febrero"))? 1: (mes.equals("Marzo"))? 2: (mes.equals("Abril"))? 3: (mes.equals("Mayo"))? 4: (mes.equals("Junio"))? 5 : (mes.equals("Julio"))? 6: (mes.equals("Agosto"))? 7: (mes.equals("Septiembre"))? 8 : (mes.equals("Octubre"))? 9 : (mes.equals("Noviembre"))? 10: 11;
		horasTrabajadas [pos] += cantidadHoras;
	}

	public double getHoras(String mes) {
		int pos = (mes.equals("Enero"))? 0: (mes.equals("Febrero"))? 1: (mes.equals("Marzo"))? 2: (mes.equals("Abril"))? 3: (mes.equals("Mayo"))? 4: (mes.equals("Junio"))? 5 : (mes.equals("Julio"))? 6: (mes.equals("Agosto"))? 7: (mes.equals("Septiembre"))? 8 : (mes.equals("Octubre"))? 9 : (mes.equals("Noviembre"))? 10: 11;
		return horasTrabajadas [pos];
	}

	public double horasTotal() {
		double sum = 0;
		for (int i = 0; i <= 11; i++) {
			sum += horasTrabajadas[i];
		} return sum;
	}

}