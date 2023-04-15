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
    private int num_Ronda;
    private String Descripcion; 
    private ArrayList<Partido> l_Pdo;  

    public int getNum_Ronda() {
        return num_Ronda;
    }

    public ArrayList<Partido> getL_Pdo() {
        return l_Pdo;
    }

    public Ronda (int num_Ronda, String Descripcion){
    
    l_Pdo = new ArrayList<>(); 
    this.num_Ronda = num_Ronda;
    this.Descripcion = Descripcion; 
    
    }

    public String getDescripcion() {
        return Descripcion;
    }
    
    // Agrega los Partidos de cada Ronda
    
    public void Agregar_P(ArrayList<Partido> l_Pdo) {
        for (int i=0; i< l_Pdo.size(); i++){
             if (num_Ronda == l_Pdo.get(i).getNum_ronda()){
                 this.l_Pdo.add(l_Pdo.get(i)); 
             
             }
        }
         
    }
    
    
     
    @Override
    public String toString() {
        return "Ronda{" + "num_Ronda=" + num_Ronda + ", Descripcion=" + Descripcion + ", l_Pdo=" + l_Pdo + '}';
    }
  
}
