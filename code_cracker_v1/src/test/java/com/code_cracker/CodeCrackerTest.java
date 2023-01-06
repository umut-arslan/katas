package com.code_cracker;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
class CodeCrackerTest
{
    @Test
    void getPositionInAlphabet() {
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals(2, cc.getPositionInAlphabet("c"));
    }


    @Test
    void getLetterForPosition(){
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("\"", cc.getLetterForPosition(2));
    }
    @Test
    void encryptLetter() {
        String letter = "a";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("!", cc.encrypt(letter));
    }
    @Test
    void encryptB() {
        String letter = "b";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals(")", cc.encrypt(letter));
    }

    @Test
    void encryptWord() {
        String word = "julius";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("<ja>jh", cc.encrypt(word));
    }

    @Test
    void encryptWordTwo() {
        String word = "not julius";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("cdi <ja>jh", cc.encrypt(word));
    }
    @Test
    void decryptWord() {
        String word = "<ja>jh";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("julius", cc.decrypt(word));
    }

    @Test
    void decryptWordTwo() {
        String word = "cdi <ja>jh";
        String alphabet =      "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";
        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);
        assertEquals("not julius", cc.decrypt(word));
    }

}
