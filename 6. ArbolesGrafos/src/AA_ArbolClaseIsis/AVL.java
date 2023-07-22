package AA_ArbolClaseIsis;

public class AVL<E extends Comparable<E>> extends ABB<E> {

	public AVL(NodoB<E> raiz) {
		super(raiz);
	}


	
	@Override
	public void insertNodo(NodoB<E> n) throws ExceptionNodo {
		super.insertNodo(n);
		balancear(n);
	}
	
	private void balancear(NodoB<E> n) {
		NodoB<E> desb = desbalance(n);
		if (desb!=null){
			NodoB<E> p= desb.getPadre();
			
			if (desb.FE()>0){
				if (desb.getHijoDer().FE()>=0) //Caso SimpleIzq FE + e Hijo Derecha +
					desb=balanceSimpleIzq(desb);
				else							//Caso DobleIzq FE + e Hijo Derecha -
					desb=balanceDobleIzq(desb);
			}	
			else 
				if (desb.FE()<0){
					if (desb.getHijoIzq().FE()<=0)//Caso SimpleDer FE - e Hijo Izquierda -
						desb=balanceSimpleDer(desb);
					else							//Caso DobleDer FE - e Hijo Izquierda +
						desb=balanceDobleDer(desb);
				}			
			if (p==null)
				 raiz=desb;
			else
				if(desb.getLlave().compareTo(p.getLlave())>0)
					p.setHijoDer(desb);
				else
					p.setHijoIzq(desb);
		}		
	}
	
	

	public NodoB<E> desbalance(NodoB<E> n){
		NodoB<E> nodo=n;
		while(nodo!=null && Math.abs(nodo.FE())<=1){
			nodo= nodo.getPadre();
		}
		return nodo;
	}
	
	
	public NodoB<E> balanceSimpleIzq(NodoB<E> n){
		NodoB<E> der=n.getHijoDer();
		der.setPadre(n.getPadre());
		n.setHijoDer(der.getHijoIzq());
		der.setHijoIzq(n);
		return der;
	}	
		
	public NodoB<E> balanceSimpleDer(NodoB<E> n){
		NodoB<E> izq=n.getHijoIzq();// Tomar hijo de la izquierda del desbalanceado
		izq.setPadre(n.getPadre()); // Padre de este pasa a ser el padre del anterior
		n.setHijoIzq(izq.getHijoDer());
		izq.setHijoDer(n);
		return izq;
	}	
	
		
	
	public NodoB<E> balanceDobleDer(NodoB<E> n){
		n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq())); 
		return balanceSimpleDer(n);
	}
	
	
	public NodoB<E> balanceDobleIzq(NodoB<E> n){
		n.setHijoDer(balanceSimpleDer(n.getHijoDer())); 
		return balanceSimpleIzq(n);
	}

	@Override
	public void deleteNodo(E llave) throws ExceptionNodo {
		// TODO Auto-generated method stub
		NodoB<E> n=buscar(llave);
		NodoB<E> padre;
		if (n.getHijoDer()!=null && n.getHijoIzq()!=null)
			padre=buscarAntecesor(n).getPadre();
		else
			padre=n.getPadre();
		super.deleteNodo(llave);
		if (padre==null)
			balancear(raiz);
		else
			while (padre!=null){
				balancear(padre);
				padre=padre.getPadre();
			}		
	}
	
		
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodoB<Integer> n1 = new NodoB<Integer>(1);
		NodoB<Integer> n2 = new NodoB<Integer>(2);
		NodoB<Integer> n3 = new NodoB<Integer>(3);
		NodoB<Integer> n4 = new NodoB<Integer>(4);
		NodoB<Integer> n5 = new NodoB<Integer>(5);
		NodoB<Integer> n6 = new NodoB<Integer>(6);
		NodoB<Integer> n7 = new NodoB<Integer>(7);
		NodoB<Integer> n8 = new NodoB<Integer>(8);
		NodoB<Integer> n9 = new NodoB<Integer>(9);
		NodoB<Integer> n10 = new NodoB<Integer>(10);
		//NodoB<Integer> n11 = new NodoB<Integer>(11);
		NodoB<Integer> n12 = new NodoB<Integer>(12);
		NodoB<Integer> n13 = new NodoB<Integer>(13);
		AVL<Integer> a= new AVL<Integer>(n8);
		
		try {
			a.insertNodo(n3);
			a.insertNodo(n1);
			
			a.insertNodo(n12);
			a.insertNodo(n2);
			a.insertNodo(n9);
			
			a.insertNodo(n6);
			a.insertNodo(n13);
			a.insertNodo(n10);
			a.insertNodo(n5);
			a.insertNodo(n7);
			a.insertNodo(n4);
		} catch (ExceptionNodo e) {
			System.out.println(e.getMessage());
		}

		a.preorden(); System.out.println();
		a.inorden(); System.out.println();
		a.postorden();System.out.println();

		System.out.println(a.altura());
		System.out.println(a.getRaiz().FE());
	}

}
