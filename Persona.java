/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

/**
 *
 * @author pc
 */
public class Persona {
    private int id_Persona;
    private String nombre;
    private int puntaje; 

    public Persona(int id_Persona, String nombre, int puntaje) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        this.puntaje =0;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void suma_Puntaje(){
        puntaje++;
    
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", puntaje=" + puntaje + '}';
    }

}
