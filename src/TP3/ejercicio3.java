package TP3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ejercicio3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantHoras;
	private JRadioButton btnWindows, btnMac, btnLinux;
	private JRadioButton btnAdministracion, btnDisenio, btnProgramacion;
	private String sistOperativo, especialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio3 frame = new ejercicio3();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
					                // Se pide una confirmación antes de finalizar el programa
							int option = JOptionPane.showConfirmDialog(
								frame, 
								"¿Estás seguro de que quieres cerrar la aplicación?",
								"Confirmación de cierre", 
								JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
							if (option == JOptionPane.YES_OPTION) {
								frame.hide();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ejercicio3() {
		setTitle("Seleccion multiple");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(34, 41, 174, 14);
		contentPane.add(lblNewLabel);
		
		btnWindows = new JRadioButton("Windows");
		btnWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnWindows.isSelected()) {
					btnLinux.setSelected(false);
					btnMac.setSelected(false);
					sistOperativo = "Windows";
				}

			}
		});
		btnWindows.setBounds(199, 38, 89, 23);
		contentPane.add(btnWindows);

		btnMac = new JRadioButton("Mac");
		btnMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMac.isSelected()) {
					btnLinux.setSelected(false);
					btnWindows.setSelected(false);
					sistOperativo = "Mac";
				}
			}
		});
		btnMac.setBounds(290, 38, 63, 23);
		contentPane.add(btnMac);
		
		btnLinux = new JRadioButton("Linux");
		btnLinux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnLinux.isSelected()) {
					btnMac.setSelected(false);
					btnWindows.setSelected(false);
					sistOperativo = "Linux";
				}
			}
		});
		btnLinux.setBounds(355, 38, 63, 23);
		contentPane.add(btnLinux);
		
		JLabel lblElijeUnaEspecialidad = new JLabel("Elije una especialidad");
		lblElijeUnaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblElijeUnaEspecialidad.setBounds(34, 121, 174, 14);
		contentPane.add(lblElijeUnaEspecialidad);
		
		btnProgramacion = new JRadioButton("Programaci\u00F3n");
		btnProgramacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnProgramacion.isSelected()) {
					btnDisenio.setSelected(false);
					btnAdministracion.setSelected(false);
					especialidad = "Programaci\u00F3n";
				}
			}
		});
		btnProgramacion.setBounds(199, 81, 142, 23);
		contentPane.add(btnProgramacion);

		btnAdministracion = new JRadioButton("Administraci\u00F3n");
		btnAdministracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnAdministracion.isSelected()) {
					btnDisenio.setSelected(false);
					btnProgramacion.setSelected(false);
					especialidad = "Administraci\u00F3n";
				}
			}
		});
		btnAdministracion.setBounds(199, 118, 142, 23);
		contentPane.add(btnAdministracion);

		btnDisenio = new JRadioButton("Dise\u00F1o gr\u00E1fico");
		btnDisenio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnDisenio.isSelected()) {
					btnProgramacion.setSelected(false);
					btnAdministracion.setSelected(false);
					especialidad = "Dise\u00F1o gr\u00E1fico";
				}
			}
		});
		btnDisenio.setBounds(199, 155, 142, 23);
		contentPane.add(btnDisenio);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadDeHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeHoras.setBounds(34, 207, 242, 14);
		contentPane.add(lblCantidadDeHoras);
		
		txtCantHoras = new JTextField();
		txtCantHoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validaciones.validarCampoVacio(txtCantHoras.getText()) && validaciones.validarCampoUnico(txtCantHoras.getText())) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un horario");
				}
			}
		});
		txtCantHoras.setBounds(266, 205, 140, 20);
		contentPane.add(txtCantHoras);
		txtCantHoras.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!validaciones.verificarSistOperativo(btnWindows.isSelected(), btnMac.isSelected(), btnLinux.isSelected())) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un sistema operativo");
					return;
				}if(!validaciones.verificarSistOperativo(btnAdministracion.isSelected(), btnDisenio.isSelected(), btnProgramacion.isSelected())) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una especialidad");
					return;
				}if(validaciones.validarCampoUnico(txtCantHoras.getText()) || validaciones.validarCampoVacio(txtCantHoras.getText())) {
					JOptionPane.showMessageDialog(null, "Ingrese una cantidad de horas valida");
					return;
				}JOptionPane.showMessageDialog(null, sistOperativo + " - " + especialidad + " - " + txtCantHoras.getText());
			}
		});
		btnAceptar.setBounds(317, 246, 89, 23);
		contentPane.add(btnAceptar);
		
	}
}
