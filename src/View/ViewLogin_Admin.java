package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewAdmin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class ViewLogin_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_usuario;
	public JPasswordField txt_pasword;
	public JButton btn_ingreso;

	
	public ViewLogin_Admin() {
		setTitle("LOGIN ADMIN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setBounds(25, 36, 49, 14);
		contentPane.add(lbl_usuario);
		
		JLabel lbl_pasword = new JLabel("Contraseña:");
		lbl_pasword.setBounds(25, 92, 70, 14);
		contentPane.add(lbl_pasword);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(125, 33, 96, 20);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		txt_pasword = new JPasswordField();
		txt_pasword.setBounds(123, 89, 98, 20);
		contentPane.add(txt_pasword);
		
		btn_ingreso = new JButton("Ingresar");
		btn_ingreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ingreso.setBounds(290, 186, 89, 23);
		contentPane.add(btn_ingreso);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicViewAdmin(this);
	}
}
