package Exercicios_primeira_avaliacao;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 

Escreva um algoritmo para funcionar em um caixa eletrônico. 
O usuário digita o valor em dinheiro a ser sacado e o algoritmo deve exibir a quantidade de notas de 100 reais, 50 reais, 20 reais, 10 reais, 5 reais. 
O algoritmo deve dar preferencia para calcular a quantidade sempre com as notas maiores possíveis.

Ex 01:
Digite a quantidade de dinheiro a ser sacada: 265

Quantidades
100 reais: 2
50 reais: 1
20 reais: 0
10 reais: 1
5 reais: 1

Qualquer exceção no código deve ser tratada com um try catch. Caso o valor informado seja menor ou igual a (zero), exibir a mensagem. "Valor precisa ser maior que 0".

*/

class exercicio1{
    public static void alert(String message) {
        System.out.println("\n" + message);
    }
    public static void main(String[] args) {
        System.out.print("Digite o valor que você deseja sacar: R$ ");
        Scanner scanner = new Scanner(System.in);
        int valor = 0;

        int[] notas = {100, 50, 10, 5};
        while (true) {
            try {
                valor = scanner.nextInt();
                if (valor <= 0) {
                    throw new InputMismatchException();
                } else if ((valor % 5) != 0) {
                    throw new InputMismatchException();
                }
                for (int i = 0; i < notas.length; i++) {
                    int qtdNotas = valor / notas[i];
                    valor = valor % notas[i];
                    System.out.println(qtdNotas + " nota(s) de R$ " + notas[i]);
                }
                scanner.close();
                break;
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                if (valor <= 0) {
                    alert("Valor inválido! Digite um valor maior que 0!\n");
                } else {
                    alert("Valor inválido! Nossa menor cédula é 5\nPor favor digite um valor inteiro multiplo de 5!\n");
                }
                System.out.print("Digite o valor que você deseja sacar: R$ ");
            }
        }
    }
}