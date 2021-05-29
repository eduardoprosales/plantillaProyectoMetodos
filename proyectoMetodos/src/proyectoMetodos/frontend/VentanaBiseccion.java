package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyectoMetodos.backend.Biseccion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaBiseccion extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private Biseccion b;//declara objeto de tipo biseccion
	private double lim1, lim2;//valores que recibe

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaBiseccion dialog = new VentanaBiseccion();
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
	public VentanaBiseccion() {
		setBounds(100, 100, 677, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese valores de a y b:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(245, 39, 170, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("M\u00E9todo de bisecci\u00F3n");//nombre de la ventana
			lblNewLabel.setBounds(260, 11, 140, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(167, 69, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			textField_1 = new JTextField();
			textField_1.setBounds(411, 69, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		//etiquetas de entrada
		JLabel lblNewLabel_2 = new JLabel("a=");
		lblNewLabel_2.setBounds(111, 72, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("b=");
		lblNewLabel_3.setBounds(355, 75, 46, 14);
		contentPanel.add(lblNewLabel_3);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 97, 641, 167);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
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
						//manda llamar metodo
						//linea que puede dar error
						try {
							lim1 = Double.parseDouble(textField.getText());
						}
						//dentro del parentesis va el error esperado y dentro va la accion a realizar
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en a");
			            	return;
			            }
						try {
							lim2 = Double.parseDouble(textField_1.getText());
						}
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en b");
			            	return;
			            }
						if(lim1==lim2) {
							JOptionPane.showMessageDialog(null, "Introduce valores diferentes de a y b");
							return;
						}
						b = new Biseccion(lim1,lim2);
						//
						textArea.setText(b.getResultado());
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
