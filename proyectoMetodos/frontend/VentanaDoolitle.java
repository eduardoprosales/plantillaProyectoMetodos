package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import proyectoMetodos.backend.Doolitle;
import proyectoMetodos.backend.Jacobi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDoolitle extends JDialog {
	
	private final JPanel contentPanel1 = new JPanel();
	private Doolitle i;
	private JTextField textField;
	private int n=3;
	private double coeficientes[][] = new double [n][n];
	private double b[]=new double[n];
	private int c;
	

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaDoolitle dialog = new VentanaDoolitle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaDoolitle() {
		setBounds(100, 100, 398, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel1, BorderLayout.CENTER);
		contentPanel1.setLayout(null);
			final JLabel lblNewLabel_1 = new JLabel("Ingrese la variable x_"+(c%n+1)+" de la ecuacion "+(c/n+1));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(18, 39, 341, 17);
			contentPanel1.add(lblNewLabel_1);
		{
			JLabel lblNewLabel = new JLabel("Factorización Doolittle");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 11, 357, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel1.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(190, 67, 86, 20);
		contentPanel1.add(textField);
		textField.setColumns(10);
		c = 0;
		final JLabel lblNewLabel_2 = new JLabel("A["+(c/n+1)+"]["+(c%n+1)+"]: ");
		lblNewLabel_2.setBounds(127, 70, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel1.add(lblNewLabel_2);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 97, 362, 167);
			contentPanel1.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				textArea.setLocation(-36, 0);
				scrollPane.setViewportView(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(c>=0 && c<n*n) {
							try {
								coeficientes[c/n][c%n] = Double.parseDouble(textField.getText());
							}
							catch (NumberFormatException ex) {
				            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico");
				            	return;
				            }
							c++;
							lblNewLabel_1.setText("Ingrese la variable x_"+(c%n+1)+" de la ecuacion "+(c/n+1));
							lblNewLabel_2.setText("A["+(c/n+1)+"]["+(c%n+1)+"]: ");
							textField.setText("");
							if(c==n*n) {
								lblNewLabel_1.setText("Ingrese el término independiente de la ecuacion "+(c%n+1));
								lblNewLabel_2.setText("b["+(c%n+1)+"]: ");
								textField.setText("");
							}
							return;
						}
						if(c>=n*n && c<n*(n+1)) {
							try {
								b[c%n] = Double.parseDouble(textField.getText());
							}
							catch (NumberFormatException ex) {
				            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico");
				            	return;
				            }
							c++;
							lblNewLabel_1.setText("Ingrese el término independiente de la ecuacion "+(c%n+1));
							lblNewLabel_2.setText("b["+(c%n+1)+"]: ");
							textField.setText("");
							if(c!=n*(n+1)) {
								return;
							}
						}
						i = new Doolitle(coeficientes,b);
						textArea.setText(i.getResultado());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//metodo para cerrar ventana
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	} 
}