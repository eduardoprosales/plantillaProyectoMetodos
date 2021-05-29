package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Doolitle {
	 static String resultado;
	
	 
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
	 
	 
	public String getResultado() {
		return resultado;
	}
	
	static int j , i,k, n=3;
	//static double A[][] = {{4,2,2},{2,2,0},{2,0,4}};
	static double L[][] = {{0,0,0},{0,0,0},{0,0,0}};
	static double U[][] = {{0,0,0},{0,0,0},{0,0,0}};
//	static double b[] = {3,2,1};
	static double sL[] = {0,0,0};
	static double sU[] = {0,0,0};
	
	public Doolitle(double A[][], double b[]) {
		resultado = "\nMATRIZ DEL SISTEMA \n";
		imprimir (A);
		resultado += "\nTÉRMINOS INDEPENDIENTES\n";
		for(int i=0; i<3; i++) {
			resultado+="b["+(i+1)+"] = "+b[i]+"\n";
		}
		metodoDoo(A);
		resultado += "\nMATRIZ L \n";
		imprimir (L);
		resultado += "\nMATRIZ U \n";
		imprimir (U);
		sistema(b);
		resultado += "\nSolucion del sistema\n"+"x = "+redondear(sU[0]) + "\ny = "+redondear(sU[1])+"\nz = "+redondear(sU[2]);
	}
	
	
	

	public  void imprimir( double x[][]) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				
				resultado += redondear(x[i][j])+"\t";
			  //  System.out.print (x[i][j]+" ");
			    }
			resultado += "\n";
			//System.out.println (" ");
		    }
	}
	
	public void metodoDoo(double A[][]) {
			for( k=0;k<3;k++) {
				
				L[k][k]=1;
				U[k][k]=A[k][k]-((L[k][0]*U[0][k])+(L[k][1]*U[1][k]));
				
				for(j=k+1;j<3;j++) {
								
					U[k][j] =  ( A[k][j]-((L[k][0]*U[0][j])+(L[k][1]*U[1][j])))/L[k][k];
				}
				
				for(i=k+1;i<3;i++) {
					
					L[i][k] = (A[i][k]-((L[i][0]*U[0][k])+(L[i][1]*U[1][k])))/U[k][k];
					
					
				}
				
				
				
				
				
			}
			
		}
	
	public void sistema(double b[]) {
		sL[0]=(b[0]/L[0][0]);
		
		sL[1]=(b[1]-(L[1][0]*sL[0]));
		
		sL[2]=(b[2]-(L[2][0]*sL[0])+sL[1]);
		
		sU[2]=(sL[2]/U[2][2]);
		
		sU[1]=(sL[1]+(U[1][2]*sU[2]));
		
		sU[0]=(sL[0]-(U[0][1]*sU[1])-(U[0][2]*sU[2]))/U[0][0];
		
	/*	for (int k=0;k<n;k++) {
			
		    System.out.println (sL[k]+" ");
		    }
		for (int k=0;k<n;k++) {
					
		    System.out.println (sU[k]+" ");
		    }*/
																							
		}
	 
	
/*public static void main(String[] args) {
		
	Doolitle met = new Doolitle();
		met.imprimir(A);
		met.metodoDoo();
		resultado = "MATRIZ U ";
		//System.out.println ("MATRIZ U ");
		met.imprimir(U);
		System.out.println ("MATRIZ L ");
		met.imprimir(L);
		met.sistema();
		
		System.out.println ("Solucion del sistema");
		System.out.println ("x = "+sU[0]);
		System.out.println ("y = "+sU[1]);
		System.out.println ("z = "+sU[2]);
	}*/



}


