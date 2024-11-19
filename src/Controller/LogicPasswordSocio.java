package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.Socio;
import Model.SocioDAO;
import View.ViewMenuSocio;
import View.ViewPasswordSocio;
import lib_genericP65v1.Files;

public class LogicPasswordSocio implements ActionListener {
    private ViewPasswordSocio vps;
    private SocioDAO socioDAO;
    private String userID; // ID ingresado en el textField

    public LogicPasswordSocio(ViewPasswordSocio vps, String userID) {
        super();
        this.vps = vps;
        this.socioDAO = new SocioDAO();
        this.userID = userID;
        this.vps.btn_guardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vps.btn_guardar) {
            if (validatePasswordChange()) {
                updatePassword();
            }
        }
    }

    private boolean validateNewPassword() {
        String newPassword = String.valueOf(vps.newPassword.getPassword());
        return Files.validateByER(newPassword, "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
    }

    private boolean checkLastPassword() {
        try {
            Socio socio = socioDAO.findById(userID);
            if (socio != null) {
                String inputPassword = String.valueOf(vps.lastPassword.getPassword());
                return inputPassword.equals(socio.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void updatePassword() {
        try {
            String newPassword = String.valueOf(vps.newPassword.getPassword());
            if (socioDAO.updatePassword(userID, newPassword)) {
                JOptionPane.showMessageDialog(vps, "Contraseña actualizada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vps.setVisible(false);
                ViewMenuSocio vms = new ViewMenuSocio();
                vms.setVisible(true);
                vms.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(vps, "Error al actualizar la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vps, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validatePasswordChange() {
        if (!checkLastPassword()) {
            JOptionPane.showMessageDialog(vps, "La contraseña anterior no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!validateNewPassword()) {
            JOptionPane.showMessageDialog(vps, 
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
