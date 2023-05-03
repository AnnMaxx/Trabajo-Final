/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deporte;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author pc
 */
public class Partido {
    private int num_fase; 
    private int num_ronda; 
    private int id_partido;
    private Equipo equipo1; 
    private Equipo equipo2; 
    private int Golequipo1;
    private int Golequipo2;
    private ArrayList<Pronostico> l_pp;  

    public Partido(int num_fase,int num_ronda, int id_partido, Equipo equipo1, Equipo equipo2, int Golequipo1, int Golequipo2) {
        l_pp = new ArrayList(); 
        this.num_fase = num_fase;
        this.num_ronda = num_ronda;
        this.id_partido = id_partido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.Golequipo1 = Golequipo1;
        this.Golequipo2 = Golequipo2;
    }

    public int getNum_fase() {
        return num_fase;
    }

    
    public int getNum_ronda() {
        return num_ronda;
    }

    public int getId_partido() {
        return id_partido;
    }

    
    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public String getEquipo1() {
        return equipo1.Descripcion;
    }

    public String getEquipo2() {
        return equipo2.Descripcion;
    }
    
    public int getGol1(){
        return Golequipo1; 
    
    }
  
    public int getGol2(){
        return Golequipo2;
        
    }

    public ArrayList<Pronostico> getL_pp() {
        return l_pp;
    }

    public int resultado(){
    
        int respuesta=0; 
        if(Golequipo1 == Golequipo2) respuesta=0;
        if(Golequipo1  > Golequipo2) respuesta=1;
        if(Golequipo2  > Golequipo1) respuesta=2;
        
        return respuesta;
    
    }
    
    // Agrega los Pronosticos a cada Partido
    
    public void Agrega_Partido(Pronostico pronostico){
        l_pp.add(pronostico);
    
    }
 
}
  
  


