package Exercicios_16_09_2022;

/*
01) Construa um algoritmo que imprima a tabela de equivalência de graus Fahrenheit para centígrados. Os limites são de 32 a 200 graus Fahrenheit com intervalo de 1 grau.

Fórmula de Fahrenheit para Celcius é: (5 / 9 * (Fahrenheit -32))

Exemplo:

Fahrenheit     Celcius
32              0.00
33              0.56
34              1.11
...
200             93.33
*/

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Fahrenheit\tCelcius");
        for (int i = 32; i <= 200; i++) {
            float fahrenheit = (float) (5.0 / 9.0 * (i - 32));
            System.out.printf("%3d \t\t%.2f\n", i, fahrenheit);
        }
    }
}