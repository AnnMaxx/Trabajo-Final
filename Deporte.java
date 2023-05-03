/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deporte;

/**
 *
 * @author pc
 */

import java.util.ArrayList; 
import java.io.*;
import javax.swing.*;

public class Deporte {

    private static  int p1,p2;
    private static  int fa,ro,id,i1,i2,g1,g2; 
    
    private static ArrayList<Persona> l_Persona = new ArrayList<>();
    private static ArrayList<Fase> l_Fase = new ArrayList<>();
    private static ArrayList<Ronda> l_Ronda = new ArrayList<>(); 
    public static ArrayList<Equipo> l_Equipo = new ArrayList<>();
    private static ArrayList<Partido> l_Partido = new ArrayList<>();
    private static ArrayList<Pronostico> l_Pronostico = new ArrayList<>();
    
    private static ArrayList<String> lista = new ArrayList<>();

    
    public static void main(String[] args) {
    
              
       lista = leer_Arch("C:/Doc/Personas.csv"); 
       cargar_Persona(lista);

       lista = leer_Arch("C:/Doc/Equipos.csv");
       cargar_Equipo(lista);
                   
       lista = leer_Arch("C:/Doc/Fases.csv");
       cargar_Fase(lista);
        
       lista = leer_Arch("C:/Doc/Rondas.csv"); 
       cargar_Ronda(lista);
        
       lista = leer_Arch("C:/Doc/Partidos.csv");
       cargar_Partido(lista);

       lista = leer_Arch("C:/Doc/Pronosticos.csv");
       cargar_Pronostico(lista);

       
        // Asigna el Puntaje x Partido, x Ronda, x Fase
        
        Puntaje puntaje = new Puntaje(1,2,3);
        
        
       //Agrega los Pronosticos a Personas
        
        for (int i=0; i<l_Persona.size();i++){
            for (int j=0; j<l_Pronostico.size(); j++){
                       if ( l_Persona.get(i).equals(l_Pronostico.get(j).getPersona())){
                           l_Persona.get(i).Agrega_Pronostico(l_Pronostico.get(j)); 
                       }
            }            
        }
        
        
        // Agrega los Pronosticos a cada Partido, Marca Pronostico Acertado y Suma Puntaje a Persona
        
        for (int i=0; i<l_Partido.size();i++){
            for (int j=0; j<l_Pronostico.size();j++){
                if (l_Partido.get(i).getNum_fase()==l_Pronostico.get(j).getId_fase() && l_Partido.get(i).getNum_ronda()==l_Pronostico.get(j).getId_ronda() && l_Partido.get(i).getId_partido()==l_Pronostico.get(j).getId_Partido()){
                    l_Partido.get(i).Agrega_Partido(l_Pronostico.get(j));
                        if (l_Partido.get(i).resultado()==l_Pronostico.get(j).getApuesta()){
                            l_Pronostico.get(j).setEstado(true);
                            l_Pronostico.get(j).getPersona().SumaPunto_P(puntaje.getPuntaje_P());
                        
                        }
                }
            }
        }                         
        
        
        // Agrega los Partidos a cada Ronda
        
        for (int i=0; i<l_Ronda.size();i++){
            for (int j=0; j<l_Partido.size();j++){
                 if (l_Ronda.get(i).getNum_Fase()==l_Partido.get(j).getNum_fase() && l_Ronda.get(i).getNum_Ronda()==l_Partido.get(j).getNum_ronda()){
                     l_Ronda.get(i).Agregar_Partido(l_Partido.get(j));
                 }
            }        
        }
            
        // Agrega las Rondas a cada Fase
        
        
        for (int i=0; i<l_Fase.size();i++){
            for (int j=0; j<l_Ronda.size();j++){
                if (l_Fase.get(i).getNum_Fase()==l_Ronda.get(j).getNum_Fase()){
                    l_Fase.get(i).Agrega_Ronda(l_Ronda.get(j));
                }
            }
        }
        

        // Suma Puntos Extras por Ronda por Fases (Archivo Rondas Ordenado x Numero de Fase)
        
        for (int i=0; i<l_Persona.size();i++){
                int NFase = l_Ronda.get(0).getNum_Fase();
                int contador=0;
                int suma=0;
                
                for (int j=0; j<l_Ronda.size();j++){
                    if (NFase== l_Ronda.get(j).getNum_Fase()){
                        contador ++;    
                    }else{
                        NFase = l_Ronda.get(j).getNum_Fase();
                        if (contador*puntaje.getPuntaje_R()==suma){
                            l_Persona.get(i).SumaPunto_F(puntaje.getPuntaje_F());
                    
                        }  
                    suma=0;
                    }    
                
                    int cantidad = l_Persona.get(i).ApuestaxRonda(l_Ronda.get(j).getNum_Fase(),l_Ronda.get(j).getNum_Ronda());
                    if (l_Ronda.get(j).Cant_Partido()== cantidad && cantidad !=0){
                         suma=suma+puntaje.getPuntaje_R();
                        l_Persona.get(i).SumaPunto_R(puntaje.getPuntaje_R());
                    }
                }
        }
        
       
        // Menu de Incio 
        
        String item = JOptionPane.showInputDialog("\t\t\t\t Ingrese el Numero de la Opcion \n"
                    + " 1- Listado de Fases, Rondas, Partidos y sus Resultados, Pronosticos de cada Presona que Apuesta a cada Partido \n"
                    + " 2- Listado de las Personas que Apostaron y el Puntaje Total \n");
                    
               
        int op = Integer.parseInt(item);
        switch (op) {
            
            case 1: listado_total(); break;
            case 2: listado_Personas(); break;
            
            default: break; 
        } 
     
   }
              
  
    
