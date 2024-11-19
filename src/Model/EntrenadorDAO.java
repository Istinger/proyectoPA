package Model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import lib_genericP65v1.Files;
import lib_genericP65v1.Generic;

public class EntrenadorDAO {
	private Files file;
	private Entrenador entrenador;
	
	public EntrenadorDAO(Entrenador entrenador) {
		this.entrenador = entrenador;
		load();
	}
	
	public EntrenadorDAO() {
		entrenador = new Entrenador();
	}
	

	private void load() {
		this.file = new Files("src/empleados");
		file.create(0);
		file.setFile(new File(file.getFile().getPath(),"empleados.txt"));
		file.create(1);
	}
	/*
	 * Login para trainer
	 * */
	public boolean login(String email, String password) throws IOException {
				  
	    String content = file.readerFile();	    
	    String[] lines = content.split("\n");
	    
	    for (String line : lines) {
	        if (line.trim().isEmpty()) continue;

	        String[] data = line.split(",");
	        if (data.length < 4) continue; // Evitar líneas mal formadas
	        
	        if (data[2].equals(email) && data[3].equals(password)) {
	            return true;
	        }
	    }
	    return false;
	}
	
    private Entrenador createEntrenador(String[] data) {
        Entrenador entrenador = new Entrenador(
            data[1],  // nombre
            data[2],  // email
            data[3],  // password
            Integer.parseInt(data[4])  // edad
        );
        entrenador.setId(data[0]);
        return entrenador;
    }
	
	 public boolean save(Entrenador entrenador) throws IOException {
	        String entrenadorStr = String.format("%s,%s,%s,%s,%d",
	            entrenador.getId(),
	            entrenador.getNombre(),
	            entrenador.getEmail(),
	            entrenador.getPassword(),
	            entrenador.getEdad());
	        
	        return file.writerFile(entrenadorStr, false); 
	    }
	 
	 public Entrenador findById(String id) throws IOException {
	        String content = file.readerFile();
	        String[] lines = content.split("\n");
	        
	        for (String line : lines) {
	            if (line.trim().isEmpty()) continue;
	            
	            String[] data = line.split(",");
	            if (data[0].equals(id)) {
	                return createEntrenador(data);
	            }
	        }
	        return null;
	    }
	    public Entrenador findByEmail(String email) throws IOException {
	        String content = file.readerFile();
	        String[] lines = content.split("\n");
	        
	        for (String line : lines) {
	            if (line.trim().isEmpty()) continue;
	            
	            String[] data = line.split(",");
	            if (data[2].equals(email)) {
	                return createEntrenador(data);
	            }
	        }
	        return null;
	    }
	    
	    public boolean updatePassword(String id, String newPassword) throws IOException {
	        String content = file.readerFile();
	        String[] lines = content.split("\n");
	        StringBuilder newContent = new StringBuilder();
	        boolean updated = false;

	        for (String line : lines) {
	            if (line.trim().isEmpty()) continue;
	            
	            String[] data = line.split(",");
	            if (data[0].equals(id)) {
	                data[3] = newPassword;
	                updated = true;
	            }
	            newContent.append(String.join(",", data)).append("\n");
	        }

	        if (updated) {
	            return file.writerFile(newContent.toString(), true); // overwrite mode
	        }
	        return false;
	    }
	    
	    public boolean validatePassword(String password) {
	        return Files.validateByER(password, "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
	    }

}
