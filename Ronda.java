/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Ronda {
    private int num_Fase;
    private int num_Ronda;
    private String Descripcion; 
    private ArrayList<Partido> l_Pdo;  

    public Ronda (int num_Fase,int num_Ronda, String Descripcion){
    
        l_Pdo = new ArrayList<>(); 
        this.num_Fase = num_Fase;
        this.num_Ronda = num_Ronda;
        this.Descripcion = Descripcion; 
    }

    public int getNum_Fase() {
        return num_Fase;
    }
    
        
    public int getNum_Ronda() {
        return num_Ronda;
    }

    public ArrayList<Partido> getL_Pdo() {
        return l_Pdo;
    }

       
    public String getDescripcion() {
        return Descripcion;
    }
    
    // Agrega los Partidos de cada Ronda
    
    public void Agregar_Partido(Partido partido){
        l_Pdo.add(partido); 
    }
    
    public int Cant_Partido(){
        return l_Pdo.size(); 
    
    }

}
