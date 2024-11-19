package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.Entrenador;
import Model.EntrenadorDAO;
import View.ViewMenuTrainer;
import View.ViewPasswordTrainer;
import lib_genericP65v1.Files;

public class LogicPasswordTrainer implements ActionListener{
	private ViewPasswordTrainer vpt;
	private EntrenadorDAO entrenadorDAO;
	private String userID;//el que ingrese en el textField

	public LogicPasswordTrainer(ViewPasswordTrainer vpt,String userID) {
		super();
		this.vpt = vpt;
		this.entrenadorDAO = new EntrenadorDAO();
		this.vpt.btn_savepswrd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vpt.btn_savepswrd) {
			if(validatePasswordChange()) {
				updatePassword();
			}

		}
		
	}
	
	  private boolean validateNewPassword() {
	        String newPassword = String.valueOf(vpt.newpassword.getPassword());
	        return Files.validateByER(newPassword, "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
	    }
	
	  
	    private boolean checkLastPassword() {
	        try {
	            Entrenador entrenador = entrenadorDAO.findById(userID);
	            if (entrenador != null) {
	                String inputPassword = String.valueOf(vpt.lastpassword.getPassword());
	                return inputPassword.equals(entrenador.getPassword());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    private void updatePassword() {
	        try {
	            String newPassword = String.valueOf(vpt.newpassword.getPassword());
	            if (entrenadorDAO.updatePassword(userID, newPassword)) {
	                JOptionPane.showMessageDialog(vpt,"Contraseña actualizada exitosamente","Éxito",JOptionPane.INFORMATION_MESSAGE);
	                vpt.setVisible(false);
	                ViewMenuTrainer vmt = new ViewMenuTrainer();
	                vmt.setVisible(true);
	                vmt.setLocationRelativeTo(null);
	            } else {
	                JOptionPane.showMessageDialog(vpt,"Error al actualizar la contraseña","Error",JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(vpt,"Error al guardar los cambios","Error",JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	    private boolean validatePasswordChange() {
	        if (!checkLastPassword()) {
	            JOptionPane.showMessageDialog(vpt,"La contraseña anterior no es correcta","Error",JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        if (!validateNewPassword()) {
	            JOptionPane.showMessageDialog(vpt, 
	                "La nueva contraseña debe tener:\n" +
	                "- Entre 8 y 16 caracteres\n" +
	                "- Al menos un dígito\n" +
	                "- Al menos una mayúscula\n" +
	                "- Al menos una minúscula\n" +
	                "- No puede tener espacios", 
	                "Error", 
	                JOptionPane.ERROR_MESSAGE);
	            return false;
	        }

	        return true;
	    }

	
	
	
}
