public class Main {
    public static void main(String[] args) throws Exception {
        CardenetaPoupanca cardenetaPoupanca = new CardenetaPoupanca("Jean", 9, 125);

        cardenetaPoupanca.atualizarRendimento(0.61);
        cardenetaPoupanca.atualizarRendimento(0.61);
        cardenetaPoupanca.atualizarRendimento(0.58);
        cardenetaPoupanca.atualizarRendimento(0.57);
        cardenetaPoupanca.atualizarRendimento(0.59);
        cardenetaPoupanca.atualizarRendimento(0.5);

        System.out.println(cardenetaPoupanca.getTitular());
        System.out.println(cardenetaPoupanca.getDiaAniversario());
        System.out.println(cardenetaPoupanca.getDepositoInicial());
        System.out.println(cardenetaPoupanca.getRedimentoAcumulado());
        System.out.println(cardenetaPoupanca.getSaldo());
        System.out.println(cardenetaPoupanca.getTaxaRendimentoAcumulada());
    }
}
