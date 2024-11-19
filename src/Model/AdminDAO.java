package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lib_genericP65v1.Files;

public class AdminDAO {
	private Files file;
	private Admin admin;
	
	public AdminDAO() {
		admin = new Admin();
        this.file = new Files("src/empleados");
        file.create(0);
        file.setFile(new File(file.getFile().getPath(), "empleados.txt"));
        file.create(1);
	}
	
	
	public AdminDAO(Admin admin) {
		this.admin = admin;
		this.file = new Files("src/empleados");
		file.create(0);
		file.setFile(new File(file.getFile().getPath(),"empleados.txt"));
		file.create(1);
	}
	
	public boolean write() throws IOException {
		return file.writerFile(admin.toString(), true);
	}
	
	public String getEmail() {
		return this.admin.getEmail();
	}
	
	public String getPassword() {
		return this.admin.getPassword();
	}
	public Admin findByEmail(String email) throws IOException {
	    String content = file.readerFile();
	    String[] lines = content.split("\n");

	    for (String line : lines) {
	        if (line.trim().isEmpty()) continue;

	        String[] data = line.split(",");
	        if (data[3].equals(email)) { // data[2] es el email
	            return new Admin(
	                data[0],  // nombre
	                data[1],  // id
	                data[2],  // edad
	                data[3],  // email
	                data[4],  // password
	                data[5],  // telefono
	                data[6],  // direccion
	                data[7]   // rol
	            );
	        }
	    }
	    return null; // Si no se encuentra el email
	}


	
 

}
