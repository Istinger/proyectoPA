package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.ViewLogin_Admin;
import View.Viewpanel_Admin;


public class LogicViewAdmin implements ActionListener {
	private ViewLogin_Admin vl;

	public LogicViewAdmin(ViewLogin_Admin vl) {
		super();
		this.vl = vl;
		this.vl.btn_ingreso.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == vl.btn_ingreso) {
			
			String user = vl.txt_usuario.getText();
			String psw = "";
			for(char c : vl.txt_pasword.getPassword()) {
				psw+= String.valueOf(c);
			}
			
			//valido credenciales user & password admin
			if(user.equals("admin") && psw.equals("1234")) {
				JOptionPane.showMessageDialog(vl, "Acceso Correcto","Inicio de Sesion",JOptionPane.INFORMATION_MESSAGE);
				vl.setVisible(false);
				Viewpanel_Admin vmt = new Viewpanel_Admin();
				vmt.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(vl, "Credenciales incorrctos","Inicio de Sesion",JOptionPane.WARNING_MESSAGE);
			}		

			
		}
		
	}

}
