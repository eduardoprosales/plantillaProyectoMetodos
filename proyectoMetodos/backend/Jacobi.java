package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Jacobi {
	static int n=3,m=60;
	static double sistema[][] = {{4,2,2},{2,2,0},{2,0,4}};
	static double b[] = {3,2,1};
	static double valores[][] = new double[m][3];
	
	static String resultado;
	
	public String getResultado() {
		return resultado;
	}
	
	public double redondear(double x){
		DecimalFormat formateador = new DecimalFormat("###.###");
		double prdped = x;
		try {
			prdped = formateador.parse(formateador.format(prdped)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prdped;
	}
	
	
	
	public Jacobi(double x[]) {
		resultado += "\n Vector Dado:"+ x[1];
		valores[0][0] = x[0];
		valores[0][1] = x[1];
		valores[0][2] = x[2];
		despejar ();
		proceso ();
	/*	resultado += "\n Vector inicial:"+ b[1];
		resultado += "\n Vector Dado:11111\n"+ x[0];
		resultado += "\n Vector Dado:222222\n"+ x[1];
		resultado += "\n Vector Dado:3333333\n"+ x[2];*/
		
		resultado += "\n La solución más aproximada para el sistema de ecuaciones es:\n x = "+redondear(valores[59][0])+"\n y = "+redondear(valores[59][1])+"\n z = "+redondear(valores[59][2]);
	}
	
	
	
	public void despejar() {
		
		sistema[0][1] = sistema[0][1]/sistema[0][0]; 
		sistema[0][2] = sistema[0][2]/sistema[0][0];
		b[0] = b[0]/sistema[0][0];
		sistema[0][0] = sistema[0][0]/sistema[0][0];  
		
		sistema[1][0] = sistema[1][0]/sistema[1][1]; 
		sistema[1][2] = sistema[1][2]/sistema[1][1];
		b[1] = b[1]/sistema[1][1];
		sistema[1][1] = sistema[1][1]/sistema[1][1];  
		
		sistema[2][0] = sistema[2][0]/sistema[2][2]; 
		sistema[2][1] = sistema[2][1]/sistema[2][2];
		b[2] = b[2]/sistema[2][2];
		sistema[2][2] = sistema[2][2]/sistema[2][2]; 
		
	}
	public void proceso() {
		resultado = "\t x \t y \t z\n";
		
		for( int i=0;i<m-1;i++) {
			
			valores[i+1][1]=b[1]-(sistema[1][0]*valores[i][0]);
			valores[i+1][2]=b[2]-(sistema[2][0]*valores[i][0]);
			valores[i+1][0]=b[0]-(sistema[0][1]*valores[i][1])-(sistema[2][0]*valores[i][2]);
			resultado += "\t"+redondear(valores[i][0])  + "\t"+redondear(valores[i][1])  + "\t"+redondear(valores[i][2])  + "\t\n";
		
		}
		
	
	}
	
 

}
