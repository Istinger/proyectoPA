package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicViewListar_Empleados;
import Controller.LogicViewPanelAdmin;
import Controller.LogicViewRegister_Empleados;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Viewpanel_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_listar;
	public JButton btn_registrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewpanel_Admin frame = new Viewpanel_Admin();
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
	public Viewpanel_Admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_registrar = new JButton("");
		btn_registrar.setIcon(new ImageIcon(Viewpanel_Admin.class.getResource("/imgs/icons8-registro-100.png")));
		btn_registrar.setBounds(41, 47, 133, 109);
		contentPane.add(btn_registrar);
		
		btn_listar = new JButton("");
		btn_listar.setIcon(new ImageIcon(Viewpanel_Admin.class.getResource("/imgs/icons8-lista-100.png")));
		btn_listar.setBounds(242, 47, 133, 109);
		contentPane.add(btn_listar);
		
		JLabel lbl_registeremple = new JLabel("Registrar empleados");
		lbl_registeremple.setBounds(61, 181, 113, 46);
		contentPane.add(lbl_registeremple);
		
		JLabel lbl_listar = new JLabel("Listar Empleados");
		lbl_listar.setBounds(250, 181, 113, 46);
		contentPane.add(lbl_listar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicViewPanelAdmin(this);

	}

}
