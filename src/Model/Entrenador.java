package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lib_genericP65v1.Generic;



public class Entrenador {
	
	private Generic<String,String>data1;
	private Generic<String,String>data2;
	private Generic<Integer,Integer>data3;
	private String id;
	private List<String> clientes;

	public Entrenador(String nombre, String email, String password, int edad) {
			this.clientes = new ArrayList<>();
			this.id = UUID.randomUUID().toString();
			this.data1 = new Generic<>(nombre,id);//generar random ID  = UUID.randomUUID().toString()
			this.data2 = new Generic<>(email,password);
			this.data3 = new Generic<>(edad);
	}
	public Entrenador() {
		this("","","",0);
	}

	public void setEdad(int edad) {
		this.data3.setAttribute1(edad);
	}
	public int getEdad() {
		return this.data3.getAttribute1();
	}
	
	public void setEmail(String email) {
		this.data2.setAttribute1(email);
	}
	public void setPassword(String password) {
		this.data2.setAttribute2(password);
	}
	
	public String getEmail() {
		return this.data2.getAttribute1();
	}
	
	public String getPassword() {
		return this.data2.getAttribute2();
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
	
	public String getId() {
		return this.data1.getAttribute2();
	}
	@Override
	public String toString() {
		return String.format("%s,%s,%s", getNombre(),getId(),getEmail());
	}
		
	
	

}
