/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

import java.util.*;

/**
 *
 * @author pc
 */
public class Fase {
  private int num_Fase;
   private String Descripcion;
   private ArrayList<Ronda> l_Rda;
   
   public Fase(int num_Fase, String Descripcion) {
        this.num_Fase = num_Fase;
        this.Descripcion = Descripcion;
        l_Rda = new ArrayList<>(); 
   }

    public int getNum_Fase() {
        return num_Fase;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public ArrayList<Ronda> getL_Rda() {
        return l_Rda;
    }

        
    public void setNum_Fase(int num_Fase) {
        this.num_Fase = num_Fase;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void Agrega_Ronda(Ronda ronda){
        l_Rda.add(ronda);
    }
     
}
