package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Socio;
import Model.SocioDAO;
import View.ViewRegistroSocio;

public class LogicViewRegisterSocio implements ActionListener {
    private ViewRegistroSocio vrs;
    private SocioDAO socioDAO;

    public LogicViewRegisterSocio(ViewRegistroSocio vrs) {
        super();
        this.vrs = vrs;
        this.socioDAO = new SocioDAO();
        this.vrs.btn_registrar.addActionListener(this);
        this.vrs.btn_cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vrs.btn_registrar) {
            if (validateFields()) {
                guardarSocio();
                vrs.setVisible(false);
                JOptionPane.showMessageDialog(vrs, "Registro exitoso", "Formulario", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == vrs.btn_cancelar) {
            vrs.setVisible(false);
        }
    }

    private boolean validateFields() {
        String nombre = vrs.txt_name.getText().trim();
        String id = vrs.txt_id.getText().trim();
        String edad = vrs.txt_age.getText().trim();
        String email = vrs.txt_mail.getText().trim();
        String telefono = vrs.txt_phone.getText().trim();
        String direccion = vrs.txt_address.getText().trim();
        String membresia = vrs.txt_membresia.getText().trim();

        if (nombre.isEmpty() || id.isEmpty() || edad.isEmpty() || email.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || membresia.isEmpty()) {
            JOptionPane.showMessageDialog(vrs, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!edad.matches("\\d+")) {
            JOptionPane.showMessageDialog(vrs, "La edad debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(vrs, "El correo electrónico no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(vrs, "El teléfono debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar la dirección
        if (!isValidAddress(direccion)) {
            JOptionPane.showMessageDialog(vrs, "La dirección no es válida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

 
    private boolean isValidAddress(String address) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9,\\.\\-\\s]+$");
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }


    private void guardarSocio() {
        String nombre = vrs.txt_name.getText().trim();
        String id = vrs.txt_id.getText().trim();
        String edad = vrs.txt_age.getText().trim();
        String email = vrs.txt_mail.getText().trim();
        String telefono = vrs.txt_phone.getText().trim();
        String direccion = vrs.txt_address.getText().trim();
        String membresia = vrs.txt_membresia.getText().trim();

        Socio socio = new Socio(nombre, id, email, membresia, telefono, direccion, edad);
        
        try {
            if (socioDAO.save(socio)) {
                JOptionPane.showMessageDialog(vrs, "Socio registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vrs, "Error al guardar el socio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(vrs, "Error al guardar el socio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}