package Clase10;

import java.util.*;

public class Metodos {
	//-----------------------------------------------------------------------------------------
	//BubbleSort

	//Para un arreglo de enteros
	public static void bubbleSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++)
			for(int j = 0; j < a.length - 1 - i; j++)
				if(a[j+1] < a[j]) {
					int temp = a[j];
					a[j] = a [j+1];
					a[j+1] = temp;
				}
	}

	//General
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void bubbleSort(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i++)
			for(int j = 0; j < a.length - 1 - i; j++)
				if(a[j+1].compareTo(a[j]) < 0) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void bubbleSort2(Comparable[] a) {
		boolean notReady = true;
		for(int i = 0; i < a.length - 1 && notReady; i++) {
			notReady = false;
			for(int j = 0; j < a.length - 1 - i; j++)
				if(a[j+1].compareTo(a[j]) < 0) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					notReady = true;
				}
		}
	}

	//-----------------------------------------------------------------------------------------
	//Método para imprimir la lista de Personas
	@SuppressWarnings("rawtypes")
	public static void printLista(Comparable[] lista) {
		if(lista != null)
			for(Comparable p: lista)
				System.out.print(p + " ");
		//System.out.println();
	}

	//-----------------------------------------------------------------------------------------
	//Método de Selección Directa (Menor Complejidad que BubbleSort)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void selectionSort(Comparable[] a) {
		for(int i = 0; i < a.length-1; i++) {
			int im = i;
			for(int j = i+1; j < a.length; j++)
				if(a[j].compareTo(a[im]) < 0)
					im = j;
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
	}

	//-----------------------------------------------------------------------------------------
	// Método de Inserción Directa
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertSort(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			Comparable temp = a[i]; //El que voy a insertar
			int j = i;
			while(j > 0 && temp.compareTo(a[j-1]) < 0) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}

	//-----------------------------------------------------------------------------------------
	//QuickSort (Método Recursivo)
	@SuppressWarnings("rawtypes")
	public static void quickSort(Comparable[] a) {
		quickSort(a, 0, a.length-1);
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void quickSort(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio)
			return;
		Comparable pivote = a[fin];
		int i = inicio-1;
		int j = fin;
		Comparable temp;

		boolean intercambioRealizado = true;

		while(i<j && intercambioRealizado) {
			intercambioRealizado = false;

			//Busca un elemento mayor que pivote, si no, para en el pivote (el último)
			while(a[++i].compareTo(pivote) < 0);
			//Se busca un elemento menor que el pivote, si no lo hay, para en el primero
			while(j > inicio && pivote.compareTo(a[--j]) < 0);
			//Se intercambian los elementos
			if(i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				intercambioRealizado = true;
			}
		} //Se sale del ciclo cuando la i >= j. Si se cruzan los índices, en i hay un elemento mayor que el pivote y la posición correcta del pivote es i, por lo que deben intercambiar
		temp = a[i];
		a[i] = a[fin]; //El pivote está en el fin del arreglo
		a[fin] = temp;
		int partition = i;
		quickSort(a, inicio, partition-1);
		quickSort(a, partition+1, fin);
	}

	//-----------------------------------------------
	//Quick Sort con Pivote Aleatorio
	@SuppressWarnings("rawtypes")
	public static void quickSortAl(Comparable[] array) {
		quickSortAl(array, 0, array.length-1);
	}
	@SuppressWarnings("rawtypes")
	public static void quickSortAl(Comparable [] array, int lower, int upper){ //Implementa el Quick Sort, verificando que el arreglo sea suficientemente grande para arreglarse
		if (lower < upper){
			int a = particion(array, lower, upper); //Implementa recursivamente la función de particion, hasta que el arreglo esté ordenado
			quickSortAl(array, lower, a-1);
			quickSortAl(array, a+1, upper);
		}
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int particion(Comparable [] array, int lower, int upper){ //Dividir el arreglo en dos, según el pivote aleatorio seleccionado
		randomPivote(array, lower, upper); //Llamar el método de randomPivote
		Comparable pivote = array[upper]; //Definir un pivote nuevo, según la posición en "upper"

		//Si el elemento comparado es menor al pivote, se pasa a la izquierda. Si es mayor, se pasa a la derecha
		int i = (lower-1);  
		for (int j = lower; j < upper; j++){
			if (array[j].compareTo(pivote) < 0){
				i++;
				Comparable aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		Comparable aux = array[i+1];
		array[i+1] = array[upper];
		array[upper] = aux;
		return i+1; //Retorna el índice del pivote
	}
	@SuppressWarnings("rawtypes")
	public static void randomPivote(Comparable [] array, int lower, int upper){ //Seleccionará un pivote aleatorio entre los índices menor y mayor del arreglo
		Random random = new Random();
		int pivote = random.nextInt(upper-lower) + lower; //Generar un pivote aleatorio entre el valor "lower" y "upper"

		//Intercambiar el valor en el arreglo de "upper" y el pivote
		Comparable aux = array[pivote]; 
		array[pivote] = array[upper];
		array[upper] = aux;
	}

	//-----------------------------------------------------------------------------------------
	//Merge Sort
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] array) {
		return mergeSort(array, 0, array.length-1);
	}
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] array, int inicio, int fin) { //Divide el arreglo en 2 y se llama recursivamente para cada mitad. Luego, junta las dos mitades con el método "merge".
		if (inicio == fin)
			return new Comparable[] {array[inicio]};
		else {
			Comparable[] list1 = mergeSort(array, inicio, (inicio+fin)/2);
			Comparable[] list2 = mergeSort(array, (inicio+fin)/2+1, fin);
			return merge(list1, list2);
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable[] merge(Comparable[] array1, Comparable[] array2) { //Junta las mitades de los arreglos en 1
		if(array1 == null || array2 == null)
			return null;

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

	//-----------------------------------------------------------------------------------------
	//Main
	public static void main(String [] args) {

		//Arreglo de Enteros
		int[] array = {4, 6, 8, 3, 4, 1};
		System.out.println("Array " + array + " antes de organizarse por BubbleSort: " + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("Array " + array + " después de organizarse por BubbleSort: " + Arrays.toString(array));
		System.out.println("-----------------------------------------------------------------------------------------");

		//General
		//Personas
		System.out.println();
		Persona p1 = new Persona("Marcela", 24);
		Persona p2 = new Persona("Oscar", 21);
		Persona p3 = new Persona("Marcela", 20);
		Persona p4 = new Persona("Andrés", 26);
		Persona p5 = new Persona("Oscar", 30);
		Persona p6 = new Persona("Nadia", 21);
		Persona[] listaP = {p1, p2, p3, p4, p5, p6};
		System.out.print("- Lista antes de ordenar: "); printLista(listaP);
		System.out.println("\n");
		Persona[] listaTempP1 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP11 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP2 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP3 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP4 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP5 = Arrays.copyOf(listaP, listaP.length);
		Persona[] listaTempP6 = Arrays.copyOf(listaP, listaP.length);

		//BubbleSort
		System.out.println("- Lista ordenada con BubbleSort, por nombre y por edad: "); bubbleSort(listaTempP1); bubbleSort2(listaTempP11);
		System.out.println("Bubble Sort normal: "); printLista(listaTempP1); System.out.print("\n");
		System.out.println("Bubble Sort mejorado: "); printLista(listaTempP11); System.out.println("\n");

		//Selección Directa (Mejor Complejidad Temporal con Array aleatorio y al revés)
		System.out.println("- Lista ordenada con Selección Directa, por nombre y por edad: "); selectionSort(listaTempP2);
		printLista(listaTempP2); System.out.println("\n");

		//Inserción Directa (Mejor con Array Ordenado)
		System.out.println("- Lista ordenada con Inserción Directa, por nombre y por edad: "); insertSort(listaTempP3);
		printLista(listaTempP3); System.out.println("\n");

		//QuickSort (Recursivo)
		System.out.println("- Lista ordenada con QuickSort, por nombre y por edad: "); quickSort(listaTempP4);
		printLista(listaTempP4); System.out.println("\n");

		//QuickSort con pivote aleatorio
		System.out.println("- Lista ordenada por QuickSort con pivote aleatorio: "); quickSortAl(listaTempP5);
		printLista(listaTempP5); System.out.println("\n");

		//MergeSort
		try {
			System.out.println("- Lista ordenada con MergeSort, por nombre y por edad: "); mergeSort(listaTempP6);
			printLista(listaTempP6); System.out.println("\n");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}


		System.out.println("-----------------------------------------------------------------------------------------");

		//Probar Complejidad Temporal
		System.out.println("Complejidad Temporal (ms): ");

		int N = 50000;
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for(int i = 0; i < N; i++)
			lista[i] = r.nextInt(2*N); System.out.println("Con la lista aleatoria: \n");//Aleatorio
			//lista[i] = N-i; System.out.println("Con la lista al revés: \n");//Al revés
			//lista[i] = i; System.out.println("Con la lista en orden: \n");//En orden
			
			Integer[] listaTemp = Arrays.copyOf(lista, lista.length);
			long timeInicio;
			long timeFin;

			timeInicio = System.currentTimeMillis();
			bubbleSort(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("BubbleSort normal: " + (timeFin-timeInicio) + "\n");

			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			bubbleSort2(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("BubbleSort mejorado: " + (timeFin-timeInicio) + "\n");

			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			selectionSort(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("SelecSort: " + (timeFin-timeInicio) + "\n");

			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			insertSort(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("InsertSort: " + (timeFin-timeInicio) + "\n");

			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			quickSort(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("QuickSort: " + (timeFin-timeInicio) + "\n");
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			quickSortAl(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("QuickSort con Pivote Aleatorio: " + (timeFin-timeInicio) + "\n");
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeInicio = System.currentTimeMillis();
			//mergeSort(listaTemp);
			timeFin = System.currentTimeMillis();
			System.out.println("MergeSort: " + (timeFin-timeInicio) + "\n");
	}
}
