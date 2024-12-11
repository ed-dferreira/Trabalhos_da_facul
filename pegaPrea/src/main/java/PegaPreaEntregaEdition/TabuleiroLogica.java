package PegaPreaEntregaEdition;

import java.util.Arrays;

public class TabuleiroLogica {
    private final int[][] tabuleiro = new int[3][5];

    public TabuleiroLogica() {
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = 0;
            }
        }
        tabuleiro[0][0] = -2;
        tabuleiro[0][4] = -2;
        tabuleiro[2][0] = -2;
        tabuleiro[2][4] = -2;

        tabuleiro[0][2] = -1;
        tabuleiro[2][2] = -1;
        tabuleiro[1][1] = -1;
        tabuleiro[1][3] = -1;

        tabuleiro[0][1] = 1;
        tabuleiro[1][0] = 2;
        tabuleiro[2][1] = 3;
        tabuleiro[1][4] = 4;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean podeMover(int linha, int coluna, int peca) {
        // Verifica se é um Jogador (peças 1, 2, 3)
        if (peca == 1 || peca == 2 || peca == 3) {
            return podeMoverJogador(linha, coluna, peca);
        }

        // Verifica se é um Preá (peça 4)
        if (peca == 4) {
            return podeMoverPrea(linha, coluna, peca);
        }

        return false; // Caso a peça não seja reconhecida
    }

    public boolean podeMoverJogador(int linha, int coluna, int peca) {
        // Verifica se a célula inicial é válida para o jogador (0 ou -1)
        if (tabuleiro[linha][coluna] == -2 && tabuleiro[linha][coluna] == 1) {
            return false;  // A célula de origem não é válida para o movimento
        }

        int rows = tabuleiro.length;
        int cols = tabuleiro[0].length;

        // Verifica as posições adjacentes (diagonais, verticais e horizontais)
        if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
            return true;
        }
        if (linha + 1 < rows && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
            // Movimento Baixo Esquerda
            return true;
        }
        // Verifica os movimentos verticais e horizontais
        if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
            // Movimento Cima
            return true;
        }
        if (linha + 1 < rows && tabuleiro[linha + 1][coluna] == peca) {
            // Movimento Baixo
            return true;
        }
        if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
            // Movimento Esquerda
            return true;
        }
        // Se nenhum movimento válido for encontrado
        return false;
    }

    public boolean podeMoverPrea(int linha, int coluna, int peca) {
        // Verifica se a célula inicial é válida para o jogador (0 ou -1)
        if (tabuleiro[linha][coluna] != 0 && tabuleiro[linha][coluna] != -1) {
            return false;  // A célula de origem não é válida para o movimento
        }

        int rows = tabuleiro.length;
        int cols = tabuleiro[0].length;

        if (tabuleiro[linha][coluna] == 0) {
            // Verifica as posições adjacentes (diagonais, verticais e horizontais)
            if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
                // Movimento Cima Esquerda
                return true;
            }
            if (linha - 1 >= 0 && coluna + 1 < cols && tabuleiro[linha - 1][coluna + 1] == peca) {
                // Movimento Cima Direita
                return true;
            }
            if (linha + 1 < rows && coluna + 1 < cols && tabuleiro[linha + 1][coluna + 1] == peca) {
                // Movimento Baixo Direita
                return true;
            }
            if (linha + 1 < rows && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
                // Movimento Baixo Esquerda
                return true;
            }

            // Verifica os movimentos verticais e horizontais
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // Movimento Cima
                return true;
            }
            if (linha + 1 < rows && tabuleiro[linha + 1][coluna] == peca) {
                // Movimento Baixo
                return true;
            }
            if (coluna + 1 < cols && tabuleiro[linha][coluna + 1] == peca) {
                // Movimento Direita
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                // Movimento Esquerda
                return true;
            }
        }
        if (tabuleiro[linha][coluna] == -1){
            // Verifica os movimentos verticais e horizontais
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // Movimento Cima
                return true;
            }
            if (linha + 1 < rows && tabuleiro[linha + 1][coluna] == peca) {
                // Movimento Baixo
                return true;
            }
            if (coluna + 1 < cols && tabuleiro[linha][coluna + 1] == peca) {
                // Movimento Direita
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                // Movimento Esquerda
                return true;
            }
        }
        // Se nenhum movimento válido for encontrado
        return false;
    }

    public void moverPeca(int linha, int coluna, int peca) {
        espacoEspecial();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    tabuleiro[i][j] = 0; // Remove a peça da posição antiga
                }
            }
        }
        tabuleiro[linha][coluna] = peca; // Coloca a peça na nova posição
        espacoEspecial();
    }

    public void espacoEspecial(){
        if (tabuleiro[0][2] != 1 && tabuleiro[0][2] != 2 && tabuleiro[0][2] != 3 && tabuleiro[0][2] != 4 &&
                tabuleiro[2][2] != 1 && tabuleiro[2][2] != 2 && tabuleiro[2][2] != 3 && tabuleiro[2][2] != 4 &&
                tabuleiro[1][1] != 1 && tabuleiro[1][1] != 2 && tabuleiro[1][1] != 3 && tabuleiro[1][1] != 4 &&
                tabuleiro[1][3] != 1 && tabuleiro[1][3] != 2 && tabuleiro[1][3] != 3 && tabuleiro[1][3] != 4) {

            // Atualiza as posições específicas para -1
            tabuleiro[0][2] = -1;
            tabuleiro[2][2] = -1;
            tabuleiro[1][1] = -1;
            tabuleiro[1][3] = -1;
        }
    }

    public boolean vitoriaPrea() { // funciona
        if (tabuleiro[1][0] == 4) {
            return true; // O Preá venceu
        }
        return false; // O Preá ainda não venceu
    }

    public boolean verificarVitoria() {
        if (empate()) { // Verifica se há empate
            return true;
        } else if (vitoriaPrea()) { // Verifica se o Preá venceu
            return true;
        } else if (vitoriaEstudantes()) { // Verifica se os estudantes venceram
            return true;
        }
        return false; // Retorna false se não houver vitória ou empate
    }

    public boolean vitoriaEstudantes() { // precisa ser verificado
        // Time Azul vence se PP está cercado
        int linhaPP = -1, colunaPP = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == 4) { // Encontra PP
                    linhaPP = i;
                    colunaPP = j;
                    break;
                }
            }
        }

        if (linhaPP != -1 && colunaPP != -1) {
            int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            for (int[] direcao : direcoes) {
                int novaLinha = linhaPP + direcao[0];
                int novaColuna = colunaPP + direcao[1];
                if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 5 && tabuleiro[novaLinha][novaColuna] == 0) {
                    return false; // PP ainda pode se mover
                }
            }
            return true; // PP está cercado
        }
        return false;
    }

    private boolean eJogador(int valor) {
        return valor == 1 || valor == 2 || valor == 3;
    }

    public boolean empate() {
        // Verifica se as posições contêm valores 1, 2 ou 3
        if (eJogador(tabuleiro[0][3]) && eJogador(tabuleiro[1][3]) && eJogador(tabuleiro[1][4]) ||
                eJogador(tabuleiro[2][3]) && eJogador(tabuleiro[1][3]) && eJogador(tabuleiro[1][4])) {
            System.out.println("Empate! Todos os jogadores chegaram nas posições desejadas!");
            return true;
        }
        return false; // Caso não haja empate
    }
}
