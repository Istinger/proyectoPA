package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ViewMenuSocio;
import View.ViewLoginSocio;
import View.ViewRegistroSocio;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Socio;
import View.ViewLoginSocio;
import View.ViewMenuSocio;
import Model.SocioDAO;

public class LogicViewLoginSocio implements ActionListener {
    private ViewLoginSocio vls;
    private SocioDAO socioDAO;

    public LogicViewLoginSocio(ViewLoginSocio vls) {
        super();
        this.vls = vls;
        this.socioDAO = new SocioDAO();
        this.vls.btnIngresar.addActionListener(this);
        this.vls.btnCrear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vls.btnIngresar) {
            login();
        } else if (e.getSource() == vls.btnCrear) {
            vls.setVisible(false);
            ViewRegistroSocio vns = new ViewRegistroSocio();
            vns.setVisible(true);
        }
    }

    private void login() {
        String username = vls.txt_User.getText();
        String password = new String(vls.pass_Socio.getPassword());

        // Debug statements
        System.out.println("Username entered: " + username);
        System.out.println("Password entered: " + password);

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(vls, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Pattern.matches("^[\\w.-]+@socio$", username)) {
            JOptionPane.showMessageDialog(vls, "Formato de usuario inválido. Debe ser 'nombre@socio'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Socio socio = socioDAO.findByUsername(username);
            if (socio != null) {
                // Debug statements
                System.out.println("Username from file: " + socio.getNombre());
                System.out.println("Password from file: " + socio.getPassword());

                if (socio.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(vls, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    vls.setVisible(false);
                    ViewMenuSocio vms = new ViewMenuSocio();
                    vms.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(vls, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vls, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vls, "Error al iniciar sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}