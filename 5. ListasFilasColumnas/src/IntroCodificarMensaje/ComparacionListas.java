package IntroCodificarMensaje;
import java.util.*;

public class ComparacionListas {

	public static void main(String[] args) {
		//Array List
		int N = 10000000;
		Integer p2 = 10;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		long inicio = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			aList.add(i);
		long fin = System.currentTimeMillis();
		aList.add(p2);
		
		inicio = System.currentTimeMillis();
		aList.remove(100000);
		fin = System.currentTimeMillis();
		
		long time = fin - inicio;
		System.out.println("ArrayList: " + time + " (ms)");

		//Linked List
		LinkedList<Integer> lList = new LinkedList<Integer>();
		inicio = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			lList.add(i);
		fin = System.currentTimeMillis();
		lList.add(p2);
		
		inicio = System.currentTimeMillis();
		lList.remove(100000);
		fin = System.currentTimeMillis();

		inicio = System.currentTimeMillis();
		time = fin - inicio;
		System.out.println("LinkedList: " + time + " (ms)");
		
		//Queue - Cola
		Queue<Integer> lQueue = new LinkedList<Integer>();
		inicio = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			lQueue.add(i);
		fin = System.currentTimeMillis();
		lQueue.add(p2);
		
		inicio = System.currentTimeMillis();
		lQueue.poll();
		fin = System.currentTimeMillis();
		
		time = fin - inicio;
		System.out.println("Queue: " + time + " (ms)");
		
		//Stack - Pila
		Stack<Integer> lStack = new Stack<Integer>();
		inicio = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			lStack.push(i);
		fin = System.currentTimeMillis();
		lStack.push(p2);
		
		inicio = System.currentTimeMillis();
		lStack.pop();
		fin = System.currentTimeMillis();
		
		time = fin - inicio;
		System.out.println("Stack: " + time + " (ms)");
	}



}
