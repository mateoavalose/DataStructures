package IntroCodificarMensaje;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CodMensaje {
	//Codificar 
			public String codificar(String mensaje) {
				Queue<Character> q = strQueue(mensaje);
				Stack<Character> s = invNoVocales(q);
				return printStack(s);
			}
			
		//String a Cola
		public Queue<Character> strQueue(String str) {
			Queue<Character> q = new LinkedList<Character>();
			for(int i = 0; i < str.length(); i++)
				q.add(str.charAt(i));
			return q;
		}

		//Invertir Vocales
			public Stack<Character> invNoVocales(Queue<Character> q) {
				String vocales = "AEIOUaeiou";
				Stack<Character> s = new Stack<Character>();
				Stack<Character> aux = new Stack<Character>();
				
				while(!q.isEmpty()) {
					while(!q.isEmpty() && !vocales.contains(String.valueOf(q.peek())))
						aux.push(q.poll());
					//Copiar lo que está en la pila del resultado
					while(!aux.isEmpty())
						s.push(aux.pop());
					if(!q.isEmpty())
						s.push(q.poll());
				}
				return s;
			}

		//Imprimir todo lo de una pila
		public String printStack(Stack<Character> pila) {
			@SuppressWarnings("unchecked")
			Stack<Character> stackTemp = (Stack<Character>) pila.clone();
			String result = "";
			while(!stackTemp.isEmpty())
				result = result + stackTemp.pop();
			return result;
		}

		//Main
		public static void main(String[] args) {
			//String str = "Problemas Super Interesantes";
			String str = "S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAE. VENTERGU";
			
			CodMensaje cod = new CodMensaje();
			System.out.println(cod.codificar(str));

		}
}
