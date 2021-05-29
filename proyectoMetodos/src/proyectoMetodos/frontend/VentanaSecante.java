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

import proyectoMetodos.backend.Biseccion;
import proyectoMetodos.backend.Secante;

public class VentanaSecante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private Secante s;
	private double x1, x2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaSecante dialog = new VentanaSecante();
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
	public VentanaSecante() {
		setBounds(100, 100, 464, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Ingrese valores de x_0 y x_1:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(139, 39, 170, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("M\u00E9todo de la Secante");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(124, 11, 200, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(122, 67, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			textField_1 = new JTextField();
			textField_1.setBounds(326, 67, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		
		JLabel lblNewLabel_2 = new JLabel("x_0=");
		lblNewLabel_2.setBounds(66, 70, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("x_1=");
		lblNewLabel_3.setBounds(278, 70, 46, 14);
		contentPanel.add(lblNewLabel_3);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 97, 428, 167);
			contentPanel.add(scrollPane);
				final JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ejecutar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							x1 = Double.parseDouble(textField.getText());
						}
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en x_0");
			            	return;
			            }
						try {
							x2 = Double.parseDouble(textField_1.getText());
						}
						catch (NumberFormatException ex) {
			            	JOptionPane.showMessageDialog(null, "Introduce un valor numérico en x_1");
			            	return;
			            }
						if(x1==x2) {
							JOptionPane.showMessageDialog(null, "Introduce valores diferentes de x_0 y x_1");
							return;
						}
						s = new Secante(x1,x2);
						textArea.setText(s.getResultado());
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
