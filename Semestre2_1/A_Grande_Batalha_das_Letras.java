package Trabalhos_da_facul;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A_Grande_Batalha_das_Letras {
    static char[][] tabuleiro = new char[3][3]; //cria a matriz do tabuleiro
    static boolean vezMinuscula = true; // Começa com as minusculas
    static Set<Character> letrasMaiusculasUsadas = new HashSet<>(); //armazenam as letras maiusculas
    static Set<Character> letrasMinusculasUsadas = new HashSet<>(); //armazenam as letras minusculas
    static Scanner scanner = new Scanner(System.in);
    static boolean ganhouMesmo = false; 

    public static void primeiroTabuleiro() { //ele é o primeiro tabuleiro e inicia com - nos lugares vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public static void mostraTabuleiro() { //mostra o tabuleiro durante o jogo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Batalha das letras!");
        System.out.println("Deseja começar o jogo ou carregar um jogo salvo?");
        System.out.println("1. Para um novo jogo.");
        System.out.println("2. Para carregar um jogo salvo?");
        System.out.println("Qualquer outra escolha para sair do jogo!");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Seja bem vindo à eterna batalha das letras:"); // ajustei a mensagem
                System.out.println("O objetivo é construir uma ponte completa de tamanho 3 até o outro lado!");
                System.out.println("QUE COMECE A BATALHA!");
                primeiroTabuleiro(); // função a ser definida
                while (true) {
                    mostraTabuleiro();
                    char jogadorDaVez = vezMinuscula ? 'm' : 'M';
                    System.out.println("Jogador: " + jogadorDaVez + ", digite a posição da linha:");
                    int linha = scanner.nextInt();
                    System.out.println("Jogador: " + jogadorDaVez + ", digite a posição da coluna:");
                    int coluna = scanner.nextInt();
                    System.out.println("Qual a letra irá para batalha:");
                    char letra = scanner.next().charAt(0);
                    // Verifica se a letra está em uma posição válida
                    if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && AdicionarEVerificarLetras(linha, coluna, letra)) {
                        // Verificar se alguém ganhou
                        ganhouMesmo = verificarVitoria();
                        if (ganhouMesmo) {
                            mostraTabuleiro();
                            System.out.println("Os guerreiros " + jogadorDaVez + " venceram!");
                            break;
                        }
                        vezMinuscula = !vezMinuscula;
                    } else {
                        System.out.println("Posição fora do tabuleiro ou letra inválida. Tente outra vez.");
                    }
                    System.out.println("Deseja salvar o jogo? s/n");
                    char salvarGame = scanner.next().charAt(0);
                    if (salvarGame == 's') {
                        salvarJogo();
                        break;
                    }
                }
                break;
            case 2:
                carregarJogo();
                while (true) {
                    mostraTabuleiro();
                    char jogadorDaVez = vezMinuscula ? 'm' : 'M'; // operador ternario pique if else
                    System.out.println("Jogador: " + jogadorDaVez + ", digite a posição da linha:");
                    int linha = scanner.nextInt();
                    System.out.println("Jogador: " + jogadorDaVez + ", digite a posição da coluna:");
                    int coluna = scanner.nextInt();
                    System.out.println("Qual a letra irá para batalha:");
                    char letra = scanner.next().charAt(0);
                    // Verifica se a letra está em uma posição válida
                    if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && AdicionarEVerificarLetras(linha, coluna, letra)) {
                        // Verificar se alguém ganhou
                        ganhouMesmo = verificarVitoria();
                        if (ganhouMesmo) {
                            mostraTabuleiro();
                            System.out.println("Os guerreiros " + jogadorDaVez + " venceram!");
                            break;
                        }
                        vezMinuscula = !vezMinuscula;
                    } else {
                        System.out.println("Posição fora do tabuleiro ou letra inválida. Tente outra vez.");
                    }
                    System.out.println("Deseja salvar o jogo? s/n");
                    char salvarGame = scanner.next().charAt(0);
                    if (salvarGame == 's') {
                        salvarJogo();
                        break;
                    }
                }
            default:
                System.out.println("Encerrando a batalha!");
                break;
            }
        }

    public static boolean AdicionarEVerificarLetras(int linha, int coluna, char letra) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false; // De alguma forma um posição fora do tabuleiro
        }
        if (tabuleiro[linha][coluna] == '-') { //adiciona nos espaços "vazios"
            if (Character.isLetter(letra)) { // verifica se é uma letra
                if (!vezMinuscula && Character.isUpperCase(letra) && !letrasMaiusculasUsadas.contains(letra)) {
                    //verifica se é vez das maiusculas, usando isso Character.isUpperCase(letra)
                    //o !letrasMaiusculasUsadas.contains(letra) ve se essa letra já foi usada alguma vez
                    tabuleiro[linha][coluna] = letra;
                    letrasMaiusculasUsadas.add(letra); // adiciona as letras já usadas
                    return true; //funcionou, essa lógica se aplica nos de baixo 
                } else if (vezMinuscula && Character.isLowerCase(letra) && !letrasMinusculasUsadas.contains(letra)) {
                    tabuleiro[linha][coluna] = letra;
                    letrasMinusculasUsadas.add(letra);
                    return true;
                }
            }
        } else { // Espaço ja ocupado por outra letra
            char letraNoTabuleiro = tabuleiro[linha][coluna];
            if (!vezMinuscula && Character.isUpperCase(letra) && Character.isLowerCase(letraNoTabuleiro) &&
                    letra > Character.toUpperCase(letraNoTabuleiro) && !letrasMaiusculasUsadas.contains(letra)) {
                // letra > Character.toUpperCase(letraNoTabuleiro) para ver se ela é maior
                tabuleiro[linha][coluna] = letra;
                letrasMaiusculasUsadas.add(letra);
                return true;
            } else if (vezMinuscula && Character.isLowerCase(letra) && Character.isUpperCase(letraNoTabuleiro) &&
                    Character.toUpperCase(letra) > letraNoTabuleiro && !letrasMinusculasUsadas.contains(letra)) {
                tabuleiro[linha][coluna] = letra;
                letrasMinusculasUsadas.add(letra);
                return true;
            }
        }
        return false;
    }

    public static boolean verificarVitoria() {
        for (int i = 0; i < 3; i++) { // Verifica as linhas
            if ((Character.isLowerCase(tabuleiro[i][0]) && Character.isLowerCase(tabuleiro[i][1]) &&
                Character.isLowerCase(tabuleiro[i][2])) || (Character.isUpperCase(tabuleiro[i][0]) && 
                Character.isUpperCase(tabuleiro[i][1]) && Character.isUpperCase(tabuleiro[i][2]))) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) { // Verifica as colunas
            if ((Character.isLowerCase(tabuleiro[0][i]) && Character.isLowerCase(tabuleiro[1][i]) &&
                Character.isLowerCase(tabuleiro[2][i])) || (Character.isUpperCase(tabuleiro[0][i]) && 
                Character.isUpperCase(tabuleiro[1][i]) && Character.isUpperCase(tabuleiro[2][i]))) {
                return true;
            }
        }
        if ((Character.isLowerCase(tabuleiro[0][0]) && Character.isLowerCase(tabuleiro[1][1]) &&
                Character.isLowerCase(tabuleiro[2][2])) || (Character.isUpperCase(tabuleiro[0][0]) && 
                Character.isUpperCase(tabuleiro[1][1]) && Character.isUpperCase(tabuleiro[2][2]))) {
            return true; // Verifica a diagonal principal
        }
        if ((Character.isLowerCase(tabuleiro[0][2]) && Character.isLowerCase(tabuleiro[1][1]) &&
            Character.isLowerCase(tabuleiro[2][0])) || (Character.isUpperCase(tabuleiro[0][2]) && 
            Character.isUpperCase(tabuleiro[1][1]) && Character.isUpperCase(tabuleiro[2][0]))) {
            return true; // Verificar diagonal secundaria
        }
        return false; // Se nenhuma condição foi encontrada retorna um false 
    }

    public static void salvarJogo() {
        try (FileWriter writer = new FileWriter("estado_da_batalha!.txt")) { // esse try maluco fecha o FileWriter no final
            writer.write((vezMinuscula ? 'm' : 'M') + "\n"); // escreve a vez

            for (Character letra : letrasMinusculasUsadas) {
                writer.write(letra);
            }
            writer.write("\n");

            for (Character letra : letrasMaiusculasUsadas) {
                writer.write(letra);
            }
            writer.write("\n");

            for (int i = 0; i < 3; i++) { // o tabuleiro
                for (int j = 0; j < 3; j++) {
                    writer.write(tabuleiro[i][j]);
                }
                writer.write("\n");
            }
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) { // procura erros e tals
            System.out.println("Erro ao salvar o jogo: " + e.getMessage()); // e.getMessage() mostra o que explodiu aqui
        }
    }

    static void carregarJogo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("estado_da_batalha!.txt"))) {
            vezMinuscula = reader.readLine().charAt(0) == 'm'; // ve quem joga
            System.out.println("Vez minúscula: " + vezMinuscula); // mostra quem joga

            String letrasMinusculas = reader.readLine(); // guarda as minusculas
            letrasMinusculasUsadas.clear();
            for (char c : letrasMinusculas.toCharArray()) { //converte em char
                letrasMinusculasUsadas.add(c);
            }
            System.out.println("Letras minúsculas usadas: " + letrasMinusculas); 

            String letrasMaiusculas = reader.readLine(); // // guarda as maiúsculas
            letrasMaiusculasUsadas.clear();
            for (char c : letrasMaiusculas.toCharArray()) {
                letrasMaiusculasUsadas.add(c);
            }
            System.out.println("Letras maiúsculas usadas: " + letrasMaiusculas); 

            for (int i = 0; i < 3; i++) { // preenche o tabuleiro
                String linha = reader.readLine();
                for (int j = 0; j < 3; j++) {
                    tabuleiro[i][j] = linha.charAt(j);
                }
            }
            System.out.println("Batalha carregada");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
    }
}
//  static Set<Character> letrasMinusculasUsadas = new HashSet<>(); //armazenam as letras minusculas
//  letrasMinusculasUsadas.add(c); adiona na paradinha de cima
//
/*
 * Alternativa 2: MAIÚSCULAS vs. minúsculas
Você deve criar um programa para um jogo que ocorre em uma matriz 3 x 3
representando um lago onde duas cidades competem para construir uma ponte: a cidade das
letras MAIÚSCULAS quer a ponte formada por suas letras e a cidade das letras minúsculas,
por sua vez, quer a ponte formada por suas letras. Os números não gostam de se envolver
com construção civil e preferiram ficar fora dessa disputa. Embora essa ponte vá ser usada
por todas as letras, a obra de engenharia executada por uma cidade ou outra vai servir como
demonstração de competência profissional para as gerações de letras futuras.
Cada jogadora representa uma engenheira das cidades e tem o objetivo de formar uma
sequência de 3 letras do tipo da cidade que representa para que a ponte seja construída.
O estado inicial do jogo é completamente vazio. A jogadora das minúsculas joga
sempre primeiro, colocando uma letra qualquer em um espaço qualquer do lago. Depois
disso, a jogadora das MAIÚSCULA pode escolher colocar uma letra em um espaço não
ocupado do lago ou colocar uma letra MAIÚSCULA superior sobre um espaço de uma letra
minúscula que já está no lago (veja os detalhes abaixo). Depois, a jogadora das minúsculas
pode escolher colocar uma letra em um espaço não ocupado ou colocar uma letra minúscula
superior sobre um espaço de uma letra MAIÚSCULA que já está no lago. O jogo segue
dessa forma na alternância de turnos entre as jogadoras. Depois que uma jogadora usa uma
letra, ela não pode usar aquela letra novamente.
Uma jogadora ganha quando completar uma sequência de 3 letras que controla na
horizontal, na vertical ou na diagonal.
O uso de letras com diacríticos (sinais gráficos que alteram o papel ou a fonética das
letras) não é permitido, ou seja, nada de acentos circunflexos (letras com chapéu), til (letras
com penteado estravagante), cedilha (letras com rabinho) etc.
Uma letra superior é aquela localizada mais para o final do alfabeto. Por exemplo:
• M é superior a F
• B é inferior a D
• Z é superior a todas as outras letras (então use-o com sabedoria).
Em um exemplo de jogada, se fosse a vez das MAIÚSCULAS jogarem e o estado do
lago fosse a referência a seguir (hifens representam os espaços vazios), então elas poderiam
ganhar colocando 'Z' sobre 'y':

Outro exemplo, se fosse a vez das MAIÚSCULAS jogarem e elas já tivessem usado a
letra 'X' anteriormente que foi sobreposta por 'w' e o estado do lago fosse a referência a
seguir, então jogar 'X' novamente seria uma jogada inválida:

FUNCIONALIDADE BÔNUS
Deve ser possível salvar o estado do jogo em um arquivo de texto que guarda na
primeira linha a letra da jogadora que deve fazer a próxima jogada (a letra 'M' se for a
jogadora das MAIÚSCULAS ou 'm' se for a jogadora das minúsculas), depois uma linha
contendo a sequência de letras minúsculas já usadas e uma linha contendo a sequência de
letras maiúsculas usadas. O arquivo ainda tem outras 3 linhas de caracteres que representam
o estado do jogo, sendo:
Qualquer letra maiúscula para as posições da cidade das MAIÚSCULAS
Qualquer letra minuscula para as posições da cidade das minúsculas
'-' para as posições vazias
Exemplo de arquivo:
M
ahdbzy
GTFWZ
aZy
dzW
-T
 */