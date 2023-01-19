package com.code_cracker;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Unit test for simple App.
 */
class CodeCrackerTest {
    @Test
    void getPositionInAlphabet() {
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.getPosition("c", false)).isEqualTo(2);
    }

    @Test
    void getPositionInDecryptionKey() {
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.getPosition("(", true)).isEqualTo(3);
    }


    @Test
    void getLetterForPosition() {
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.getForPosition(2, false)).isEqualTo("\"");
    }

    @Test
    void encryptLetter() {
        final String letter = "a";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(letter, false)).isEqualTo("!");
    }

    @Test
    void encryptB() {
        final String letter = "b";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(letter, false)).isEqualTo(")");
    }

    @Test
    void encryptWord() {
        final String word = "julius";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, false)).isEqualTo("<ja>jh");
    }

    @Test
    void encryptWordTwo() {
        final String word = "not julius";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, false)).isEqualTo("cdi <ja>jh");
    }

    @Test
    void decryptWord() {
        final String word = "<ja>jh";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, true)).isEqualTo("julius");
    }

    @Test
    void decryptWordTwo() {
        final String word = "cdi <ja>jh";
        final var alphabet = "abcdefghijklmnopqrstuvwxyz";
        final String decryptionKey = "!)\"(£*%&><@abcdefghijklmno";

        CodeCracker cc = new CodeCracker(alphabet, decryptionKey);

        assertThat(cc.crypt(word, true)).isEqualTo("not julius");
    }

}
