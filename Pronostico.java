/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

/**
 *
 * @author pc
 */
public class Pronostico {
    private int id_fase;
    private int id_ronda; 
    private int id_Partido;
    private Persona  persona;
    private int apuesta;
    private boolean estado; 

    public Pronostico(int id_fase, int id_ronda, int id_Partido, Persona persona, int apuesta) {
        this.id_fase = id_fase;
        this.id_ronda = id_ronda;
        this.id_Partido = id_Partido;
        this.persona = persona;
        this.apuesta = apuesta;
        estado = false; 
    }

    public int getId_fase() {
        return id_fase;
    }

    
    public int getId_ronda() {
        return id_ronda;
    }

    public int getId_Partido() {
        return id_Partido;
    }

   public int getApuesta() {
           
       return apuesta;
    }

    public Persona getPersona() {
        return persona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
   
}
