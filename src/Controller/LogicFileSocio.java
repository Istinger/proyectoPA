package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogicFileSocio{

    private static final String FILE_PATH = "socio_data.txt";

  
    public static void guardarSocioCompleto(String nombre, String email, String dni, int edad, String telefono, String direccion, String plan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(nombre + "," + email + "," + dni + "," + edad + "," + telefono + "," + direccion + "," + plan);
            writer.newLine();
            System.out.println("Socio guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el socio: " + e.getMessage());
        }
    }


    public static List<String> leerTodosLosSocios() {
        List<String> socios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                socios.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer los socios: " + e.getMessage());
        }
        return socios;
    }

    // Método para buscar un socio por DNI
    public static String buscarSocioPorDNI(String dni) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[2].equals(dni)) { // El DNI está en la posición 2
                    return linea; // Retornar la línea completa con los datos del socio
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar el socio: " + e.getMessage());
        }
        return null; 
    }

    // Método para listar todos los socios
    public static List<String[]> listarSocios() {
        List<String[]> socios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                socios.add(datos); // Agregar cada socio como un array de String
            }
        } catch (IOException e) {
            System.err.println("Error al listar los socios: " + e.getMessage());
        }
        return socios;
    }

    // Método para eliminar un socio 
    public static boolean eliminarSocioPorDNI(String dni) {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp_" + FILE_PATH);

        boolean eliminado = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
             
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (!datos[2].equals(dni)) { // Escribir todas las líneas excepto la que coincide con el DNI
                    writer.write(linea);
                    writer.newLine();
                } else {
                    eliminado = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar el socio: " + e.getMessage());
        }

        // Reemplazar el archivo original con el archivo temporal
        if (eliminado) {
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } else {
            tempFile.delete();
        }
        return eliminado;
    }
}