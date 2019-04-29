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
import pl.polsl.wieczorek.tomasz.caesarcipher.modeexception.ModeException;

/**
 * Class for unit test of CeasarCipher
 *
 * @author Tomasz Wieczorek
 * @version 1.0
 */
public class CaesarTest {

    CaesarCipher cipher;

    /*
    * Checks if message is encrypted correctly.
     */
    @Test
    public void testEncrypting() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Ala");
        words.add("ma");
        words.add("kota");
        words.add("ZZZ");
        cipher = new CaesarCipher(words, 'e');

        cipher.encryptMessage();

        String encrypted = cipher.getEncryptedMessage();
        String expected = "Dod pd nrwd CCC";

        if (encrypted != expected) {
            fail("Wrong encrypted message, should be: " + expected + ", is: " + encrypted);
        }
    }

    /*
    * Checks if message is encrypted correctly.
     */
    @Test
    public void testDecrypting() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("ccc");
        words.add("DDD");
        words.add("ZZZ");
        cipher = new CaesarCipher(words, 'd');

        cipher.decryptMessage();

        String decrypted = cipher.getEncryptedMessage();
        String expected = "zzz AAA WWW";

        if (decrypted != expected) {
            fail("Wrong encrypted message, should be: " + expected + ", is: " + decrypted);
        }
    }

    /*
    * Checks if message is encrypted correctly.
     */
    @Test
    public void testMode() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("ccc");
        words.add("DDD");
        words.add("ZZZ");

        try {
            cipher = new CaesarCipher(words, 'd');
        } catch (ModeException e) {
            view.printMessage("Mode error: " + e.getMessage());
        }

        cipher.decryptMessage();

        String decrypted = cipher.getEncryptedMessage();
        String expected = "zzz AAA WWW";

        if (decrypted != expected) {
            fail("Wrong encrypted message, should be: " + expected + ", is: " + decrypted);
        }
    }

}
