package clase2;

public class Producto {

	public enum day{
		Lunes, Martes, Miercoles, Jueves, Viernes;
	}

	String name;
	double [] produccionDiaria = new double[5];

	public Producto(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addProduccionDia(double produccion, day dia) {
		produccionDiaria[dia.ordinal()] += produccion;
		/*switch(day.valueOf(name)) {
		case Lunes: produccionDiaria[0] += produccion;
		break;
		case Martes: produccionDiaria[1] += produccion;
		break;
		case Miercoles: produccionDiaria[2] += produccion;
		break;
		case Jueves: produccionDiaria[3] += produccion;
		break;
		case Viernes: produccionDiaria[4] += produccion;
		break;
		}*/
	}

	public double getProduccionDia(day dia) {
		return produccionDiaria[dia.ordinal()];

		/*switch(day.valueOf(name)) {
		case Lunes: return produccionDiaria[0];
		case Martes: return produccionDiaria[1];
		case Miercoles: return produccionDiaria[2];
		case Jueves: return produccionDiaria[3];
		case Viernes: return produccionDiaria[4];
		}
		return 0;*/
	}

	public double getproduccionSemana() {
		double sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += produccionDiaria[i];
		} return sum;
	}
}
