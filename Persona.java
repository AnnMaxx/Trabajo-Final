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
public class Persona {
   private int id_Persona;
private String nombre;
private ArrayList<Pronostico> l_pr; 
private int puntaje_P;
private int puntaje_R;
private int puntaje_F;

    
public Persona(int id_Persona, String nombre) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        puntaje_P =0;
        puntaje_R =0;
        puntaje_F =0;
        l_pr =new ArrayList<>(); 
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeP() {
        return puntaje_P;
    }

    public int getPuntajeR() {
        return puntaje_R;
    }

    public int getPuntaje_F() {
        return puntaje_F;
    }
    
    
    public void SumaPunto_P(int puntaje_P){
        this.puntaje_P += puntaje_P;
    
    }
    
    public void SumaPunto_R(int puntaje_R){
        this.puntaje_R += puntaje_R;
    
    }
    
    public void SumaPunto_F(int puntaje_F){
        this.puntaje_F += puntaje_F;
    }
    
    public int ApuestaxRonda(int num_fase,int num_ronda){
    
        int suma=0;
        for (int i=0; i<l_pr.size();i++){
            if (l_pr.get(i).getId_fase()== num_fase && l_pr.get(i).getId_ronda()== num_ronda && l_pr.get(i).isEstado()){
                suma ++;
            }
        }
        return suma;
    }
    
    
    public void Agrega_Pronostico(Pronostico pronostico){
        l_pr.add(pronostico);
    
    }

}
