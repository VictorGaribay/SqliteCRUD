package com.raitom.sqlitecrud.model;

/**
 * Created by raitom on 29/10/16.
 */

public class Persona {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String dirTrabajo;
    private String ocupacion;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellidos, String dni, String direccion, String telefono, String dirTrabajo, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni=dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dirTrabajo = dirTrabajo;
        this.ocupacion = ocupacion;

    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirTrabajo() {
        return dirTrabajo;
    }

    public void setDirTrabajo(String dirTrabajo) {
        this.dirTrabajo = dirTrabajo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
