/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.wieczorek.tomasz.ceasarcipher.ceasartest;

import java.util.ArrayList;
import pl.polsl.wieczorek.tomasz.caesarcipher.model.*;
import org.junit.*;
import static org.junit.Assert.*;
import pl.polsl.wieczorek.tomasz.caesarcipher.Main;
import pl.polsl.wieczorek.tomasz.caesarcipher.exceptions.ModeException;
import pl.polsl.wieczorek.tomasz.caesarcipher.view.View;

/**
 * Class for unit test of CeasarCipher
 *
 * @author Tomasz Wieczorek
 * @version 1.0
 */
public class CaesarTest {

    /*
    * Instance that will be used to test
     */
    CaesarCipher cipher;

    /**
     * View for printing data
     */
    View view;

    /*
    * Checks if message is encrypted correctly.
     */
    @Test
    public void testEncrypting() {
        this.view = new View();
        ArrayList<String> words = new ArrayList<String>();
        words.add("Ala");
        words.add("ma");
        words.add("kota");
        words.add("ZZZ");
        try {
            cipher = new CaesarCipher(words, 'e', this.view);
        } catch (Exception e) {
            fail("Shouldn't fail - correct mode " + 'e' + " and arguments.");
        }

        String encrypted = cipher.getEncryptedMessage();
        String expected = "Dod pd nrwd CCC";

        if (!encrypted.equals(expected)) {
            System.out.println(encrypted.compareTo(expected));
            fail("Wrong encrypted message, should be: " + expected + ", is: " + encrypted);
        }
        
        view.printMessage("Encrypting test OK");
    }

    /*
    * Checks if message is decrypted correctly.
     */
    @Test
    public void testDecrypting() {
        this.view = new View();

        ArrayList<String> words = new ArrayList<String>();
        words.add("ccc");
        words.add("DDD");
        words.add("ZZZ");
        try {
            cipher = new CaesarCipher(words, 'd', this.view);
        } catch (Exception e) {
            fail("Shouldn't fail - correct mode " + 'd' + " and arguments.");
        }

        String decrypted = cipher.getDecryptedMessage();
        String expected = "zzz AAA WWW";

        if (!decrypted.equals(expected)) {
            System.out.println(decrypted.compareTo(expected));
            fail("Wrong decrypted message, should be: " + expected + ", is: " + decrypted);
        }
        
        view.printMessage("Decrypting test OK");
    }

    /*
    * Checks if wrong mode is caught
     */
    @Test
    public void testCheckingMode1() {
        this.view = new View();

        ArrayList<String> words = new ArrayList<String>();
        words.add("ccc");
        words.add("DDD");
        words.add("ZZZ");

        char testMode = 'x';

        try {
            cipher = new CaesarCipher(words, testMode, this.view);
            fail("Should throw mode exception. Mode is " + testMode + ", should be 'e' or 'd'");
        } catch (ModeException e) {
            view.printMessage("Mode error: " + e.getMessage());
        }
        
        view.printMessage("Mode test 1 OK");
    }

    @Test
    public void testCheckingMode2() {
        this.view = new View();
        
        Main main = new Main();

        String[] args = {"eWordMode", "Ala", "ma", "kota"};

        try {
            main.main(args);
        } catch (Exception e) {
            fail("Shouldn't fail. Mode is " + args[0] + ", should be 'e' or 'd'");
        }
        
        view.printMessage("Mode test 2 OK");
    }

}
