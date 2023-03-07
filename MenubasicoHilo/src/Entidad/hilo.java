/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */
public class hilo implements Runnable {

    int hora;
    int minuto;
    ArrayList<Datos> listaMedicina;

    public hilo(ArrayList<Datos> listaMedicina) {
        this.listaMedicina = listaMedicina;
    }

    @Override
    public void run() {

        boolean estado = true;
        while (estado) {
            
            LocalDateTime locaDate = LocalDateTime.now();
           
            int hours        = locaDate.getHour();
            int minutes      = locaDate.getMinute();
            int seconds      = locaDate.getSecond();
            int milisegundos = locaDate.getNano();
            
                 for (Datos pro : listaMedicina) {

                
                if (pro.getHora() == hours && pro.getMinutos() == minutes   ) {

                    System.out.println("es hora ");
                    System.out.println(hours + " " + minutes + " " + seconds );
                    System.out.println("es hora de tomar la medicina ");
                    System.out.println(pro.getNombreMedicina()+ " "+ pro.getDescripcion());


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

}
