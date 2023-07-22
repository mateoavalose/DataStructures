package clase1;

class Triangulo {
	double l1;
	double l2;
	double l3;

	//Método para calcular el perímetro
	public double Perimetro() {
		double per = l1 + l2 + l3;
		return per;
	}

	//Método para calcular el área
	public double Area() {
		double s = (l1+l2+l3)/2;
		double area = Math.pow(s*(s-l1)*(s-l2)*(s-l3), 0.5);
		return area;
	}

	//Método para cambiar los lados
	public void setTriangle (double newL1, double newL2, double newL3) {
		l1 = newL1;
		l2 = newL2;
		l3 = newL3;
	}

	//Método para clasificar el triángulo
	public char clasif() {
		return (l1 == l2 && l2 == l3)? 'q' : (l1 == l2 || l1 == l3 || l2 == l3)? 'i': 'e';
	}

}
