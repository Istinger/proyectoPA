package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewAdmin;
import Controller.LogicViewRegister_Empleados;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class ViewRegister_empleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_name;
	public JTextField txt_cedula;
	public JTextField txt_Email;
	public JTextField txt_telefono;
	public JTextField txt_direccion;
	public JButton btn_registrar;
	public JTextField txt_edad;
	public JTextField txt_rol;
	public JTextField txt_password;


	public ViewRegister_empleados() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Name = new JLabel("Nombre completo:");
		lbl_Name.setBounds(28, 36, 91, 14);
		contentPane.add(lbl_Name);
		
		JLabel lbl_Cedula = new JLabel("Cedula:");
		lbl_Cedula.setBounds(28, 70, 91, 14);
		contentPane.add(lbl_Cedula);
		
		JLabel lbl_Edad = new JLabel("Edad:");
		lbl_Edad.setBounds(28, 95, 91, 14);
		contentPane.add(lbl_Edad);
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setBounds(28, 136, 91, 14);
		contentPane.add(lbl_Email);
		
		JLabel lbl_Telefono = new JLabel("Telefono:");
		lbl_Telefono.setBounds(28, 217, 91, 14);
		contentPane.add(lbl_Telefono);
		
		JLabel lbl_Email_2 = new JLabel("Direccion:");
		lbl_Email_2.setBounds(28, 253, 91, 14);
		contentPane.add(lbl_Email_2);
		
		JLabel lbl_Rol = new JLabel("Rol:");
		lbl_Rol.setBounds(28, 298, 49, 14);
		contentPane.add(lbl_Rol);
		
		btn_registrar = new JButton("Registrar");
		btn_registrar.setBounds(147, 395, 89, 23);
		contentPane.add(btn_registrar);
		
		txt_name = new JTextField();
		txt_name.setBounds(199, 33, 96, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_cedula = new JTextField();
		txt_cedula.setColumns(10);
		txt_cedula.setBounds(199, 67, 96, 20);
		contentPane.add(txt_cedula);
		
		txt_Email = new JTextField();
		txt_Email.setBounds(199, 133, 96, 20);
		contentPane.add(txt_Email);
		txt_Email.setColumns(10);
		
		txt_telefono = new JTextField();
		txt_telefono.setBounds(199, 214, 96, 20);
		contentPane.add(txt_telefono);
		txt_telefono.setColumns(10);
		
		txt_direccion = new JTextField();
		txt_direccion.setBounds(199, 250, 96, 20);
		contentPane.add(txt_direccion);
		txt_direccion.setColumns(10);
		
		txt_edad = new JTextField();
		txt_edad.setColumns(10);
		txt_edad.setBounds(199, 98, 96, 20);
		contentPane.add(txt_edad);
		
		JLabel lbl_password = new JLabel("Contraseña");
		lbl_password.setBounds(28, 177, 91, 14);
		contentPane.add(lbl_password);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		txt_password.setBounds(199, 174, 96, 20);
		contentPane.add(txt_password);
		
		txt_rol = new JTextField();
		txt_rol.setColumns(10);
		txt_rol.setBounds(199, 295, 96, 20);
		contentPane.add(txt_rol);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicViewRegister_Empleados(this);
	}
}
