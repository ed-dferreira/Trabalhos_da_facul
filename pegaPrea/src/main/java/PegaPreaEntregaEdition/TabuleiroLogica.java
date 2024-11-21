package PegaPreaEntregaEdition;

public class TabuleiroLogica {
    private final int[][] tabuleiro = new int[3][5];

    public TabuleiroLogica() {
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        // Limpa o tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        tabuleiro[0][0] = -1;
        tabuleiro[0][4] = -1;
        tabuleiro[2][0] = -1;
        tabuleiro[2][4] = -1;

        tabuleiro[0][1] = 1; // P1
        tabuleiro[1][0] = 2; // P2
        tabuleiro[2][1] = 3; // P3
        tabuleiro[1][4] = 4; // PP
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean podeMover(int linha, int coluna, int peca) {
        if (tabuleiro[linha][coluna] != 0) return false; // Só pode mover para células vazias

        int[][] direcoes = peca == 4
                ? new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}} // PP pode mover em todas as direções
                : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {-1, 1}, {1, 1}}; // P1, P2, P3 movem-se para a direita ou diagonais à direita

        for (int[] direcao : direcoes) {
            int novaLinha = linha - direcao[0];
            int novaColuna = coluna - direcao[1];
            if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 5 && tabuleiro[novaLinha][novaColuna] == peca) {
                return true;
            }
        }
        return false;
    }

    public void moverPeca(int linha, int coluna, int peca) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    tabuleiro[i][j] = 0; // Remove a peça da posição antiga
                    break;
                }
            }
        }
        tabuleiro[linha][coluna] = peca; // Coloca a peça na nova posição
    }

    public boolean verificarVitoria() {
        // Time Vermelho vence se PP alcança (1, 0)
        if (tabuleiro[1][0] == 4) {
            return true;
        }

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
}
