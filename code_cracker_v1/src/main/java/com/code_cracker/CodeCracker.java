package com.code_cracker;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
@AllArgsConstructor
class CodeCracker {
    private final String alphabet;
    private final String decryptionKey;

    public int getPosition(final String letter, final boolean decrypt) {
        final String[] idx = !decrypt ? alphabet.split(" ") : decryptionKey.split(" ");
        return Arrays
                .stream(idx)
                .toList()
                .indexOf(letter);
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

    public String crypt(final String word, final boolean decrypt) {
        return word
                .chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(letter -> getPosition(letter, decrypt))
                .map(!decrypt ? this::getLetterForPosition : this::getDecryptionForPosition)
                .collect(Collectors.joining());
    }
}