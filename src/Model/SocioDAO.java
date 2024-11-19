package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lib_genericP65v1.Files;

public class SocioDAO {
	private Files file;
	private Socio socio;

	public SocioDAO(Socio socio) {
		this.socio = socio;
		load();
	}
	
	public SocioDAO() {
		this.socio = new Socio();
		load();
	}
    private void load() {
        this.file = new Files("src/socios");
        file.create(0);
        file.setFile(new File(file.getFile().getPath(), "socios.txt"));
        file.create(1);
    }

    /**
     * Login para socio
     */
    public boolean login(String email, String password) throws IOException {
        String content = file.readerFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");
            if (data.length < 5) continue; // Evitar líneas mal formadas

            if (data[2].equals(email) && data[3].equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    private Socio createSocio(String[] data) {
        Socio socio = new Socio(
            data[0],  // nombre
            data[1],  // id
            data[2],	//email
            data[3],  // plan de membresía
            data[4]   // password
        );
        return socio;
    }

    public boolean save(Socio socio) throws IOException {
        String socioStr = String.format("%s,%s,%s,%s,%s",
            socio.getID(),
            socio.getNombre(),
            socio.getEmail(),
            socio.getPassword(),
            socio.getPlan());

        return file.writerFile(socioStr, false); 
    }

    public Socio findById(String id) throws IOException {
        String content = file.readerFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");
            if (data[1].equals(id)) {
                return createSocio(data);
            }
        }
        return null;
    }

    public Socio findByEmail(String email) throws IOException {
        String content = file.readerFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");
            if (data[2].equals(email)) {
                return createSocio(data);
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
            if (data[1].equals(id)) {
                data[4] = newPassword; 
                updated = true;
            }
            newContent.append(String.join(",", data)).append("\n");
        }

        if (updated) {
            return file.writerFile(newContent.toString(), true); 
        }
        return false;
    }

    public boolean validatePassword(String password) {
        return Files.validateByER(password, "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,16}$");
    }

    public List<Socio> findAll() throws IOException {
        List<Socio> socios = new ArrayList<>();
        String content = file.readerFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");
            if (data.length >= 6) { 
                socios.add(createSocio(data));
            }
        }
        return socios;
    }
    
    public Socio findByUsername(String username) throws IOException {
        String content = file.readerFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");
            if (data[0].equalsIgnoreCase(username)) { // Comparación no sensible a mayúsculas/minúsculas
                return createSocio(data);
            }
        }
        return null; // No se encontró el socio
    }
	
}
