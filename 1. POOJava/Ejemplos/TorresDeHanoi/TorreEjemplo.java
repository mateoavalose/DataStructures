package TorresDeHanoi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TorreEjemplo {

	public static int cont = 0;

	public static int [][] torresDeHanoi(int n) {
		int[] A = IntStream.rangeClosed(1, n).toArray();
		int [] B = new int[n];
		int [] C = new int[n];
		System.out.println("Estado Inicial: " + Arrays.toString(A) + Arrays.toString(B) + Arrays.toString(C));
		return torresDeHanoi(n, A, B, C);
	}
	public static int[][] torresDeHanoi(int n, int[] inicial, int[] auxiliar, int[] destino) {
		if(n == 1) {
			int i = 0;
	        while (destino[i] != 0 && i < destino.length) {
	        	i++;
	        }
			destino[i] = inicial[n-1];
			inicial[n-1] = 0;
			cont++;
		} else {
			int [][] aux1 = torresDeHanoi(n-1, inicial, destino, auxiliar);
			inicial = aux1[0];
			auxiliar = aux1[2];
			destino = aux1[1];

			int i = 0;
	        while (destino[i] != 0 && i < destino.length) {
	            i++;
	        }
			destino[i] = inicial[n-1];
			inicial[n-1] = 0;
			cont++;

			int [][] aux2 = torresDeHanoi(n-1, auxiliar, inicial, destino);
			inicial = aux2[0];
			auxiliar = aux2[1];
			destino = aux2[2];
		}
		int[][] ans = {inicial, auxiliar, destino};
		return ans;
	}


	public static void main(String[] args) {
		int n = 3;
	    System.out.println("Estado Final: " + Arrays.deepToString(torresDeHanoi(n)));
	    System.out.println("Número mínimo de pasos: " + cont);

	}
}
