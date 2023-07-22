package clase1;

class Rectangulo {
	double alto;
	double ancho;

	//Método para calcular el perímetro

	public double Perimetro() {
		double per;
		per = 2*alto+2*ancho;
		return per;
	}

	//Método para calcular el área
	public double Area() {
		double area;
		area = alto*ancho;
		return area;
	}

	//Método para obtener el alto
	public double getAlto() {
		return alto;
	}

	//Método para cambiar valor de la altura
	public void setAlto(double newAlto) {
		alto = newAlto;
	}

	//Método para obtener ancho
	public double getAncho() {
		return ancho;
	}

	//Método para cambiar valor del ancho
	public void setAncho(double newAncho) {
		ancho = newAncho;
	}
}
