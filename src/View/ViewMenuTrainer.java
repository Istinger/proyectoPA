package View;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.LogicViewMenuTrainer;

public class ViewMenuTrainer extends JFrame {
	public JButton btn_list;
	public JButton btn_registrar;
	public JButton btn_password;
	
	public ViewMenuTrainer() {
		getContentPane().setLayout(null);
		setTitle("Menu Trainer");
		setResizable(false);
		setBounds(100, 100, 390, 302);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btn_list = new JButton("Listar Socios a cargo");
		btn_list.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_list.setBounds(86, 49, 184, 29);
		panel.add(btn_list);
		
		btn_registrar = new JButton("Registrar Progreso");
		btn_registrar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_registrar.setBounds(86, 103, 184, 29);
		panel.add(btn_registrar);
		
		btn_password = new JButton("Cambiar Contrasena");
		btn_password.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_password.setBounds(86, 161, 184, 29);
		panel.add(btn_password);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu vm = new ViewMenu();
				vm.setVisible(true);
				vm.setLocationRelativeTo(null);
			}
		});
		new LogicViewMenuTrainer(this);
		
	}

}
