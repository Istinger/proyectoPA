package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ViewListClient;
import View.ViewMenuTrainer;

public class LogicListClient implements ActionListener {
	private ViewListClient vlc;

	public LogicListClient(ViewListClient vlc) {
		super();
		this.vlc = vlc;
		this.vlc.btn_listar.addActionListener(this);
		this.vlc.btn_regresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vlc.btn_listar) {
			//metodo para listar clientes en el JList
		}else if(e.getSource() == vlc.btn_regresar) {
			//un metodo para clear list
			vlc.setVisible(false);
			ViewMenuTrainer vmt = new ViewMenuTrainer();
			vmt.setVisible(true);
		}
	}
	
	

}
