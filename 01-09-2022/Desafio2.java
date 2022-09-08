import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float minimumPayment = scanner.nextFloat();
        scanner = new Scanner(System.in);
        float payment = scanner.nextFloat();

        if (payment < minimumPayment) {
            System.out.println("Funcionário ganha menos que um salário mínimo");
        } else {
            float result = payment / minimumPayment;
            System.out.println("O funcionário recebe " + result + " salários mínimos!");
        }
    }
}