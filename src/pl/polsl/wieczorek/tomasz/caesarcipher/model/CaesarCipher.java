/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.wieczorek.tomasz.caesarcipher.model;

import java.util.ArrayList;
import java.util.List;
import pl.polsl.wieczorek.tomasz.caesarcipher.modeexception.ModeException;

/**
 * Class corresponding to message encrypting and decrypting
 *
 * @author Tomasz Wieczorek
 * @version 3.0
 */
public class CaesarCipher {

    /**
     * message after encoding or message before decoding
     */
    private ArrayList<String> encryptedMessage;

    /**
     * message before encoding or message before encoding
     */
    private ArrayList<String> decryptedMessage;

    /**
     * mode of operation - 'e' for encoding, 'd' for decoding
     */
    private char mode;

    /**
     * number of characters by which message is shifted
     * (encrypted)
     */
    private int shift;

    /**
     * Default constructor
     *
     * @param message - message
     * @param mode - mode of operation
     */
    public CaesarCipher(ArrayList<String> message, char mode) {
        if (mode == 'e') {
            this.decryptedMessage = message;
        } else if (mode == 'd') {
            this.encryptedMessage = message;
        } else {
            view.throwModeException();
        }

        this.mode = mode;
        this.shift = 3;
    }

    /**
     * Method to encrypt messages.
     */
    public void encryptMessage() {
        int encryptShift = this.shift;
        this.encryptedMessage = this.cipherizeMessage(encryptShift, decryptedMessage);
    }

    /**
     * Method to decrypt messages. As cipherizeMessage is repetative, we can use
     * decryptShift to obtain decoding.
     */
    public void decryptMessage() {
        int decryptShift = 26 - this.shift;

        this.decryptedMessage = this.cipherizeMessage(decryptShift, encryptedMessage);
    }

    /**
     * Method to set initially encrypted messages.
     *
     * @param msg value of message
     */
    public void setEncryptedMessage(ArrayList<String> msg) {
        this.encryptedMessage = msg;
    }

    /**
     * Method to set initially decrypted messages.
     *
     * @param msg value of message
     */
    public void setDecryptedMessage(ArrayList<String> msg) {
        this.decryptedMessage = msg;
    }

    /**
     * Method to return value of encrypted message
     *
     * @return value of encrypted message
     */
    public String getEncryptedMessage() {
        StringBuilder messageMerged = new StringBuilder();
        this.encryptedMessage.forEach(msg
                -> {
            messageMerged.append(msg);
            messageMerged.append(" ");
        });

        return messageMerged.toString();
    }

    /**
     * Method to return value of decrypted message
     *
     * @return value of decrypted message
     */
    public String getDecryptedMessage() {
        StringBuilder messageMerged = new StringBuilder();
        this.decryptedMessage.forEach(msg
                -> {
            messageMerged.append(msg);
            messageMerged.append(" ");
        });

        return messageMerged.toString();
    }

    /**
     * Default method to encrypt messages. It uses modulo, so its repetative for
     * k*26+l.
     *
     * @param int shift by which shifting is done (e.g. 3 - encrypt, 23 - decrypt)
     * @param words message to be encrypted or decrypted
     */
    private ArrayList<String> cipherizeMessage(int shift, ArrayList<String> words) {

        StringBuilder result = new StringBuilder();
        ArrayList<String> cipherizedMessage = new ArrayList<String>();

        for (String word  : words) {
            result.delete(0, result.length());
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    char ch = (char) (((int) word.charAt(i)
                            + shift - 65) % 26 + 65);
                    result.append(ch);
                } else {
                    char ch = (char) (((int) word.charAt(i)
                            + shift - 97) % 26 + 97);
                    result.append(ch);
                }
            }
            cipherizedMessage.add(result.toString());
        }
        return cipherizedMessage;
    }
}
