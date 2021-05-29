package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class GaussSeidel {

	static int n=3;
	static double sistema[][] = {{4,2,2},{2,2,0},{2,0,4}};
	static double b[] = {3,2,1};
	static double valGauss[][]=new double[30][3];
	
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
	
	public GaussSeidel(double x[]) {
		double a=x[0];
		double b=x[1];
		double c=x[2];
		System.out.println(a+"\n"+b+"\n"+c);
		valGauss[0][0] = x[0];
		valGauss[0][1] = x[1];
		valGauss[0][2] = x[2];
		despejar ();
		proceso ();
	/*	resultado += "\n Vector inicial:"+ b[1];
		resultado += "\n Vector Dado:11111\n"+ x[0];
		resultado += "\n Vector Dado:222222\n"+ x[1];
		resultado += "\n Vector Dado:3333333\n"+ x[2];*/
		
		resultado += "\n Después de 30 iteraciones, la solución para el sistema de ecuaciones es:\n x = "+redondear(valGauss[29][0])+"\n y = "+redondear(valGauss[29][1])+"\n z = "+redondear(valGauss[29][2]);
	}
	
	
	
	
	
	/*public  void imprimir() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
			    System.out.print (sistema[i][j]+" ");
			    }
			System.out.println (b[i]+" ");
		    }
	}*/
	
	
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
		for( int i=0;i<valGauss.length-1;i++) {
			
			valGauss[i+1][0]=b[0]-(sistema[0][1]*valGauss[i][1])-(sistema[2][0]*valGauss[i][2]);
			valGauss[i+1][1]=b[1]-(sistema[1][0]*valGauss[i+1][0]);
			valGauss[i+1][2]=b[2]-(sistema[2][0]*valGauss[i+1][0]);
			resultado += "\t"+redondear(valGauss[i][0])  + "\t"+redondear(valGauss[i][1])  + "\t"+redondear(valGauss[i][2])  + "\t\n";
			
			/*System.out.println ("valor de x "+ i +" es:  "+valGauss[i][0]);
			System.out.println ("valor de y "+ valGauss[i][1]);
			System.out.println ("valor de z "+ valGauss[i][2]);
			System.out.println (" ");*/
			
		}
	}
	
/*	public static void main(String[] args) {
		
		GaussSeidel pr = new GaussSeidel();
		
		//pr.imprimir();
		pr.despejar();
		//pr.imprimir();
		pr.proceso();
		
	}*/


}
