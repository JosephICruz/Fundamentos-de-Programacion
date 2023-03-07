package Automation;

import java.awt.*;
import java.util.*;
public class RobotMouseMachineAwake{


 public static void main(String[] args) throws Exception{
   Robot hal = new Robot();
   //hal.mou
   hal.mouseMove(1366,0);
   hal.delay(5000);
   Random random = new Random();
   while(true){
     hal.delay(5000);
  
     int x= random.ints(0, 1366).findFirst().getAsInt();
     int y= random.ints(0, 768).findFirst().getAsInt();
     hal.mouseMove(x,y);
     System.out.println(x+"*"+y);
   }
 }
}