   public  static ArrayList leer_Arch(String pcamino){

     
        ArrayList<String >l_lista = new ArrayList<>(); 
        String renglon = null;
       
        try {
            FileInputStream  pfis   = new FileInputStream( pcamino );
            DataInputStream pDatos = new DataInputStream( pfis );
     
                        
            renglon = pDatos.readLine(); 
  
            boolean linea = true; 
            while ( renglon != null ) {  //  Es "null" si encuentra fin del archivo.
                if (linea) {
                    renglon = pDatos.readLine(); 
                    linea = false; 
                }
                else {
           
                    l_lista.add(renglon); 
                    renglon = pDatos.readLine();
                }    
                
            }
            pfis.close();
        }
    
        catch (FileNotFoundException e){
            System.out.println("Error de Archivo1");
        }
        catch (IOException e){
            System.out.println( "Error de Archivo");    
        }

        return l_lista; 
    }    

   
    
       
    public static void cargar_Persona(ArrayList<String> list_Persona){
        
        String renglon = null; 
        for (int i=0; i<list_Persona.size(); i++){
            renglon = list_Persona.get(i); 
            String x[] = renglon.split(";"); 
            Persona persona = new Persona (Integer.parseInt(x[0]), x[1]); 
            l_Persona.add(persona); 
        }      
    }
   
   
   public static void cargar_Equipo(ArrayList<String> list_Equipo){
   
        String renglon = null;  
        for (int i=0; i<list_Equipo.size(); i++){
            renglon = list_Equipo.get(i); 
            String x[] = renglon.split(";"); 
            Equipo equipo = new Equipo (Integer.parseInt(x[0]), x[1]); 
            l_Equipo.add(equipo); 
        }    
   }
   
   
   public static void cargar_Fase(ArrayList<String> list_Fase){
   
       String renglon = null;
       for (int i=0; i<list_Fase.size();i++){
           renglon = list_Fase.get(i);
           String x[] = renglon.split(";");
           Fase fase = new Fase (Integer.parseInt(x[0]),x[1]);
           l_Fase.add(fase);
       }
       
    }
   
     
   
   public static void cargar_Ronda(ArrayList<String> list_Ronda){
        
        String renglon = null;
        for (int i=0; i<list_Ronda.size(); i++){
            renglon =list_Ronda.get(i);
            String x[] = renglon.split(";");
            Ronda ronda = new Ronda (Integer.parseInt(x[0]), Integer.parseInt(x[1]),x[2]); 
            l_Ronda.add(ronda);
            
        }
   }

