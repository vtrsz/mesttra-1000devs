package Exercicios_01_09_2022;

import java.util.Scanner;

public class Desafio1 {
    public static void main(String[] args) {
        System.out.print("Quantos metros o terreno possui de frente: ");
        Scanner scanner = new Scanner(System.in);
        float frente = scanner.nextFloat();
        scanner = new Scanner(System.in);
        System.out.print("Quantos metros o terreno possui de lateral: ");
        float lateral = scanner.nextFloat();
        scanner = new Scanner(System.in);
        System.out.print("Informe o valor do metro quadrado: R$ ");
        float valorMetroQuadrado = scanner.nextFloat();
        float area = frente * lateral;
        float valorTotal = area * valorMetroQuadrado;
        scanner.close();
        System.out.println("Area total do terreno de " + frente + " mts de frente com " + lateral + " de lateral é: " + area + " mts²");
        if (area < (frente * 0.10f)) {
            valorTotal = valorTotal + (valorTotal * 0.22f);
            System.out.printf("O terreno recebeu um acréscimo de 22%% e custará: R$ %.2f", valorTotal);
        } else if (frente < (lateral * 0.40f)) {
            valorTotal = valorTotal - (valorTotal * 0.12f);
            System.out.printf("O terreno recebeu um decréscimo de 12%% e custará: R$ %.2f", valorTotal);
        } else if (frente > (lateral * 0.70f)) {
            valorTotal = valorTotal - (valorTotal * 0.15f);
            System.out.printf("O terreno recebeu um decréscimo de 15%% e custará: R$ %.2f", valorTotal);
        } else {
            System.out.printf("O valor do terreno é: R$ %.2f", valorTotal);
        }
    }
}