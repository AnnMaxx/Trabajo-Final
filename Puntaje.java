/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

/**
 *
 * @author pc
 */
public class Puntaje {
   private int puntaje_P;
   private int puntaje_R;
   private int puntaje_F;

   public Puntaje(){
       puntaje_P = 1;
       puntaje_R = 2;
       puntaje_F = 3;
    
    }
    
    public Puntaje(int puntaje_P, int puntaje_R, int puntaje_F) {
        this.puntaje_P = puntaje_P;
        this.puntaje_R = puntaje_R;
        this.puntaje_F = puntaje_F;
    }
    
    public int getPuntaje_P() {
        return puntaje_P;
    }

    
    public int getPuntaje_R() {
        return puntaje_R;
    }

    
    public int getPuntaje_F() {
        return puntaje_F;
    }
    
}
