package TorresDeHanoi;

import java.util.stream.IntStream;
import java.util.*;

public class Solucion {
public static int cont = 0;
	
	public static int [][] torresDeHanoi(int n) {
		int[] A = IntStream.rangeClosed(1, n).toArray();
		int[] invA = new int[A.length];

		for (int i = invA.length - 1, j = 0; i >= 0; i--, j++)
			invA[i] = A[j];
		
		int [] B = new int[n];
		int [] C = new int[n];
		System.out.println("Estado Inicial: " + Arrays.toString(invA) + Arrays.toString(B) + Arrays.toString(C));
		return torresDeHanoi(n, invA, B, C);
	}
	public static int[][] torresDeHanoi(int n, int[] inicial, int[] auxiliar, int[] destino) {
		int [] A = inicial;
		int [] B = auxiliar;
		int [] C = destino;
		
		if(n == 1) {
			int i = 0;
	        while (C[i] != 0) {
	            i++;
	        }
			C[i] = A[n-1];
			A[n-1] = 0;
			cont++;
		
		} else {
			
			int [][] aux1 = torresDeHanoi(n-1, A, C, B);
			A = aux1[0];
			B = aux1[1];
			C = aux1[2];
			
			int i = 0;
	        while (C[i] != 0) {
	            i++;
	        }
			C[i] = A[n-1];
			A[n-1] = 0;
			cont++;
			
			int [][] aux2 = torresDeHanoi(n-1, B, A, C);
			A = aux2[0];
			B = aux2[1];
			C = aux2[2];
			
		}
		
		int[][] ans = {A, B, C};
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 2;
		
	    System.out.println("Estado Final: " + Arrays.deepToString(torresDeHanoi(n)));
	    System.out.println("Número mínimo de pasos: " + cont);
		
	}
}
