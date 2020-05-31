package com.example.postgresql.ui.Model;

import java.util.Date;

public class Usuari {

    private String nombre;
    private Date fechaNacimiento;
    private Integer id;

    public Usuari(String nombre, Date fechaNacimiento, Integer id) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static boolean checkInput(String nombre, String fechaNacimiento, Integer id) {
        if (nombre.equalsIgnoreCase("") || fechaNacimiento.equalsIgnoreCase("") || id.toString().equalsIgnoreCase("")) {
            return false;
        }
        else {
            return true;
        }
    }
}
