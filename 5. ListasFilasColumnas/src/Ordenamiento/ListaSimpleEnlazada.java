package Ordenamiento;

class NodoL<E>{
	private E Info;
	private NodoL<E> next;

	public E getInfo() {
		return Info;
	}
	public void setInfo(E Info) {
		this.Info = Info;
	}
	public NodoL<E> getNext(){
		return next;
	}
	public void setNext(NodoL<E> next) {
		this.next = next;
	}
	public NodoL(E Info) {
		super();
		this.Info = Info;
		next = null;
	}
	@Override
	public String toString(){
		return Info.toString();
	}
}
public class ListaSimpleEnlazada<E extends Comparable<E>>{
	private NodoL<E> head;

	public NodoL<E> getHead(){
		return head;
	}
	public void setHead(NodoL<E> head) {
		this.head = head;
	}
	public ListaSimpleEnlazada(NodoL<E> head) {
		super();
		this.head = head;
	}
	public ListaSimpleEnlazada() {
		this.head = null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public int length() {
		int l = 0;
		NodoL<E> temp = head;
		while(temp != null) {
			temp = temp.getNext();
			l++;
		}
		return l;
	}
	public void addFirst(E x) {
		NodoL<E> newNodo = null;
		if(head != null) {
			newNodo = new NodoL<E>(head.getInfo());
			newNodo.setNext(head.getNext());
		} else {
			head = new NodoL<E>(x);
		}
		head.setInfo(x);
		head.setNext(newNodo);
	}
	public void printList() {
		NodoL<E> actual = head;
		while(actual != null) {
			System.out.print(actual.getInfo()+ " ");
			actual = actual.getNext();
		}
		System.out.println();
	}
	public int getIndex(E x) {
		NodoL<E> actual = head;
		int ind = -1;
		while(actual != null) {
			ind++;
			if(actual.getInfo().compareTo(x) == 0)
				break;
			actual = actual.getNext();
		}
		return (actual != null)? ind: -1;
	}
	public int getIndexIsis(E x) {
		int i = 0;
		NodoL<E> tmp = head;
		while(tmp != null && ((Comparable<E>) tmp.getInfo()).compareTo(x) != 0) {
			tmp = tmp.getNext();
			i++;
		}
		return ((tmp != null)? i: -1);	
	}
	public NodoL<E> getNodo(int i){
		NodoL<E> actual = head;
		int j = 0;
		while(actual != null && j<i) {
			actual = actual.getNext();
			j++;
		}
		return ((actual!=null)? actual: null);
	}
	
	public void insertNodo(E x, int pos) throws Exception{
		if(pos == 0)
			addFirst(x);
		else {
			NodoL<E> actual = head;
			NodoL<E> newNodo = new NodoL<E>(x);
			int j = 1;
			
			while(actual != null && j<pos) {
				actual = actual.getNext();
				j++;
			}
			if(actual != null) {
				newNodo.setNext(actual.getNext());
				actual.setNext(newNodo);
			} else
				throw new Exception("Posición no válida");
		}
	}

	//Main
	public static void main(String[] args) {

		ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<Integer>();
		lista.addFirst(5);
		lista.addFirst(1);
		lista.addFirst(2);
		lista.addFirst(3);
		lista.addFirst(4);
		
		System.out.print("La lista es: "); lista.printList();
		System.out.print("\n");
		
		//Buscar información
		int info = 1;
		System.out.println("La posición del nodo con posición " + info + " es: " + lista.getIndex(info));
		System.out.print("\n");
		
		//Buscar el nodo
		int pos2 = 4;
		System.out.println("Información del nodo en la posición " + pos2 + ": " + lista.getNodo(pos2));
		System.out.print("\n");
		
		//Insertar
		int num = 8;
		int pos3 = 4;
		System.out.println("Insertar el " + num + " en la posición " + pos3); 
		try{
			lista.insertNodo(num, pos3);
			System.out.print("Lista después de insertar el número"); lista.printList();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
