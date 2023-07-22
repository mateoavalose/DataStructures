package VerificarParentesisYPostfix;
import java.util.*;

public class PostfixExpression {
    
    //Método para obtener la prioridad de un operador
    public static int prioridad(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        } else if (operador == '^') {
            return 3;
        } else {
            return 0;
        }
    }
    
    //Método para convertir una expresión infija a fija
    public static String infijoAFijo(String infijo) {
        Stack<Character> pila = new Stack<>(); //Para almacenar y organizar los operadores
        Queue<Character> cola = new LinkedList<>(); //Para almacenar la expresión fija
        
        for(int i=0; i<infijo.length(); i++) {
            char simbolo = infijo.charAt(i);
            
            //Si es un operando, lo agregamos a la cola
            if (simbolo >= '0' && simbolo <= '9') {
                cola.add(simbolo);
            }
            //Si es un operador
            else if(simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/' || simbolo == '^') {
                // Sacamos de la pila todos los operadores con mayor o igual prioridad
                while (!pila.empty() && prioridad(pila.peek()) >= prioridad(simbolo)) {
                    cola.add(pila.pop());
                }
                //Agregamos el operador a la pila
                pila.push(simbolo);
            }
            //Si es un paréntesis izquierdo, lo agregamos a la pila
            else if (simbolo == '(') {
                pila.push(simbolo);
            }
            //Si es un paréntesis derecho, sacamos todos los operadores de la pila hasta encontrar el paréntesis izquierdo
            else if (simbolo == ')') {
                while (!pila.empty() && pila.peek() != '(') {
                    cola.add(pila.pop());
                }
                pila.pop();
            }
        }
        //Sacamos los operadores que quedan en la pila y los agregamos a la cola
        while (!pila.empty()) {
            cola.add(pila.pop());
        }
        
        // Construimos la expresión fija a partir de la cola
        String fijo = new String();
        while (!cola.isEmpty()) {
            fijo += cola.remove();
        }
        return fijo;
    }
    
    //Main
    public static void main(String[] args) {
    	String expresion = "4+((5*6)/3)";
    	System.out.println("La expresión " + expresion + " en forma infija es: " + infijoAFijo(expresion));
    }
}