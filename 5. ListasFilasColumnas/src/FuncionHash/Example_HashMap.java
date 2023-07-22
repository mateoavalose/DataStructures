package FuncionHash;

import java.util.*;
import Ordenamiento.*;

public class Example_HashMap {

	public static void main(String[] args) {
		//HashMap de String
		String str = "Hola";
		System.out.println("HashMap de " + "'" + str + "'" + ": " + str.hashCode());
		System.out.println("------------------------------");
		
		//HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1_4", "Alex");
		map.put("1_2", "Ana");
		map.put("1_3", "Juan");
		map.put("1_1", "Pedro");
		System.out.print("HashMap:"); System.out.println(map);
		for(Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("------------------------------");
		
		//Linked HashMap
		LinkedHashMap<String, String> lmap = new LinkedHashMap<String, String>();
		lmap.put("1_4", "Alex");
		lmap.put("1_2", "Ana");
		lmap.put("1_3", "Juan");
		lmap.put("1_1", "Pedro");
		System.out.print("Linked HashMap:"); System.out.println(lmap);
		for(Map.Entry<String, String> m : lmap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("------------------------------");
		
		//HashMap con Objetos
		Persona2 p1 = new Persona2("Alex", 23);
		Persona2 p2 = new Persona2("Pedro", 27);
		Persona2 p3 = new Persona2("Juan", 20);
		Persona2 p4 = new Persona2("Ana", 18);
		HashMap<Integer, Persona2> mapP = new HashMap<Integer, Persona2>();
		mapP.put(3, p3);
		mapP.put(1, p1);
		mapP.put(2, p2);
		mapP.put(4, p4);
		System.out.print("Persona2 HashMap:"); System.out.println(mapP);
		for(Map.Entry<Integer, Persona2> m : mapP.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("------------------------------");
		
		//Sorted Map
		SortedMap<Integer, Persona2> mapTS = new TreeMap<Integer, Persona2>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1); //De mayor a menor
		}
		});
		mapTS.put(3, p3);
		mapTS.put(1, p1);
		mapTS.put(2, p2);
		mapTS.put(4, p4);
		System.out.print("Persona2 SortedMap:"); System.out.println(mapTS);
		for(Map.Entry<Integer, Persona2> m : mapTS.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("------------------------------");
	}
	
}
