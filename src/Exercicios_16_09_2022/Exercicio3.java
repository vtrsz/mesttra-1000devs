package Exercicios_16_09_2022;

/*
03) Foi feita uma pesquisa entre os habitantes de uma região e coletados os dados de altura e sexo (m, f) das pessoas.
    Faça um programa que leia estes dados e que continue a leitura caso o usuário responda (s) e pare a execução ele digitar (n).

    No final exiba os seguintes dados:
    - média da altura das mulheres;
    - maior e a menor altura;
    - percentual de homens que participaram da pesquisa;
*/

import java.util.Scanner;

public class Exercicio3 {
    public static char getChar(Scanner scanner) {
        do {
            try {
                String input = scanner.nextLine();
                if (input.length() != 1) {
                    throw new Exception("Erro! Opção inválida. Digite novamente (m, f): ");
                } else {
                    return input.charAt(0);
                }
            } catch (Exception ex) {
                scanner = new Scanner(System.in);
                String message = ex.getMessage();
                if (message == null) {
                    message = "Erro! Opção inválida. Digite novamente (m, f): ";
                }
                System.out.print(message);
            }
        } while (true);
    }
    public static void main(String[] args) {
        char continuar = '0';
        char sexo;
        boolean firstRun = true;
        float altura;
        float quantidadeMulheres = 0;
        float quantidadeHomens = 0;
        float somaAlturaMulheres = 0;
        float maiorAltura = 0;
        float menorAltura = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print("Digite a altura: ");
                altura = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Digite o sexo (m, f): ");
                sexo = Character.toLowerCase(getChar(scanner));

                System.out.print("Deseja continuar? (s/n): ");
                continuar = Character.toLowerCase(getChar(scanner));

                if (sexo != 'm' && sexo != 'f') {
                    throw new Exception("Sexo inválido!");
                }

                if (altura > maiorAltura) {
                    maiorAltura = altura;
                }

                if (firstRun) {
                    menorAltura = altura;
                } else if (altura < menorAltura) {
                    menorAltura = altura;
                }

                if (sexo == 'f') {
                    quantidadeMulheres++;
                    somaAlturaMulheres += altura;
                } else if (sexo == 'm') {
                    quantidadeHomens++;
                }

                while (continuar != 's' && continuar != 'n') {
                        System.out.println("Resposta inválida!");
                        System.out.print("Deseja continuar? (s/n): ");
                        continuar = Character.toLowerCase(getChar(scanner));
                }

                firstRun = false;

            } catch (Exception e) {
                scanner = new Scanner(System.in);
                String message = e.getMessage();
                if (message == null) {
                    message = "Erro!";
                }
                System.out.println(message);
            }
        } while (continuar == 's');
        scanner.close();
        float mediaAlturaMulheres = somaAlturaMulheres / quantidadeMulheres;
        float percentualHomens = (quantidadeHomens / (quantidadeHomens + quantidadeMulheres)) * 100;
        System.out.printf("Média da altura das mulheres: %.2f\n", mediaAlturaMulheres);
        System.out.printf("Maior altura: %.2f\n", maiorAltura);
        System.out.printf("Menor altura: %.2f\n", menorAltura);
        System.out.printf("Percentual de homens que participaram da pesquisa: %.2f%%", percentualHomens);
    }
}
