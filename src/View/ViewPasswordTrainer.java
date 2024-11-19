package View;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controller.LogicPasswordTrainer;

public class ViewPasswordTrainer extends JFrame{

	public JPasswordField lastpassword;
	public JPasswordField newpassword;
	public JButton btn_savepswrd;
	public JButton btn_cancel;
	private String UserID;
	
	public ViewPasswordTrainer(String userID) {
		this.UserID = userID;
		
		setTitle("Cambiar Contraseña");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 265);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 406, 246);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_lastPassword = new JLabel("Antigua Contraseña");
		lbl_lastPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_lastPassword.setBounds(42, 65, 136, 20);
		panel.add(lbl_lastPassword);
		
		JLabel lbl_newPassword = new JLabel("Nueva Contraseña");
		lbl_newPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_newPassword.setBounds(42, 135, 136, 20);
		panel.add(lbl_newPassword);
		
		lastpassword = new JPasswordField();
		lastpassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lastpassword.setBounds(230, 58, 144, 34);
		panel.add(lastpassword);
		
		newpassword = new JPasswordField();
		newpassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		newpassword.setBounds(230, 129, 144, 34);
		panel.add(newpassword);
		
		btn_savepswrd = new JButton("GUARDAR");
		btn_savepswrd.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_savepswrd.setBounds(152, 191, 117, 29);
		panel.add(btn_savepswrd);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenuTrainer menutrainer = new ViewMenuTrainer();
				menutrainer.setVisible(true);
				menutrainer.setLocationRelativeTo(null);
			}
		});
		
		new LogicPasswordTrainer(this,UserID);
		
	}
}
