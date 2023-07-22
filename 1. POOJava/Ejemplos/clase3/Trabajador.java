package clase3;

public class Trabajador {
	protected String nombre;
	protected float sb; //Salario Básico
	protected float dt; //Días Trabajados

	public Trabajador(String nombre, float sb, float dt) {
		this.nombre = nombre;
		this.sb = sb;
		this.dt = dt;
	}

	public float salario() {
		return sb*dt/24;
	}
}
