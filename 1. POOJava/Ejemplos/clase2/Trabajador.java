package clase2;

public class Trabajador {
	String nombre;
	double salariob, dias;
	public static final double diasMinimos = 24;

	public double calcSalario() {
		double salario = salariob*dias/diasMinimos;
		return salario;
	}

	public String getNombre() {
		return nombre;
	}


	public double getSalarioB() {
		return salariob;
	}
	public void setSalariob(double newSalariob) {
		salariob = newSalariob;
	}


	public double getDias() {
		return dias;
	}
	public void setCantDias(int newDias) {
		dias = newDias;
	}


	public Trabajador(String nombre, double salariob) {
		this.nombre = nombre;
		this.salariob = salariob;
	}

}