package proyectoMetodos.backend;

public class Crout {
	
	 static String resultado;
		
	public String getResultado() {
		return resultado;
	}

	static int j , i,k;
	//static double A[][] = {{4,2,2},{2,2,0},{2,0,4}};
	static double L[][] = {{0,0,0},{0,0,0},{0,0,0}};
	static double U[][] = {{0,0,0},{0,0,0},{0,0,0}};
//	static double b[] = {3,2,1};
	static double sL[] = {0,0,0};
	static double sU[] = {0,0,0};
	
	public Crout (Integer n,double A[][], double b[]) {
		resultado = "\nMATRIZ DEL SISTEMA \n";
		imprimir (A,n);
		triangSup(A,n);
		resultado += "\nMATRIZ L \n";
		imprimir (L,n);
		resultado += "\nMATRIZ U \n";
		imprimir (U,n);
		sistema(b);
		resultado += "\nSolucion del sistema\n"+"x = "+sU[0] + "\ny = "+sU[1]+"\nz = "+sU[2];
		
		
		
	}
	
	
	

	public  void imprimir( double x[][], Integer n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				
				resultado += x[i][j]+"\t";
			    }
			resultado += "\n";
		    }
	}
	
	public void triangSup(double A[][],Integer n) {
			for( k=0;k<n;k++) {
				
				U[k][k]=1;
				L[k][k]=A[k][k]-((L[k][0]*U[0][k])+(L[k][1]*U[1][k]));
				
				for(j=k+1;j<n;j++) {
								
					U[k][j] =  ( A[k][j]-((L[k][0]*U[0][j])+(L[k][1]*U[1][j])))/L[k][k];
				}
				
				for(i=k+1;i<n;i++) {
					
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
		

																							
		}
	
	

	

}
