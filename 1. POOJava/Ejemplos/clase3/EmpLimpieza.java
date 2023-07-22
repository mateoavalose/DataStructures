package clase3;

public class EmpLimpieza extends Trabajador {
	private float norma;
	private float cump;

	public EmpLimpieza(String nombre, float sb, int dt, float norma, float cump) {
		super(nombre, sb, dt); //Llamar constructor ancestro
		this.norma = norma;
		this.cump = cump;
	}

	@Override
	public float salario() {
		return super.salario() + super.salario()*(float) 0.1*cump/norma;
	}
}
