package View;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicMenuSocio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewMenuSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_name;
	public  JTextField txt_id;
	public  JTextField txt_phone;
	public  JTextField txt_plan;
	public  JButton btn_Progreso;
	public  JButton btn_Password;


	public ViewMenuSocio() {
		setTitle("Menu Socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 499, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo: ");
		lblNombreCompleto.setBounds(31, 58, 92, 19);
		panel.add(lblNombreCompleto);
		
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setBounds(31, 100, 60, 14);
		panel.add(lblCdula);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(31, 140, 60, 14);
		panel.add(lblTelfono);
		
		JLabel lblPlanDeMembresia = new JLabel("Plan de Membresia:");
		lblPlanDeMembresia.setBounds(31, 177, 136, 30);
		panel.add(lblPlanDeMembresia);
		
		JLabel lblNotasDeProgreso = new JLabel("Notas de progreso físico");
		lblNotasDeProgreso.setBounds(292, 216, 163, 30);
		panel.add(lblNotasDeProgreso);
		
		txt_name = new JTextField();
		txt_name.setBounds(143, 57, 121, 20);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(76, 97, 121, 20);
		panel.add(txt_id);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(86, 137, 121, 20);
		panel.add(txt_phone);
		
		txt_plan = new JTextField();
		txt_plan.setColumns(10);
		txt_plan.setBounds(131, 182, 121, 20);
		panel.add(txt_plan);
		
		btn_Progreso = new JButton("Ver progreso");
		btn_Progreso.setBounds(302, 257, 121, 30);
		panel.add(btn_Progreso);
		
		btn_Password = new JButton("Cambiar Contraseña");
		btn_Password.setBounds(290, 301, 136, 30);
		panel.add(btn_Password);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenu menu = new ViewMenu();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicMenuSocio(this);
	}

}
