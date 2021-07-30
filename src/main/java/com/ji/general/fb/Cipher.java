package com.ji.general.fb;

/*
input = "Zebra-493?";
rotationFactor = 3;
output = Cheud-726?;
 */
public class Cipher {
    public static void main(String[] args) {
        System.out.println(rotationalCipher("Zebra-493?", 3));
        System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
        //System.out.println(rotationalCipher("abcDE", 3));
    }

    public static String rotationalCipher(String input, int rotationFactor) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int num = ((c - '0') + rotationFactor) % 10;
                output += num;
            } else if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    int letter = ((c - 'a') + rotationFactor) % 26;
                    output += (char) ('a' + letter);
                } else {
                    int letter = ((c - 'A') + rotationFactor) % 26;
                    output += (char) ('A' + letter);
                }
            } else {
                output += c;
            }
        }
        return output;
    }
}
