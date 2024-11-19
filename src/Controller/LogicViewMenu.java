package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ViewLoginTrainer;
import View.ViewMenu;
import View.ViewLoginSocio;
import View.ViewLogin_Admin;

public class LogicViewMenu implements ActionListener {
	private ViewMenu vm;


	public LogicViewMenu(ViewMenu vm) {
		super();
		this.vm = vm;
		this.vm.btn_trainer.addActionListener(this);
		this.vm.btn_socio.addActionListener(this);
		this.vm.btn_admin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vm.btn_trainer) {
			vm.setVisible(false);
			ViewLoginTrainer vl = new ViewLoginTrainer();
			vl.setVisible(true);	
		}else if (e.getSource()==vm.btn_socio)		{
			vm.setVisible(false);
			ViewLoginSocio logSocio = new ViewLoginSocio();
			logSocio.setVisible(true);
		}else if(e.getSource() == vm.btn_admin) {
			vm.setVisible(false);
			ViewLogin_Admin vl = new ViewLogin_Admin();
			vl.setVisible(true);	
		}		
	}
	
	

}
