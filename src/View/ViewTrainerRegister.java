package View;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;

import Controller.LogicTrainerRegister;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class ViewTrainerRegister extends JFrame {
	public JTextField txt_socio;
	public JTextField txt_peso;
	public JTextField txt_altura;
	public JTextField txt_imc;
	public JButton btn_imc;
	public JTextArea txt_rutina;
	public JButton btn_buscar;
	public JButton btn_guardar;
	public JTextField txt_date;
	public JLabel lbl_peso;
	public JLabel lbl_altura;
	public JLabel lbl_rutina;
	public JCalendar calendar;
	
	public ViewTrainerRegister() {
		setTitle("Registro");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 490);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_socio = new JLabel("Socio a cargo");
		lbl_socio.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_socio.setBounds(6, 30, 87, 31);
		panel.add(lbl_socio);
		
		txt_socio = new JTextField();
		txt_socio.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_socio.setBounds(133, 32, 130, 26);
		panel.add(txt_socio);
		txt_socio.setColumns(10);
		
		lbl_peso = new JLabel("PESO");
		lbl_peso.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_peso.setVisible(false);
		lbl_peso.setBounds(16, 73, 44, 31);
		panel.add(lbl_peso);
		
		lbl_altura = new JLabel("ALTURA");
		lbl_altura.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_altura.setVisible(false);
		lbl_altura.setBounds(26, 116, 87, 31);
		panel.add(lbl_altura);
		
		txt_peso = new JTextField();
		txt_peso.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_peso.setColumns(10);
		txt_peso.setVisible(false);
		txt_peso.setBounds(133, 75, 130, 26);
		panel.add(txt_peso);
		
		txt_altura = new JTextField();
		txt_altura.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_altura.setColumns(10);
		txt_altura.setVisible(false);
		txt_altura.setBounds(133, 118, 130, 26);
		panel.add(txt_altura);
		
		btn_imc = new JButton("IMC");
		btn_imc.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_imc.setVisible(false);
		btn_imc.setBounds(10, 167, 87, 29);
		panel.add(btn_imc);
		
		txt_imc = new JTextField();
		txt_imc.setBounds(133, 166, 130, 26);
		txt_imc.setEditable(false);
		txt_imc.setVisible(false);
		panel.add(txt_imc);
		txt_imc.setColumns(10);
		
		lbl_rutina = new JLabel("RUTINA");
		lbl_rutina.setFont(new Font("Calibri", Font.PLAIN, 15));
		lbl_rutina.setBounds(14, 226, 87, 31);
		lbl_rutina.setVisible(false);
		panel.add(lbl_rutina);
		
		txt_rutina = new JTextArea();
		txt_rutina.setBounds(116, 218, 189, 49);
		txt_rutina.setVisible(false);
		panel.add(txt_rutina);
		
		btn_buscar = new JButton("BUSCAR");
		btn_buscar.setBounds(282, 30, 87, 26);
		panel.add(btn_buscar);
		
		btn_guardar = new JButton("GUARDAR");
		btn_guardar.setBounds(210, 352, 117, 29);
		btn_guardar.setVisible(false);
		panel.add(btn_guardar);
		
		calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getOldValue() != null) {
					SimpleDateFormat ff = new SimpleDateFormat("dd//MM/yyyy");
					txt_date.setText(ff.format(calendar.getCalendar().getTime()));//valor actualmente en calendar
				}
			}
		});
		calendar.setVisible(false);
		calendar.setBounds(16, 285, 184, 153);
		panel.add(calendar);
		
		txt_date = new JTextField();
		txt_date.setEditable(false);
		txt_date.setVisible(false);
		txt_date.setColumns(10);
		txt_date.setBounds(210, 285, 130, 26);
		panel.add(txt_date);
		
		
	
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				ViewMenuTrainer menutrainer = new ViewMenuTrainer();
				menutrainer.setVisible(true);
				menutrainer.setLocationRelativeTo(null);
			}
		});
		
		new LogicTrainerRegister(this);
	}
}
