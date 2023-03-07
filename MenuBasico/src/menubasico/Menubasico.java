/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menubasico;

import Entidad.Datos;
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
public class Menubasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int eleccionUsuario;
        final String TEXT_RED = "\u001B[31m";
        final String TEXT_BLUE = "\u001B[34m";
        do {
            menu();
            mensaje("Ingrese su eleccion:");
            eleccionUsuario = scannerEntero();
            if (eleccionUsuario == 1) {
                 
                 System.out.println(TEXT_RED + "*******INGRESAR AL SISTEMA********");
                 mensaje(TEXT_BLUE + "ingrese su usuario:");
                 String usuario = scannerTexto();
                 
                 mensaje(TEXT_BLUE + "ingrese su contrasena:");
                 String contrasena = scannerTexto();
                 
                 String resultadoValidar = validarDatos(usuario, contrasena);
                 if("fail".equals(resultadoValidar)){
                    mensaje(TEXT_BLUE + "sus datos no  estan registrado");
                 }else {
                    mensaje(TEXT_BLUE + "INGRESASTE AL SISTEMA");
                   String agregar;
                  
                   ArrayList<Datos> datos = new ArrayList();
                   
                    do{
                        mensaje(TEXT_BLUE + "ingrese el nombre de la medicina:");
                        String nombreMedicina = scannerTexto();
                        
                        mensaje(TEXT_BLUE + "ingrese la hora:");
                        int hora = scannerEntero();
                        
                        mensaje(TEXT_BLUE + "ingrese el minuto:");
                        int minuto = scannerEntero();
                        
                        mensaje(TEXT_BLUE + "ingrese la descripcion:");
                        String descripcion = scannerTexto();
                        
                         Datos d = new Datos();
        
                         d.setNombreMedicina(nombreMedicina);
                         d.setHora(hora);
                         d.setMinutos(minuto);
                         d.setDescrpcion(descripcion);
                        
                         datos.add(d);
                        
                        mensaje(TEXT_BLUE + "Agregar mas datos S/N:");
                        agregar = scannerTexto().toUpperCase();
                        
                    }while(!"N".equals(agregar));
                    
                    mensaje(TEXT_BLUE + "Estas en  sala de espera....");
                   
                   
                 }
                 
                 

            } else if (eleccionUsuario == 2) {

                System.out.println(TEXT_RED + "**************REGISTRASE**********");

                mensaje(TEXT_BLUE + "ingrese su  nombre:");
                String nombre = scannerTexto();

                mensaje(TEXT_BLUE + "ingrese su  Apellido  Paterno:");
                String apePaterno = scannerTexto();

                mensaje(TEXT_BLUE + "ingrese su  Apellido  Materno:");
                String apeMaterno = scannerTexto();

                mensaje(TEXT_BLUE + "ingrese su  edad:");
                int edad = scannerEntero();

                mensaje(TEXT_BLUE + "ingrese su  DNI:");
                int DNI = scannerEntero();

                mensaje(TEXT_BLUE + "ingrese su usuario:");
                String usuario = scannerTexto();

                mensaje(TEXT_BLUE + "ingrese su contrasena:");
                String contrasena = scannerTexto();

                String estado = registrarUsuario(nombre, apePaterno, apeMaterno, edad, DNI, usuario, contrasena);
                if ("ok".equals(estado)) {
                    mensaje("Se registro  de manera satisfactoria");
                } else {
                    mensaje("ocurrio un  error en el registro");
                }

            } else if (eleccionUsuario == 3) {
                System.out.println(TEXT_RED + "**************RECORDAR DATOS**********");

                mensaje(TEXT_BLUE + "ingrese su DNI:");
                int dni = scannerEntero();
                String resultadoBusqueda=buscarDatos(dni);
                if("fail".equals(resultadoBusqueda)){
                   mensaje("ocurrio un  error en la busqueda");
                }else if ("ok".equals(resultadoBusqueda)){
                   mensaje("ocurrio un  error en la busqueda");
                }else{
                  mensaje(resultadoBusqueda);
                }
          
            }

        } while (eleccionUsuario != 0);
    }

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

    public static int scannerEntero() {

        Scanner in = new Scanner(System.in);
        int eleccion = in.nextInt();
        return eleccion;
    }

    public static String scannerTexto() {

        Scanner in = new Scanner(System.in);
        String texto = in.nextLine();
        return texto;
    }

    private static void mensaje(String texto) {
        System.out.println(texto);
    }

    public static String registrarUsuario(String nombre,
                                          String apepaterno,
                                          String apeMaterno,
                                          int edad,
                                          int DNI,
                                          String usuario,
                                          String contrasena) {

        try {
            BufferedWriter escribirTXT = new BufferedWriter(new FileWriter("Usuario.txt", true));
            escribirTXT.write(nombre + "," + apepaterno + "," + apeMaterno + "," + edad + "," + DNI + "," + usuario + "," + contrasena);
            escribirTXT.flush();
            escribirTXT.newLine();
            escribirTXT.close();

            return "ok";

        } catch (IOException ex) {
            Logger.getLogger(Menubasico.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        }

    }
    
    public static String buscarDatos(int dni){
    
       String leerLinea,resultadoBusqueda = "ok"; 
       int conta =0;
       
       String dniBusca = dni+"";
       
        try {
            BufferedReader leerTXT = new BufferedReader(new FileReader("Usuario.txt"));
              while ((leerLinea = leerTXT.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(leerLinea, ",");
                if (leerLinea.contains(dniBusca)) {
                    conta++;
                    if (conta > 0) {
                        
                         resultadoBusqueda=      " Nombre: " + st.nextToken() +
                                                 "\n Apellido Paterno: " + st.nextToken() +
                                                 "\n Apellido Materno: " + st.nextToken() +
                                                 "\n Edad: "+ st.nextToken() +
                                                 "\n DNI: "+ st.nextToken() +
                                                 "\n Usuario:" + st.nextToken() + 
                                                 "\n Contraseña:" + st.nextToken();
                        
                        return resultadoBusqueda;
                    }
                } else {
                    
                    return "fail";
                }

            }
         return resultadoBusqueda;
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menubasico.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        } catch (IOException ex) {
            Logger.getLogger(Menubasico.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        }
    }
    
    public static String validarDatos(String usuario, String contrasena){
    
       String leerLinea,resultadoBusqueda = "fail"; 
       int conta =0;
       
     
       
        try {
            BufferedReader leerTXT = new BufferedReader(new FileReader("Usuario.txt"));
              while ((leerLinea = leerTXT.readLine()) != null) {
                if (leerLinea.contains(usuario) && leerLinea.contains(contrasena) ) {
                    conta++;
                    if (conta > 0) {
                         resultadoBusqueda= "ok";                        
                        return resultadoBusqueda;
                    }
                } else {
                    
                    return "fail";
                }

            }
         return resultadoBusqueda;
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menubasico.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        } catch (IOException ex) {
            Logger.getLogger(Menubasico.class.getName()).log(Level.SEVERE, null, ex);
            return "fail";
        }
    }
    
     

}
