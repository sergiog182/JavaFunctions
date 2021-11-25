package com.mycompany.functions;

import java.util.*;
//import static java.util.Map.entry;

/**
 *
 * @author Sergio Alejandro Gutierrez Sanchez sergioa.gutierrezs@gmail.com
 */
public class Functions {
    //String[] array = {"a", "b", "c", "d", "e"};
    //final List<String> BRACKETS = Arrays.asList({"[", "]", "{", "}", "(", ")"});
    
    public static void main(String[] args) {
        System.out.println("Numero: " + distance(2, 3, 5, 2, 6, 8));
        
        System.out.println("Es o no abccba => " + IsCasiPalindromo("abccba"));
        System.out.println("Es o no abccbx => " + IsCasiPalindromo("abccbx"));
        System.out.println("Es o no abccfg => " + IsCasiPalindromo("abccfg"));
        System.out.println("Es o no oro => " + IsCasiPalindromo("oro"));
        System.out.println("Es o no anana => " + IsCasiPalindromo("anana"));
        System.out.println("Es o no oro oro=> " + IsCasiPalindromo("oro oro"));
        
        System.out.println("Numero mas popular en { 1,1,1,4,5,6,1 } : " + NumMasPopular(new int[]{ 1,1,1,4,5,6,1 }));
        System.out.println("Numero mas popular en { 22, 101, 102, 101, 102, 525, 88 } : " + NumMasPopular(new int[]{ 22, 101, 102, 101, 102, 525, 88 }));
        
        System.out.println("Sumar digitos de 29: " + addTwoDigits(29));
		
        System.out.println("Invertir solo letras y no caracteres especiales de Ab,c,TR& : " + reverseJustLetters("Ab,c,TR&"));
    }
    
    public static double distance(double x1, double y1, double x2, double y2, double x3, double y3) {
        double response = 0;
        double distanciaAB = Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
        double distanciaAC = Math.sqrt((Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2)));
        double distanciaBC = Math.sqrt((Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)));
        
        response = (distanciaAB + distanciaAC + distanciaBC) / 3;
        return response;
    }
    
    public static boolean IsCasiPalindromo(String palabra) {
        boolean response = true;
        char[] original = palabra.toCharArray();
        int difCount = 0;
        
        for (int i = (palabra.length() - 1), j = 0; i >= 0; i--, j++) {
            if (original[i] != original[j]) {
                difCount++;
            }
        }
        
        if (difCount > 2) {
            response = false;
        }
        
        return response;
    } 
    
    public static int NumMasPopular(int[] numbers) {
        HashMap<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (numberCount.containsKey(numbers[i])) {
                int count = numberCount.get(numbers[i]) + 1;
                numberCount.replace(numbers[i], count);
            } else {
                numberCount.put(numbers[i], 1);
            }
        }
        
        int maxCount = 0;
        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNumber = entry.getKey();
            } else {
                if (entry.getValue() == maxCount && entry.getKey() < maxNumber) {
                    maxCount = entry.getValue();
                    maxNumber = entry.getKey();
                }
            }
        }
        
        return maxNumber;
    }
    
    public static int addTwoDigits(int n) {
        String original = Integer.toString(n);
        char[] digits = original.toCharArray();
        
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Integer.parseInt(Character.toString(digits[i]));
        }
        
        return sum;
    }
	
    public static String reverseJustLetters(String word) {

        char[] parts = word.toCharArray();
        List<String> cleared = new ArrayList<String>();

        for (int x = 0; x < parts.length ; x++) {
            if (Character.isLetter(parts[x])) {
                cleared.add(String.valueOf(parts[x]));
            }
        }

        Collections.reverse(cleared);

        int counter = 0;
        for (int x = 0; x < parts.length ; x++) {
            if (Character.isLetter(parts[x])) {
                parts[x] = cleared.get(counter).charAt(0);
                counter++;
            }
        }

        return String.valueOf(parts); 
    }
}