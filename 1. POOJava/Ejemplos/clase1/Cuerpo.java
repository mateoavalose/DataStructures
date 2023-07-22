package clase1;

public class Cuerpo {
	private double espacio;
	private double tiempo;

	public double velocidad() {
		double vel;
		vel = espacio/tiempo;
		return vel;
	}

	//Método para obtener el espacio
			public double getEspacio() {
				return espacio;
			}
	//Método para poner un nuevo valor de espacio
			public void setEspacio(double newEsp) {
			espacio = newEsp;
			}

	//Método para obtener el tiempo
			public double getTiempo() {
				return tiempo;
			}
	//Método para poner un nuevo valor de tiempo
			public void setTiempo(double newTiempo) {
			tiempo=newTiempo;
	}
}
