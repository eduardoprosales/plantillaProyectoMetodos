package proyectoMetodos.backend;

public class FactorizacionLU {
	static int j , i,k, n=3;
	static double A[][] = {{4,2,2},{2,2,0},{2,0,4}};
	static double L[][] = {{0,0,0},{0,0,0},{0,0,0}};
	static double U[][] = {{0,0,0},{0,0,0},{0,0,0}};
	static double b[] = {3,2,1};
	static double sL[] = {0,0,0};
	static double sU[] = {0,0,0};

	public  void imprimir( double x[][]) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
			    System.out.print (x[i][j]+" ");
			    }
			System.out.println (" ");
		    }
	}
	
	public void triangSup() {
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
	
	public void sistema() {
		sL[0]=(b[0]/L[0][0]);
		
		sL[1]=(b[1]-(L[1][0]*sL[0]));
		
		sL[2]=(b[2]-(L[2][0]*sL[0])+sL[1]);
		
		sU[2]=(sL[2]/U[2][2]);
		
		sU[1]=(sL[1]+(U[1][2]*sU[2]));
		
		sU[0]=(sL[0]-(U[0][1]*sU[1])-(U[0][2]*sU[2]))/U[0][0];
		
		for (int k=0;k<n;k++) {
			
		    System.out.println (sL[k]+" ");
		    }
		for (int k=0;k<n;k++) {
					
		    System.out.println (sU[k]+" ");
		    }
																							
		}
	
	
	public static void main(String[] args) {
			
			FactorizacionLU z = new FactorizacionLU();
			z.imprimir(A);
			z.triangSup();
			System.out.println ("MATRIZ U ");
			z.imprimir(U);
			System.out.println ("MATRIZ L ");
			z.imprimir(L);
			z.sistema();
		}

	

}
