import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		float salarioInicial;
		float salarioPosReajuste;
		float salarioFinal;
		float aumento = 0;
		float inss;
		float fgts;
		float totalDescontos;
		
		System.out.printf("Digite o Salário: ");
		
		salarioInicial = teclado.nextFloat();
		
		if (salarioInicial >= 0) {
			if ((salarioInicial > 0) && (salarioInicial < 2000)) {
				aumento = salarioInicial*0.15f;
		} else if ((salarioInicial >= 2000) && (salarioInicial < 3000)) {
				aumento = 0;
		} else if (salarioInicial >= 3000) {
				aumento = salarioInicial*0.1f;
				
		}
					
		salarioPosReajuste = salarioInicial + aumento;
					
		inss = salarioPosReajuste*0.11f;
		fgts = salarioPosReajuste*0.08f;
		totalDescontos = inss + fgts;
		salarioFinal = salarioPosReajuste - totalDescontos;
					
		System.out.printf("Salário Inicial: R$ %.2f\n", salarioInicial);
		System.out.printf("Aumento Salarial: R$ %.2f\n", aumento);
		System.out.printf("Desconto INSS: R$ %.2f\n", inss);
		System.out.printf("Desconto FGTS: R$ %.2f\n", fgts);
		System.out.printf("Total de descontos: R$ %.2f\n", totalDescontos);
		System.out.printf("Salário Final: R$ %.2f\n", salarioFinal);
		} else {
			System.out.print("O Salario não pode ser menor ou igual a 0!");
		}
	}
}