public class CardenetaPoupanca extends Thread{
    private String titular;
    private int diaAniversario;
    private double depositoInicial;
    private double redimentoAcumulado;

    public CardenetaPoupanca(String titular, int diaAniversario, double depositoInicial) throws Exception {
        if (diaAniversario < 1 || diaAniversario > 31) {
            throw new Exception("Dia de aniversário inválido. Deve estar entre 1 e 31.");
        }
        if (depositoInicial <= 0) {
            throw new Exception("Depósito inicial inválido. Deve ser maior que 0.");
        }
        this.titular = titular;
        this.diaAniversario = diaAniversario;
        this.depositoInicial = depositoInicial;
    }

    @Override
    public void run() {
        java.util.Random gerador = new java.util.Random();
        while (true) {
            double taxaRendimento = gerador.nextDouble(0.5, 1);
            try {
                atualizarRendimento(taxaRendimento);
                //System.out.println("Rendimento atualizado para " + this.titular + ": " + this.getSaldo());
                Thread.sleep(2000); // Pausa de 2 segundos
            } catch (Exception e) {
                System.out.println("Erro ao atualizar rendimento: " + e.getMessage());
            }
        }
    }

    public String getTitular() {
        return titular;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public double getRedimentoAcumulado() {
        return redimentoAcumulado;
    }

    public void atualizarRendimento(double prTaxa) throws Exception {
        if (prTaxa <= 0) {
            throw new Exception("Taxa de rendimento inválida. Deve ser maior que 0.");
        }
        redimentoAcumulado += (depositoInicial + redimentoAcumulado) * (prTaxa / 100);
    }

    public double getSaldo() {
        return depositoInicial + redimentoAcumulado;
    }

    public double getTaxaRendimentoAcumulada() {
        return redimentoAcumulado/depositoInicial;
    }
}
