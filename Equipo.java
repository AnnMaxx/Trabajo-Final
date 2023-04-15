/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Equipo {
    
    int id_equipo;
    String Descripcion; 

    public Equipo(int id_equipo, String Descripcion) {
        this.id_equipo = id_equipo;
        this.Descripcion = Descripcion;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

       
    @Override
    public String toString() {
        return "Equipo{" + "id_equipo=" + id_equipo + ", Descripcion=" + Descripcion + '}';
    }

}
