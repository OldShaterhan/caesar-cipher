/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.wieczorek.tomasz.caesarcipher;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import pl.polsl.wieczorek.tomasz.caesarcipher.model.CaesarCipher;
import pl.polsl.wieczorek.tomasz.caesarcipher.view.View;
import pl.polsl.wieczorek.tomasz.caesarcipher.modeexception.ModeException;

/**
 * Main class corresponding to code execution
 *
 * @author Tomasz Wieczorek
 * @version 3.0
 */
public class Main {

    /**
     * Main method of program, that starts to execute when program is
     * initialized
     *
     * @param args the command line arguments. First argument - mode (e or d),
     * other - words to cypher or decypher.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CaesarCipher caesarCipher;
        View view = new View();
        ArrayList<String> messageParts = new ArrayList<String>();
        char mode;

        try {
            if (args[0].length()>1) {
                throw new ModeException();
            }
            mode = args[0].charAt(0);
            for (int i = 1; i < args.length; i++) {
                messageParts.add(args[i]);
            }
            caesarCipher = new CaesarCipher(messageParts, mode, view);

        } catch (InputMismatchException e) {
            view.printMessage("Input Mismatch error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            view.printMessage("Array Index Out Of Bounds error: " + e.getMessage());
        } catch (ModeException e) {
            view.printMessage("Mode error: " + e.getMessage());
        }
    }

}
