package Solucion;

public class SolucionOchoReinas {

	private static final int TAM_TABLERO = 8;
	private static int contadorSoluciones = 0;

	//Comprueba si colocar una reina en la posición dada es seguro
	private static boolean esSeguro(int[][] tablero, int fila, int columna) {
		//Comprueba si no hay otra reina en la misma fila
		for (int i = 0; i < columna; i++) {
			if (tablero[fila][i] == 1) {
				return false;
			}
		}
		//Comprueba si no hay otra reina en la diagonal superior izquierda a inferior derecha
		for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
			if (tablero[i][j] == 1) {
				return false;
			}
		}
		//Comprueba si no hay otra reina en la diagonal inferior izquierda a superior derecha
		for (int i = fila, j = columna; i < TAM_TABLERO && j >= 0; i++, j--) {
			if (tablero[i][j] == 1) {
				return false;
			}
		}
		//Si no se cumple ninguna de las condiciones anteriores, es seguro colocar una reina en la posición actual
		return true;
	}

	private static void imprimirSolucion(int[][] tablero) {
		System.out.println();
		System.out.println("Solución #" + (++contadorSoluciones));

		//Imprime las columnas
		System.out.println("  A B C D E F G H");
		System.out.println("  ----------------");

		//Imprime las filas
		for (int i = 0; i < TAM_TABLERO; i++) {
			System.out.print((i+1) + "|"); // Imprime el número de la fila
			for (int j = 0; j < TAM_TABLERO; j++) {
				//Si hay una reina en esta posición, imprime Q, de lo contrario, imprime -
				System.out.print((tablero[i][j] == 1 ? "Q" : "-") + " "); 
			}
			System.out.println("|" + (i+1)); // Imprime el número de la fila al final de la fila
		}

		//Imprime las columnas de nuevo al final
		System.out.println("  ----------------");
		System.out.println("  A B C D E F G H");
	}

	private static void resolverTodas(int[][] tablero, int col) {
		//Caso base: si se han colocado las 8 reinas, la solución es válida
		if(col == TAM_TABLERO) {
			imprimirSolucion(tablero);
			return;
		}
		//Para cada fila en la columna actual
		for(int i = 0; i < TAM_TABLERO; i++) {
			//Comprueba si es seguro colocar una reina en esta posición
			if(esSeguro(tablero, i, col)) {
				//Coloca una reina en esta posición
				tablero[i][col] = 1;
				//Resuelve el problema para la siguiente columna
				resolverTodas(tablero, col + 1);
				//Si no se puede resolver para la siguiente columna, retrocede y prueba otra fila
				tablero[i][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] tablero = new int[TAM_TABLERO][TAM_TABLERO];
		resolverTodas(tablero, 0);
		if (contadorSoluciones == 0) {
			System.out.println("No se encontró ninguna solución.");
		} else {
			System.out.println("Se encontraron " + contadorSoluciones + " soluciones en total, y se colocaron " + TAM_TABLERO + " reinas en total.");
		}
	}
}