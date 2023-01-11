package com.code_cracker;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
@AllArgsConstructor
public class CodeCracker
{
    private final String alphabet;
    private final String decryptionKey;

    public int getPositionInAlphabet(final String letter) {
        final String[] idx = alphabet.split(" ");
        return Arrays.stream(idx).toList().indexOf(letter);
    }
    public int getPositionInDecryptionKey(final String letter) {
        final String[] idx = decryptionKey.split(" ");
        return Arrays.stream(idx).toList().indexOf(letter);
    }

    public String encrypt(final String word) {
        return word.chars().mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(this::getPositionInAlphabet).map(this::getLetterForPosition)
                .collect(Collectors.joining());
    }

    public String getLetterForPosition(final int i) {
        final String[] idx = decryptionKey.split(" ");
        if (i == -1) {
            return " ";
        }
        return idx[i];
    }

    public String getDecryptionForPosition(final int i) {
        final String[] idx = alphabet.split(" ");
        if (i == -1) {
            return " ";
        }
        return idx[i];
    }

    public String decrypt(final String word) {
        return word.chars().mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(this::getPositionInDecryptionKey).map(this::getDecryptionForPosition)
                .collect(Collectors.joining());
    }
}