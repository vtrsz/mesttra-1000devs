package Exercicios_12_09_2022;

import java.util.Scanner;

/*Faça um algoritmo para ler três notas de um aluno em uma disciplina e imprimir a
sua média ponderada (as notas tem pesos respectivos de 1, 2 e 3). Calcule o valor das notas com
base em seus pesos e além de apresentar a média, exiba a maior nota entre as 3 notas, ou a
mensagem “As 3 notas são iguais”, ou “As notas 1 e 2 são as maiores”, “As notas 1 e 3 são as
maiores”, “As notas 2 e 3 são as maiores” caso exista duas notas iguais e elas sejam as maiores. */

public class exercicio1 {
        public static float getNotas(String msg) {
            Scanner scanner;
            scanner = new Scanner(System.in);
            System.out.print("Digite o valor da " + msg + " nota:");
            return scanner.nextFloat();
        }
        public static float calculeMedia(float notaComPeso01, float notaComPeso02, float notaComPeso03, float peso01, float peso02, float peso03) {
            return (notaComPeso01 + notaComPeso02 + notaComPeso03) / (peso01 + peso02 + peso03);
        }
        public static void calculeNotas(float nota01, float nota02, float nota03) {
            float peso01, peso02, peso03;
            float notaComPeso01, notaComPeso02, notaComPeso03;
            float mediaPonderada;

            peso01 = 1.0f;
            peso02 = 2.0f;
            peso03 = 3.0f;

            notaComPeso01 = (nota01 * peso01);
            notaComPeso02 = (nota02 * peso02);
            notaComPeso03 = (nota03 * peso03);

            mediaPonderada = calculeMedia(notaComPeso01, notaComPeso02, notaComPeso03, peso01, peso02, peso03);

            System.out.printf("A media ponderada das notas %.2f, %.2f e %.2f é: %.2f\n", nota01, nota02, nota03, mediaPonderada);
            
            if ((notaComPeso01 > notaComPeso02) && (notaComPeso01 > notaComPeso03)) {
                System.out.printf("A nota01 (%.2f) é a maior nota após o calculo do peso %.0f (%.2f)", nota01, peso01, notaComPeso01);
            } else if ((notaComPeso02 > notaComPeso01) && (notaComPeso02 > notaComPeso03)) {
                System.out.printf("A nota02 (%.2f) é a maior nota após o calculo do peso %.0f (%.2f)", nota02, peso02, notaComPeso02);
            } else if ((notaComPeso03 > notaComPeso01) && (notaComPeso03 > notaComPeso02)) {
                System.out.printf("A nota03 (%.2f) é a maior nota após o calculo do peso %.0f (%.2f)", nota03, peso03, notaComPeso03);
            } else if ((notaComPeso01 == notaComPeso02) && (notaComPeso01 > notaComPeso03)) {
                System.out.printf("As nota01 (%.2f) e nota02 (%.2f) foram as maiores notas após o calculo dos pesos %.0f (%.2f) e %.0f (%.2f)", nota01, nota02, peso01, notaComPeso01, peso02, notaComPeso02);
            } else if ((notaComPeso02 == notaComPeso03) && (notaComPeso02 > notaComPeso01)) {
                System.out.printf("As nota02 (%.2f) e nota03 (%.2f) foram as maiores notas após o calculo dos pesos %.0f (%.2f) e %.0f (%.2f)", nota02, nota03, peso02, notaComPeso02, peso03, notaComPeso03);
            } else if ((notaComPeso03 == notaComPeso01) && (notaComPeso03 > notaComPeso02)) {
                System.out.printf("As nota03 (%.2f) e nota01 (%.2f) foram as maiores notas após o calculo dos pesos %.0f (%.2f) e %.0f (%.2f)", nota03, nota01, peso03, notaComPeso03, peso01, notaComPeso01);
            } else {
                System.out.println("As três notas foram iguais");
            }
        }
        public static void main(String[] args) {
            float nota01, nota02, nota03;
            
            nota01 = getNotas("primeira");
            nota02 = getNotas("segunda");
            nota03 = getNotas("terceira");
            
            calculeNotas(nota01, nota02, nota03);
        }
}