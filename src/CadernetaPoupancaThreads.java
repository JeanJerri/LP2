import java.util.Scanner;

public class CadernetaPoupancaThreads {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CardenetaPoupanca[] cardenetas = new CardenetaPoupanca[3];

        try {
            System.out.println("Informe o nome do titular:");
            String titular = entrada.nextLine();
            for (int i = 0; i < cardenetas.length; i++) {
                System.out.println("Informe o valor do depósito inicial da caderneta " + (i + 1) + ":");
                double depositoInicial = entrada.nextDouble();
                entrada.nextLine(); // Consumir a quebra de linha
                cardenetas[i] = new CardenetaPoupanca(titular, 15, depositoInicial); // Usando dia fixo para simplificar
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar caderneta: " + e.getMessage());
        }

        for (CardenetaPoupanca cp : cardenetas) {
            cp.start(); // Inicia as threads
        }

        String opcao = "";
        while (!"sair".equalsIgnoreCase(opcao)) {
            System.out.println("Deseja consultar saldo de qual caderneta (1, 2 ou 3)? Ou digite 'sair' para encerrar:");
            opcao = entrada.nextLine();
            if ("sair".equalsIgnoreCase(opcao)) {
                System.out.println("Encerrando...");
                break;
            }
            try {
                int indice = Integer.parseInt(opcao) - 1;
                if (indice >= 0 && indice < cardenetas.length) {
                    System.out.println("Saldo da caderneta " + (indice + 1) + ": " + cardenetas[indice].getSaldo());
                } else {
                    System.out.println("Caderneta inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
    }
}
