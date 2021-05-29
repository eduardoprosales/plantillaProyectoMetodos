package proyectoMetodos.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class Portada extends JDialog {
	private JFrame frame;
	private Menu m;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		try {
			Portada dialog = new Portada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Portada() {
		getContentPane().setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 501, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{178, 77, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("UNAM");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
			lblNewLabel.setForeground(new Color(169, 183, 107));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("FACULTAD DE ESTUDIOS SUPERIORES ACATL\u00C1N");
			lblNewLabel_1.setForeground(new Color(189, 183, 107));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 3;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("MAC");
			lblNewLabel_2.setForeground(new Color(189, 183, 107));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("M\u00C9TODOS NUM\u00C9RICOS");
			lblNewLabel_3.setForeground(new Color(189, 183, 107));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("INTEGRANTES");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_4.setForeground(new Color(189, 183, 107));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 6;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("PEREZ ROSALES EDUARDO");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_5.setForeground(new Color(189, 183, 107));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 8;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("PIZANO CASTILLO CECILIA");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_6.setForeground(new Color(189, 183, 107));
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 9;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("Fecha: Enero 2021");
			lblNewLabel_7.setForeground(new Color(189, 183, 107));
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 12;
			contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton cancelButton = new JButton("ok");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						/* JOptionPane.showMessageDialog(null, "INTRODUCCIÓN A LOS MÉTODOS NUMÉRICOS:\n"
									+ "Los métodos numéricos son técnicas mediante las cuales es posible\n "
									+ "formular problemas matemáticos de tal forma que puedan resolverse usando\n"
									+ "operaciones aritméticas. Son algoritmos mediante los cuales se obtiene, de\n"
									+ "manera aproximada, la solución de ciertos problemas realizando cálculos aritméticos\n"
									+ "y lógicos (operaciones aritméticas elementales, cálculo de funciones, tablas de\n"
									+ "valores, cálculo proposicional, etc.).");*/
						dispose();
						
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
			
			
		
		
	
		
	}

}

