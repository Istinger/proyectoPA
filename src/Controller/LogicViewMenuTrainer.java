package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Entrenador;
import Model.EntrenadorDAO;
import View.ViewListClient;
import View.ViewMenuTrainer;
import View.ViewPasswordTrainer;
import View.ViewTrainerRegister;

public class LogicViewMenuTrainer implements ActionListener{
	private ViewMenuTrainer vmt;
	private EntrenadorDAO entrenadorDAO;

	public LogicViewMenuTrainer(ViewMenuTrainer vmt) {
		super();
		this.vmt = vmt;
		this.entrenadorDAO = new EntrenadorDAO();
		this.vmt.btn_list.addActionListener(this);
		this.vmt.btn_password.addActionListener(this);
		this.vmt.btn_registrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vmt.btn_list) {
			vmt.setVisible(false);
			ViewListClient vlc = new ViewListClient();
			vlc.setVisible(true);
		}else if(e.getSource() == vmt.btn_password) {
			Entrenador entrenador = new Entrenador();
			vmt.setVisible(false);
			ViewPasswordTrainer vpt = new ViewPasswordTrainer(String.valueOf(entrenador.getId()));
			vpt.setVisible(true);
			
		}else if(e.getSource() == vmt.btn_registrar) {
			vmt.setVisible(false);
			ViewTrainerRegister vtr = new  ViewTrainerRegister(); 
			vtr.setVisible(true);
		}
		
	}
	
	
	
}
