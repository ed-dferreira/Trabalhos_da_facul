package Trabalhos_da_facul;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RinhaDeTeste5 {
    private static char[][] tabuleiro = new char[3][3];
    private static boolean vezMaiuscula = false; // Começa com minúsculas
    private static String usadasMinusculas = "";
    private static String usadasMaiusculas = "";
    private static Set<Character> letrasMaiusculasUsadas = new HashSet<>();
    private static Set<Character> letrasMinusculasUsadas = new HashSet<>();

    public RinhaDeTeste5() { // Inicia o tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public static void main(String[] args) {
        RinhaDeTeste5 jogo = new RinhaDeTeste5();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja carregar o jogo salvo? (s/n)");
        char carregar = scanner.next().charAt(0);
        if (carregar == 's' || carregar == 'S') {
            carregarJogo();
        } else {
            System.out.println("Novo jogo iniciado!");
        }

        while (true) {
            escreverTabuleiro();
            char jogadorDaVez = vezMaiuscula ? 'M' : 'm';
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da linha:");
            int linha = scanner.nextInt();
            System.out.println("Jogador " + jogadorDaVez + ", digite a posição da coluna:");
            int coluna = scanner.nextInt();
            System.out.println("Qual a letra vai ser usada:");
            char letra = scanner.next().charAt(0);

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

            System.out.println("Deseja salvar o jogo? (s/n)");
            char salvar = scanner.next().charAt(0);
            if (salvar == 's' || salvar == 'S') {
                salvarJogo();
            }
        }

        scanner.close();
    }

    public static boolean verificarLetras(int i, int j, char letra) {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            return false; // Posição fora da matriz
        }

        if (tabuleiro[i][j] == '-') { // Espaço vazio
            if (Character.isLetter(letra)) {
                if (vezMaiuscula && Character.isUpperCase(letra) && !letrasMaiusculasUsadas.contains(letra)) {
                    tabuleiro[i][j] = letra;
                    letrasMaiusculasUsadas.add(letra);
                    usadasMaiusculas += letra;
                    return true;
                } else if (!vezMaiuscula && Character.isLowerCase(letra) && !letrasMinusculasUsadas.contains(letra)) {
                    tabuleiro[i][j] = letra;
                    letrasMinusculasUsadas.add(letra);
                    usadasMinusculas += letra;
                    return true;
                }
            }
        } else { // Espaço ocupado
            char letraNoTabuleiro = tabuleiro[i][j];
            if (vezMaiuscula && Character.isUpperCase(letra) && Character.isLowerCase(letraNoTabuleiro) &&
                letra > Character.toUpperCase(letraNoTabuleiro) && !letrasMaiusculasUsadas.contains(letra)) {
                tabuleiro[i][j] = letra;
                letrasMaiusculasUsadas.add(letra);
                usadasMaiusculas += letra;
                return true;
            } else if (!vezMaiuscula && Character.isLowerCase(letra) && Character.isUpperCase(letraNoTabuleiro) &&
                Character.toUpperCase(letra) > letraNoTabuleiro && !letrasMinusculasUsadas.contains(letra)) {
                tabuleiro[i][j] = letra;
                letrasMinusculasUsadas.add(letra);
                usadasMinusculas += letra;
                return true;
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
        // Verificação das linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }
        // Verificação das colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] != '-' && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return true;
            }
        }
        // Verificação das diagonais
        if (tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }
        return false;
    }

    public static void salvarJogo() {
        try (FileWriter writer = new FileWriter("estado_do_jogo.txt")) {
            writer.write((vezMaiuscula ? 'M' : 'm') + "\n");
            writer.write(usadasMinusculas + "\n");
            writer.write(usadasMaiusculas + "\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(tabuleiro[i][j]);
                }
                writer.write("\n");
            }
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public static void carregarJogo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("estado_do_jogo.txt"))) {
            vezMaiuscula = reader.readLine().charAt(0) == 'M';
            usadasMinusculas = reader.readLine();
            usadasMaiusculas = reader.readLine();
            
            for (char c : usadasMinusculas.toCharArray()) {
                letrasMinusculasUsadas.add(c);
            }
            for (char c : usadasMaiusculas.toCharArray()) {
                letrasMaiusculasUsadas.add(c);
            }

            for (int i = 0; i < 3; i++) {
                String linha = reader.readLine();
                for (int j = 0; j < 3; j++) {
                    tabuleiro[i][j] = linha.charAt(j);
                }
            }
            System.out.println("Jogo carregado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
    }
}
