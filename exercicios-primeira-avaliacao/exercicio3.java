import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/* 
    Desenvolva um algoritmo para ler o nome, a idade, o sexo de 03 (três) indivíduos e imprimir “XXXX é criança”, se a idade for menor ou igual a 13 anos, 
    “XXXX é adolescente”, no caso de idade estar entre 13 e 20 anos, e “XXX é adulto”, se for até a idade 50 anos e "XXX é da melhor idade" acima de 50 anos. 
    XXX deve ser substituído pelo nome do indivíduo. No caso do sexo, o individuo pode digitar: F, f, m ou M. O algoritmo também deve imprimir ao final 
    a quantidade de indivíduos que são crianças, adolescentes, adultos e melhor idade.
    Deve ser informado também o nome do indivíduo mais Velho. 
    Qualquer exceção no código deve ser tratada com um try catch.
*/

class exercicio3 {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        int idade;
        char sexo;
        int maiorIdade = 0;
        String maisVelho = "";
        int criancas = 0;
        int adolescentes = 0;
        int adultos = 0;
        int melhorIdade = 0;
        for (int i = 0; i < 3; i++){
            try {
                System.out.print("Digite o nome da pessoa: ");
                nome = scanner.nextLine();
                if ((nome.getClass().getName() != "java.lang.String") || isNumeric(nome) ){
                    throw new InputMismatchException("Nome inválido");
                }
                System.out.print("Digite a idade da pessoa: ");
                idade = scanner.nextInt();
                scanner.nextLine();
                if (idade <= 0) {
                    throw new InputMismatchException("Idade inválida");
                }
                System.out.print("Digite o sexo da pessoa: ");
                sexo = scanner.next().charAt(0);
                scanner.nextLine();
                if (Character.toUpperCase(sexo) != 'M' && Character.toUpperCase(sexo) != 'F' ) {
                    throw new InputMismatchException("Sexo inválido");
                }
                Pessoa pessoa = new Pessoa(nome, idade, sexo);
                if (pessoa.getIdade() <= 13) {
                    System.out.println(pessoa.getNome() + " é criança");
                    criancas += 1;
                } else if (pessoa.getIdade() > 13 && pessoa.getIdade() <= 20) {
                    System.out.println(pessoa.getNome() + " é adolescente");
                    adolescentes += 1;
                } else if (pessoa.getIdade() > 20 && pessoa.getIdade() <= 50) {
                    System.out.println(pessoa.getNome() + " é adulto");
                    adultos += 1;
                } else {
                    System.out.println(pessoa.getNome() + " é da melhor idade");
                    melhorIdade += 1;
                }
                if (pessoa.getIdade() > maiorIdade) {
                    maisVelho = pessoa.getNome();
                    System.out.println("O mais velho é: " + maisVelho);
                }
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                if (e.getMessage() == null){
                    System.out.println("Valor inválido");
                } else {
                    System.out.println(e.getMessage());
                }
                i--;
            }
        }
        System.out.println("Quantidade de crianças: " + criancas);
        System.out.println("Quantidade de adolescentes: " + adolescentes);
        System.out.println("Quantidade de adultos: " + adultos);
        System.out.println("Quantidade de melhor idade: " + melhorIdade);
        System.out.println("O mais velho é: " + maisVelho);
    }
}