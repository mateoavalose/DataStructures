package Ordenamiento;
import java.util.*;

//Comparar por Nombre
class CompNombre implements Comparator<Persona2>{
	@Override
	public int compare(Persona2 o1, Persona2 o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
}
//Comparar por Edad
class CompEdad implements Comparator<Persona2>{
	@Override
	public int compare(Persona2 o1, Persona2 o2) {
		return o1.getEdad()-o2.getEdad();
	}
}
//Comparar por nombre o por edad, dependiendo del parámetro
class Comp implements Comparator<Persona2>{
	private String tipo;
	public Comp(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int compare(Persona2 o1, Persona2 o2) {
		if(tipo.compareTo("nombre") == 0)
			return o1.getNombre().compareTo(o2.getNombre());
		else
			return o1.getEdad()-o2.getEdad();
	}
}

class CompEsp implements Comparator<Persona2>{
	@Override
	public int compare(Persona2 o1, Persona2 o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}
}

public class EjPriorityQueue{
	public static void main(String[] args) {
		//Comparar Nombre y edad
		System.out.println("--------------------");
		System.out.println("Comparar por nombre y por edad: ");
		PriorityQueue<Persona2> pq = new PriorityQueue<Persona2>();
		pq.add(new Persona2("Juan", 20));
		pq.add(new Persona2("Juan", 16));
		pq.add(new Persona2("Abel", 20));
		pq.add(new Persona2("Ana", 20));
		pq.add(new Persona2("Abel", 15));
		
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		System.out.print("\n");
		System.out.println("--------------------");
		
		//Comparar Nombre
		System.out.println("Comparar por nombre: ");
		CompNombre compararPersona2 = new CompNombre();
		PriorityQueue<Persona2> pqNom = new PriorityQueue<Persona2>(compararPersona2);
		pqNom.add(new Persona2("Juan", 20));
		pqNom.add(new Persona2("Juan", 16));
		pqNom.add(new Persona2("Abel", 20));
		pqNom.add(new Persona2("Ana", 20));
		pqNom.add(new Persona2("Abel", 15));
		
		while(!pqNom.isEmpty())
			System.out.println(pqNom.poll());
		System.out.print("\n");
		System.out.println("--------------------");
		
		//Comparar Edad
		System.out.println("Comparar por edad: ");
		CompEdad compPersonasClass = new CompEdad();
		PriorityQueue<Persona2> pqEd = new PriorityQueue<Persona2>(compPersonasClass);
		pqEd.add(new Persona2("Juan", 20));
		pqEd.add(new Persona2("Juan", 16));
		pqEd.add(new Persona2("Abel", 20));
		pqEd.add(new Persona2("Ana", 20));
		pqEd.add(new Persona2("Abel", 15));
		
		while(!pqEd.isEmpty())
			System.out.println(pqEd.poll());
		System.out.print("\n");
		System.out.println("--------------------");
		
		//Comparar por nombre o por edad, dependiendo del parámetro
		System.out.println("Comparar por nombre o por edad, dependiendo del parámetro: ");
		Comp compPar = new Comp("nombre");
		PriorityQueue<Persona2> pqPar = new PriorityQueue<Persona2>(compPar);
		pqPar.add(new Persona2("Juan", 20));
		pqPar.add(new Persona2("Juan", 16));
		pqPar.add(new Persona2("Abel", 20));
		pqPar.add(new Persona2("Ana", 20));
		pqPar.add(new Persona2("Abel", 15));
		
		while(!pqPar.isEmpty())
			System.out.println(pqPar.poll());
		System.out.print("\n");
		System.out.println("--------------------");
	}
	
}
