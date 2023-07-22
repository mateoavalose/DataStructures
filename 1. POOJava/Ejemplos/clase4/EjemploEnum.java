package clase4;

public class EjemploEnum {
	public static void main(String[] args) {
		Precio precio = Precio.valueOf("CARO");
		System.out.println(precio);

		switch(precio) {
		case BARATO: System.out.println("Algo específico para baratos"); break;
		case MEDIO: System.out.println("Algo específico para medios"); break;
		case CARO: System.out.println("Algo específico para caros"); break;
		}
		System.out.println();
		for(Precio pr:Precio.values()) {
			System.out.println(pr.name() + " " + pr.ordinal());
		}
		System.out.println("----");

		PrecioRango p = PrecioRango.CAROS;
		System.out.println(p);
		System.out.println(p.ordinal());
	}
	public enum Precio {BARATO, MEDIO, CARO}

	public enum PrecioRango{
		BARATOS(0,10000), MEDIOS(10000, 100000), CAROS(100000, 1000000);
		private double min;
		private double max;
		private PrecioRango(double min, double max) {
			this.min = min;
			this.max = max;
		}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
}
}