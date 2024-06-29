package MAIUSCULAS_vs_minusculas;
import java.util.Scanner;
public class Controle_de_estoque_bobSponja {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistema de controle de estoque:");
        System.out.println("Quantos pães no estoque?");
        int paes = scanner.nextInt();
        System.out.println("Quantos Hambúrgueres no estoque?");
        int hamburguer = scanner.nextInt();
        System.out.println("Quantas folhas de alface no estoque?");
        int alface = scanner.nextInt();
        System.out.println("Quantas rodelas de cebola no estoque?");
        int cebola = scanner.nextInt();
        System.out.println("Quantas fatias de queijo no estoque?");
        int queijo = scanner.nextInt();
        scanner.close();

        // vai ser usado no fim do código
        int horasDeOperacao = 0;

        //ingredientes:
        // Hambúrguer de Siri
        int paesSiri = 1;
        int hamburSiri = 1;
        int foAlfaceSiri = 2;
        int cebolaSiri = 1;
        int queijoSiri = 2;
        // Hambúrguer de Siri luxo 
        int paesLuxo = 1;
        int hamburLuxo = 2;
        int foAlfaceLuxo = 2;
        int cebolaLuxo = 1;
        int queijoLuxo = 3;
        // Hambúrguer de Siri luxo duplo
        int paesDuplo = 1;
        int hamburDuplo = 4;
        int foAlfaceDuplo = 2;
        int cebolaDuplo = 2;
        int queijoDuplo = 5;
        // Combo cascudo
        int paesCombo = 2;
        int hamburCombo = 2;
        int foAlfaceCombo = 2;
        int cebolaCombo = 2;
        int queijoCombo = 2;

        //Preços
        // Hambúrguer de Siri preço
        double precoHSiri = 1.00;
        // Hambúrguer de Siri luxo 
        double precoHLuxo = 1.75;
        // Hambúrguer de Siri luxo duplo
        double precoHDuplo = 2.75;
        // Combo cascudo
        double precoHCombo = 2.00;
        // Faturamento 
        double faturamento = 0;

        //Vendas por hora 
        //vendasHSiri = 27
        //vendasHLuxo = 8
        //vendasHDuplo = 3
        //vendasHCombo = 14

        boolean podeOperar = true;

        //Verifica se os ingredientes são suficientes
        while (podeOperar){
                if (paes < paesSiri * 27 + paesLuxo * 8 + paesDuplo * 3 + paesCombo * 14) 
                break;
                if (hamburguer < hamburSiri * 27 + hamburLuxo * 8 + hamburDuplo * 3 + hamburCombo * 14)
                break;
                if (alface < foAlfaceSiri * 27 + foAlfaceLuxo * 8 + foAlfaceDuplo * 3 + foAlfaceCombo * 14) 
                break;
                if (cebola < cebolaSiri * 27 + cebolaLuxo * 8 + cebolaDuplo * 3 + cebolaCombo * 14) 
                break;
                if (queijo < queijoSiri * 27 + queijoLuxo * 8 + queijoDuplo * 3 + queijoCombo * 14) 
                break;

            //Subtrai os ingredientes
            paes -= paesSiri * 27 + paesLuxo * 8 + paesDuplo * 3 + paesCombo * 14;
            hamburguer -= hamburSiri * 27 + hamburLuxo * 8 + hamburDuplo * 3 + hamburCombo * 14;
            alface -= foAlfaceSiri * 27 + foAlfaceLuxo * 8 + foAlfaceDuplo * 3 + foAlfaceCombo * 14;
            cebola -= cebolaSiri * 27 + cebolaLuxo * 8 + cebolaDuplo * 3 + cebolaCombo * 14;
            queijo -= queijoSiri * 27 + queijoLuxo * 8 + queijoDuplo * 3 + queijoCombo * 14;

            // Calcula o faturamento
        	faturamento += precoHSiri * 27 + precoHLuxo * 8 + precoHDuplo * 3 + precoHCombo * 14;

            // Incrementa a contagem de horas
            horasDeOperacao++;
        }
        System.out.println("Horas operacionais: " + horasDeOperacao);
        System.out.println("Faturamento: " + faturamento);
    }
}