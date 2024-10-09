package Prova2;

public class CoberturaVacinal extends Thread{
    private String municipio;
    private String estado;
    private int habitantes;
    private int habitantesImunizados;
    boolean executando = true;

    public CoberturaVacinal(String municipio, String estado, int habitantes) throws Exception {
        this.municipio = municipio;
        if(municipio == null || municipio.isEmpty()) {
            throw new Exception("Insira um nome valido de municipio");
        }
        this.estado = estado;
        if(estado == null || estado.length() != 2) {
            throw new Exception("Insira apenas a sigla do estado");
        }
        this.habitantes = habitantes;
        if(habitantes <= 0) {
            throw new Exception("Insira uma quantidade valida de habitantes");
        }
        this.habitantesImunizados = 0;
    }

    public String getMunicipio() {
        return municipio;
    }
    public String getEstado() {
        return estado;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public int getImunizados() {
        return habitantesImunizados;
    }

    public void atualizarCobertura(int qtd) throws Exception{
        if(qtd <= 0) {
            throw new Exception("Insira uma quantidade valida");
        }
        habitantesImunizados += qtd;
    }
    public int getHabitantesSemCobertura() {
        int semCobertura = habitantes - habitantesImunizados;
        return semCobertura;
    }
    public double getPercentual() {
        double percentual = (double)habitantesImunizados / habitantes * 100;
        return percentual;
    }

    public void parar() {
        executando = false;
    }

    @Override
    public void run() {
        
        java.util.Random gerador = new java.util.Random();
        int totalMaximo = (int)(habitantes * 0.01);
        while (executando) {
            
            int qtd = gerador.nextInt(1, totalMaximo);

            try {
                atualizarCobertura(qtd);;
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}