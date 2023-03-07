/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menubasicohilo;

import Entidad.Datos;
import Entidad.hilo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joseph
 */
public class MenuBasicoHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int eleccionCliente;
      
        do {
           
            menu();// llamando al  void menu 
            mensaje("Ingrese su eleccion");// llamando a la funcion mensaje que recibo argumento
            eleccionCliente = scannerEntero();// llamamos a la funcion scannerEntero y lo recibimos en la variable eleccion
            
            if (eleccionCliente == 1) {
                System.out.println("*******INGRESAR AL SISTEMA********");
                mensaje("Ingrese su usuario:");
                String nombre = scannerTexto(); // llamamos a la funcion scannerTexto y lo recibimos en la variable nombre
                mensaje("Ingrese la contrasena");
                String contrasena = scannerTexto();
                String estado =validarDatos(nombre, contrasena);
                if(estado == "fail"){
                    mensaje("NO INGRESASTE AL SISTEMAS");
                }else{
                    
                    mensaje("INGRESASTE AL SISTEMA");
                    String valor;
                     ArrayList<Datos> listaMedicina = new ArrayList();// declaramos el arraylist para guardar los datos de la medicina y el horario
                    
                    do{
                        mensaje("ingrese el nombre de la medicina:");
                        String medicina = scannerTexto();
                        
                        mensaje("ingrese la hora");
                        int hora = scannerEntero();
                        
                        mensaje("ingrese el minutos");
                        int minuto = scannerEntero();
                        
                        mensaje("ingrese la descripcion");
                        String descripcion  = scannerTexto();
                        
                        Datos d = new Datos();
                        d.setNombreMedicina(medicina);
                        d.setHora(hora);
                        d.setMinutos(minuto);
                        d.setDescripcion(descripcion);
                        
                        listaMedicina.add(d);
                        
                        mensaje("desea agegar mas datos : S/N");
                        valor = scannerTexto().toUpperCase();
                    
                    }while( !"N".equals(valor));
                    
                    mensaje("Estas en  sala de espera....");
                    alarma(listaMedicina);
                    
                    
                }
                
                

            } else if (eleccionCliente == 2) {
                System.out.println("*******REGISTRARSE********");
                mensaje("ingreso  su nombre");
                String nombre = scannerTexto();
                
                mensaje("ingrese su  Apellido Paterno");
                String apePaterno = scannerTexto();
                mensaje("ingrese su  Apellido Materno");
               
                String apematerno = scannerTexto();
                mensaje("ingrese su  dni");
                int dni = scannerEntero();
               
                mensaje("ingrese su  edad");
                int edad =  scannerEntero();
                
                mensaje("ingrese su  usuario");
                String usuario = scannerTexto();
                
                mensaje("ingrese su  contrasena");
                String contrasena = scannerTexto();
                
                String estado = registrarUsuario(nombre, apePaterno, apematerno, edad, dni, usuario, contrasena);
                if("ok".equals(estado)){
                    mensaje("Se registro  exitosamente");
                }else{
                     mensaje("Su registro fallo ");
                }
                

            } else if (eleccionCliente == 3) {

            } else {
                mensaje("No es un opcion valida");
            }
        } while (eleccionCliente != 0);
    }
    // creando funciones 

    /**
     * *
     * Es un funciones que muestro el menu en pantalla
     */
    // inicia funcion: creando menu
    public static void menu() {

        final String TEXT_RED = "\u001B[31m";
        final String TEXT_BLUE = "\u001B[34m";
        System.out.println(TEXT_RED + "**************MENU**********");
        System.out.println(TEXT_BLUE + "1.-Ingresar al sistema.");
        System.out.println(TEXT_BLUE + "2.-Registrarse?.");
        System.out.println(TEXT_BLUE + "3.-Recordar datos?");
        System.out.println(TEXT_BLUE + "0.-Salir.");
        System.out.println(TEXT_RED + "****************************");

    }
    ////////////////////////////////////////////

    /**
     * *
     *
     * @return devuelve la eleccion del cliente siendo un entero
     */
    //inicia funcion: creando scanner de enteros
    public static int scannerEntero() {
        Scanner in = new Scanner(System.in);
        int eleccion = in.nextInt();
        return eleccion;
    }

    //////////////////////////////////////////////
    /**
     * *
     *
     * @return devuelve la eleccion del cliente siendo un texto
     */
    //iniciando funcion: creando  scanner de texto
    public static String scannerTexto() {
        Scanner in = new Scanner(System.in);
        String texto = in.nextLine();
        return texto;
    }

    //////////////////////////////////////////////////
    /**
     * *
     *
     * @param String texto: recibe el parametro que se va a mostrar en pantalla
     *
     */
    // iniciando funcion: creando mensaje en pantalla
    private static void mensaje(String texto) {
        System.out.println(texto);
    }
    //////////////////////////////////////////////////
    /***
     * 
     * @param nombre : la variable nombre es la que se va a registrar
     * @param apepaterno : la apepaterno nombre es la que se va a registrar
     * @param apeMaterno: la apematerno nombre es la que se va a registrar
     * @param edad: la variable edad es la que se va a registrar
     * @param DNI:la variable DNI es la que se va a registrar
     * @param usuario:la variable usuario es la que se va a registrar
     * @param contrasena:la variable contrasena es la que se va a registrar
     * @return devielve ok si  todo  se registro de manera satisifactoria o fail  si fallo
     */
    //iniciando funcion: parar guardar los datos del registrar
    public static String registrarUsuario(String nombre,
                                          String apepaterno,
                                          String apeMaterno,
                                          int edad,
                                          int DNI,
                                          String usuario,
                                          String contrasena){
     
       
        try {
            BufferedWriter escribirTXT = new BufferedWriter(new FileWriter("Usuario.txt", true)); // estamos creando un documento  txt para guardar los datos
            escribirTXT.write(nombre + ","
                          + apepaterno + ","
                          + apeMaterno + ","
                          + edad + ","
                          + DNI + "," 
                          + usuario + ","
                          + contrasena); 
         
         escribirTXT.flush();
         escribirTXT.newLine();
         escribirTXT.close();
        
         return "ok";
        
        } catch (IOException ex) {
            Logger.getLogger(MenuBasicoHilo.class.getName()).log(Level.SEVERE, null, ex);
             return "fail";
        }
    } 
    //////////////////////////////////////////////////
    //iniciando funcion: Para valida su  el usuario  y  contrasena estan registrados
    public static String validarDatos(String usuario, String contrasena){
        String leerLinea, resultadoBusqueda;
        int conta= 0;
        try {
            BufferedReader leerTXT = new BufferedReader(new FileReader("Usuario.txt")); // estamos leyendo un documento  txt para validad si el usuario  y contrasena estan  en las lineas correspondientes
            /* while ((leerLinea = leerTXT.readLine()) != null) {
                  if (leerLinea.contains(usuario) && leerLinea.contains(contrasena) ){
                  conta++;
                   if(conta >0){
                        resultadoBusqueda= "ok";                        
                        return resultadoBusqueda;
                    }
                  }else{
                        resultadoBusqueda= "fail";                        
                        return resultadoBusqueda;
                  }
              }
            */
            
         while ((leerLinea = leerTXT.readLine())!= null) {
                if (leerLinea.contains(usuario)&& leerLinea.contains(contrasena) ) {
                    conta++;
                }
            }  
          if (conta > 0) {
                resultadoBusqueda= "ok";                        
                        return resultadoBusqueda;
               
            } else {
                resultadoBusqueda= "fail";                        
                        return resultadoBusqueda;

            }
      
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuBasicoHilo.class.getName()).log(Level.SEVERE, null, ex);
        return resultadoBusqueda = "fail";
        } catch (IOException ex) {
            Logger.getLogger(MenuBasicoHilo.class.getName()).log(Level.SEVERE, null, ex);
        return resultadoBusqueda = "fail";
        }
    }
    ///////////////////////////////////////////////////////////////////////////////
    // iniciando funcion: permite activar la alarma del hilo 
    public static void alarma(ArrayList<Datos> listaMedicina){
     hilo h = new hilo ( listaMedicina);
    h.start();
    
    }
    
    
}
