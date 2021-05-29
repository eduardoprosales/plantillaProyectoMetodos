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

public class MenuUnidad3 extends JDialog{
	private VentanaDoolitle vDoolitle;
	private VentanaCrout vCrout;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuUnidad3 dialog = new MenuUnidad3();
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
	public MenuUnidad3() {
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
		
		JButton btnNewButton = new JButton("Factorización Doolitle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, " FACTORIZACIÓN DOOLITTLE\n"
						+ "Es un método que ocupa la factorización LU.\n"
						+ "Los valores de las incógnitas se obtienen creando un\n"
						+ "sistema de ecuaciones auxiliar con la matriz triangular\n"
						+ "inferior, al obtener los valores de cada incógnita,\n"
						+ "se sustituyen como resultado del sistema de ecuaciones,\n"
						+ "formado por la matriz triangular superior y se obtienen\n"
						+ "los valores buscados\n");
				vDoolitle = new VentanaDoolitle();
				vDoolitle.setVisible(true);
			}
		});
		btnNewButton.setBounds(126, 72, 197, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnCrout = new JButton("Factorización Crout");
		btnCrout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "FACTORIZACIÓN CROUT\n"
						+ "Este método al igual que el Doolittle ocupa la factorización LU\n"
						+ " para resolver el sistema de ecuaciones, en este metodo la \n"
						+ " la matrz U tiene valores de uno en la diagonal   ");
				vCrout = new VentanaCrout();
				vCrout.setVisible(true);
			}
		});
		btnCrout.setBounds(126, 134, 197, 23);
		contentPanel.add(btnCrout);
		
		
		JTextPane txtpnTodosLosMtodos = new JTextPane();
		txtpnTodosLosMtodos.setBackground(SystemColor.control);
		txtpnTodosLosMtodos.setText("Todos los metodos funcionan para matrices de 3x3");
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
