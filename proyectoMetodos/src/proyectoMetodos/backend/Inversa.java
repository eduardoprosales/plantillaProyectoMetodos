package proyectoMetodos.backend;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Inversa {
	
	private String resultado;
	
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
	
	public Inversa(Integer n, double matriz[][], double b[]) {
		if(determinante(n,matriz)==0.0) {
			resultado="El determinante de la matriz es 0.\nNo es posible obtener solución del sistema por este método";
			return;
		}
		resultado = "La matriz de coeficientes ingresada es:\n";
		int i,j;
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				resultado+=matriz[i][j]+"\t";
			}
			resultado+="\n";
		}
		resultado+="\nLos terminos independientes ingresados son: \n";
		for(i=0; i<n; i++) {
			resultado+="x_"+(i+1)+" = "+b[i]+"\n";
		}
		if(n==1) {
			resultado+="\nLa solución del sistema es:\nx_1 = "+(b[0]/matriz[0][0]);
			return;
		}
		double inv[][] = new double[n][n];
		double resp[]= new double[n];
		inv = inversa(n,matriz);

		resultado+="\nLa solución del sistema es\n";
		for(i=0; i<n; i++) {
			for(j=0; j<n; j++) {
				resp[i]+=inv[i][j]*b[j];
			}
			resultado+="x_"+(i+1)+" = "+redondear(resp[i])+"\n";
		}
	}
	
	double cofactor(int n, double matriz[][], int fila, int columna){
		int tam=n-1;
		double matrizAux[][] = new double[n][n];
		int signo=1, filAux=0, colAux=0;
		double cof=0.0;
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (fila!=i && columna!=j){
					matrizAux[filAux][colAux]=matriz[i][j];
					colAux++;
					if(colAux>=tam){
						colAux=0;
						filAux++;
					}
				}
			}
		}
		if ((fila+columna)%2==1){
			signo=-1;
		}
		cof = signo*determinante(tam, matrizAux);
		return cof;
	}
	
	double[][] traspuesta(int n, double matrizA[][]){
		double matrizC[][]=new double[n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				matrizC[j][i]=matrizA[i][j];
			}
		}
		return matrizC;
	}

	double[][] inversa(int n, double matrizA[][]){
		double det = determinante(n, matrizA);
		double matrizCof[][] = new double[n][n];
		int i, j;
		for (i=0; i<n; i++){
			for (j=0; j<n; j++){
				matrizCof[i][j]=cofactor(n,matrizA,i,j);
			}
		}
		matrizCof = traspuesta(n,matrizCof);
		resultado += "\nLa matriz inversa es:\n";
		for (i=0; i<n; i++){
			for (j=0; j<n; j++){
				matrizCof[i][j]/=det;
				resultado+=redondear(matrizCof[i][j])+"\t";
				//System.out.print(matrizCof[i][j]+"\t");
			}
			resultado+="\n";
			//System.out.println("");
		}
		return matrizCof;
	}
	
	double determinante(int n, double matriz[][]){
		double det=0;
		if (n==2){
			det= (matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0]);
		}
		else if (n==1){
			det=matriz[0][0];
		}
		else {
			for (int i=0; i<n; i++){
				det+=matriz[0][i]*cofactor(n, matriz,0,i);
			}
		}
		return det;
	}
	
	
}
