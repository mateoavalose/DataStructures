package clase2;
import clase2.Producto.day;

public class Fabrica {

	Producto[] productos = new Producto[10];
	private static int cantidad;

	public void addProducto(String name) {
		productos[cantidad] = new Producto(name);
		cantidad++;
	}

	public String buscarProducto(String name) {
		int i = 0;
		while (i < 9 && productos[i].getName().compareTo(name) !=0) i++;
		return productos[i].getName();
	}

	public void addProduccionDia(String name, double produccion, day dia) {
		int i = 0;
		while (i < 9 && productos[i].getName().compareTo(name) !=0) i++;
		productos[i].addProduccionDia(produccion, dia);
	}

	public double getProduccionDia(String name, day dia) {
		int i = 0;
		while (i < 9 && productos[i].getName().compareTo(name) !=0) i++;
		return productos[i].getProduccionDia(dia);
	}

	public double getProduccionSemana(String name) {
		int i = 0;
		while (i < 9 && productos[i].getName().compareTo(name) !=0) i++;
		return productos[i].getproduccionSemana();
	}

	public double getProduccionTotal() {
		double sum = 0;
		for(int i = 0; i < cantidad; i++) {
			sum += productos[i].getproduccionSemana();
		} return sum;
	}
}
