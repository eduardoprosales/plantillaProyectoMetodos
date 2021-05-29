package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MenuUnidad2 extends JDialog {
	private VentanaInversa vInversa;
	private VentanaJacobi  vJacobi;
	private VentanaGaussSeidel vGaussSeidel;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuUnidad2 dialog = new MenuUnidad2();
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
	public MenuUnidad2() {
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
		
		JButton btnNewButton = new JButton("M\u00E9todo de la matriz inversa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Introduccion a matriz inversa
				JOptionPane.showMessageDialog(null, "MÉTODO DE LA MATRIZ INVERSA\n"
										+ "A partir de la representación matricial de un SEL (Ax=b), \n"
										+ "es posible despejar el vector incógnita multiplicando ambos lados de \n"
										+ "la igualdad por la izquierda por la matriz inversa de\n"
										+ "A, teniendo: \n"
										+ "x=A^{-1}b. \n"
										+ "Este método exacto calcula la matriz inversa de la matriz \n"
										+ "de coeficientes (si es que existe) y la multiplica por \n"
										+ "el vector de términos independientes, mostrando las soluciones obtenidas\n"
										+ "tras el cálculo.");
				vInversa = new VentanaInversa();
				vInversa.setVisible(true);
			}
		});
		btnNewButton.setBounds(126, 72, 197, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewton = new JButton("Jacobi");
		btnNewton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Introduccion - Jacobi\n"
						+ "Es un método iterativo para resolver ecuaciones lineales\n"
						+ " en este método se propone un vector inicial.\n"
						+ "Es condición necesaria que el elemento ubicado en la diagonal principal\n"
						+ " de cada ecuación sea mayor en valor absoluto que la suma del resto de\n elementos de la misma ecuación.\n\n"
						+ "Como ejemplo se realiza el siguiente sistema de ecuaciones:\n"
						+ "4x + 2y + 2z = 3\n"
						+ "\t2x + 2y = 2\n"
						+ "\t2x + 4z = 1 ");
				vJacobi = new VentanaJacobi();
				vJacobi.setVisible(true);
			}
		});
		btnNewton.setBounds(167, 134, 115, 23);
		contentPanel.add(btnNewton);
		
		JButton btnSecante = new JButton("Gauss-Seidel");
		btnSecante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Introducción - Gauss Seidel\n"
						+ "Es un método iterativo utilizado para resolver sistemas de ecuaciones lineales, es similar al método Jacobi\n"
						+ "tiene como condición que la diagonal de la matriz sea dominante.\n Al ser un método iterativo parte de una aproximación, pero a diferencia del método Jacobi, ocupa los valores\n"
						+ " que ya se han calculado para obtener el valor de la siguiente ecuación.\n"
						+ " Como ejemplo se realiza el siguiente sistema de ecuaciones:\n"
						+ "4x + 2y + 2z = 3\n"
						+ "\t2x + 2y = 2\n"
						+ "\t2x + 4z = 1 ");
				vGaussSeidel = new VentanaGaussSeidel();
				vGaussSeidel.setVisible(true);
			}
		});
		btnSecante.setBounds(170, 194, 115, 23);
		contentPanel.add(btnSecante);
		
		JTextPane txtpnTodosLosMtodos = new JTextPane();
		txtpnTodosLosMtodos.setBackground(SystemColor.control);
		txtpnTodosLosMtodos.setText("Resolvamos un sistema de ecuaciones lineales");
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
