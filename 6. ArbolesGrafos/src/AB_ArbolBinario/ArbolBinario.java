package AB_ArbolBinario;

import java.util.*;

public class ArbolBinario <E extends Comparable<E>>{

	protected NodoBinario<E> raiz;

	public NodoBinario<E> getRaiz(){
		return raiz;
	}
	public void setRaiz(NodoBinario<E> raiz) {
		this.raiz = raiz;
	}

	public ArbolBinario(NodoBinario<E> raiz) {
		super();
		this.raiz = raiz;
	}

	//Preorden
	public void preorden() {
		preorden(raiz);
		System.out.println();
	}
	public void preorden(NodoBinario<E> raiz) {
		if(raiz != null) {
			System.out.print(raiz.getLlave() + " ");
			preorden(raiz.getHijoIzq());
			preorden(raiz.getHijoDer());
		}
	}

	//Preorden con array
	public ArrayList<E> preordenArr() {
		return preordenArr(raiz);
	}
	public ArrayList<E> preordenArr(NodoBinario<E> nodo) {
		ArrayList<E> arreglo = new ArrayList<E>();
		if(nodo != null) {
			arreglo.add(nodo.getLlave());
			arreglo.addAll(preordenArr(nodo.getHijoIzq()));
			arreglo.addAll(preordenArr(nodo.getHijoDer()));
		}
		return arreglo;
	}

	//Inorden
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	public void inorden(NodoBinario<E> raiz) {
		if(raiz != null) {
			inorden(raiz.getHijoIzq());
			System.out.print(raiz.getLlave() + " ");
			inorden(raiz.getHijoDer());
		}
	}

	//Inorden con array
	public ArrayList<E> inordenArr(){
		return inordenArr(raiz);
	}
	public ArrayList<E> inordenArr(NodoBinario<E> nodo){
		ArrayList<E> arreglo = new ArrayList<E>();
		if(nodo != null) {
			arreglo.addAll(inordenArr(nodo.getHijoIzq()));
			arreglo.add(nodo.getLlave());
			arreglo.addAll(inordenArr(nodo.getHijoDer()));
		}
		return arreglo;
	}

	//Posorden
	public void posorden() {
		posorden(raiz);
		System.out.println();
	}
	public void posorden(NodoBinario<E> raiz) {
		if(raiz != null) {
			posorden(raiz.getHijoIzq());
			posorden(raiz.getHijoDer());
			System.out.print(raiz.getLlave() + " ");
		}
	}

	//Posorden con array
	public ArrayList<E> posordenArr(){
		return posordenArr(raiz);
	}
	public ArrayList<E> posordenArr(NodoBinario<E> nodo){
		ArrayList<E> arreglo = new ArrayList<E>();
		if(nodo != null) {
			arreglo.addAll(posordenArr(nodo.getHijoIzq()));
			arreglo.addAll(posordenArr(nodo.getHijoDer()));
			arreglo.add(nodo.getLlave());
		}
		return arreglo;
	}

	//Cantidad Hojas
	public int cantHojas() {
		return cantHojas(raiz);
	}
	public int cantHojas(NodoBinario<E> nodo) {
		int hojas = 0;
		if(nodo.getHijoIzq() == null && nodo.getHijoDer() == null)
			hojas++;
		else {
			hojas += (nodo.getHijoIzq()==null? 0: cantHojas(nodo.getHijoIzq()));
			hojas += (nodo.getHijoDer() == null? 0: cantHojas(nodo.getHijoDer()));
		}
		return hojas;
	}

	//Recorrer el arbol por niveles
	public ArrayList<E> recorridoNivelArr() {
		ArrayList<E> ans = new ArrayList<E>();

		if (raiz == null)
			return ans;

		Queue<NodoBinario<E>> cola = new LinkedList<NodoBinario<E>>();
		cola.add(raiz);

		while (!cola.isEmpty()) {
			NodoBinario<E> nodoActual = cola.poll();
			ans.add(nodoActual.getLlave());
			
			if (nodoActual.getHijoIzq() != null) {
				cola.add(nodoActual.getHijoIzq());
			}
			if (nodoActual.getHijoDer() != null) {
				cola.add(nodoActual.getHijoDer());
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		NodoBinario<Integer> n1 = new NodoBinario<Integer>(10);
		NodoBinario<Integer> n2 = new NodoBinario<Integer>(7);
		NodoBinario<Integer> n3 = new NodoBinario<Integer>(15);
		NodoBinario<Integer> n4 = new NodoBinario<Integer>(5);
		NodoBinario<Integer> n5 = new NodoBinario<Integer>(9);
		NodoBinario<Integer> n6 = new NodoBinario<Integer>(12);

		n3.setHijoIzq(n6);
		n2.setHijoIzq(n4);
		n2.setHijoDer(n5);
		n1.setHijoIzq(n2);
		n1.setHijoDer(n3);

		ArbolBinario<Integer> a = new ArbolBinario<Integer>(n1);

		System.out.println("Preorden: ");
		a.preorden();
		System.out.println("Inorden: ");
		a.inorden();
		System.out.println("Posorden: ");
		a.posorden();

		//Altura
		System.out.println();
		NodoBinario<Integer> nodo = n1;
		System.out.println("La altura del nodo " + nodo.getLlave() + " es: " + nodo.altura());
		System.out.println("La altura del nodo " + nodo.getLlave() + " es (método Isis): " + nodo.altura());

		//Cantidad de hojas
		System.out.println();
		System.out.println("La cantidad de hojas del arbol " + a + " es: " + a.cantHojas() + "\n");

		//Preorden
		System.out.println("Preorden con arreglo: ");
		System.out.println(a.preordenArr());

		//Inorden
		System.out.println("Inorden con arreglo: ");
		System.out.println(a.inordenArr());

		//Posorden
		System.out.println("Posorden con arreglo: ");
		System.out.println(a.posordenArr());
	}

}
