package Trabalhos_da_facul;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RinhaDeTeste {
    private static char[][] tabuleiro = new char[3][3];
    private static boolean vezMaiuscula = false; // Começa com minúsculas
    private static String usadasMinusculas = "";
    private static String usadasMaiusculas = "";
    private static Set<Character> letrasUsadas = new HashSet<>();

    public RinhaDeTeste() { // Inicia o tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public static void main(String[] args) {
        RinhaDeTeste jogo = new RinhaDeTeste();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            escreverTabuleiro();
            char jogadorDaVez = vezMaiuscula ? 'M' : 'm';
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da linha:");
            int linha = scanner.nextInt();
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da coluna:");
            int coluna = scanner.nextInt();
            System.out.println("Qual a letra vai ser usada:");
            char letra = scanner.next().toUpperCase().charAt(0); // Converte para maiúscula

            if (verificarLetras(linha, coluna, letra)) {
                if (verificarGanhador()) {
                    escreverTabuleiro();
                    System.out.println("Jogador " + jogadorDaVez + " ganhou a lendária Rinha de Letras!");
                    break;
                }
                vezMaiuscula = !vezMaiuscula; // Alterna o turno
            } else {
                System.out.println("Posição fora do tabuleiro ou letra inválida. Tente outra vez.");
            }
        }

        scanner.close();
    }

    public static boolean verificarLetras(int i, int j, char letra) {
        if (i < 0 || i > 2 || j < 0 || j > 2 || tabuleiro[i][j] != '-') {
            return false; // Posição fora da matriz ou já ocupada
        }

        // Converte a letra para maiúscula para comparação ASCII
        letra = Character.toUpperCase(letra);

        // Verifica se a letra é válida conforme as regras do jogo
        if (Character.isLetter(letra)) {
            if (vezMaiuscula) {
                tabuleiro[i][j] = letra;
                letrasUsadas.add(letra);
                usadasMaiusculas += letra;
                return true;
            } else {
                // Se não for vez das maiúsculas, verifica se a letra já foi usada como maiúscula
                if (!letrasUsadas.contains(Character.toUpperCase(letra))) {
                    tabuleiro[i][j] = letra;
                    letrasUsadas.add(letra);
                    usadasMinusculas += letra;
                    return true;
                }
            }
        }
        return false; // Letra não permitida ou já usada
    }

    public static void escreverTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean verificarGanhador() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] &&
                tabuleiro[i][1] == tabuleiro[i][2]) {
                return true; // Verificação das linhas
            }
            if (tabuleiro[0][i] != '-' && tabuleiro[0][i] == tabuleiro[1][i] &&
                tabuleiro[1][i] == tabuleiro[2][i]) {
                return true; // Verificação das colunas
            }
            if (i == 0 && tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][2]) {
                return true; // Verificação da diagonal \
            }
            if (i == 0 && tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] &&
                tabuleiro[1][1] == tabuleiro[2][0]) {
                return true; // Verificação da diagonal /
            }
        }
        return false; // Retorna false se nenhuma condição de vitória for atendida
    }
}