    public static void cargar_Partido(ArrayList<String> list_Partido){
        
        String renglon = null; 
        for (int i=0; i<list_Partido.size(); i++){
            renglon = list_Partido.get(i); 
            String x[] = renglon.split(";"); 
            
            fa = Integer.parseInt(x[0]);
            ro = Integer.parseInt(x[1]);
            id = Integer.parseInt(x[2]);
            i1=  Integer.parseInt(x[3]); 
            i2=  Integer.parseInt(x[4]);
            g1=  Integer.parseInt(x[5]);
            g2=  Integer.parseInt(x[6]);
          
            
            for (int j=0; j<l_Equipo.size();j++){
                if (l_Equipo.get(j).getId_equipo()==i1)p1=j;
                if (l_Equipo.get(j).getId_equipo()==i2)p2=j;
            }
            
           
            Partido partido = new Partido(fa,ro,id,l_Equipo.get(p1), l_Equipo.get(p2),g1,g2); 
            l_Partido.add(partido); 
            
        }

    } 

   
    public static void cargar_Pronostico(ArrayList<String> list_Pronostico){
        
        String renglon = null; 
        
        for (int i=0; i<list_Pronostico.size(); i++){
            renglon = list_Pronostico.get(i); 
            String x[] = renglon.split(";"); 
            
            fa = Integer.parseInt(x[0]);
            ro = Integer.parseInt(x[1]);
            id = Integer.parseInt(x[2]);
            i1 = Integer.parseInt(x[3]);
            i2 = Integer.parseInt(x[4]);
            
            
            
            for (int j=0; j<l_Persona.size(); j++){
                if (l_Persona.get(j).getId_Persona()==i1){
                
                    Pronostico pronostico = new Pronostico (fa,ro,id,l_Persona.get(j),i2);
                    l_Pronostico.add(pronostico); 
                    break; 
                }
            }
    
        }    

    } 

    public static void listado_total(){
    
         ArrayList<Ronda> Fase_Ronda = new ArrayList<>(); 
         ArrayList<Partido> Ronda_Partido= new ArrayList<>();
         ArrayList<Pronostico> Partido_Pronostico= new ArrayList<>(); 

         for (int i=0; i<l_Fase.size();i++){
            System.out.println("Numero de Fase:"+l_Fase.get(i).getNum_Fase());
            Fase_Ronda = l_Fase.get(i).getL_Rda();
            for (int j=0; j<Fase_Ronda.size(); j++){
                System.out.println("\t Numero de Ronda:"+l_Ronda.get(j).getNum_Ronda());
                Ronda_Partido = Fase_Ronda.get(j).getL_Pdo();
                for (int z=0; z<Ronda_Partido.size(); z++){
                    System.out.println("\n\t\t\t Partido :"+ Ronda_Partido.get(z).getId_partido());
                    System.out.println("\t\t\t\t Equipo 1 :" +Ronda_Partido.get(z).getEquipo1()+" "+ "\t"+ Ronda_Partido.get(z).getGol1());
                    System.out.println("\t\t\t\t Equipo 2 :" +Ronda_Partido.get(z).getEquipo2()+" "+ "\t"+ Ronda_Partido.get(z).getGol2()); 
                    System.out.println("\t\t\t\t Resultado :" + Ronda_Partido.get(z).resultado()+"\n" );
                    Partido_Pronostico = Ronda_Partido.get(z).getL_pp();
                    for (int k=0; k<Partido_Pronostico.size();k++){
                
                        System.out.println("\t\t\t\t Persona : "+ Partido_Pronostico.get(k).getPersona().getNombre()+ "\t Apuesta: "+ Partido_Pronostico.get(k).getApuesta() );
                    }
               
               
               }
        
           }
         } 
    }

    public static void listado_Personas(){ 
    for(int i=0; i<l_Persona.size();i++){
               System.out.println("Nombre : "+l_Persona.get(i).getNombre()+"\t\t Puntos x Partidos : \t"+l_Persona.get(i).getPuntajeP()+
                                  "\n \t\t\t\t Puntos Extras x Ronda: "+l_Persona.get(i).getPuntajeR()+"\n \t\t\t\t Puntos Extras x Fase: \t"+l_Persona.get(i).getPuntaje_F());
           }
    }
 
}
