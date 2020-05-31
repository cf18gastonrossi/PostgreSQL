package com.example.postgresql.ui.Model;

public class Usuari {

    private String nombre, fechaNacimiento;
    private Integer id;

    public Usuari(String nombre, String fechaNacimiento, Integer id) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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
