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
    private static  int ro,id,i1,i2,g1,g2; 
    
    private static ArrayList<Persona>l_Persona = new ArrayList<>();
    private static ArrayList<Ronda> l_Ronda= new ArrayList<>(); 
    public static ArrayList<Equipo> l_Equipo = new ArrayList<>();
    private static ArrayList<Partido>l_Partido= new ArrayList<>();
    private static ArrayList<Pronostico>l_Pronostico= new ArrayList<>();
    
    private static ArrayList<String> lista = new ArrayList<>();

    
    public static void main(String[] args) {
    
        lista = leer_Arch("d:/Personas.csv"); 
        cargar_Persona(lista);

        lista = leer_Arch("d:/Equipos.csv");
        cargar_Equipo(lista);
  
        lista = leer_Arch("d:/Rondas.csv"); 
        cargar_Ronda(lista);
        
        lista = leer_Arch("d:/Partidos.csv");
        cargar_Partido(lista);
        
        lista = leer_Arch("d:/Pronosticos.csv");
        cargar_Pronostico(lista);
        
        
        // Agrega los Pronosticos a cada Partido 
        
        for (int i=0; i<l_Partido.size();i++){
             l_Partido.get(i).Agregar_P(l_Pronostico);
        }
                                 
        // Agrega los Partidos a cada Ronda
        
        for (int i=0; i<l_Ronda.size();i++){
             l_Ronda.get(i).Agregar_P(l_Partido);
        }
            
        
        // Menu de Incio 
        
        String item = JOptionPane.showInputDialog("\t\t\t\t Ingrese el Numero de la Opcion \n\n"
                    + " 1- Listado de Rondas, Partidos, Pronosticos, Presonas que Apuestan en cada Partido \n\n"
                    + " 2- Listado de las Personas que Apostaron y el Puntaje Obtenido en todas las Rondas \n");
        
        
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
            Persona persona = new Persona (Integer.parseInt(x[0]), x[1],Integer.parseInt(x[2])); 
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
   
   public static void cargar_Ronda(ArrayList<String> list_Ronda){
        
        String renglon = null;
        for (int i=0; i<list_Ronda.size(); i++){
            renglon =list_Ronda.get(i);
            String x[] = renglon.split(";");
            Ronda ronda = new Ronda (Integer.parseInt(x[0]), x[1]); 
            l_Ronda.add(ronda);
            
        }
   }

    public static void cargar_Partido(ArrayList<String> list_Partido){
        
        String renglon = null; 
        for (int i=0; i<(list_Partido.size()); i++){
            renglon = list_Partido.get(i); 
            String x[] = renglon.split(";"); 
         
            ro = Integer.parseInt(x[0]);
            id = Integer.parseInt(x[1]);
            i1=  Integer.parseInt(x[2]); 
            i2=  Integer.parseInt(x[3]);
            g1=  Integer.parseInt(x[4]);
            g2=  Integer.parseInt(x[5]);
          
            
            for (int j=0; j<l_Equipo.size()-1;j++){
                if (l_Equipo.get(j).getId_equipo()==i1)p1=i1;
                if (l_Equipo.get(j).getId_equipo()==i2)p2=i2;
                 
            }
            
           
            Partido partido = new Partido(ro,id,l_Equipo.get(p1), l_Equipo.get(p2),g1,g2); 
            l_Partido.add(partido); 
           
        }

    } 

    
    public static void cargar_Pronostico(ArrayList<String> list_Pronostico){
        
        String renglon = null; 
        for (int i=0; i<list_Pronostico.size(); i++){
            renglon = list_Pronostico.get(i); 
            String x[] = renglon.split(";"); 
            
            ro = Integer.parseInt(x[0]);
            id = Integer.parseInt(x[1]);
            i1 = Integer.parseInt(x[2]);
            i2 = Integer.parseInt(x[3]);
            
            for (int j=0; j<l_Persona.size(); j++){
                if (l_Persona.get(j).getId_Persona()==i1){
                    Pronostico pronostico1 = new Pronostico (ro,id,l_Persona.get(j),i2);
                    l_Pronostico.add(pronostico1); 
                    break; 
                }
            }
    
        }    

    } 

    public static void listado_total(){
    
         ArrayList<Partido> Ronda_Partido = new ArrayList<>(); 
         ArrayList<Pronostico> Partido_Pronostico= new ArrayList<>();

           for (int i=0; i<l_Ronda.size(); i++){
               System.out.println("Numero de_Ronda :"+l_Ronda.get(i).getNum_Ronda()); 
               Ronda_Partido = l_Ronda.get(i).getL_Pdo(); 
               
               for (int t=0; t<Ronda_Partido.size(); t++){
                    System.out.println("\n\t\t\t Partido :"+ Ronda_Partido.get(t).getId_partido());
                    System.out.println("\t\t\t\t Equipo 1 :" +Ronda_Partido.get(t).getEquipo1()+" "+ "\t"+ Ronda_Partido.get(t).getGol1());
                    System.out.println("\t\t\t\t Equipo 2 :" +Ronda_Partido.get(t).getEquipo2()+" "+ "\t"+ Ronda_Partido.get(t).getGol2()); 
                    System.out.println("\t\t\t\t Resultado :" + Ronda_Partido.get(t).resultado()+"\n" );
                    Partido_Pronostico = Ronda_Partido.get(t).getL_pp(); 
                    for (int j=0; j<Partido_Pronostico.size();j++){
                
                        System.out.println("\t\t\t\t Persona : "+ Partido_Pronostico.get(j).getPersona().getNombre()+ "\t Apuesta: "+ Partido_Pronostico.get(j).getApuesta() );
                    }
               
               
               }
        
           }
         
    }

    public static void listado_Personas(){ 
        for(int i=0; i<l_Persona.size();i++){
            System.out.println("Nombre : \t"+l_Persona.get(i).getNombre());
            System.out.println("\t\t Puntaje: "+l_Persona.get(i).getPuntaje()+"\n"); 
        }
    }
 
}
