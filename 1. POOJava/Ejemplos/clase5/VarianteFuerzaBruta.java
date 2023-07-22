package clase5;

public class VarianteFuerzaBruta {

	public static int subsecuenciaSumaMaxima (int [] a)
	{
		int sumaActual;
		int sumaMax = 0;
		for ( int i =0; i<a.length; i++)
			for ( int j=i; j<a.length; j++)
			{
				sumaActual = 0;
				for ( int k=i; k<=j; k++)
					sumaActual += a[k];
				if (sumaActual > sumaMax)
					sumaMax = sumaActual;
			}
		return sumaMax;
	}

	public static int subSecSumMax(int [] a) {
		int sumaMax = 0;
		int sumaActual = 0;

		for (int element : a) {
            sumaActual += element;

            if (sumaActual < 0)
                sumaActual = 0;
            else if(sumaActual > sumaMax)
            	sumaMax = sumaActual;
        }

		return sumaMax;
	}

	public static void main(String[] args) {
		int [] a = {1, -5, 2, 10, -7, 8};
		System.out.println("La mayor suma (ineficiente) en la secuencia del arreglo es: " + subsecuenciaSumaMaxima(a));
		System.out.println("La mayor suma (eficiente) en la secuencia del arreglo es: " + subSecSumMax(a));
	}

}
