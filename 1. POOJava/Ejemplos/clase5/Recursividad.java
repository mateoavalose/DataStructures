package clase5;

public class Recursividad {

	//Solución Iterativa para Factorial
	public static long factorial(long n) {
		long f = 1;
		for(int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}
	//Solución Recursiva para Factorial
	public static long factorialRec(long n) {
		long f = 1;
		if( n == 1 || n <= 0) //Condición de parada
			return 1;
		f = n*factorialRec(n-1); //Llamada recursiva
		return f;
	}

	//Suma de 1 hasta n
	public static int sumaN(int n) {
		if(n <= 0)
			return 0;
		return n+sumaN(n-1);
	}

	//Suma de Elementos de un Array
	public static int sumaArray(int []a) {
		return sumaArray(a, a.length);
	}
	public static int sumaArray(int [] a, int pos) {
		if(pos-1 == 0)
			return a[0];
		return a[pos-1] + sumaArray(a, pos-1);
	}

	//Encontrar el Máximo de un Array
	public static int maxArray(int []a) {
		return maxArray(a, a.length);
	}
	public static int maxArray(int [] a, int pos) {
		int max;
		int max2;
		if(a[pos-1] < a[pos-2])
			max = a[pos-2];
		else
			max = a[pos-1];
		if(pos-2 > 0)
			max2 = maxArray(a, pos-1);
		else
			max2 = 0;

		if(max < max2)
			max = max2;
		return max;
	}

	//Invertir un String
	public static String invertString(String str) {
		if(str == "" || str == null)
			return str;
		return invertString(str, str.length());
	}
	public static String invertString(String str, int index) {
		String inv = "";
		if(index - 1 >= 0)
			inv += String.valueOf(str.charAt(index-1)) + invertString(str, index-1);
		return inv;
	}
	
	//Invertir un string Isis
	public static String invertir(String str) {
		if(str == "" || str == null)
			return str;
		return invertir(str, str.length()-1);
	}
	public static String invertir(String str, int index) {
		if(index == 0)
			return String.valueOf(str.charAt(0));
		return str.charAt(index) + invertir(str, index - 1);
	}

	//Verificar si un String es palíndrome
	public static boolean palabraPalindrome(String str) {
		return palabraPalindrome(str, str.length()-1, 0);
	}
	public static boolean palabraPalindrome(String str, int index, int pos) {
		boolean bool = false;

		if(pos+1 == index-1 && Character.toLowerCase(str.charAt(pos)) == Character.toLowerCase(str.charAt(index)))
			bool = palabraPalindrome(str, index - 1, pos + 1);
		else if(pos != index && Character.toLowerCase(str.charAt(pos)) == Character.toLowerCase(str.charAt(index)))
			bool = true;

		return bool;
	}

	//Suma de todos los elementos de un Array
	public static int sumaElementosArreglo(int[] a) {
		return sumaElementosArreglo(a, 0, a.length-1);
	}
	public static int sumaElementosArreglo(int[]arr, int inferior, int superior) {
		if(inferior >= superior)
			return arr[inferior];
		int medio = (superior - inferior)/2;
		return sumaElementosArreglo(arr, inferior, inferior+medio) + sumaElementosArreglo(arr, inferior+medio+1, superior);
	}
	
	//Encontrar el número máximo de un array
	public static int numMaxArray(int[] array) {
		return numMaxArray(array, 0, array.length-1);
	}
	public static int numMaxArray(int[] array, int inicio, int length) {
		if(inicio >= length) {
			return array[inicio];
		}
		int medio = (length - inicio)/2;
		int maxI = numMaxArray(array, inicio, inicio+medio);
		int maxD = numMaxArray(array, inicio+medio+1, length);
		return Math.max(maxI, maxD);
	}
	//Encontrar el número máximo de un array Isis
	public static int maxArrayIsis(int[] array) {
		if(array.length == 0)
			return 0;
		return maxArrayIsis(array, 0);
	}
	public static int maxArrayIsis(int[] array, int index) {
		if (index ==array.length-1)
			return array[array.length-1];
		return Math.max(array[index], maxArrayIsis(array,index+1));
	}
	
	//Suma de los elementos de una matriz
	public static int sumaElementosMatriz(int[][] matriz) {
		return sumaElementosMatriz(matriz, 0,0);
	}
	public static int sumaElementosMatriz(int[][] matriz, int fila, int columna) {
		
		if((fila == matriz.length - 1) && (columna == matriz[fila].length - 1))
			return matriz[matriz.length - 1][matriz[matriz.length - 1].length - 1];
		else if(columna == matriz[fila].length)
			return sumaElementosMatriz(matriz, fila+1, 0); //Cuando termina una fila, cambio de fila y reinicio
		else
			return matriz[fila][columna] + sumaElementosMatriz(matriz, fila, columna+1); //Se suma una casilla donde estoy y me cambio de columna
			
	}
	
	//Cantidad de pares en un arreglo
	public static int cantidadParesArreglo(int[] array) {
		return cantidadParesArreglo(array, array.length - 1);
	}
	public static int cantidadParesArreglo(int[] array, int index) {
		if(index < 0)
			return 0;
		if(array[index]%2 == 0)
			return 1 + cantidadParesArreglo(array, index - 1);
		return cantidadParesArreglo(array, index-1);
	}

	public static void main(String[] args) {
		//Factorial Número
		System.out.println("Factorial de un Número: ");
		int n = 5;
		System.out.println(factorialRec(n));
		System.out.println("Factorial de " + n + " es: "+ Recursividad.factorialRec(n));

		//Suma desde 1 hasta n
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Suma consecutiva de números: del 1 hasta el n");
		System.out.println("La suma de " + n + " hasta 1 es: " + sumaN(n));

		//Suma elementos array
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Suma de los números de un array chequeando posición a posición");
		int [] a = {1, 2, 3, 4};
		System.out.println("La suma del array " + a.toString() + " es: " + sumaArray(a));

		//Mayor número de un array
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Mayor número en un arreglo recursivamente, chequeando posición a posición");
		System.out.println("El mayor número del array " + a.toString() + " es: " + maxArray(a));

		//Invertir un String
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Invertir un String: ");
		String str = "Hola";
		System.out.println("El string " + str + " invertido: " + invertString(str)); System.out.print("\n");
		System.out.println("Invertir un array (Isis): ");
		System.out.println("El string " + str + " invertido: " + invertir(str));

		//Verificar si un String es palíndrome
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Verificar si un array es Palíndrome");
		String b = "Holoh";
		System.out.println("El string " + b + " es palindrome: " + palabraPalindrome(b));

		//Suma de un array "Divide y Vencerás"
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Suma de un array dividiendo el array");
		System.out.println("La suma del array" + a.toString() + " es: " + sumaElementosArreglo(a));
		
		//Número máximo de un array "Divide y Vencerás"
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		System.out.println("Mayor número en un arreglo: dividiendo el array");
		System.out.println("El número máximo del array " + a.toString() + " es: " + numMaxArray(a)); System.out.print("\n");
		System.out.println("Mayor número en un arreglo: dividiendo el array (Isis)");
		System.out.println("El número máximo del array " + a.toString() + " es: " + maxArrayIsis(a));
		
		//Suma de los elementos de una matriz
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		int[][] c = {{1, 2, 3}, {1, 2, 3}};
		System.out.println("La suma de los elementos una matriz");
		System.out.println("La suma de la matriz " + c + " es " + sumaElementosMatriz(c));
		
		//Cantidad pares de un arreglo
		System.out.print("\n"); System.out.println("-------------------"); System.out.print("\n");
		int[] arre = {1, 2, 3, 4, 5, 6};
		System.out.println("Cantidad de pares en el arreglo");
		System.out.println(cantidadParesArreglo(arre));
	}

}
