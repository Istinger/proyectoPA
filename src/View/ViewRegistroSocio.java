package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewRegisterSocio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.List;

public class ViewRegistroSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_name;
	public JTextField txt_id;
	public JTextField txt_age;
	public JTextField txt_mail;
	public JTextField txt_phone;
	public JTextField txt_address;
	public JPanel panel;
	public JButton btn_registrar;
	public JTextField txt_membresia;
	public JButton btn_cancelar;


	public ViewRegistroSocio() {
		setTitle("REGISTRO DE SOCIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 561, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Completo: ");
		lblNewLabel.setBounds(38, 68, 116, 20);
		panel.add(lblNewLabel);
		
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setBounds(25, 113, 72, 14);
		panel.add(lblCdula);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(25, 157, 72, 14);
		panel.add(lblEdad);
		
		JLabel txt_email = new JLabel("Email:");
		txt_email.setBounds(25, 195, 72, 14);
		panel.add(txt_email);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(25, 235, 72, 14);
		panel.add(lblTelfono);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(25, 271, 72, 14);
		panel.add(lblDireccin);
		
		JLabel lblNewLabel_6_1 = new JLabel("Plan de membresia:");
		lblNewLabel_6_1.setBounds(25, 307, 116, 20);
		panel.add(lblNewLabel_6_1);
		
		txt_name = new JTextField();
		txt_name.setBounds(157, 66, 131, 25);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(68, 110, 131, 25);
		panel.add(txt_id);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(68, 154, 131, 25);
		panel.add(txt_age);
		
		txt_mail = new JTextField();
		txt_mail.setColumns(10);
		txt_mail.setBounds(68, 192, 131, 25);
		panel.add(txt_mail);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(90, 232, 131, 25);
		panel.add(txt_phone);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(90, 268, 131, 25);
		panel.add(txt_address);
		
		btn_registrar = new JButton("Registar");
		btn_registrar.setBounds(368, 219, 89, 23);
		panel.add(btn_registrar);
		
		txt_membresia = new JTextField();
		txt_membresia.setColumns(10);
		txt_membresia.setBounds(129, 307, 131, 25);
		panel.add(txt_membresia);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(368, 267, 89, 23);
		panel.add(btn_cancelar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewLoginSocio menu = new ViewLoginSocio();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicViewRegisterSocio(this);
	}
}
