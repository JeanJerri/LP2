import java.util.Scanner;

public class CardenetaPoupancaUtil {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        CardenetaPoupanca[] cardenetas = new CardenetaPoupanca[3];

        for (int i = 0; i < cardenetas.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Informe o nome do titular:");
                    String titular = entrada.nextLine();
                    System.out.println("Informe o dia de aniversário (entre 1 e 31):");
                    int dia = entrada.nextInt();
                    System.out.println("Informe o valor do depósito inicial:");
                    double valor = entrada.nextDouble();
                    entrada.nextLine(); // Consumir a quebra de linha

                    // Tentativa de criar a caderneta
                    cardenetas[i] = new CardenetaPoupanca(titular, dia, valor);
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Tente novamente.\n");
                    entrada.nextLine(); // Consumir a quebra de linha
                }
            }
        }

        String opcao = "";
        while (!"d".equals(opcao)) {
            System.out.println("""
                Escolha uma operação:
                a) Atualizar rendimento
                b) Listar cadernetas por dia de aniversário
                c) Consultar caderneta por titular
                d) Encerrar
            """);
            opcao = entrada.nextLine();

            switch (opcao) {
                case "a":
                    System.out.println("Informe o nome do titular da conta que deseja atualizar o rendimento:");
                    String titular = entrada.nextLine();

                    for (int i = 0; i < cardenetas.length; i++) {
                        if (cardenetas[i].getTitular().equals(titular)) {
                            System.out.println(cardenetas[i].getTitular());
                            System.out.println(cardenetas[i].getSaldo());
                            boolean validTaxa = false;
                            while (!validTaxa) {
                                try {
                                    System.out.println("Informe a taxa percentual de rendimento:");
                                    double valor = entrada.nextDouble();
                                    entrada.nextLine(); // Consumir a quebra de linha
                                    cardenetas[i].atualizarRendimento(valor);
                                    validTaxa = true;
                                    System.out.println("Novo saldo: " + cardenetas[i].getSaldo() + "\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                            }
                        }
                    }
                    break;
                case "b":
                    System.out.println("Informe o dia de aniversário:");
                    int dia = entrada.nextInt();

                    for (int i = 0; i < cardenetas.length; i++) {
                        if (cardenetas[i].getDiaAniversario() == dia) {
                            System.out.println(cardenetas[i].getTitular());
                            System.out.println(cardenetas[i].getSaldo()+"\n");
                        }
                    }
                    break;
                case "c":
                    System.out.println("Informe o nome do titular da conta que deseja consultar os dados:");
                    String titular2 = entrada.nextLine();

                    for (int i = 0; i < cardenetas.length; i++) {
                        if (cardenetas[i].getTitular().equalsIgnoreCase(titular2)) {
                            System.out.println(cardenetas[i].getDepositoInicial());
                            System.out.println(cardenetas[i].getDiaAniversario());
                            System.out.println(cardenetas[i].getSaldo()+"\n");
                        }
                    }
                    break;
                case "d":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
