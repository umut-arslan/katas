package com.code_cracker;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class CodeCracker
{
    private final String alphabet;
    private final String decryptionKey;
    public CodeCracker(String alphabet, String decryptionKey) {
        this.alphabet = alphabet;
        this.decryptionKey = decryptionKey;
    }
    public int getPositionInAlphabet(String letter) {
        String[] idx = alphabet.split(" ");
        int pos = -1;
        for (int i = 0; i < idx.length; i++) {
            if (Objects.equals(idx[i], letter)) {
                pos = i;
            }
        }
        return pos;
    }
    public int getPositionInDecryptionKey(String letter) {
        String[] idx = decryptionKey.split(" ");
        int pos = -1;
        for (int i = 0; i < idx.length; i++) {
            if (Objects.equals(idx[i], letter)) {
                pos = i;
            }
        }
        return pos;
    }

    public String encrypt(String word) {
        StringBuilder encryptedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
           encryptedWord.append(getLetterForPosition(getPositionInAlphabet(String.valueOf(word.charAt(i)))));
        }
        return encryptedWord.toString();
    }

    public String getLetterForPosition(int i) {
        String[] idx = decryptionKey.split(" ");
        if (i == -1) {
            return " ";
        }
        return idx[i];
    }

    public String getDecryptionForPosition(int i) {
        String[] idx = alphabet.split(" ");
        if (i == -1) {
            return " ";
        }
        return idx[i];
    }

    public String decrypt(String word) {
        StringBuilder decryptedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            decryptedWord.append(getDecryptionForPosition(getPositionInDecryptionKey(String.valueOf(word.charAt(i)))));
        }
        return decryptedWord.toString();
    }
}

