package com.code_cracker;

import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

/**
 * Hello world!
 */
@AllArgsConstructor
class CodeCracker {
    private final String alphabet;
    private final String decryptionKey;

    public int getPosition(final String letter, final boolean decrypt) {
        return !decrypt ? alphabet.indexOf(letter) : decryptionKey.indexOf(letter);
    }

    public String getForPosition(final int i, final boolean decrypt) {
        return (i == -1) ? decrypt ? alphabet.substring(i, i + 1) : decryptionKey.substring(i, i + 1) : " ";
    }

    public String crypt(final String word, final boolean decrypt) {
        return word
                .chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(letter -> getPosition(letter, decrypt))
                .map(!decrypt ? (pos -> getForPosition(pos, false)) : (pos -> getForPosition(pos, true)))
                .collect(Collectors.joining());
    }
}