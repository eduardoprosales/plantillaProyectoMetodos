package proyectoMetodos.backend;

public class Pruebita {
	static int n=3;
	static double coef[][] = {{4,4,1},{9,8,2},{1,0,2}};
	static double b[] = {1,2,3};
	
	public static void main(String[] args) {
		Inversa i = new Inversa(n,coef,b);
		System.out.print(i.getResultado());
	}
	
}
