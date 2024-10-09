package Prova2;

public class CoberturaVacinalUtil {
    
    public static void main(String[] args) throws Exception {
        CoberturaVacinal[] ficha = new CoberturaVacinal[3];

        try {
            ficha[0] = new CoberturaVacinal("Conquista", "BA", 230000);
            ficha[1] = new CoberturaVacinal("Planalto", "BA", 9500);
            ficha[2] = new CoberturaVacinal("Xique-Xique", "BA", 5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            ficha[0].atualizarCobertura(30000);
            ficha[1].atualizarCobertura(258);
            ficha[2].atualizarCobertura(67);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        for(int i = 0; i < ficha.length; i++) {
            System.out.println("================================================");
            System.out.println("Cidade: "+ficha[i].getMunicipio());
            System.out.println("Estado: " + ficha[i].getEstado());
            System.out.println("Habitantes: " + ficha[i].getHabitantes());
            System.out.println("Habitantes imunizados: " + ficha[i].getImunizados());
            System.out.println("Habitantes sem cobertura: " + ficha[i].getHabitantesSemCobertura());
            System.out.println("Percentual de vacina: " + ficha[i].getPercentual()+" %");
            System.out.println("================================================");
            
        }
        
        CoberturaVacinal maior = ficha[0];
        CoberturaVacinal menor = ficha[0];

        for(int i = 0; i < ficha.length; i++) {
            if(ficha[i].getPercentual() > maior.getPercentual()) {
                maior = ficha[i];
            }
            if(ficha[i].getPercentual() < menor.getPercentual()) {
                menor = ficha[i];
            }
        }
        
        System.out.println("================================================");
        System.out.println("Municipio com maior cobertura: " + maior.getMunicipio()+" - "+maior.getEstado());
        System.out.println("Percentual: " + maior.getPercentual()+" %");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println("Municipio com menor cobertura: " + menor.getMunicipio()+" - "+menor.getEstado());
        System.out.println("Percentual: " + menor.getPercentual()+ " %");
        System.out.println("================================================");

    }

}