package Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.AdminDAO;
import View.ViewRegister_empleados;



public class LogicViewRegister_Empleados implements ActionListener {
	private ViewRegister_empleados vl;
	private AdminDAO adminDAO;

	
	public LogicViewRegister_Empleados(ViewRegister_empleados vl) {
		super();
		this.vl = vl;
		this.vl.btn_registrar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vl.btn_registrar) {
			guardarDatos();
		}
		
	}
	
	private void guardarDatos() {
		Admin admin = new Admin();
		admin.setEmail(vl.txt_Email.getText());
		admin.setId(vl.txt_cedula.getText());
		admin.setNombre(vl.txt_name.getText());
		admin.setDireccion(vl.txt_direccion.getText());
		admin.setEdad(vl.txt_edad.getText());
		admin.setPassword(vl.txt_password.getText());
		admin.setRol(vl.txt_rol.getText());
		admin.setTelefono(vl.txt_telefono.getText());
		
		adminDAO = new AdminDAO(admin);
		
		try {
			if(adminDAO.write()) {
				 JOptionPane.showMessageDialog(vl, "Usuario guardado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(vl, "Error al guardar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		}



    }
	private boolean validarCampos() {
	    if (vl.txt_Email.getText().isEmpty() || vl.txt_cedula.getText().isEmpty() || vl.txt_name.getText().isEmpty() ||
	        vl.txt_direccion.getText().isEmpty() || vl.txt_edad.getText().isEmpty() || vl.txt_password.getText().isEmpty() ||
	        vl.txt_rol.getText().isEmpty() || vl.txt_telefono.getText().isEmpty()) {

	        JOptionPane.showMessageDialog(vl, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    if (!vl.txt_Email.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
	        JOptionPane.showMessageDialog(vl, "Email no válido", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    if (!vl.txt_password.getText().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")) {
	        JOptionPane.showMessageDialog(vl, "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    return true;
	}

}
