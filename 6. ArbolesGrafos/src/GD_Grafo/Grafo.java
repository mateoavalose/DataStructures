package GD_Grafo;

import java.util.*;

class ExceptionVertice extends Exception{
	private static final long serialVersionUID = 1L;
	public ExceptionVertice() {
		super("Error en Vértice");
	}
	public ExceptionVertice(String s) {
		super(s);
	}
}

public class Grafo <E extends Comparable<E>>{
	private LinkedList<Vertice<E>> vertices;
	
	public Grafo(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
	public Grafo() {
		this.vertices = new LinkedList<Vertice<E>>();
	}
	public LinkedList<Vertice<E>> getVertices() {
		return vertices;
	}
	public void setVertices(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
	
	public void inicializarVertices() {
		ListIterator<Vertice<E>> list = vertices.listIterator();
		while(list.hasNext()) {
			Vertice<E> v = list.next();
			v.setAnterior(null);
			v.setDistance(Double.POSITIVE_INFINITY);
		}
	}
	
	//-------------------------------------------------------------------------------------------------------
	//Método de camino sin pesos
	public Stack<Vertice<E>> camino(Vertice<E> inicio, Vertice<E> destino) throws ExceptionVertice{
		Stack<Vertice<E>> camino = new Stack<Vertice<E>>();
		Vertice<E> v = destino;
		while(v != null && inicio.getInfo().compareTo(v.getInfo()) != 0) {
			camino.push(v);
			v = v.getAnterior();
		}
		camino.push(inicio);
		return camino;
	}
	
	public Stack<Vertice<E>> menorCaminoSinPesos(Vertice<E> inicio, Vertice<E> destino) throws ExceptionVertice{
		inicializarVertices(); // Inicializar los anteriores y distancias antes de recorrerlas
		//Recorrer a lo ancho todas las aristas con las que tiene conexión
		Queue<Vertice<E>> vSinVisitar = new LinkedList<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while(!vSinVisitar.isEmpty()) {
			//Buscar Vértice
			Vertice<E> actual = vSinVisitar.poll();
			//Recorrer adyacentes y poner en cola sin visitar
			ListIterator<Arista<E>> iterator = actual.getAdyacentes().listIterator();
			while(iterator.hasNext()) {
				Arista<E> a = iterator.next();
				Vertice<E> v = a.getDestino();
				if(v.getAnterior() == null) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+1);
					vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio, destino);
	}
	
	//-------------------------------------------------------------------------------------------------------
	//Dijkstra con Vertices
	public Stack<Vertice<E>> dijkstra(Vertice<E> inicio, Vertice<E> destino) throws ExceptionVertice{
		inicializarVertices();
		Queue<Vertice<E>> vSinVisitar = new PriorityQueue<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while(!vSinVisitar.isEmpty()) {
			Vertice<E> actual = vSinVisitar.poll();
			ListIterator<Arista<E>> iterator = actual.getAdyacentes().listIterator();
			while(iterator.hasNext()) {
				Arista<E> a = iterator.next();
				Vertice<E> v = a.getDestino();
				if(v.getAnterior() == null || (actual.getDistance()+a.getPeso() < v.getDistance())) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+a.getPeso());
					if(!vSinVisitar.contains(v))
						vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio, destino);
	}
	//Dijkstra con Información
	public Stack<Vertice<E>> dijkstra(E infoInicio, E infoDestino) throws ExceptionVertice{
		Vertice<E> inicio = vertices.get(indexVertice(infoInicio));
		Vertice<E> destino = vertices.get(indexVertice(infoDestino));
		inicializarVertices();
		Queue<Vertice<E>> vSinVisitar = new PriorityQueue<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while(!vSinVisitar.isEmpty()) {
			Vertice<E> actual = vSinVisitar.poll();
			ListIterator<Arista<E>> iterator = actual.getAdyacentes().listIterator();
			while(iterator.hasNext()) {
				Arista<E> a = iterator.next();
				Vertice<E> v = a.getDestino();
				if(v.getAnterior() == null || (actual.getDistance()+a.getPeso() < v.getDistance())) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+a.getPeso());
					if(!vSinVisitar.contains(v))
						vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio, destino);
	}
	
	//-------------------------------------------------------------------------------------------------------
	//Imprimir camino
	public void imprimirCamino(Stack<Vertice<E>> s) {
		while(!s.isEmpty()) {
			Vertice<E> v = s.pop();
			System.out.print(v.getInfo() + " ");
		}
		System.out.println();
	}
	
	//-------------------------------------------------------------------------------------------------------
	//Buscar indice vertice
	public int indexVertice(E info) throws ExceptionVertice{
		int i = 0;
		while(i < vertices.size() && vertices.get(i).getInfo().compareTo(info) != 0) i++;
		if(i<vertices.size())
			return i;
		else throw new ExceptionVertice("Vertice no existe");
	}
	//-------------------------------------------------------------------------------------------------------
	//Compare to de Vertice, según distancia
	/*@Override
	public void compareTo() {
		
	}*/
	
	//-------------------------------------------------------------------------------------------------------
	//Main
	public static void main(String[] args) {
		//Vertices
		Vertice<Integer> v1 = new Vertice<Integer>(1);
		Vertice<Integer> v2 = new Vertice<Integer>(2);
		Vertice<Integer> v3 = new Vertice<Integer>(3);
		Vertice<Integer> v4 = new Vertice<Integer>(4);
		Vertice<Integer> v5 = new Vertice<Integer>(5);
		Vertice<Integer> v6 = new Vertice<Integer>(6);
		Vertice<Integer> v7 = new Vertice<Integer>(7);
		
		//Aristas (salen)
		Arista<Integer> a12 = new Arista<Integer>(v2, 3);
		Arista<Integer> a13 = new Arista<Integer>(v3, 10);
		Arista<Integer> a14 = new Arista<Integer>(v4, 7);
		Arista<Integer> a25 = new Arista<Integer>(v5, 8);
		Arista<Integer> a24 = new Arista<Integer>(v4, 2);
		Arista<Integer> a36 = new Arista<Integer>(v6, 5);
		Arista<Integer> a47 = new Arista<Integer>(v7, 3);
		Arista<Integer> a57 = new Arista<Integer>(v7, 1);
		Arista<Integer> a67 = new Arista<Integer>(v7, 1);
		Arista<Integer> a46 = new Arista<Integer>(v6, 1);
		
		//Aristas (llegan)
		v1.getAdyacentes().add(a12); v1.getAdyacentes().add(a14); v1.getAdyacentes().add(a13);
		v2.getAdyacentes().add(a25); v2.getAdyacentes().add(a24);
		v3.getAdyacentes().add(a36);
		v4.getAdyacentes().add(a47); v4.getAdyacentes().add(a46);
		v5.getAdyacentes().add(a57);
		v6.getAdyacentes().add(a67);
		
		Grafo<Integer> grafo = new Grafo<Integer>();
		
		grafo.getVertices().add(v1);
		grafo.getVertices().add(v2);
		grafo.getVertices().add(v3);
		grafo.getVertices().add(v4);
		grafo.getVertices().add(v5);
		grafo.getVertices().add(v6);
		grafo.getVertices().add(v7);
		
		Stack<Vertice<Integer>> s;
		
		try {
			s = grafo.menorCaminoSinPesos(v1, v7);
			grafo.imprimirCamino(s);
			
			s = grafo.dijkstra(1, 7);
			grafo.imprimirCamino(s);
		} catch(ExceptionVertice e) {
			System.out.println(e.getMessage());
		}
	}
}
