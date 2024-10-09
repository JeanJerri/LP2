package Prova2;
import java.util.Scanner;

public class CoberturaVacinalThreads {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("Bem vindo ao sistema de controle de vacinas");
        CoberturaVacinal[] ficha = new CoberturaVacinal[5];
        
        try {
            for(int i = 0; i < ficha.length; i++) {
                System.out.println("===========================================");
                System.out.println("Insira um municipio: ");
                String municipio = sc.nextLine();
                System.out.println("Insira um estado: ");
                String estado = sc.nextLine();
                System.out.println("Insira a quantidade de habitantes: ");
                int habitantes = sc.nextInt();
                sc.nextLine();
                ficha[i] = new CoberturaVacinal(municipio, estado, habitantes);
                ficha[i].start();
            }
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }

        boolean rodando = true;
        while(rodando) {
            System.out.println("==============================================");
            System.out.println("Consultar percentual de vacinação");
            for (int i = 0; i < ficha.length; i++) {
                System.out.println((i + 1) + " - " + ficha[i].getMunicipio());
            }
            System.out.println("6 - Fechar programa");
            System.out.println("==============================================");
            int opcao = sc.nextInt();

            if (opcao >= 1 && opcao <= 5) {
                int index = opcao - 1;
                CoberturaVacinal cv = ficha[index];
                System.out.println("================================================");
                System.out.println("Cidade: " + cv.getMunicipio());
                System.out.println("Estado: " + cv.getEstado());
                System.out.println("Habitantes: " + cv.getHabitantes());
                System.out.println("Habitantes imunizados: " + cv.getImunizados());
                System.out.println("Habitantes sem cobertura: " + cv.getHabitantesSemCobertura());
                System.out.println("Percentual de vacina: " + cv.getPercentual() + " %");
                System.out.println("================================================");
            } else if (opcao == 6) {
                for (int i = 0; i < ficha.length; i++) {
                    ficha[i].parar();
                }
                System.out.println("Programa encerrado!");
                rodando = false;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close(); 
            
    }
}
        
    
