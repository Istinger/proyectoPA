package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.LogicListClient;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class ViewListClient extends JFrame {
	public JButton btn_listar;
	public JButton btn_regresar;
	
	public ViewListClient() {
		getContentPane().setLayout(null);
		setTitle("Lista Clientes asignados");
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 390, 302);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 374, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(23, 22, 314, 171);
		panel.add(list);
		
		btn_listar = new JButton("Listar");
		btn_listar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_listar.setBounds(49, 209, 89, 23);
		panel.add(btn_listar);
		
		btn_regresar = new JButton("Regresar");
		btn_regresar.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_regresar.setBounds(213, 209, 89, 23);
		panel.add(btn_regresar);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenuTrainer menutrainer = new ViewMenuTrainer();
				menutrainer.setVisible(true);
				menutrainer.setLocationRelativeTo(null);
			}
		});
		
		new LogicListClient(this);
	}
}
