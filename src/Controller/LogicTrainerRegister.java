package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Entrenador;
import View.ViewMenuTrainer;
import View.ViewTrainerRegister;
import lib_genericP65v1.Files;

public class LogicTrainerRegister implements ActionListener {
	private ViewTrainerRegister vtr;

	public LogicTrainerRegister(ViewTrainerRegister vtr) {
		super();
		this.vtr = vtr;
		this.vtr.btn_buscar.addActionListener(this);
		this.vtr.btn_guardar.addActionListener(this);
		this.vtr.btn_imc.addActionListener(this);
		directoryExist("src/clients");
		directoryExist("src/rutinas");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vtr.btn_buscar) {
			buscarCliente();
			
		}else if(e.getSource() == vtr.btn_guardar) {
			//save(); meter el IMC con un setTExt para que se guarde dentro del FIle
			//Se guarda le sale una ventana de mensaje que se guardaron los datos, se cierra la ventana de VIewLogicTrainerRegister y se abre la ventana del menu trainer
//			JOptionPane.showMessageDialog(vtr, "Registro exitoso","Formulario",JOptionPane.INFORMATION_MESSAGE);

			if(validateFields()) {
				guardarRutina();
				vtr.setVisible(false);
				ViewMenuTrainer vmt = new ViewMenuTrainer();
				vmt.setVisible(true);
			}
		}else if(e.getSource() == vtr.btn_imc) {
			IMC();
		}
		
	}
	
	private void visible() {
		//poner todo en visible true si da true dentro de un if else
		vtr.txt_peso.setVisible(true);
		vtr.txt_altura.setVisible(true);
		vtr.txt_date.setVisible(true);
		vtr.txt_imc.setVisible(true);
		vtr.txt_rutina.setVisible(true);
		vtr.btn_guardar.setVisible(true);
		vtr.btn_imc.setVisible(true);
		vtr.lbl_altura.setVisible(true);
		vtr.lbl_peso.setVisible(true);
		vtr.lbl_rutina.setVisible(true);
		vtr.calendar.setVisible(true);
	}
    /**
     * Verifica que un directorio exista y lo crea si es necesario.
     */
    private void directoryExist(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
	
    /**
     * Busca un cliente en el archivo "clients.txt".
     */
    private void buscarCliente() {
        String socio = vtr.txt_socio.getText().trim();
        File file = new File("src/clients/clients.txt");
        boolean found = false;
        
        if(file.exists()) {
        	JOptionPane.showMessageDialog(vtr, "El archivo no existe","Error",JOptionPane.ERROR_MESSAGE);
        	return;
        }
        

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(socio)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(vtr, "Error al leer el archivo de clientes", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
        }

        if (found) {
        	visible();
        } else {
            JOptionPane.showMessageDialog(vtr, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	

	
	private void IMC() {
		double peso = Double.parseDouble(vtr.txt_peso.getText());
		double altura = Double.parseDouble(vtr.txt_altura.getText());		
		double IMC = peso/ (altura*altura);		
		vtr.txt_imc.setText(String.format("%.2f",IMC));//seteo el valor del text y despues lo tomo para guardar esto en el archivo con un metodo 
	}
	
	/**
     * Guarda la rutina en un archivo específico para el cliente.
     */
	private void guardarRutina() {
        String socio = vtr.txt_socio.getText();
        String peso = vtr.txt_peso.getText();
        String altura = vtr.txt_altura.getText();
        String imc = vtr.txt_imc.getText();
        String rutina = vtr.txt_rutina.getText();
        String fecha = vtr.txt_date.getText();

        File file = new File("src/rutinas/" + socio + "_Rutine.txt");

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("Nombre: " + socio + "\n");
            writer.write("Peso: " + peso + "\n");
            writer.write("Altura: " + altura + "\n");
            writer.write("IMC: " + imc + "\n");
            writer.write("Rutina: " + rutina + "\n");
            writer.write("Fecha: " + fecha + "\n");
            writer.write("\n");
            JOptionPane.showMessageDialog(vtr, "Rutina guardada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(vtr, "Error al guardar la rutina", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	

//	private void save() {
//		Client client = new Client();
//		client.setAltura(Integer.parseInt(vtr.txt_altura.getText()));
//		client.setPeso(Integer.parseInt(vtr.txt_peso.getText()));
//		ClientDAO = new ClientDAO(client);
//		try {
//			if(ClientDAO.write()) {
//				JOptionPane.showMessageDialog(vtr, "Registro exitoso","Formulario",JOptionPane.INFORMATION_MESSAGE);//venta de informacion con icono
//			}
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(vtr, "Problemas al registrar en el archivo","Registro",JOptionPane.ERROR_MESSAGE);
//		}
//		vtr.setVisible(false);
//		ViewMenuTrainer vmt = new ViewMenuTrainer();
//		vmt.setVisible(true);
//	}
	
	  /**
     * Valida los campos antes de guardar la rutina.
     */
    private boolean validateFields() {
        String socio = vtr.txt_socio.getText();
        String peso = vtr.txt_peso.getText();
        String altura = vtr.txt_altura.getText();
        String imc = vtr.txt_imc.getText();
        String rutina = vtr.txt_rutina.getText();
        String fecha = vtr.txt_date.getText();

        if (socio.isEmpty() || peso.isEmpty() || altura.isEmpty() || imc.isEmpty() || rutina.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(vtr, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!Pattern.matches("\\d+(\\.\\d+)?", peso)) {
            JOptionPane.showMessageDialog(vtr, "Peso inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!Pattern.matches("\\d+(\\.\\d+)?", altura)) {
            JOptionPane.showMessageDialog(vtr, "Altura inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        return true;
    }
	
	
}
