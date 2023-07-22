package clase4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ejemploFicheroEstudiante {
	public Estudiante[] listaEstudiantes;

	public ejemploFicheroEstudiante(Estudiante[] listaEstudiantes) {
		super();
		this.listaEstudiantes = listaEstudiantes;
	}

	public ejemploFicheroEstudiante() {
		super();
		this.listaEstudiantes = new Estudiante[0];
	}

	public Estudiante[] getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public void writeEstudiantes(String fichero) throws IOException{
		File f = new File(fichero);
		FileWriter fr = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fr);
		for(Estudiante est:listaEstudiantes) {
			b.write(est.getNombre());b.newLine();
			b.write(est.getCc());b.newLine();
			b.write(Integer.toString(est.getEdad()));b.newLine();
		}
		b.close();
		fr.close();
	}

	public Estudiante[] readEstudiantes(String fichero) throws IOException{
		File f = new File(fichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		String linea;
		Estudiante [] listaEstudiantes = new Estudiante[0];
		while((linea=b.readLine()) != null) {
			String nombre = linea;
			String cedula = b.readLine();
			int edad = Integer.parseInt(b.readLine());
			Estudiante e = new Estudiante(nombre, cedula, edad);
			listaEstudiantes = Arrays.copyOf(listaEstudiantes, listaEstudiantes.length + 1);
			listaEstudiantes[listaEstudiantes.length - 1] = e;
		}
		b.close();
		fr.close();
		this.listaEstudiantes = listaEstudiantes;
		return listaEstudiantes;
	}

	public void writeEstudiantesObjeto(String address) throws IOException{
		for(int i = 0; i < listaEstudiantes.length; i++)
			listaEstudiantes[i].escribirObjeto(address+"\\"+i+".est");
	}

	public void readTodosEstudiantesObjetos(String address) throws IOException, ClassNotFoundException{
		File f = new File(address);
		File[] listaF = f.listFiles(new Filtro(".est"));
		listaEstudiantes = new Estudiante[listaF.length];
		for(int i = 0; i < listaF.length; i++) {
			FileInputStream in = new FileInputStream(listaF[i]);
			ObjectInputStream o = new ObjectInputStream(in);
			listaEstudiantes[i] = (Estudiante)o.readObject();
			o.close();
			in.close();
		}
	}

	class Filtro implements FilenameFilter{
		private String extension;

		public Filtro(String extension) {
			super();
			this.extension = extension;
		}

		@Override
		public boolean accept(File ruta, String file) {
			return file.endsWith(extension);
		}
	}
}
