package TP3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ejercicio1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNacimiento;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio1 frame = new ejercicio1();
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
	public ejercicio1() {
		setTitle("CONTACTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(110, 41, 82, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(110, 77, 82, 14);
		contentPane.add(lblApellido);

		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(110, 113, 82, 14);
		contentPane.add(lblTelefono);

		JLabel lblFechaNac = new JLabel("FECHA NAC.");
		lblFechaNac.setBounds(110, 154, 82, 14);
		contentPane.add(lblFechaNac);

		txtNombre = new JTextField();
		txtNombre.setBounds(238, 41, 149, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(238, 77, 149, 20);
		contentPane.add(txtApellido);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(238, 113, 149, 20);
		contentPane.add(txtTelefono);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(238, 154, 149, 20);
		contentPane.add(txtFechaNacimiento);

		JLabel lblDatosIngresados = new JLabel("Los datos ingresados fueron: ");
		lblDatosIngresados.setBounds(10, 250, 182, 14);
		contentPane.add(lblDatosIngresados);

		JLabel lblDatos = new JLabel("");
		lblDatos.setBounds(191, 250, 316, 14);
		contentPane.add(lblDatos);

		
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!validaciones.verificarCampos(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), txtFechaNacimiento.getText())) {
					lblDatos.setText(txtApellido.getText() + ", " + txtNombre.getText() + ". Telefono: " + txtTelefono.getText() + ". Fecha Nac: " + txtFechaNacimiento.getText());
					limpiarTextBoxs();
				} else {
					validarTextBoxCompleto(txtNombre.getText(), txtNombre);
					validarTextBoxCompleto(txtApellido.getText(), txtApellido);
					validarTextBoxCompleto(txtTelefono.getText(), txtTelefono);
					validarTextBoxCompleto(txtFechaNacimiento.getText(), txtFechaNacimiento);
				}
			}

		});
		btnMostrar.setBounds(268, 202, 114, 23);
		contentPane.add(btnMostrar);

	}

	protected void validarTextBoxCompleto(String dato, JTextField campo) {
		if (dato.trim().isEmpty() || dato == null) {
			campo.setBackground(Color.red);
		} else {
			campo.setBackground(Color.white);
		}
	}

	protected void limpiarTextBoxs() {
		txtApellido.setText(null);
		txtNombre.setText(null);
		txtTelefono.setText(null);
		txtFechaNacimiento.setText(null);
		txtNombre.setBackground(Color.white);
		txtApellido.setBackground(Color.white);
		txtTelefono.setBackground(Color.white);
		txtFechaNacimiento.setBackground(Color.white);
	}
}
