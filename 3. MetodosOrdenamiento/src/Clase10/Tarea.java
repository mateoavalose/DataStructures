package Clase10;
import java.util.*;

public class Tarea {
	// ----------------------------------------------------------------------------------------
	//Quick Sort con Pivote Aleatorio
	static void randomPivote(int [] array, int lower, int upper){ //Seleccionará un pivote aleatorio entre los índices menor y mayor del arreglo
		Random random = new Random();
		int pivote = random.nextInt(upper-lower) + lower; //Generar un pivote aleatorio entre el valor "lower" y "upper"
		
		//Intercambiar el valor en el arreglo de "upper" y el pivote
		int aux = array[pivote]; 
		array[pivote] = array[upper];
		array[upper] = aux;
	}

	static int particion(int [] array, int lower, int upper){ //Dividir el arreglo en dos, según el pivote aleatorio seleccionado
		randomPivote(array, lower, upper); //Llamar el método de randomPivote
		int pivote = array[upper]; //Definir un pivote nuevo, según la posición en "upper"

		//Si el elemento comparado es menor al pivote, se pasa a la izquierda. Si es mayor, se pasa a la derecha
		int i = (lower-1);  
		for (int j = lower; j < upper; j++){
			if (array[j] < pivote){
				i++;
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		int aux = array[i+1];
		array[i+1] = array[upper];
		array[upper] = aux;
		return i+1; //Retorna el índice del pivote
	}

	static void sort(int [] array, int lower, int upper){ //Implementa el Quick Sort, verificando que el arreglo sea suficientemente grande para arreglarse
		if (lower < upper){
			int a = particion(array, lower, upper); //Implementa recursivamente la función de particion, hasta que el arreglo esté ordenado
			sort(array, lower, a-1);
			sort(array, a+1, upper);
		}
	}

	//-----------------------------------------------------------------------------------------
	//Merge Sort
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] array, int n) { //Divide el arreglo en 2 y se llama recursivamente para cada mitad. Luego, junta las dos mitades con el método "merge".
		if (n < 2) {
			return null;
		}
		int half = n / 2;
		Comparable[] left = new Comparable[half];
		Comparable[] right = new Comparable[n - half];

		for (int i = 0; i < half; i++) {
			left[i] = array[i];
		}
		for (int i = half; i < n; i++) {
			right[i - half] = array[i];
		}
		return merge(mergeSort(left, half), mergeSort(right, n - half));
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable[] merge(Comparable[] array1, Comparable[] array2) /*throws Exception*/{ //Junta las mitades de los arreglos en 1
		if(array1 == null || array2 == null)
			//throw new Exception("Una lista es vacía");
			System.out.println("Una lista es vacía");
		
		Comparable[] result = new Comparable[array1.length + array2.length];
		int i=0, j=0;
		
		while (i < array1.length && j < array2.length)
			result[i+j] = (array1[i].compareTo(array2[j]) <= 0)? array1[i++]:array2[j++];
		
		for(int k = i; k < array1.length; k++)
			result[k+j] = array1[k];
			
		for(int k = j; k < array2.length; k++)
			result[k+i] = array2[k];
		return result;
	}
	
	// ----------------------------------------------------------------------------------------
	//MergeSort para enteros
	public static void mergeSort(int[] array, int n) { //Divide el arreglo en 2 y se llama recursivamente para cada mitad. Luego, junta las dos mitades con el método "merge".
		if (n < 2) {
			return;
		}
		int half = n / 2;
		int[] left = new int[half];
		int[] right = new int[n - half];

		for (int i = 0; i < half; i++) {
			left[i] = array[i];
		}
		for (int i = half; i < n; i++) {
			right[i - half] = array[i];
		}
		mergeSort(left, half);
		mergeSort(right, n - half);
		merge(array, left, right, half, n - half);
	}
	public static void merge(int[] array, int[] leftArr, int[] rightArr, int le, int ri) { //Junta las mitades de los arreglos en 1
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < le && j < ri) {
			if(leftArr[i] != (rightArr[j])) {
				array[k++] = leftArr[i++];
			}
			else {
				array[k++] = rightArr[j++];
			}
		}
		while (i < le) {
			array[k++] = leftArr[i++];
		}
		while (j < ri) {
			array[k++] = rightArr[j++];
		}
	}
	
	// ----------------------------------------------------------------------------------------
	public static void main(String [] args) {
		int[] a = {1, 6, 5, 4, 7, 13, 2, 0};
		int [] b = a;
		
		System.out.println("Arreglo por QuickSort");		
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		
		System.out.println("Arreglo por MergeSort");
		mergeSort(b, b.length);
		System.out.println(Arrays.toString(b));
		
	}
	
}
