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

import proyectoMetodos.backend.GaussSeidel;
import proyectoMetodos.backend.Jacobi;

public class VentanaGaussSeidel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private GaussSeidel j;
	
	private int c,n=3;
	private double x[]= new double[n];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaGaussSeidel dialog = new VentanaGaussSeidel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaGaussSeidel() {
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
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
			JLabel lblNewLabel = new JLabel("M\u00E9todo de Gauss-Seidel");
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
		c = 0;
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
		//ejecutar
				{
					JPanel buttonPane = new JPanel();
					buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
					getContentPane().add(buttonPane, BorderLayout.SOUTH);
					{
						JButton okButton = new JButton("Ejecutar");
						
						okButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
			
				
							//	lblNewLabel_2.setText("x["+(c+1%n)+"]: ");
								
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
								else {
									lblNewLabel_2.setText("");
								}
							}
								
								
								
						j = new GaussSeidel(x);
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