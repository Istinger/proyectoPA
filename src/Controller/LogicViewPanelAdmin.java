package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.ViewListar_Empleados;
import View.ViewRegister_empleados;

import View.Viewpanel_Admin;



public class LogicViewPanelAdmin implements ActionListener {
	private Viewpanel_Admin vl;
	
	
	public LogicViewPanelAdmin(Viewpanel_Admin vl) {
		super();
		this.vl = vl;
		this.vl.btn_listar.addActionListener(this);
		this.vl.btn_registrar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vl.btn_listar) {
			vl.setVisible(false);
			ViewListar_Empleados vmt = new ViewListar_Empleados();
			vmt.setVisible(true);
			
		}else if(e.getSource() == vl.btn_registrar) {
			vl.setVisible(false);
			ViewRegister_empleados vmt = new ViewRegister_empleados();
			vmt.setVisible(true);
		}
		
	}



	
	
}
