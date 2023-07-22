package AVL_ArbolBinarioBalanceado;

import AB_ArbolBinario.*;

import java.util.ArrayList;

import ABB_ArbolBinarioBusqueda.*;

public class CombineTrees <E extends Comparable<E>> extends ArbolBinarioBalanceado<E>{
	public CombineTrees(NodoBinario<E> raiz) {
		super(raiz);
	}

	//-------------------------------------------------------------------------------------------------------
	//Combinar 2 AVL en un ArrayList
	public ArrayList<E> combinarArbol(ArbolBinarioBalanceado<E> arbol1, ArbolBinarioBalanceado<E> arbol2){
		ArrayList<E> ans = new ArrayList<E>();

		ArrayList<E> inOr1 = arbol1.inordenArr();
		ArrayList<E> inOr2 = arbol2.inordenArr();

		int i = 0;
		int j = 0;
		
		while(i < inOr1.size() && j < inOr2.size()) {
			if(inOr1.get(i).compareTo(inOr2.get(j)) < 0 )
				ans.add(inOr1.remove(i++));
			else if(inOr1.get(i).compareTo(inOr2.get(j)) > 0)
				ans.add(inOr2.remove(j++));
			else {
				ans.add(inOr1.remove(i++)); 
				inOr2.remove(j++);
			}
				
		}
		
		int n = 0;
		if(i >= inOr1.size())
			while(n < inOr2.size()) {
				if(!ans.contains(inOr2.get(n)))
					ans.add(inOr2.get(n));
				n++;
			}
		else
			while(n < inOr1.size()) {
				if(!ans.contains(inOr1.get(n)))
					ans.add(inOr1.get(n++));
				n++;
			}
		return ans;
	}

	//-------------------------------------------------------------------------------------------------------
	//Main
	public static void main(String[] args) {
		//Arbol 1
		NodoBinario<Integer> a1n1 = new NodoBinario<Integer>(1);
		NodoBinario<Integer> a1n2 = new NodoBinario<Integer>(2);
		NodoBinario<Integer> a1n3 = new NodoBinario<Integer>(3);
		NodoBinario<Integer> a1n4 = new NodoBinario<Integer>(4);
		NodoBinario<Integer> a1n5 = new NodoBinario<Integer>(5);
		NodoBinario<Integer> a1n6 = new NodoBinario<Integer>(6);
		NodoBinario<Integer> a1n7 = new NodoBinario<Integer>(7);
		NodoBinario<Integer> a1n8 = new NodoBinario<Integer>(8);

		ArbolBinarioBalanceado<Integer> arbol1 = new ArbolBinarioBalanceado<Integer>(a1n4);

		try {
			arbol1.insertNodo(a1n2);
			arbol1.insertNodo(a1n6);
			arbol1.insertNodo(a1n1);
			arbol1.insertNodo(a1n3);
			arbol1.insertNodo(a1n5);
			arbol1.insertNodo(a1n7);
			arbol1.insertNodo(a1n8);
		}catch(ExceptionNodo e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Arbol 1 (Preorden): " + arbol1.preordenArr());
		System.out.println("Arbol 1 (Inorden): " + arbol1.inordenArr());
		System.out.println("Arbol 1 (Posorden): " + arbol1.posordenArr());
		System.out.print("\n");

		//Arbol 2
		//NodoBinario<Integer> a2n1 = new NodoBinario<Integer>(1);
		NodoBinario<Integer> a2n2 = new NodoBinario<Integer>(2);
		NodoBinario<Integer> a2n3 = new NodoBinario<Integer>(3);
		NodoBinario<Integer> a2n4 = new NodoBinario<Integer>(4);
		NodoBinario<Integer> a2n5 = new NodoBinario<Integer>(5);
		NodoBinario<Integer> a2n6 = new NodoBinario<Integer>(6);
		NodoBinario<Integer> a2n7 = new NodoBinario<Integer>(7);
		NodoBinario<Integer> a2n8 = new NodoBinario<Integer>(8);
		NodoBinario<Integer> a2n9 = new NodoBinario<Integer>(9);
		NodoBinario<Integer> a2n10 = new NodoBinario<Integer>(10);
		NodoBinario<Integer> a2n11 = new NodoBinario<Integer>(11);
		NodoBinario<Integer> a2n12 = new NodoBinario<Integer>(12);

		ArbolBinarioBalanceado<Integer> arbol2 = new ArbolBinarioBalanceado<Integer>(a2n7);

		try {
			arbol2.insertNodo(a2n4);
			arbol2.insertNodo(a2n11);
			arbol2.insertNodo(a2n2);
			arbol2.insertNodo(a2n5);
			arbol2.insertNodo(a2n9);
			arbol2.insertNodo(a2n12);
			arbol2.insertNodo(a2n8);
			arbol2.insertNodo(a2n10);
			arbol2.insertNodo(a2n3);
			arbol2.insertNodo(a2n6);
		}catch(ExceptionNodo e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Arbol 2 (Preorden): " + arbol2.preordenArr());
		System.out.println("Arbol 2 (Inorden): " + arbol2.inordenArr());
		System.out.println("Arbol 2 (Posorden): " + arbol2.posordenArr());
		System.out.print("\n");

		//Juntarlos
		CombineTrees<Integer> combineTrees = new CombineTrees<Integer>(null);
		System.out.println("Arboles juntos en orden: " + combineTrees.combinarArbol(arbol1, arbol2));
		System.out.print("\n");
		
		//Recorrer el arbol 1 por niveles
		System.out.println("Arbol 1 por niveles: " + arbol1.recorridoNivelArr());
		System.out.print("\n");
	}

}
