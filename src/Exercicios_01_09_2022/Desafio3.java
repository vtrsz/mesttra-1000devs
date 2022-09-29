package Exercicios_01_09_2022;

import java.util.Scanner;

public class Desafio3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        float value1 = scanner.nextFloat();

        scanner = new Scanner(System.in);
        float value2 = scanner.nextFloat();
        if (value1 == 0 || value2 == 0) {
            System.out.println("A operação não pode ser realizada");
        } else if (value1 > value2) {
            float result = value1 / value2;
            System.out.println("A divisão de " + value1 + " por " + value2 + " é: " + result);
        } else if (value2 > value1) {
            float result = value2 / value1;
            System.out.println("A divisão de " + value2 + " por " + value1 + " é: " + result);
        }
    }
}