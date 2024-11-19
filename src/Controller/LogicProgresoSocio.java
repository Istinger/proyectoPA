package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ViewMenu;
import View.ViewMenuSocio;
import View.ViewProgresoSocio;


public class LogicProgresoSocio implements ActionListener {
	private ViewProgresoSocio vls;

	public LogicProgresoSocio (ViewProgresoSocio vls) {
		super();
		this.vls = vls;
		this.vls.btn_listar.addActionListener(this);
		this.vls.btn_regresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vls.btn_listar) {
			//metodo para listar clientes en el JList
		}else if(e.getSource() == vls.btn_regresar) {
			//un metodo para clear list
			vls.setVisible(false);
			ViewMenuSocio vmt = new ViewMenuSocio();
			vmt.setVisible(true);
		}
	}
	
	

}

