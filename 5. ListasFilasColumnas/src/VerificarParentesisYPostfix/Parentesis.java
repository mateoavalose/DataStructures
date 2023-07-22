package VerificarParentesisYPostfix;
import java.util.*;

public class Parentesis {
    
	//Verificar si los paréntesis de una expresión son válidos
	public static boolean parentesisValidos(String exp) {
        Stack<Character> aux = new Stack<Character>(); //Crear una pila para almacenar los paréntesis
        for(int i = 0; i < exp.length(); i++) { //Un ciclo que recorre toda la expresión
            char c = exp.charAt(i); 
            if (c == '(') { //Verificar si la expresión en la posición i es un paréntesis
                aux.push(c); //Adicionar el paréntesis a la pila
            } else if (c == ')') { //Verificar si es el otro paréntesis
                if (aux.isEmpty() || !parValido(aux.peek(), c)) { //Verifica si no hay más paréntesis o si no es un "par válido"
                    return false; //En este caso, retorna falso
                }
                aux.pop(); //Quita el paréntesis almacenado
            }
        }

        return aux.isEmpty(); //Verifica si ningún paréntesis quedó almacenado en "aux"
    }

    private static boolean parValido(char c1, char c2) {
        return (c1 == '(' && c2 == ')'); //Verifica si son un par de paréntesis válidos
    }
    
    public static boolean verificarParentesis(String expresion) throws ExceptionParentesis{
    	Stack<Integer> pila = new Stack<Integer>();
    	Queue<Integer> posMal = new LinkedList<Integer>();
    	
    	for(int i = 0; i<expresion.length(); i++) {
    		Character c = expresion.charAt(i);
    		if(c=='(')
    			pila.push(i+1);
    		if(c==')')
    			if(pila.isEmpty())
    				posMal.add(i+1);
    			else
    				pila.pop();
    	}
    	while(!pila.isEmpty()) {
            posMal.add(pila.pop());
    	}
    	
    	if(!posMal.isEmpty())
    		throw new ExceptionParentesis("Error en las posiciones " + posMal);
    	
    	return pila.isEmpty();
    }

    public static void main(String[] args) {
        String expresion1 = "((5+3)*(2+1))";
        String expresion2 = "(a+b))((c*4)))(x";
        
        System.out.println("La expresión '" + expresion1 + "' es válida? "); System.out.println(parentesisValidos(expresion1));
        System.out.print("\n");
        System.out.println("-----------------------");
        
        //Posiciones malas
        System.out.print("\n");
        try {
        	System.out.println("La expresión '" + expresion2 + "' es válida? " ); System.out.println(verificarParentesis(expresion2));
        	
        } catch (ExceptionParentesis e) {
        	System.out.println(e.toString());
        }
    }
}
