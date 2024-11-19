package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewLoginSocio;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ViewLoginSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_User;
	public JPasswordField pass_Socio; 
	private JPanel panel;
	public JButton btnCrear;
	public JButton btnIngresar;


	public ViewLoginSocio() {
		setTitle("Login Socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 541, 313);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA:");
		lblContrasea.setBounds(68, 110, 135, 42);
		panel.add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setBounds(68, 47, 135, 42);
		panel.add(lblNewLabel);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(114, 201, 89, 23);
		panel.add(btnCrear);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(236, 201, 89, 23);
		panel.add(btnIngresar);
		
		txt_User = new JTextField();
		txt_User.setBounds(149, 57, 147, 23);
		panel.add(txt_User);
		txt_User.setColumns(10);
		
		pass_Socio = new JPasswordField();
		pass_Socio.setBounds(149, 121, 121, 20);
		panel.add(pass_Socio);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicViewLoginSocio(this);
		
	}
	
}
