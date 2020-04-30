package TP3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pantallaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaPrincipal frame = new pantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pantallaPrincipal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("GRUPO NRO: 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 38, 134, 24);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("EJERCICIO 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejercicio1 ej1 = new ejercicio1();
				ej1.show();
			}
		});
		btnNewButton.setBounds(155, 93, 114, 23);
		contentPane.add(btnNewButton);

		JButton btnEjercicio = new JButton("EJERCICIO 2");
		btnEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ejercicio2 ej2 = new ejercicio2();
				ej2.show();
			}
		});
		btnEjercicio.setBounds(155, 141, 114, 23);
		contentPane.add(btnEjercicio);

		JButton btnEjercicio_1 = new JButton("EJERCICIO 3");
		btnEjercicio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejercicio3 ej3 = new ejercicio3();
				ej3.show();
			}
		});
		btnEjercicio_1.setBounds(155, 191, 114, 23);
		contentPane.add(btnEjercicio_1);
	}
}
