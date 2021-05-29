package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import proyectoMetodos.backend.Jacobi;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaJacobi extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private Jacobi j;
	private int c,n=3;
	private double x[] = new double[n];;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaJacobi dialog = new VentanaJacobi();
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
	public VentanaJacobi() {
		setBounds(100, 100, 400, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//texto que pide lo indicado
		{
			final JLabel lblNewLabel_1 = new JLabel("Ingrese vector inicial:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(18, 39, 170, 17);
			contentPanel.add(lblNewLabel_1);
		}
		//nombre del método
		{
			JLabel lblNewLabel = new JLabel("M\u00E9todo de Jacobi");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 11, 357, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);

		}
		
		//espacio donde recibe datos 
		textField = new JTextField();
		textField.setBounds(190, 67, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		c =0;
		
		final JLabel lblNewLabel_2 = new JLabel("x[0] =");
		lblNewLabel_2.setBounds(127, 70, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblNewLabel_2);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 362, 167);
		
		contentPanel.add(scrollPane);
		final JTextArea textArea = new JTextArea();
		textArea.setLocation(-36, 0);
		scrollPane.setViewportView(textArea);
		
		//cuadro de proceso
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 362, 167);
		contentPanel.add(scrollPane);
		final JTextArea textArea = new JTextArea();
		textArea.setLocation(-36, 0);
		scrollPane.setViewportView(textArea);*/
	
	
		
		//ejecutar
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
	
						
				
					//	lblNewLabel_2.setText("x["+(c+2%n)+"]: ");
						
						if(c<n) {
							try {
								x[c] = Double.parseDouble(textField.getText());
							}
							catch (NumberFormatException ex) {
				            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico");
				            	return;
				            }
							lblNewLabel_2.setText("x["+(c+1)+"]: ");
							c++;
							textField.setText("");
						
						if(c!=n) {
							return;
						}
						
					}
						
							
						
						
				j = new Jacobi(x);
				textArea.setText(j.getResultado());
				}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				

			}
			//boton salir
			{
				JButton cancelButton = new JButton("Salir");
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
