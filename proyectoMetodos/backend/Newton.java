package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Newton {
	Integer itmax = 20;
	double tolerancia =0.001;
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
	
	public double derivada(double x) {
		return (Math.sin(x)+x*Math.cos(x))*Math.log(x)+Math.sin(x);
	}
	
	public Newton(double x0) {
		Integer i = 1;
		double x, func, der;
		resultado = "n\tx\tf(x)\tf'(x)"+"\n";
		//System.out.println("n\tx\tf(x)\tf'(x)");
		while(i<=itmax) {
			func = funcion(x0);
			der = derivada(x0);
			resultado+=i+"\t"+redondear(x0)+"\t"+redondear(func)+"\t"+redondear(der)+"\n";
			if(Double.isNaN(func) || Double.isNaN(der)||der==0) {
				resultado+="El valor actual no puede ser usado para el método puesto que no es posible calcular un valor\nInténtelo de nuevo";
				return;
			}
			//System.out.println(i+"\t"+x0+"\t"+func+"\t"+der);
			x=x0-(func/der);
			if(Math.abs(x-x0)<tolerancia && Math.abs(func)<tolerancia) {
				resultado+="La raiz buscada es: "+x+"\n";
				//System.out.println("La raiz buscada (obtenida por el metodo de Newton) es: "+x);
				return;
			}
			else {
				x0 = x;
				i++;
			}
		}
		if (i>itmax) {
			resultado+="El metodo fracasó después de "+itmax+" iteraciones\nLa solución obtenida que más se aproximó a la raíz fue: "+x0;
			//System.out.println("El metodo fracasó después de "+itmax+" iteraciones");
			//System.out.println("La solución obtenida que más se aproximó a la raíz fue: "+x0);
		}
	}
}
