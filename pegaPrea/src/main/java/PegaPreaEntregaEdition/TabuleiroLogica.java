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
            return podeMoverPrea(linha, coluna);
        }

        return false; // Caso a peça não seja reconhecida
    }


    public boolean podeMoverJogador(int linha, int coluna, int peca) {
        // Verifica se a célula inicial é inválida (ocupada por peça ou fora do limite)
        if (tabuleiro[linha][coluna] == -2 || tabuleiro[linha][coluna] == 1 || tabuleiro[linha][coluna] == 2 || tabuleiro[linha][coluna] == 3 || tabuleiro[linha][coluna] == 4)
            return false;

        // Direções permitidas para o jogador (cima, baixo, direita e diagonais à direita)
        int[][] direcoes = {
                {-1, 0}, {1, 0}, {0, 1},  // Movimentos cima, baixo, direita
                {-1, 1}, {1, 1}           // Movimentos diagonais à direita
        };

        // Verifica todas as direções possíveis
        for (int[] direcao : direcoes) {
            int novaLinha = linha + direcao[0];
            int novaColuna = coluna + direcao[1];

            // Verifica se a nova posição está dentro dos limites do tabuleiro
            if (novaLinha >= 0 && novaLinha < tabuleiro.length &&
                    novaColuna >= 0 && novaColuna < tabuleiro[0].length) {

                // A nova célula deve estar vazia
                if (tabuleiro[novaLinha][novaColuna] == 0) {
                    return true; // Movimento permitido
                }
            }
        }

        return false; // Nenhuma posição válida foi encontrada
    }

    public boolean podeMoverPrea(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == -2 || tabuleiro[linha][coluna] == 1 || tabuleiro[linha][coluna] == 2 || tabuleiro[linha][coluna] == 3)
            return false;

        // Se o lugar no tabuleiro for -2, limita o movimento às direções verticais e horizontais
        if (tabuleiro[linha][coluna] == -1) {
            int[][] direcoesLimitadas = {
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1}  // Apenas movimentos verticais e horizontais
            };

            // Verifica as direções limitadas para o caso de célula -2
            for (int[] direcao : direcoesLimitadas) {
                int novaLinha = linha + direcao[0];
                int novaColuna = coluna + direcao[1];

                // Verifica se a nova posição está dentro dos limites do tabuleiro e se a célula está vazia
                if (novaLinha >= 0 && novaLinha < tabuleiro.length && novaColuna >= 0 && novaColuna < tabuleiro[0].length) {
                    if (tabuleiro[novaLinha][novaColuna] == 0) { // A célula de destino deve estar vazia
                        // Verifica se o movimento é de uma casa por vez
                        if (direcao[0] != 0 && direcao[1] == 0) {  // Movimento para cima/baixo (linha)
                            if (linha + direcao[0] == novaLinha) return true;
                        } else if (direcao[1] != 0 && direcao[0] == 0) {  // Movimento para esquerda/direita (coluna)
                            if (coluna + direcao[1] == novaColuna) return true;
                        }
                    }
                }
            }
            return false; // Se não encontrar movimento válido, retorna false
        }

        // Caso contrário, a peça pode se mover em todas as direções, incluindo diagonais
        int[][] direcoes = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},  // Movimentos verticais e horizontais
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Movimentos diagonais
        };

        // Verifica todas as direções possíveis
        for (int[] direcao : direcoes) {
            int novaLinha = linha + direcao[0];
            int novaColuna = coluna + direcao[1];

            // Verifica se a nova posição está dentro dos limites do tabuleiro e se a célula está vazia
            if (novaLinha >= 0 && novaLinha < tabuleiro.length && novaColuna >= 0 && novaColuna < tabuleiro[0].length) {
                if (tabuleiro[novaLinha][novaColuna] == 0) { // A célula de destino deve estar vazia
                    // Verifica se o movimento é de uma casa por vez
                    if (direcao[0] != 0 && direcao[1] == 0) {  // Movimento para cima/baixo (linha)
                        if (linha + direcao[0] == novaLinha) return true;
                    } else if (direcao[1] != 0 && direcao[0] == 0) {  // Movimento para esquerda/direita (coluna)
                        if (coluna + direcao[1] == novaColuna) return true;
                    } else if (direcao[0] != 0 && direcao[1] != 0) { // Movimento diagonal
                        if (novaLinha == linha + direcao[0] && novaColuna == coluna + direcao[1]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; // Se não encontrar movimento válido, retorna false
    }


    public void moverPeca(int linha, int coluna, int peca) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    tabuleiro[i][j] = 0; // Remove a peça da posição antiga
                }
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

        }
        tabuleiro[linha][coluna] = peca; // Coloca a peça na nova posição
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
