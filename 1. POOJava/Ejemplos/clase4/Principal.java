package clase4;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		//Ejemplo Ficheros
		System.out.println("___________________________________");
		System.out.println("Ejemplo Ficheros");
		Estudiante e1 = new Estudiante("Juan Perez", "100854326", 23);
		Estudiante e2 = new Estudiante("Ana Reys", "100854328", 20);
		Estudiante e3 = new Estudiante("Jose Lopez", "100854325", 17);
		Estudiante[] lista = {e1, e2, e3};
		ejemploFicheroEstudiante listaEst1 = new ejemploFicheroEstudiante(lista);


		System.out.println("---Fichero de Objetos---");
		String address = "C:\\Users\\mateo\\eclipse-workspace\\POOJava\\Ejemplos\\clase4\\Ficheros";
		ejemploFicheroEstudiante listaEst2 = new ejemploFicheroEstudiante();
		try {
			listaEst1.writeEstudiantesObjeto(address);
			listaEst2.readTodosEstudiantesObjetos(address);
			for(Estudiante e:listaEst2.getListaEstudiantes())
				System.out.println(e + ": " + e.getNombre());
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		System.out.println("\n");
		System.out.println("---Línea por Línea---");
		System.out.println("___Escritura___");
		for(Estudiante e:listaEst1.listaEstudiantes)
			System.out.println(e.getNombre());
		String fichero = "C:\\Users\\mateo\\eclipse-workspace\\POOJava\\Ejemplos\\clase4\\Ficheros\\fichero.txt";
		try {
			listaEst1.writeEstudiantes(fichero);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (IOException e) {
			System.out.println("Datos Incompletos IOException");
		} catch(Exception e){
			System.out.println("Datos incompletos");
		}

		System.out.println("____Lectura____");
		ejemploFicheroEstudiante listaEst = new ejemploFicheroEstudiante();
		Estudiante[] estudiantes = null;

		try {
			estudiantes = listaEst.readEstudiantes(fichero);
			} catch (FileNotFoundException e) {
				System.out.println("No se encontró el fichero");
			} catch (IOException e) {
				System.out.println("Datos Incompletos IOException");
			} catch (Exception e) {
				System.out.println("Datos incompletos");
			}

		for(Estudiante est: listaEst.getListaEstudiantes())
			System.out.println(est.getNombre());
		System.out.println(estudiantes.length);
	}

}
