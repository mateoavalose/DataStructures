package TorresDeHanoi;

public class PasosTorresDeHanoi {
	
	public static int pasosTorresDeHanoi(int n) {
		return pasosTorresDeHanoi(n, "A", "B", "C");
	}
	public static int pasosTorresDeHanoi(int n, String origen, String auxiliar, String destino) {
		int i = 0;
		if (n == 1) {
			System.out.println("Mover disco 1 de " + origen + " a " + destino);
			i++;
		} else {
			i += pasosTorresDeHanoi(n - 1, origen, destino, auxiliar);
			System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
			i++;
			i += pasosTorresDeHanoi(n - 1, auxiliar, origen, destino);
		}
		return i;
	}
	
	public static void main(String[] args) {
		int discos = 3; 
		System.out.println("Pasos torres de hanoi: ");
		System.out.println("Pasos para " + discos + " discos: ");
		System.out.println("Número mínimo de pasos: " + pasosTorresDeHanoi(discos));
	}
}