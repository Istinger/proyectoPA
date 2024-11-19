package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LogicProgresoSocio;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewProgresoSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_listar;
	public JButton btn_regresar;

	public ViewProgresoSocio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 621, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(24, 11, 587, 241);
		panel.add(list);
		
		btn_listar = new JButton("LISTAR");
		btn_listar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_listar.setBounds(123, 265, 129, 49);
		panel.add(btn_listar);
		
		btn_regresar = new JButton("REGRESAR");
		btn_regresar.setBounds(366, 263, 141, 49);
		panel.add(btn_regresar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenuSocio menu = new ViewMenuSocio();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
			}
		});
		
		new LogicProgresoSocio(this);

	}
	
	

}
