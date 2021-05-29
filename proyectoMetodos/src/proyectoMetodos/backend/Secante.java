package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Secante {
	double tolerancia = 0.001;
	Integer itmax = 20;
	
	private String resultado;
	
	public String getResultado() {
		return resultado;
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
	
	public double funcion(double x) {
		return x*Math.sin(x)*Math.log(x)+1;
	}
	
	public Secante(double x0, double x1) {
		Integer i = 2;
		double fx0 = funcion(x0);
		double fx1 = funcion(x1);
		double fx=0;
		double x=0;
		resultado="n\tx0\tx1\tx\tf(x)\n"+"0\t"+redondear(x0)+"\t"+redondear(fx0)+"\n1\t"+redondear(x1)+"\t"+redondear(fx1)+"\n";
		//System.out.println("n\tx0\tx1\tx\tf(x)\n");
		//System.out.println(1+"\t\t"+x0+"\t\t"+fx0);
		//System.out.println(2+"\t\t"+x1+"\t\t"+fx1);
		while (i<itmax) {
			x = x1-fx1*((x1-x0)/(fx1-fx0));
			fx = funcion(x);
			resultado+=i+"\t"+redondear(x0)+"\t"+redondear(x1)+"\t"+redondear(x)+"\t"+redondear(fx)+"\n";
			if(Double.isNaN(fx)) {
				resultado+="No es posible continuar con el metodo porque el valor de la función no puede ser determinado\nIntente de nuevo con otros valores de x_0 y x_1";
				return;
			}
			//System.out.println(i+"\t\t"+x0+"\t\t"+x1+"\t\t"+x+"\t\t"+fx);
			if(Math.abs(fx)<tolerancia) {
				resultado+="La raiz buscada es: "+x;
				//System.out.println("La raiz buscada (obtenida por el metodo de la secante) es: "+x);
				return;
			}
			i++;
			x0=x1;
			x1=x;
			fx0=funcion(x0);
			fx1=funcion(x1);
		}
		if(Math.abs(fx)>tolerancia) {
			resultado+="El metodo fracasó después de "+itmax+" iteraciones\nLa solución obtenida que más se aproximó a la raíz fue: "+x;
			//System.out.println("El metodo fracasó después de "+itmax+" iteraciones");
			//System.out.println("La solución obtenida que más se aproximó a la raíz fue: "+x);
		}
	}
}
