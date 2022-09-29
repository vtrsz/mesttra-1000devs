package Exercicios_16_09_2022;

/*
04) Construa uma função que receba um número inteiro e verifique se o mesmo é primo e retorne o resultado
    true para um número primo e false para um número que não seja primo.
*/

import java.util.Scanner;

public class Exercicio4 {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Digite um número: ");
                int number = scanner.nextInt();
                if (isPrime(number)) {
                    System.out.println("O número " + number + " é primo.");
                } else {
                    System.out.println("O número " + number + " não é primo.");
                }
            } catch (Exception e) {
                scanner = new Scanner(System.in);
                String message = e.getMessage();
                if (message == null) {
                    message = "Digite um número inteiro válido!";
                }
                System.out.println("Erro: " + message);
            }
        }
    }
}
