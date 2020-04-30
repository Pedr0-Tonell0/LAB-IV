package TP3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class ejercicio2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	private JComboBox comboEstado;
	private Label lblCondicion, lblPromedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio2 frame = new ejercicio2();
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
	public ejercicio2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label lblNota1 = new Label("Nota 1:");
		lblNota1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNota1.setBounds(54, 72, 62, 22);
		contentPane.add(lblNota1);
		
		Label lblNota2 = new Label("Nota 2:");
		lblNota2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNota2.setBounds(54, 112, 62, 22);
		contentPane.add(lblNota2);
		
		Label lblNota3 = new Label("Nota 3:");
		lblNota3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNota3.setBounds(54, 152, 62, 22);
		contentPane.add(lblNota3);
		
		Label lblTps = new Label("TPS");
		lblTps.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblTps.setBounds(54, 192, 62, 22);
		contentPane.add(lblTps);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(26, 27, 260, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(6, 16, 248, 182);
		panel_1.add(panel);
		panel.setLayout(null);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(109, 31, 129, 20);
		panel.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(109, 72, 129, 20);
		panel.add(txtNota2);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(109, 110, 129, 20);
		panel.add(txtNota3);
		
		comboEstado = new JComboBox();
		comboEstado.setBounds(109, 151, 129, 20);
		panel.add(comboEstado);
		comboEstado.addItem("Aprobado");
		comboEstado.addItem("Desaprobado");
		
		JButton btnNewButton = new JButton("CALCULAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarNotasEstudiante();
			}
		});
		btnNewButton.setBounds(313, 83, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNota1.setText(null);
				txtNota2.setText(null);
				txtNota3.setText(null);
				txtCondicion.setText(null);
				txtPromedio.setText(null);
			}
		});
		btnNuevo.setBounds(313, 125, 111, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(313, 168, 111, 23);
		contentPane.add(btnSalir);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(26, 247, 260, 143);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 16, 230, 120);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(97, 29, 129, 20);
		panel_2.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		txtCondicion = new JTextField();
		txtCondicion.setBounds(97, 70, 129, 20);
		panel_2.add(txtCondicion);
		txtCondicion.setColumns(10);
		
		lblPromedio = new Label("Promedio:");
		lblPromedio.setBounds(10, 27, 81, 22);
		panel_2.add(lblPromedio);
		lblPromedio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		lblCondicion = new Label("Condicion:");
		lblCondicion.setBounds(10, 68, 81, 22);
		panel_2.add(lblCondicion);
		lblCondicion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
	}

	protected void validarNotasEstudiante() {
		DecimalFormat df = new DecimalFormat("#.00");
		if (validaciones.validarCamposEjercicio2(txtNota1.getText(), txtNota2.getText(), txtNota3.getText())) {
			JOptionPane.showMessageDialog(null, "Existen campos vacios");
			return;
		}
		if (validaciones.validarCamposNumericos(txtNota1.getText(), txtNota2.getText(), txtNota3.getText())) {
			JOptionPane.showMessageDialog(null, "Las notas tienen que ser numericas");
			return;
		}
		if (comboEstado.getSelectedItem().equals("Desaprobado")
				|| validaciones.notasMenorASeis(txtNota1.getText(), txtNota2.getText(), txtNota3.getText())) {
			txtCondicion.setText("Libre");
		}
		if (validaciones.validarAprobado(txtNota1.getText(), txtNota2.getText(), txtNota3.getText())
				&& comboEstado.getSelectedItem().equals("Aprobado")) {
			txtCondicion.setText("Regular");
		}
		if (validaciones.validarPromocion(txtNota1.getText(), txtNota2.getText(), txtNota3.getText())
				&& comboEstado.getSelectedItem().equals("Aprobado")) {
			txtCondicion.setText("Promocionado");
		}
		txtPromedio.setText(String.valueOf(df.format(
				validaciones.promedioDeNotas(txtNota1.getText(), txtNota2.getText(), txtNota3.getText()))));
	}
}
