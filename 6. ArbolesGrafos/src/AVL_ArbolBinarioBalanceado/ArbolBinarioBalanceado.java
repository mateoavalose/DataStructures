package AVL_ArbolBinarioBalanceado;

import ABB_ArbolBinarioBusqueda.*;
import AB_ArbolBinario.*;

public class ArbolBinarioBalanceado <E extends Comparable<E>> extends ArbolBinarioBusqueda<E>{

	public ArbolBinarioBalanceado(NodoBinario<E> raiz) {
		super(raiz);
	}

	@Override
	public void insertNodo(NodoBinario<E> nodo) throws ExceptionNodo{
		super.insertNodo(nodo);
		balancear(nodo);
	}

	//Balancear Arbol
	public void balancear(NodoBinario<E> nodo) {
		NodoBinario<E> desb = desbalance(nodo);
		if(desb != null) {
			NodoBinario<E> padre = desb.getPadre();
			if(desb.factorEquilibrio() > 0) {
				if(desb.getHijoDer().factorEquilibrio() >= 0)
					//Caso SimpleIzq FE + e Hijo Derecha +
					desb = balanceSimpleIzq(desb);
				else
					//Caso Doble Izq FE + e Hijo Derecha -
					desb = balanceDobleIzq(desb);
			}	
			else
				if(desb.factorEquilibrio() < 0) {
					if(desb.getHijoIzq().factorEquilibrio() <= 0) 
						//Caso SimpleDer FE - e Hijo Izquierda -
						desb = balanceSimpleDer(desb);
					else
						//Caso DobleDer Fe - e Hijo izquierda +
						desb = balanceDobleDer(desb);
				}
			if(padre == null)
				raiz = desb;
			else
				if(desb.getLlave().compareTo(padre.getLlave()) > 0)
					padre.setHijoDer(desb);
				else
					padre.setHijoIzq(desb);
		}
	}
	//Encontrar Desbalance
	public NodoBinario<E> desbalance(NodoBinario<E> nodo){
		NodoBinario<E> n = nodo;
		/*if(n != null && Math.abs(n.factorEquilibrio()) <= 1)
			n = desbalance(n.getPadre());*/
		while(n != null && Math.abs(n.factorEquilibrio()) <= 1)
			n = n.getPadre();
		return n;
	}
	//Balance Rotación Simple Izquierda
	public NodoBinario<E> balanceSimpleIzq(NodoBinario<E> nodo){
		NodoBinario<E> der = nodo.getHijoDer();
		der.setPadre(nodo.getPadre());
		nodo.setHijoDer(der.getHijoIzq());
		der.setHijoIzq(nodo);
		return der;
	}
	//Rotación Doble Izquierda
	public NodoBinario<E> balanceDobleIzq(NodoBinario<E> nodo){
		nodo.setHijoDer(balanceSimpleDer(nodo.getHijoDer()));
		return balanceSimpleIzq(nodo);
	}
	//Rotación Simple Derecha
	public NodoBinario<E> balanceSimpleDer(NodoBinario<E> nodo){
		NodoBinario<E> izq = nodo.getHijoIzq();
		izq.setPadre(nodo.getPadre());
		nodo.setHijoIzq(izq.getHijoDer());
		izq.setHijoDer(nodo);
		return izq;
	}
	//Rotación Doble Derecha
	public NodoBinario<E> balanceDobleDer(NodoBinario<E> nodo){
		nodo.setHijoIzq(balanceSimpleIzq(nodo.getHijoIzq()));
		return balanceSimpleDer(nodo);
	}
	
	//Borrar Nodo
	@Override
	public void deleteNodo(E llave) throws ExceptionNodo{
		NodoBinario<E> nodo = buscar(llave);
		NodoBinario<E> padre;
		if(nodo.getHijoDer() != null && nodo.getHijoIzq() != null)
			padre = buscarAntecesor(nodo).getPadre();
		else
			padre = nodo.getPadre();
		super.deleteNodo(llave);
		if(padre == null)
			balancear(raiz);
		else
			while(padre != null) {
				balancear(padre);
				padre = padre.getPadre();
			}
	}

	//Main
	public static void main(String[] args) {
		NodoBinario<Integer> n1 = new NodoBinario<Integer>(1);
		NodoBinario<Integer> n2 = new NodoBinario<Integer>(2);
		NodoBinario<Integer> n3 = new NodoBinario<Integer>(3);
		NodoBinario<Integer> n4 = new NodoBinario<Integer>(4);
		NodoBinario<Integer> n5 = new NodoBinario<Integer>(5);
		NodoBinario<Integer> n6 = new NodoBinario<Integer>(6);
		NodoBinario<Integer> n7 = new NodoBinario<Integer>(7);
		NodoBinario<Integer> n8 = new NodoBinario<Integer>(8);
		NodoBinario<Integer> n9 = new NodoBinario<Integer>(9);
		NodoBinario<Integer> n10 = new NodoBinario<Integer>(10);
		//NodoBinario<Integer> n11 = new NodoBinario<Integer>(11);
		NodoBinario<Integer> n12 = new NodoBinario<Integer>(12);
		NodoBinario<Integer> n13 = new NodoBinario<Integer>(13);

		ArbolBinarioBalanceado<Integer> a = new ArbolBinarioBalanceado<Integer>(n8);

		try {
			a.insertNodo(n3);
			a.insertNodo(n1);
			
			//System.out.println("Preorden: " + a.preordenArr());
			//System.out.println("Inorden: " + a.inordenArr());
			
			a.insertNodo(n12);
			a.insertNodo(n2);
			a.insertNodo(n9);
			
			//System.out.println("Preorden: " + a.preordenArr());
			//System.out.println("Inorden: " + a.inordenArr());
			
			a.insertNodo(n6);
			a.insertNodo(n13);
			a.insertNodo(n10);
			a.insertNodo(n5);
			a.insertNodo(n7);
			a.insertNodo(n4);
			
		} catch(ExceptionNodo e) {
			System.out.println(e.getMessage());
		}
		
		System.out.print("\n");
		System.out.println("Preorden: " + a.preordenArr());//6 3 1 2 5 4 9 8 7 12 10 13
		System.out.println("Inorden: " + a.inordenArr()); // 1 2 3 4 5 6 7 8 9 10 12 13
		System.out.println("Posorden: " + a.posordenArr()); //2 1 4 5 3 7 8 10 13 12 9 6

	}
}
