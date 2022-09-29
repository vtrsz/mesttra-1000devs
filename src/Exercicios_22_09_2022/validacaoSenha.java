package Exercicios_22_09_2022;

import java.lang.Exception;

public class validacaoSenha {
    public static boolean verifyUpperCaseQuantity(String password, int quantity){
        final String upperCaseLetter = "ABCDEFGHIJKLMNOPQRSTUVXYWZ";
        int upperCaseLetters= 0;

        for(int passwordIndex = 0; passwordIndex < password.length(); passwordIndex++){ // iteracao com a senha
            for(int listIndex = 0; listIndex < upperCaseLetter.length(); listIndex++) { //iteracao com as letras minusculas
                if (password.charAt(passwordIndex) == upperCaseLetter.charAt(listIndex)) {
                    upperCaseLetters++;
                }
            }
        }

        if (upperCaseLetters >= quantity) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyLowerCaseQuantity(String password, int quantity){
        final String lowerCaseLetter = "abcdefghijklmnopqrstuvxywz";
        int lowerCaseLetters = 0;

        for(int passwordIndex = 0; passwordIndex < password.length(); passwordIndex++){
            for(int listIndex = 0; listIndex < lowerCaseLetter.length(); listIndex++) {
                if (password.charAt(passwordIndex) == lowerCaseLetter.charAt(listIndex)) {
                    lowerCaseLetters++;
                }
            }
        }
        if (lowerCaseLetters >= quantity) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyNumberQuantity(String password, int quantity){
        int numberQuantity = 0;

        for(int passwordIndex = 0; passwordIndex < password.length(); passwordIndex++){
            if (Character.isDigit(password.charAt(passwordIndex))) {
                numberQuantity++;
            }
        }

        if (numberQuantity >= quantity) {
            return true;
        } else {
            return false;
        }
    }



    public static void main(String[] args) throws Exception {
        float[] passwordScore = new float[3];
        System.out.println(verifyUpperCaseQuantity("ABACaTe", 2));
        System.out.println(verifyLowerCaseQuantity("ABACaTe", 2));
        System.out.println(verifyNumberQuantity("4B4CaT3", 2));
    }
}