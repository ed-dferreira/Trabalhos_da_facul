package Trabalhos_da_facul;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RinhaDeTeste6 {
    static char[][] tabuleiro = new char[3][3];
    static boolean vezMaiuscula = false; // Começa com minúscula
    static Set<Character> letrasMaiusculasUsadas = new HashSet<>();
    static Set<Character> letrasMinusculasUsadas = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean ganhouMesmo = false; // Declarado como estático

    public static void main(String[] args) {
        inicializarTabuleiro();
        while (true) {
            escreverTabuleiro();
            char jogadorDaVez = vezMaiuscula ? 'M' : 'm';
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da linha:");
            int linha = scanner.nextInt();
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da coluna:");
            int coluna = scanner.nextInt();
            System.out.println("Qual a letra vai ser usada:");
            char letra = scanner.next().charAt(0);

            // Verificar se a posição é válida e a letra pode ser colocada
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 &&
                    verificarLetras(linha, coluna, letra)) {

                // Verificar se houve vitória
                ganhouMesmo = verificarVitoria(); // Atribui o resultado à variável ganhouMesmo

                if (ganhouMesmo) {
                    escreverTabuleiro();
                    System.out.println("Jogador " + jogadorDaVez + " venceu!");
                    break;
                }

                vezMaiuscula = !vezMaiuscula;
            } else {
                System.out.println("Posição fora do tabuleiro ou letra inválida. Tente outra vez.");
            }
        }
    }

    public static void escreverTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void inicializarTabuleiro() {
        // Initialize the board with '-'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public static boolean verificarLetras(int linha, int coluna, char letra) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false; // Posição fora do tabuleiro
        }

        if (tabuleiro[linha][coluna] == '-') { // Espaço vazio
            if (Character.isLetter(letra)) {
                if (vezMaiuscula && Character.isUpperCase(letra) && !letrasMaiusculasUsadas.contains(letra)) {
                    tabuleiro[linha][coluna] = letra;
                    letrasMaiusculasUsadas.add(letra);
                    return true;
                } else if (!vezMaiuscula && Character.isLowerCase(letra) && !letrasMinusculasUsadas.contains(letra)) {
                    tabuleiro[linha][coluna] = letra;
                    letrasMinusculasUsadas.add(letra);
                    return true;
                }
            }
        } else { // Espaço ocupado
            char letraNoTabuleiro = tabuleiro[linha][coluna];
            if (vezMaiuscula && Character.isUpperCase(letra) && Character.isLowerCase(letraNoTabuleiro) &&
                    letra > Character.toUpperCase(letraNoTabuleiro) && !letrasMaiusculasUsadas.contains(letra)) {
                tabuleiro[linha][coluna] = letra;
                letrasMaiusculasUsadas.add(letra);
                return true;
            } else if (!vezMaiuscula && Character.isLowerCase(letra) && Character.isUpperCase(letraNoTabuleiro) &&
                    Character.toUpperCase(letra) > letraNoTabuleiro && !letrasMinusculasUsadas.contains(letra)) {
                tabuleiro[linha][coluna] = letra;
                letrasMinusculasUsadas.add(letra);
                return true;
            }
        }

        return false;
    }

    public static boolean verificarVitoria() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if ((Character.isLowerCase(tabuleiro[i][0]) && Character.isLowerCase(tabuleiro[i][1]) &&
                    Character.isLowerCase(tabuleiro[i][2])) ||
                    (Character.isUpperCase(tabuleiro[i][0]) && Character.isUpperCase(tabuleiro[i][1]) &&
                            Character.isUpperCase(tabuleiro[i][2]))) {
                return true;
            }
        }

        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if ((Character.isLowerCase(tabuleiro[0][i]) && Character.isLowerCase(tabuleiro[1][i]) &&
                    Character.isLowerCase(tabuleiro[2][i])) ||
                    (Character.isUpperCase(tabuleiro[0][i]) && Character.isUpperCase(tabuleiro[1][i]) &&
                            Character.isUpperCase(tabuleiro[2][i]))) {
                return true;
            }
        }

        // Verificar diagonal principal
        if ((Character.isLowerCase(tabuleiro[0][0]) && Character.isLowerCase(tabuleiro[1][1]) &&
                Character.isLowerCase(tabuleiro[2][2])) ||
                (Character.isUpperCase(tabuleiro[0][0]) && Character.isUpperCase(tabuleiro[1][1]) &&
                        Character.isUpperCase(tabuleiro[2][2]))) {
            return true;
        }

        // Verificar diagonal secundária
        if ((Character.isLowerCase(tabuleiro[0][2]) && Character.isLowerCase(tabuleiro[1][1]) &&
                Character.isLowerCase(tabuleiro[2][0])) ||
                (Character.isUpperCase(tabuleiro[0][2]) && Character.isUpperCase(tabuleiro[1][1]) &&
                        Character.isUpperCase(tabuleiro[2][0]))) {
            return true;
        }

        // Se nenhuma condição de vitória foi encontrada, retorna false
        return false;
    }
}
