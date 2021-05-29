package proyectoMetodos.frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Menu {

	private JFrame frame;
	private MenuUnidad1 m1;
	private MenuUnidad2 m2;
	private MenuUnidad3 m3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JOptionPane.showMessageDialog(null, "\t\t********** UNAM **********\n\n"
				+ "FACULTAD DE ESTUDIOS SUPERIORES ACATLÁN\n\n	"
				+ "\tMAC\n\n"
				+ "Materia: MÉTODOS NUMERICOS\n\n"
				+ "Integrantes\n"
				+ "Perez Rosales Eduardo\n"
				+ "Pizano Castillo Cecilia\n"
				+ "Fecha Enero 2021");
		JOptionPane.showMessageDialog(null, "INTRODUCCIÓN A LOS MÉTODOS NUMÉRICOS:\n"
				+ "Los métodos numéricos son técnicas mediante las cuales es posible\n "
				+ "formular problemas matemáticos de tal forma que puedan resolverse usando\n"
				+ "operaciones aritméticas. Son algoritmos mediante los cuales se obtiene, de\n"
				+ "manera aproximada, la solución de ciertos problemas realizando cálculos aritméticos\n"
				+ "y lógicos (operaciones aritméticas elementales, cálculo de funciones, tablas de\n"
				+ "valores, cálculo proposicional, etc.).");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		m1 = new MenuUnidad1();
		
		JLabel lblNewLabel = new JLabel("Escoge una unidad");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(137, 11, 163, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ecuaciones no lineales");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introducción a la unidad 1
				JOptionPane.showMessageDialog(null, "SOLUCIÓN NUMÉRICA DE ECUACIONES NO LINEALES DE UNA SOLA VARIABLE\n"
										+ "Los valores de x que solucionan cualquier ecuación f(x)=0 son\n"
										+ "llamados raíces o soluciones. Muchas ecuaciones no admiten que su \n"
										+ "solucion pueda ser expresada a traves de métodos exactos. \n"
										+ "Para aproximar una solución, se utilizarán tecnicas iterativas, \n"
										+ "es decir, métodos que inician de una aproximación inicial \n"
										+ "de la raíz de f y posteriormente construiremos una sucesión \n"
										+ "de números reales que converja hacia la solución con cada iteración");
				m1.setVisible(true);
			}
		});
		btnNewButton.setBounds(95, 42, 250, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSistemasDeEcuaciones = new JButton("Sistemas de Ecuaciones Lineales");
		btnSistemasDeEcuaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introducción a la Unidad 2
				JOptionPane.showMessageDialog(null, "SISTEMAS DE ECUACIONES LINEALES (SEL)\n"
										+ "Un sistema de ecuaciones lineales es un conjunto de dos\n"
										+ "o mas ecuaciones de grado 1 con dos o más incógnitas relacionadas \n"
										+ "entre sí. La solución de un sistema de ecuaciones lineales \n"
										+ "es un conjunto de valores que satisfacen todas las ecuaciones \n"
										+ "al mismo tiempo. Cada sistema de ecuaciones lineales puede expresarse\n"
										+ "como una multiplicacion de matrices Ax=b, donde A es la\n"
										+ "matriz de coeficientes del sistema, x es el vector de \n"
										+ "incógnitas y b es el vector de términos independientes. Solucionar \n"
										+ "el sistema consiste en encontrar los valores de los componentes \n"
										+ "del vector x que satisfacen dicho producto.");
				m2 = new MenuUnidad2();
				m2.setVisible(true);
			}
		});
		btnSistemasDeEcuaciones.setBounds(95, 100, 250, 23);
		frame.getContentPane().add(btnSistemasDeEcuaciones);
		//*******
		

		JButton btnFactorizacionLU = new JButton("Factorización LU");
		btnFactorizacionLU .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "FACTORIZACIÓN LU\n"
						+ "El esquema de descomposición LU es una transformación\n"
						+ "de una matriz A como producto de dos matrices\n"
						+ " \tA = LU\n"
						+ "donde L es una matriz triangular inferior y U es una\n"
						+ "matriz triangular superior. Lo que genera dos \n"
						+ "sistemas, y para obtener la solución del sistema \n"
						+ "se resuelve por medio de sustitución progresiva\n"
						+ "y sustitución regresiva, los sistemas generados\n");
				m3 = new MenuUnidad3();
				m3.setVisible(true);
			}
		});
		btnFactorizacionLU.setBounds(95, 160, 250, 23);
		frame.getContentPane().add(btnFactorizacionLU );
		
		
	}
}
