import java.util.Scanner;

public class Desafio4 {
    public static void main(String[] args) {
        System.out.print("Informe quantidade de cavalos: ");
        Scanner scanner = new Scanner(System.in);
        float cavalos = scanner.nextFloat();
        System.out.print("Informe o valor de cada ferradura R$: ");
        scanner = new Scanner(System.in);
        float ferraduraPrice = scanner.nextFloat();
        float ferradurasQuantityNeeded = cavalos * 4;
        float result = ferradurasQuantityNeeded * ferraduraPrice;
        float finalPrice = 0.0f;
        scanner.close();
        if (result >= 30000.01){
            finalPrice = result - (result * 0.20f);
        } else if (result >= 25000.01 && result <= 30000.00) {
            finalPrice = result - (result * 0.15f);
        } else if (result >= 20000.01 && result <= 25000.00) {
            finalPrice = result - (result * 0.12f);
        } else if (result >= 15000.01 && result <= 20000.00) {
            finalPrice = result - (result * 0.10f);
        } else {
            finalPrice = result;
        }
        System.out.println("Quantidade de ferraduras necessárias " + ferradurasQuantityNeeded);
        System.out.print("O valor total das ferraduras é: " + finalPrice);
    }
}