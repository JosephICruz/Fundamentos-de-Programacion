/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidad.Datos;

import java.time.LocalDateTime;

import java.util.ArrayList;



import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 *
 * @author LENOVO
 */
public class hilo implements Runnable {

    int hora;
    int minuto;

    //constructor
    ArrayList<Datos> datos;

    public hilo(ArrayList<Datos> Datos) {

        this.datos = Datos;
    }

    @Override
    public void run() {
        boolean estado = true;
        while (estado) {

            // estoy capturando la hora del sistema
            LocalDateTime locaDate = LocalDateTime.now();
            int hours        = locaDate.getHour();
            int minutes      = locaDate.getMinute();
            int seconds      = locaDate.getSecond();
            int milisegundos = locaDate.getNano();
//         
            for (Datos pro : datos) {

                
                if (pro.getHora() == hours && pro.getMinutos() == minutes   ) {

                    System.out.println("es hora ");
                    System.out.println(hours + " " + minutes + " " + seconds );
                    ReproducirSonido("src/recursos/alarma.wav");
                    //JOptionPane.showMessageDialog(null, "es hora de tomar");
                    

                } else {

                    System.out.println("no es hora ");
                    System.out.println(hours + " " + minutes + " " + seconds );
                }

            }
        }
    }

    public void start() {
        new Thread(this).start();
    }

    /////////// funcion par sonido
    public void ReproducirSonido(String nombreSonido){
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.");
         System.out.println(ex.getMessage());
         System.out.println(ex.getStackTrace());
       }
     }
    
    
}
