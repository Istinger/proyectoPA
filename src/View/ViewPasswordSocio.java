package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicPasswordSocio;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class ViewPasswordSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPasswordField lastPassword;
	public JPasswordField newPassword;
	public JButton btn_guardar;
	private String UserID;


	public ViewPasswordSocio(String userID) {
		this.UserID = userID;
		setTitle("Contraseña");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 382, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 367, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Antigua Contraseña:");
		lblNewLabel.setBounds(42, 66, 113, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nueva contraseña:");
		lblNewLabel_1.setBounds(42, 127, 113, 26);
		panel.add(lblNewLabel_1);
		
		lastPassword = new JPasswordField();
		lastPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lastPassword.setBounds(162, 69, 119, 23);
		panel.add(lastPassword);
		
		newPassword = new JPasswordField();
		newPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		newPassword.setBounds(165, 129, 116, 24);
		panel.add(newPassword);
		
		btn_guardar = new JButton("Guardar");
		btn_guardar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_guardar.setBounds(162, 184, 105, 23);
		panel.add(btn_guardar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenuSocio menu = new ViewMenuSocio();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicPasswordSocio(this,UserID);
		
	}

}
