package com.code_cracker;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Unit test for simple App.
 */
class CodeCrackerTest {
    @Test
    void getPositionInAlphabet() {
        final var alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.getPosition("c", false)).isEqualTo(2);
    }


    @Test
    void getLetterForPosition() {
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.getLetterForPosition(2)).isEqualTo("\"");
    }

    @Test
    void encryptLetter() {
        final String letter = "a";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(letter, false)).isEqualTo("!");
    }

    @Test
    void encryptB() {
        final String letter = "b";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(letter, false)).isEqualTo(")");
    }

    @Test
    void encryptWord() {
        final String word = "julius";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, false)).isEqualTo("<ja>jh");
    }

    @Test
    void encryptWordTwo() {
        final String word = "not julius";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, false)).isEqualTo("cdi <ja>jh");
    }

    @Test
    void decryptWord() {
        final String word = "<ja>jh";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, true)).isEqualTo("julius");
    }

    @Test
    void decryptWordTwo() {
        final String word = "cdi <ja>jh";
        final String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        final String decryptionKey = "! ) \" ( £ * % & > < @ a b c d e f g h i j k l m n o";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, true)).isEqualTo("not julius");
    }

}
