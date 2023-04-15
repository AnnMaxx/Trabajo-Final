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
    int id_ronda; 
    int id_Partido;
    Persona  persona;
    int apuesta; 

    public Pronostico(int id_ronda, int id_Partido, Persona persona, int apuesta) {
        this.id_ronda = id_ronda;
        this.id_Partido = id_Partido;
        this.persona = persona;
        this.apuesta = apuesta;
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

   @Override
    public String toString() {
        return "Pronostico{" + "id_ronda=" + id_ronda + ", id_Partido=" + id_Partido + ", persona=" + persona + ", apuesta=" + apuesta + '}';
    }

  

}
