package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Biseccion {
	
	public double funcion(double x) {
		return x*Math.sin(x)*Math.log(x)+1;
	}
	
	public double redondear(double x){
		DecimalFormat formateador = new DecimalFormat("###.######");
		double prdped = x;
		try {
			prdped = formateador.parse(formateador.format(prdped)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prdped;
	}
	
	Integer itmax = 20;
	double tolerancia = 0.001;
	private String resultado;
	
	public String getResultado() {
		return resultado;
	}
	
	public Biseccion(double a, double b) {
		if(a>b) {
			double temp;
			temp = a;
			a=b;
			b=temp;
		}
		double fa = funcion(a);
		if (Double.isNaN(fa)) {
			resultado = "La función no existe en el punto a. Intente de nuevo con otro valor.";
			return;
		}
		double fb = funcion(b);
		if (Double.isNaN(fa)) {
			resultado = "La función no existe en el punto b. Intente de nuevo con otro valor.";
			return;
		}
		if(fa*fb>0) {
			resultado = "Los valores de a y b no permiten usar el método. Intenta con otros.\nRecuerda que f(a) y f(b) deben tener signos diferentes";
			return;
		}
		double fc = 2*tolerancia;
		double c = 0;
		Integer cont = 1;
		resultado="n\ta\tb\tc\tf(a)\tf(b)\tf(c)\n";
		//System.out.println("n\t\ta\t\tb\t\tc\t\tf(a)\t\tf(b)\t\tf(c)");
		while(Math.abs(fc)>=tolerancia && cont<itmax) {
			c = (a+b)/2;
			fc=funcion(c);
			if (Double.isNaN(fa)) {
				resultado += "La función no existe en el punto c, por lo que el método no puede terminarse\nIntente con otros valores de a y b";
				return;
			}
			resultado=resultado+cont+"\t"+redondear(a)+"\t"+redondear(b)+"\t"+redondear(c)+"\t"+redondear(fa)+"\t"+redondear(fb)+"\t"+redondear(fc)+"\n";
			//System.out.println(cont+"\t\t"+a+"\t\t"+b+"\t\t"+c+"\t\t"+fa+"\t\t"+fb+"\t\t"+fc);
			if (fc==0) {
				return;
			}
			else {
				if(fa*fc<0){
					b=c;
					fb=fc;
				}
				else {
					a=c;
					fa=fc;
				}
				
			}
			cont++;
		}
		if (Math.abs(fc)>=tolerancia) {
			resultado=resultado+="\nEl metodo fracasó después de "+itmax+" iteraciones.\nLa solución obtenida que más se aproximó a la raíz fue: "+c;
			//System.out.println("El metodo fracasó después de "+itmax+" iteraciones");
			//System.out.println("La solución obtenida que más se aproximó a la raíz fue: "+c);
		}
		else {
			resultado+="\nLa raiz buscada es: "+c;
			//System.out.println("La raiz buscada (obtenida por el metodo de biseccion) es: "+c);
		}
	}
	
}
