package proyectoMetodos.frontend;
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import proyectoMetodos.backend.Inversa;

public class VentanaInversa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Inversa i;
	private JTextField textField;
	private int n;
	private double coeficientes[][];
	private double b[];
	private int c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaInversa dialog = new VentanaInversa();
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
	public VentanaInversa() {
		setBounds(100, 100, 398, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			final JLabel lblNewLabel_1 = new JLabel("Ingrese el tamano de la matriz de coeficientes");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(18, 39, 341, 17);
			contentPanel.add(lblNewLabel_1);
		{
			JLabel lblNewLabel = new JLabel("M\u00E9todo de la matriz inversa");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 11, 357, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(190, 67, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		c = -1;
		final JLabel lblNewLabel_2 = new JLabel("n =");
		lblNewLabel_2.setBounds(127, 70, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblNewLabel_2);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 97, 362, 167);
			contentPanel.add(scrollPane);
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
						if(c<0) {
							try {
								n = Integer.parseInt(textField.getText());
							}
							catch (NumberFormatException ex) {
				            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en x_0");
				            	return;
				            }
							if(n<=0) {
								JOptionPane.showMessageDialog(null, "El tamaño sólo puede ser positivo. Introduce un nuevo indice");
								return;
							}
							c++;
							coeficientes = new double[n][n];
							b = new double[n];
							lblNewLabel_1.setText("Ingrese la variable x_"+(c%n+1)+" de la ecuacion "+(c/n+1));
							lblNewLabel_2.setText("A["+(c/n+1)+"]["+(c%n+1)+"]: ");
							textField.setText("");
							return;
						}
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
						i = new Inversa(n,coeficientes,b);
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
