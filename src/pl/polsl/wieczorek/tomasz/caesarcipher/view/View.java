/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.wieczorek.tomasz.caesarcipher.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;
import pl.polsl.wieczorek.tomasz.caesarcipher.modeexception.ModeException;

/**
 * Class corresponding to writing and reading from console
 *
 * @author Tomasz Wieczorek
 * @version 3.0
 */
public class View {

    /**
     * Method to throw exception about wrong mode
     *
     * @throws ModeException exception about bad mode
     */
    public void throwModeException() throws ModeException {
        throw new ModeException();
    }

    /**
     * Method to throw exception about wrong mode
     *
     * @throws ArrayIndexOutOfBoundsException - exception about bad mode
     */
    public void throwOutOfIndexException() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Print message to the console
     *
     * @param message message that is printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
