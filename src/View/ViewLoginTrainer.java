package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Controller.LogicLoginTrainer;


import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ViewLoginTrainer extends JFrame{
	public JTextField txt_usuario;
	public  JPasswordField txt_password;
	public  JButton btn_ingresar;
	
	public ViewLoginTrainer() {
		setTitle("Login");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 302);
		getContentPane().setLayout(null);
		
		JLabel lbl_user = new JLabel("USUARIO");
		lbl_user.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_user.setBounds(29, 34, 99, 25);
		getContentPane().add(lbl_user);
		
		JLabel lbl_user_1 = new JLabel("Contraseña");
		lbl_user_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_user_1.setBounds(29, 83, 99, 25);
		getContentPane().add(lbl_user_1);
		
		txt_usuario = new JTextField();
		txt_usuario.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_usuario.setBounds(158, 34, 165, 25);
		getContentPane().add(txt_usuario);
		txt_usuario.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_password.setBounds(158, 83, 165, 25);
		getContentPane().add(txt_password);
				
		btn_ingresar = new JButton("Ingresar");
		btn_ingresar.setToolTipText("");
		btn_ingresar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_ingresar.setBounds(215, 171, 107, 39);
		getContentPane().add(btn_ingresar);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		
		new LogicLoginTrainer(this);
		
	}
}
