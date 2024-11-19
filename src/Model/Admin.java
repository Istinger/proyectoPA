package Model;

import lib_genericP65v1.Generic;

public class Admin {
    private Generic<String, String> data1;
    private Generic<String, String> data2;

    public Admin(String nombre, String id, String edad, String email, String password, String telefono, String direccion, String rol) {
        this.data1 = new Generic<>(nombre, id, email, password);
        this.data2 = new Generic<>(telefono, direccion, rol, edad);
    }

    public Admin() {
        this("", "", "", "", "", "", "", "");
    }

    public void setTelefono(String telefono) {
        this.data2.setAttribute1(telefono);
    }

    public String getTelefono() {
        return data2.getAttribute1();
    }

    public void setDireccion(String direccion) {
        this.data2.setAttribute2(direccion);
    }

    public String getDireccion() {
        return this.data2.getAttribute2();
    }

    public void setRol(String rol) {
        this.data2.setAttribute3(rol);
    }

    public String getRol() {
        return this.data2.getAttribute3();
    }

    public void setEdad(String edad) {
        this.data2.setAttribute4(edad);
    }

    public String getEdad() {
        return this.data2.getAttribute4();
    }

    public void setNombre(String nombre) {
        this.data1.setAttribute1(nombre);
    }

    public void setId(String id) {
        this.data1.setAttribute2(id);
    }

    public void setEmail(String email) {
        this.data1.setAttribute3(email);
    }

    public void setPassword(String password) {
        this.data1.setAttribute4(password);
    }

    public String getNombre() {
        return this.data1.getAttribute1();
    }

    public String getId() {
        return this.data1.getAttribute2();
    }

    public String getEmail() {
        return this.data1.getAttribute3();
    }

    public String getPassword() {
        return this.data1.getAttribute4();
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getNombre(), getId(), getEdad(), getEmail(), getPassword(), getTelefono(), getDireccion(), getRol());
    }
}