package Exercicios_16_09_2022;

/*
02) Crie um algoritmo que o usuário entre com vários números inteiros e positivos e imprima o multiplicação dos números ímpares e a soma dos números pares.
O algoritmo finaliza quando o usuário digita o número 0.
*/

import java.util.Scanner;

public class Exercicio2 {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static void main(String[] args) {
        int numero = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para encerrar digite: 0");
        do {
            try {
                System.out.print("Digite um número inteiro e positivo: ");
                numero = scanner.nextInt();

                if (isNegative(numero)) {
                    throw new NegativeNumberException("Erro! Digite um número inteiro e positivo.");
                }

                if (isEven(numero)) {
                    System.out.println("O número é par");
                } else {
                    System.out.println("O número é ímpar");
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "Erro! Digite um número inteiro e positivo.";
                }
                System.out.println(message);
                scanner = new Scanner(System.in);
            }
        } while (numero != 0);
    }
}


