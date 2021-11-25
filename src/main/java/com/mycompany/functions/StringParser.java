package com.mycompany.functions;

import java.util.*;
import java.util.regex.*;

public class StringParser {
    public static void main(String[] args) {
        String output = wordParser("Creativity is .thinking-up new things. Innovation is doing new things!");
        System.out.println(output);
    }

    public static String wordParser(String input) {
        String[] words = input.split(" ");
        StringBuilder finalResult = new StringBuilder();

        for (String word : words) {
            String result = doMagic(word);
            finalResult.append(result).append(" ");
            //System.out.println("Word ::: " + word);
        }

        return finalResult.toString().trim();
    }

    public static String doMagic(String word) {
        //System.out.println("Word :: " + word);
        char[] characters = word.toCharArray();
        StringBuilder magicDone = new StringBuilder();

        //boolean specialChar = HasSpecialChar(word);
        boolean specialChar = word.matches("(.*)[^a-zA-Z0-9](.*)");
        //System.out.println("Word :: " + word + " :: has special chars ::: " + specialChar);

        if (specialChar) {
            doMagicWithNonAlphanumeric(characters, magicDone);

        } else {
            if (characters.length < 3) {
                magicDone.append(word);
            } else {
                magicTrick(characters, magicDone);
            }
        }

        return magicDone.toString();
    }

    private static void magicTrick(char[] characters, StringBuilder magicDone) {
        boolean firstLetter = true;
        int letterCount = 0;
        Set<Character> pastCharacters = new HashSet<>();
        for (int i = 0; i < characters.length; i++) {
            if (firstLetter) {
                magicDone.append(characters[i]);
                if (Character.isLetter(characters[i])) {
                    firstLetter = false;
                }
            } else {
                if (i == (characters.length - 1)) {
                    magicDone.append(letterCount);
                    magicDone.append(characters[i]);
                } else {
                    if (!pastCharacters.contains(characters[i])) {
                        letterCount++;
                        pastCharacters.add(characters[i]);
                    }
                }
            }

        }
    }

    private static void doMagicWithNonAlphanumeric(char[] characters, StringBuilder magicDone) {
        StringBuilder subWord = new StringBuilder();

        for (char character : characters) {
            if (Character.isLetter(character)) {
                subWord.append(character);
            } else {
                if (subWord.toString().trim().length() != 0) {
                    magicDone.append(doMagic(subWord.toString())).append(character);
                    subWord = new StringBuilder();
                } else {
                    magicDone.append(character);
                }
            }
        }

        if (subWord.toString().trim().length() != 0) {
            magicDone.append(doMagic(subWord.toString()));
        }
    }

    private static boolean HasSpecialChar(String word) {
        String pattern = "[^a-zA-z0-9]";
        Pattern p = Pattern.compile(pattern);
        return p.matcher(word).find();
    }
}
