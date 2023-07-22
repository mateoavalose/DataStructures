package ABB_ArbolBinarioBusqueda;

import AB_ArbolBinario.*;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends ArbolBinario<E> {

	public ArbolBinarioBusqueda(NodoBinario<E> raiz) {
		super(raiz);
	}

	//-------------------------------------------------------------------------------------------------------
	//Buscar 
	public NodoBinario<E> buscar(E llave) throws ExceptionNodo{
		return buscar(llave, raiz);
	}
	public NodoBinario<E> buscar(E llave, NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo == null)
			throw new ExceptionNodo("El nodo no existe");
		if(llave.compareTo(nodo.getLlave()) < 0)
			return buscar(llave, nodo.getHijoIzq());
		if(llave.compareTo(nodo.getLlave()) > 0)
			return buscar(llave, nodo.getHijoDer());
		return nodo;
	}

	//-------------------------------------------------------------------------------------------------------
	//Insertar
	public void intertNodo(E llave) throws ExceptionNodo{
		raiz = insertNodo(new NodoBinario<E>(llave), raiz);
	}
	public void insertNodo(NodoBinario<E> nodo) throws ExceptionNodo{
		raiz = insertNodo(nodo, raiz);
	}
	public NodoBinario<E> insertNodo(NodoBinario<E> nodo, NodoBinario<E> raiz) throws ExceptionNodo{
		if(raiz == null) {
			raiz = nodo;
		} else {
			if(nodo.getLlave().compareTo(raiz.getLlave()) < 0)
				raiz.setHijoIzq(insertNodo(nodo, raiz.getHijoIzq()));
			if(nodo.getLlave().compareTo(raiz.getLlave()) > 0)
				raiz.setHijoDer(insertNodo(nodo, raiz.getHijoDer()));
			if(nodo.getLlave().compareTo(raiz.getLlave()) == 0)
				throw new ExceptionNodo("Nodo con la llave " + nodo.getLlave() + " ya existe");
		}
		return raiz;
	}

	//-------------------------------------------------------------------------------------------------------
	//Eliminar
	public void deleteNodo(E llave) throws ExceptionNodo{
		//Buscar llave en raiz
		raiz = deleteNodo(llave, raiz);
	}
	public NodoBinario<E> deleteNodo(E llave, NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo == null)
			throw new ExceptionNodo("El nodo no se encuentra");
		else {
			if(llave.compareTo(nodo.getLlave()) < 0)
				//nodo.setHijoIzq o Der ?????????????????????????????????????????????????????????????????????
				nodo.setHijoIzq(deleteNodo(llave, nodo.getHijoIzq()));
			else
				if(llave.compareTo(nodo.getLlave()) > 0)
					nodo.setHijoDer(deleteNodo(llave, nodo.getHijoDer()));
				else {
					//Caso 3, es una hoja
					if(nodo.getHijoDer() != null && nodo.getHijoIzq() != null) {
						NodoBinario<E> antecesor = buscarAntecesor(nodo);
						nodo.setLlave(antecesor.getLlave());
						nodo.setHijoIzq(deleteNodo(antecesor.getLlave(), nodo.getHijoIzq()));
					} else
						//Caso 2 o Caso 1
						if(nodo.getHijoDer() != null)
							nodo = nodo.getHijoDer();
						else
							nodo = nodo.getHijoIzq();
				}
		}
		return nodo;
	}
	
	public NodoBinario<E> buscarAntecesor(NodoBinario<E> nodo) throws ExceptionNodo{
		return (nodo.getHijoIzq() == null)? null: buscarMax(nodo.getHijoIzq());
	}
	public NodoBinario<E> buscarMax(NodoBinario<E> nodo) throws ExceptionNodo{
		return (nodo.getHijoDer() == null)? nodo: buscarMax(nodo.getHijoDer());
	}
	public NodoBinario<E> buscarSucesor(NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo.getHijoDer() == null)
			throw new ExceptionNodo("Error en alrgoritmo, el nodo no tiene predecesor");
		return buscarMin(nodo.getHijoDer());
	}
	public NodoBinario<E> buscarMin(NodoBinario<E> nodo) throws ExceptionNodo{
		return (nodo.getHijoIzq() == null)? nodo: buscarMin(nodo.getHijoDer());
	}
	
	//-------------------------------------------------------------------------------------------------------
	//Main
	public static void main(String[] args) {
		NodoBinario<Integer> an1 = new NodoBinario<Integer>(1);
		NodoBinario<Integer> an4 = new NodoBinario<Integer>(4);
		NodoBinario<Integer> an5 = new NodoBinario<Integer>(5);
		NodoBinario<Integer> an6 = new NodoBinario<Integer>(6);
		NodoBinario<Integer> an7 = new NodoBinario<Integer>(7);
		NodoBinario<Integer> an8 = new NodoBinario<Integer>(8);

		an6.setHijoIzq(an4);
		an4.setHijoIzq(an1);
		an4.setHijoDer(an5);
		an6.setHijoDer(an8);
		an8.setHijoIzq(an7);

		ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<Integer>(an6);
		System.out.println("Arbol a: " + a.inordenArr());
		System.out.println("-------------------------------------------------------------------------------------------------------");

		//-------------------------------------------------------------------------------------------------------
		//Busqueda
		try {
			NodoBinario<Integer> nodo = an8;
			System.out.println("\nLa busqueda del nodo " + nodo.getLlave() + " encontró el nodo: " + a.buscar(nodo.getLlave()).getLlave());
			System.out.println("-------------------------------------------------------------------------------------------------------");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("-------------------------------------------------------------------------------------------------------");
		}

		//-------------------------------------------------------------------------------------------------------
		//Inserción
		try {
			NodoBinario<Integer> bn1 = new NodoBinario<Integer>(1);
			NodoBinario<Integer> bn2 = new NodoBinario<Integer>(2);
			NodoBinario<Integer> bn3 = new NodoBinario<Integer>(3);
			NodoBinario<Integer> bn4 = new NodoBinario<Integer>(4);
			NodoBinario<Integer> bn5 = new NodoBinario<Integer>(5);
			NodoBinario<Integer> bn6 = new NodoBinario<Integer>(6);
			NodoBinario<Integer> bn7 = new NodoBinario<Integer>(7);
			NodoBinario<Integer> bn8 = new NodoBinario<Integer>(8);
			NodoBinario<Integer> bn9 = new NodoBinario<Integer>(9);
			NodoBinario<Integer> bn10 = new NodoBinario<Integer>(10);
			NodoBinario<Integer> bn15 = new NodoBinario<Integer>(15);
			NodoBinario<Integer> bn16 = new NodoBinario<Integer>(16);
			ArbolBinarioBusqueda<Integer> b = new ArbolBinarioBusqueda<Integer>(bn5);

			b.insertNodo(bn2);
			b.insertNodo(bn3);
			b.insertNodo(bn1);
			b.insertNodo(bn9);
			b.insertNodo(bn7);
			b.insertNodo(bn8);
			b.insertNodo(bn6);
			b.insertNodo(bn4);
			b.insertNodo(bn10);
			b.insertNodo(bn15);
			b.insertNodo(bn16);

			System.out.println("\nInorden arbol b: " + b.inordenArr());
			System.out.println("Preorden arbol b: " + b.preordenArr());
			System.out.println("Posorden arbol b: " + b.posordenArr());
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.print("\n");

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//-------------------------------------------------------------------------------------------------------
		//Eliminar
		NodoBinario<Integer> elimN60 = new NodoBinario<Integer>(60);
		NodoBinario<Integer> elimN41 = new NodoBinario<Integer>(41);
		NodoBinario<Integer> elimN16 = new NodoBinario<Integer>(16);
		NodoBinario<Integer> elimN25 = new NodoBinario<Integer>(25);
		NodoBinario<Integer> elimN53 = new NodoBinario<Integer>(53);
		NodoBinario<Integer> elimN46 = new NodoBinario<Integer>(46);
		NodoBinario<Integer> elimN42 = new NodoBinario<Integer>(42);
		NodoBinario<Integer> elimN55 = new NodoBinario<Integer>(55);
		NodoBinario<Integer> elimN74 = new NodoBinario<Integer>(74);
		NodoBinario<Integer> elimN65 = new NodoBinario<Integer>(65);
		NodoBinario<Integer> elimN63 = new NodoBinario<Integer>(63);
		NodoBinario<Integer> elimN62 = new NodoBinario<Integer>(62);
		NodoBinario<Integer> elimN64 = new NodoBinario<Integer>(64);
		NodoBinario<Integer> elimN70 = new NodoBinario<Integer>(70);
		
		elimN60.setHijoIzq(elimN41); elimN41.setHijoIzq(elimN16); elimN16.setHijoDer(elimN25); elimN41.setHijoDer(elimN53); elimN53.setHijoIzq(elimN46); elimN46.setHijoIzq(elimN42); elimN53.setHijoDer(elimN55);
		elimN60.setHijoDer(elimN74); elimN74.setHijoIzq(elimN65); elimN65.setHijoIzq(elimN63); elimN63.setHijoIzq(elimN62); elimN63.setHijoDer(elimN64); elimN65.setHijoDer(elimN70);
		
		ArbolBinarioBusqueda<Integer> elim = new ArbolBinarioBusqueda<Integer>(elimN60);
		
		System.out.println("Inorden arbol elim: " + elim.inordenArr());
		System.out.println("Preorden arbol elim: " + elim.preordenArr());
		System.out.println("Posorden arbol elim: " + elim.posordenArr());
		System.out.print("\n"); 
		
		//elim.eliminarNodo(nodoElim);
		try {
			NodoBinario<Integer> nodoElim = elimN53;
			System.out.println("Después de eliminar el nodo " + nodoElim.getLlave());
			
			elim.deleteNodo(nodoElim.getLlave());
			
			System.out.println("Inorden arbol elim: " + elim.inordenArr());
			System.out.println("Preorden arbol elim: " + elim.preordenArr());
			System.out.println("Posorden arbol elim: " + elim.posordenArr());
		} catch(ExceptionNodo e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}

}
