package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_trainer;
	public JButton btn_socio;
	public JButton btn_admin;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu frame = new ViewMenu();
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
	public ViewMenu() {
		setTitle("Menu");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_trainer = new JButton("");
		btn_trainer.setIcon(new ImageIcon(ViewMenu.class.getResource("/imgs/Dumbell 100.png")));
		btn_trainer.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_trainer.setBounds(406, 47, 141, 94);
		panel.add(btn_trainer);
		
		btn_socio = new JButton("");	
		btn_socio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_socio.setIcon(new ImageIcon(ViewMenu.class.getResource("/imgs/icons8-colaborando-en-circulo-100.png")));
		btn_socio.setBounds(213, 47, 170, 94);
		panel.add(btn_socio);
		
		btn_admin = new JButton("");
		btn_admin.setIcon(new ImageIcon(ViewMenu.class.getResource("/imgs/icons8-administrador-94.png")));
		btn_admin.setBounds(43, 47, 127, 94);
		panel.add(btn_admin);
		
		JLabel lbl_trainer = new JLabel("Entrenador");
		lbl_trainer.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_trainer.setBounds(278, 160, 89, 42);
		panel.add(lbl_trainer);
		new LogicViewMenu(this);
	}
}
