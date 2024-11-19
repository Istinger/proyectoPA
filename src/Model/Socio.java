package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lib_genericP65v1.Generic;

public class Socio {
	private Generic <String,String> data1;
	private Generic<String,String>data2;
	private List<String> progress;
	
    public Socio() {
        this("", "", "", "", "", "", "", "");
    }
	
	public Socio(String nombre,String id,String email,String password,String telefono,String direccion,String plan,String edad) {
		this.data1 = new Generic<>(nombre,id,email,password);
		this.data2 = new Generic<>(telefono,direccion,plan,edad);
		this.progress = new ArrayList<>();
	}
	
	public Socio(String nombre,String id,String email,String plan,String telefono,String direccion,String edad) {
		this.data1 = new Generic<>(nombre,id,email);
		this.data2 = new Generic<>(telefono,direccion,plan,edad);
	}
	
	public Socio(String nombre,String id,String email,String plan,String password) {
		this.data1 = new Generic<>(nombre,id,email,password);
		this.data2 = new Generic<>("","",plan,"");
	}
	
	
	
	
    public void addProgress(String progress) {
        this.progress.add(progress);
    }

    public List<String> getProgress() {
        return this.progress;
    }
	
	public void setNombre(String nombre) {
		this.data1.setAttribute1(nombre);
	}
	public String getNombre() {
		return this.data1.getAttribute1();
	}
	
	public void setId(String id) {
		this.data1.setAttribute2(id);
	}
	
	public String getID() {
		return data1.getAttribute2();
	}
	public void setEmail(String email) {
		this.data1.setAttribute3(email);
	}
	public String getEmail() {
		return data1.getAttribute3();
	}
	
	public void setPassword(String password) {
		this.data1.setAttribute4(password);
	}
	public String getPassword() {
		return this.data1.getAttribute4();
	}
	
	public void setTelefono(String telefono) {
		this.data2.setAttribute1(telefono);
	}
	public void setDireccion(String direccion) {
		this.data2.setAttribute2(direccion);
	}
	public void setPlan(String plan) {
		this.data2.setAttribute3(plan);
	}
	public void setEdad(String edad) {
		this.data2.setAttribute4(edad);
	}
	
	public String getTelefono() {
		return this.data2.getAttribute1();
	}
	public String getDireccion() {
		return this.data2.getAttribute2();
	}
	public String getPlan() {
		return this.data2.getAttribute3();
	}
	public String getEdad() {
		return this.data2.getAttribute4();
	}

	
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getNombre(), getID(),  getEmail(), getPassword(), getTelefono(), getDireccion(),getPlan(), getEdad());
    }
	
}
