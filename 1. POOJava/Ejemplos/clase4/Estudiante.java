package clase4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.BufferedReader;
import java.io.Serializable;

public class Estudiante implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String cc;
	private int edad;

	public Estudiante(String nombre, String cc, int edad) {
		super();
		this.nombre = nombre;
		this.cc = cc;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void escribirObjeto(String address) throws IOException{
		FileOutputStream f = new FileOutputStream(address);
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(this);
		o.close();
		f.close();
	}

	public void leerObjeto(File f) throws IOException, ClassNotFoundException{
		FileInputStream in = new FileInputStream(f);
		ObjectInputStream o = new ObjectInputStream(in);
		Estudiante est = (Estudiante)o.readObject();
		this.cc = est.cc;
		this.nombre = est.nombre;
		this.edad = est.edad;
		o.close();
		in.close();
	}
}
