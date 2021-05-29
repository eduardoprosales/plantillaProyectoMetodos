package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class MenuUnidad1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private VentanaBiseccion vBiseccion;
	private VentanaNewton vNewton;
	private VentanaSecante vSecante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			MenuUnidad1 dialog = new MenuUnidad1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuUnidad1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Escoge un m\u00E9todo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(154, 11, 131, 20);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnNewButton = new JButton("Biseccion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a Biseccion
				JOptionPane.showMessageDialog(null, "MÉTODO DE BISECCIÓN:\n"
										+ "El metodo se aplica dentro de un intervalo [a,b] donde \n"
										+ "f es continua. Si f(a) y f(b) tienen signos diferentes, \n"
										+ "significa que existe al menos una raíz en el intervalo. \n"
										+ "En cada iteración, el intervalo se divide a la mitad \n"
										+ "en c, de manera que al evaluar la función en \n"
										+ "los extremos del nuevo intervalo [a,c] o [b,c], esta siga \n"
										+ "teniendo signos diferentes. El método itera hasta aproximar una raíz \n"
										+ "o tras un número determinado de repeticiones");
				vBiseccion = new VentanaBiseccion();
				vBiseccion.setVisible(true);
			}
		});
		btnNewButton.setBounds(170, 70, 115, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewton = new JButton("Newton");
		btnNewton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a Newton
				JOptionPane.showMessageDialog(null, "MÉTODO DE NEWTON - RAPHSON\n"
										+ "Se basa en la afirmación de que la función y \n"
										+ "su derivada son continuas en la raiz. El método comienza \n"
										+ "planteando un valor inicial x_0 y obteniendo el valor de \n"
										+ "x_1 en el que la recta tangente que pasa por \n"
										+ "x_0 se intersecta con el eje x. Dicho valor corresponde \n"
										+ "a una aproximación de la raíz de f, por lo \n"
										+ "que el método puede repetirse partiendo de este valor. La \n"
										+ "fórmula para calcular el nuevo valor de x es:\n"
										+ "x_(n+1) = x_n-(f(x_n)/f'(x_n))\n"
										+ "El método itera hasta aproximar una raíz o tras un \n"
										+ "número determinado de repeticiones.");
				vNewton = new VentanaNewton();
				vNewton.setVisible(true);
			}
		});
		btnNewton.setBounds(170, 132, 115, 23);
		contentPanel.add(btnNewton);
		
		JButton btnSecante = new JButton("Secante");
		btnSecante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a secante
				JOptionPane.showMessageDialog(null, "MÉTODO DE LA SECANTE\n"
										+ "El método toma dos puntos x_0 y x_1 y calcula \n"
										+ "la pendiente de la recta tangente a x_0. Dicha pendiente \n"
										+ "es una aproximación de f'(x_0), por lo que puede sustituirse \n"
										+ "en la fórmula del método de Newton, teniendo como resultado \n"
										+ "una nueva fórmula:\n"
										+ "x_{n+1} = x_{n-1}-f(x_{n-1})[(x_n-x_{n-1})/(f(x_n)-f(x_{n-1}))]\n"
										+ "El método itera hasta aproximar una raíz o tras un\n"
										+ "número determinado de repeticiones");
				vSecante = new VentanaSecante();
				vSecante.setVisible(true);
			}
		});
		btnSecante.setBounds(170, 194, 115, 23);
		contentPanel.add(btnSecante);
		
		JTextPane txtpnTodosLosMtodos = new JTextPane();
		txtpnTodosLosMtodos.setBackground(SystemColor.control);
		txtpnTodosLosMtodos.setText("Todos los m\u00E9todos funcionan para hallar ra\u00EDces de f(x)=x*sen(x)*ln(x)+1");
		txtpnTodosLosMtodos.setEditable(false);
		txtpnTodosLosMtodos.setBounds(10, 39, 414, 20);
		contentPanel.add(txtpnTodosLosMtodos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Regresar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
