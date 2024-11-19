package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.AdminDAO;
import Model.EntrenadorDAO;
import Model.Socio;
import Model.SocioDAO;
import View.ViewLoginTrainer;
import View.ViewMenuTrainer;
import View.ViewTrainerRegister;

public class LogicLoginTrainer implements ActionListener {
	private ViewLoginTrainer vlt;
	private AdminDAO adminDAO;
	private SocioDAO socioDAO;
	
	public LogicLoginTrainer(ViewLoginTrainer vlt) {
		super();
		this.vlt = vlt;
		this.adminDAO = new AdminDAO();
		this.socioDAO = new SocioDAO();
		this.vlt.btn_ingresar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vlt.btn_ingresar) {
			login();
		}
	}
	
	

    private void login() {
        String email = vlt.txt_usuario.getText();
        String password = new String(vlt.txt_password.getPassword());

        // Debug statements to check the values
        System.out.println("Email entered: " + email);
        System.out.println("Password entered: " + password);

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(vlt, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Pattern.matches("^[\\w.-]+@entrenador$", email)) {
            JOptionPane.showMessageDialog(vlt, "Formato de usuario inválido. Debe ser 'nombre@entrenador'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Admin admin = adminDAO.findByEmail(email);
            if (admin != null) {
                // Debug statements to check the retrieved values
                System.out.println("Email from file: " + admin.getEmail());
                System.out.println("Password from file: " + admin.getPassword());

                if (admin.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(vlt, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    vlt.setVisible(false);
                    ViewMenuTrainer vmt = new ViewMenuTrainer();
                    vmt.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(vlt, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vlt, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vlt, "Error al iniciar sesión", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean changePassword(String email, String newPassword) {
        try {
            Admin admin = adminDAO.findByEmail(email);
            if (admin != null) {
                admin.setPassword(newPassword);
                return adminDAO.write();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Socio> listSocios(String trainerEmail) {
        try {
            return socioDAO.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean registerProgress(String socioId, String progress) {
        try {
            Socio socio = socioDAO.findById(socioId);
            if (socio != null) {
                // Assuming Socio class has a method to add progress
                socio.addProgress(progress);
                return socioDAO.save(socio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

	
	
	

	}
	
	


