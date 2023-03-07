package Automation;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class RobotMouse{
  public static void main(String[] args)
                             throws AWTException, IOException{
    Robot robot = new Robot();
    
    Runtime.getRuntime().exec("cmd /c start control");
    
    //robot.kepPress(KeyEvent.)
    robot.delay(2000);
    robot.keyPress(KeyEvent.VK_ALT);
    robot.keyPress(KeyEvent.VK_SPACE);
    robot.keyRelease(KeyEvent.VK_ALT);
    robot.keyRelease(KeyEvent.VK_SPACE);
    robot.keyPress(KeyEvent.VK_X);
    robot.keyRelease(KeyEvent.VK_X);
    
    robot.delay(2000);

    robot.mouseMove(2000,0);

    //Press and then release the left mouse

    robot.delay(3000);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.delay(3000);
    
    //release the left mouse
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    
    Runtime.getRuntime().exec("cmd /c start explorer");
    
    robot.delay(3000);
    
    Runtime.getRuntime().exec("cmd /c start chrome.exe");
    robot.delay(3000);
    robot.keyPress(KeyEvent.VK_G);
    robot.keyRelease(KeyEvent.VK_G);
    robot.keyPress(KeyEvent.VK_O);
    robot.keyRelease(KeyEvent.VK_O);
    robot.keyPress(KeyEvent.VK_O);
    robot.keyRelease(KeyEvent.VK_O);
    robot.keyPress(KeyEvent.VK_G);
    robot.keyRelease(KeyEvent.VK_G);
    robot.keyPress(KeyEvent.VK_L);
    robot.keyRelease(KeyEvent.VK_L);
    robot.keyPress(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_E);
    robot.keyPress(KeyEvent.VK_PERIOD);
    robot.keyRelease(KeyEvent.VK_PERIOD);
    robot.keyPress(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_C);
    robot.keyPress(KeyEvent.VK_O);
    robot.keyRelease(KeyEvent.VK_M);
    robot.keyPress(KeyEvent.VK_M);
    robot.keyRelease(KeyEvent.VK_M);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    
    robot.delay(3000);
    
    robot.keyPress(KeyEvent.VK_W);
    robot.keyRelease(KeyEvent.VK_W);
    robot.keyPress(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_E);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);
    robot.keyPress(KeyEvent.VK_H);
    robot.keyRelease(KeyEvent.VK_H);
    robot.keyPress(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_E);
    robot.keyPress(KeyEvent.VK_R);
    robot.keyRelease(KeyEvent.VK_R);
    robot.keyPress(KeyEvent.VK_SPACE);
    robot.keyRelease(KeyEvent.VK_SPACE);
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);
    robot.keyPress(KeyEvent.VK_O);
    robot.keyRelease(KeyEvent.VK_O);
    robot.keyPress(KeyEvent.VK_D);
    robot.keyRelease(KeyEvent.VK_D);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyPress(KeyEvent.VK_Y);
    robot.keyRelease(KeyEvent.VK_Y);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    
  }

}
