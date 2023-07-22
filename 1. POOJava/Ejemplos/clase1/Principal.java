package clase1;

class Principal {
	public static void main(String[] args) {
		//Ejemplo 1 - Cuerpo
		System.out.println("Ejemplo 1: Cuerpo");
		Cuerpo c = new Cuerpo();
		c.setEspacio(100);
		c.setTiempo(15);
		double v = c.velocidad();
		System.out.println("Velocidad: "+v);

		//Ejemplo 2 - Rectangulo
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 2: Rectángulo");
		Rectangulo r = new Rectangulo();
		r.setAlto(10);
		r.setAncho(12);
		double area2 = r.Area();
		double per2 = r.Perimetro();
		System.out.println("El perímetro es: " + per2 + " y el área es: " + area2);


		//Ejemplo 3 - Triangulo
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 3: Triángulo");
		Triangulo t = new Triangulo();
		t.setTriangle(5, 6, 9);
		double area3 = t.Area();
		double per3 = t.Perimetro();
		char clas = t.clasif();
		System.out.println("El perímetro es: " + per3 + ", el área es: " + area3 + " y la clasificación es: " + clas);



		//Ejemplo 4 - Calculadora
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("Ejemplo 4: Calculadora");
		System.out.println("El Mínimo Común Divisor es: " + Calculadora.MCD(10, 8));
		System.out.println("El Factorial del número es: " + Calculadora.fact(5));
	}
}