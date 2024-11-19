package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Socio;
import Model.SocioDAO;
import View.ViewMenuSocio;
import View.ViewPasswordSocio;
import View.ViewProgresoSocio;

//abrir el archivo del entrenador que se guarda el progreso
public class LogicMenuSocio implements ActionListener{
	private ViewMenuSocio vms;
	private SocioDAO socioDAO;

	public LogicMenuSocio(ViewMenuSocio vms) {
		super();
		this.vms = vms;
		this.vms.btn_Password.addActionListener(this);
		this.vms.btn_Progreso.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vms.btn_Password) {
			Socio socio = new Socio();
			vms.setVisible(false);
			ViewPasswordSocio vnps = new ViewPasswordSocio(String.valueOf(socio.getID()));
			vnps.setVisible(true);
		}else if(e.getSource() == vms.btn_Progreso) {
			vms.setVisible(false);
			ViewProgresoSocio vps = new ViewProgresoSocio();
			vps.setVisible(true);
			
			
		}
	}
	

}
