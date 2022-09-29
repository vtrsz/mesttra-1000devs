package Exercicios_primeira_avaliacao;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map.Entry;

/*

Escreva um algoritmo para criar uma votação para síndico de um prédio. 
Deve ser lido 5 votos. Os candidatos são "Candidato A", "Candidato B", "Candidato C". 
O algoritmo deve exibir um menu com as opções conforme abaixo: "1 - Candidato A", "2 - Candidato B", "3 - Candidato C", "4 - Voto Nulo". 
O algoritmo deve apresentar a quantidade percentual de votos válidos, o percentual de cada candidato (apenas votos válidos, desconsiderando os votos nulos). 
Ao final o algoritmo deve imprimir o candidato vencedor.

 */

public class exercicio2 {
    public static void alert(String msg) {
        System.out.println(msg);
    }

    public static void menuInitialize(){
        alert("=========== Menu de Votação ===========");
        alert("1 - Candidato A");
        alert("2 - Candidato B");
        alert("3 - Candidato C");
        alert("4 - Voto Nulo");
        alert("=======================================\n");
    }
    public static void main(String[] args) {
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        int voto = 0;

        HashMap<String, Integer> candidatos = new HashMap<String, Integer>();
        candidatos.put("Candidato A", 0);
        candidatos.put("Candidato B", 0);
        candidatos.put("Candidato C", 0);
        candidatos.put("Nulo", 0);

        while (!success) {
            try {
                menuInitialize();

                while (voto < 5) {
                        System.out.print("Digite o seu voto: ");
                        int candidadoVotado = scanner.nextInt();
                        if (candidadoVotado == 1) {
                            alert("Você votou no Candidato A");
                            Integer candidatoA = candidatos.get("Candidato A");
                            candidatos.put("Candidato A", candidatoA + 1);
                        } else if (candidadoVotado == 2) {
                            Integer candidatoB = candidatos.get("Candidato B");
                            candidatos.put("Candidato B", candidatoB + 1);
                            alert("Você votou no Candidato B");
                        } else if (candidadoVotado == 3) {
                            Integer candidatoC = candidatos.get("Candidato C");
                            candidatos.put("Candidato C", candidatoC + 1);
                            alert("Você votou no Candidato C");
                        } else if (candidadoVotado == 4) {
                            Integer nulo = candidatos.get("Nulo");
                            candidatos.put("Nulo", nulo + 1);
                            alert("Você votou Nulo");
                        } else {
                            throw new InputMismatchException();
                        }
                        
                        scanner.nextLine();
                        voto += 1;
                }

                int totalVotosValidos = candidatos.get("Candidato A") + candidatos.get("Candidato B") + candidatos.get("Candidato C");
                int totalVotosNulos = candidatos.get("Nulo");
                if (totalVotosValidos == 0) {
                    voto = 0;
                    candidatos.put("Candidato A", 0);
                    candidatos.put("Candidato B", 0);
                    candidatos.put("Candidato C", 0);
                    candidatos.put("Nulo", 0);            
                    alert("\n" + new AllNullVotes().getMessage() + "\nOutra votação será iniciada.\n");
                } else {
                    int totalEleitores = totalVotosValidos + totalVotosNulos;
                    int totalVotos = (totalVotosValidos * 100) / totalEleitores;
            
                    String candidatoVencedor = "";
            
                    alert("\n=========== Resultado da Votação ===========");
                    System.out.println("Percentual de Votos Válidos é de " + totalVotos + "%");
            
                    int maiorQtdVotos = 0;
                    for (Entry<String, Integer> set : candidatos.entrySet()) {
                        String key = set.getKey();
                        Integer value = set.getValue();
                        if (key != "Nulo") {
                            if (value > maiorQtdVotos) {
                                maiorQtdVotos = value;
                                candidatoVencedor = key;
                            } else if (value == maiorQtdVotos) {
                                candidatoVencedor = "Empate";
                            }
                            System.out.println("Percentual de Votos do " + key + " é de " + ((value * 100) / totalVotosValidos) + "%");
                        }
                    };
                    
                    if (candidatoVencedor == "Empate") {
                        voto = 0;
                        candidatos.put("Candidato A", 0);
                        candidatos.put("Candidato B", 0);
                        candidatos.put("Candidato C", 0);
                        candidatos.put("Nulo", 0);
                        alert("\n" + new DrawVotes().getMessage() + "\nOutra votação será iniciada.\n");
                    } else {
                        System.out.println("E o candidato vencedor é o... " + candidatoVencedor + "!!!");
                        success = true;
                        scanner.close();
                    }
                    alert("============================================\n");
                    
                }
            } catch (InputMismatchException e) {
                scanner = new Scanner(System.in);
                alert("Você digitou um valor inválido!\n");
            }
        }
    }
}

class AllNullVotes extends RuntimeException {
    public AllNullVotes() {
        super("A votação não pode ser realizada, pois não houve votos válidos.");
    }
}

class DrawVotes extends RuntimeException {
    public DrawVotes() {
        super("A votação não pode ser realizada, pois houve empate entre os candidatos.");
    }
}