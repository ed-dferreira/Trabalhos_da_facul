package Logica;

public class Tabuleiro {
    private final int[][] tabuleiro = new int[3][5];

    public Tabuleiro() {
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        // Limpa o tabuleiro, configurando as posições iniciais
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        // Configura as posições iniciais das peças
        tabuleiro[0][0] = -1; // Bloqueio
        tabuleiro[0][4] = -1; // Bloqueio
        tabuleiro[2][0] = -1; // Bloqueio
        tabuleiro[2][4] = -1; // Bloqueio

        tabuleiro[0][1] = 1; // P1 (time azul)
        tabuleiro[1][0] = 2; // P2 (time azul)
        tabuleiro[2][1] = 3; // P3 (time azul)
        tabuleiro[1][4] = 4; // PP (time vermelho)
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    /**
     * Verifica se uma peça pode se mover para a posição especificada.
     *
     * @param linha   Linha de destino.
     * @param coluna  Coluna de destino.
     * @param peca    Identificador da peça que está tentando se mover.
     * @return true se a peça pode se mover para a posição, caso contrário false.
     */
    public boolean podeMover(int linha, int coluna, int peca) {
        // Verifica se a célula de destino está vazia
        if (tabuleiro[linha][coluna] != 0) {
            return false;
        }

        // Determina as direções possíveis de movimento com base na peça
        int[][] direcoes = peca == 4
                ? new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}} // PP pode mover em todas as direções
                : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {-1, 1}, {1, 1}}; // P1, P2, P3 movem-se para a direita ou diagonais à direita

        // Verifica se alguma das direções possíveis leva à peça selecionada
        for (int[] direcao : direcoes) {
            int novaLinha = linha - direcao[0];
            int novaColuna = coluna - direcao[1];
            if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 5 && tabuleiro[novaLinha][novaColuna] == peca) {
                return true; // Se alguma direção válida for encontrada, retorna true
            }
        }
        return false; // Caso nenhuma direção válida seja encontrada
    }

    /**
     * Move a peça para a posição especificada.
     *
     * @param linha   Linha de destino.
     * @param coluna  Coluna de destino.
     * @param peca    Identificador da peça que será movida.
     */
    public void moverPeca(int linha, int coluna, int peca) {
        // Encontra a posição atual da peça e a remove
        outerLoop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    tabuleiro[i][j] = 0; // Remove a peça da posição antiga
                    break outerLoop;
                }
            }
        }

        // Coloca a peça na nova posição
        tabuleiro[linha][coluna] = peca;
    }

    /**
     * Verifica se algum time venceu.
     * Time Vermelho vence se PP alcançar (1, 0)
     * Time Azul vence se PP for cercado
     *
     * @return true se houver vitória, caso contrário false.
     */
    public boolean verificarVitoria() {
        // Time Vermelho vence se o PP alcançar a posição (1, 0)
        if (tabuleiro[1][0] == 4) {
            return true; // Vitória do Time Vermelho
        }

        // Time Azul vence se o PP estiver cercado
        int linhaPP = -1, colunaPP = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == 4) {
                    linhaPP = i;
                    colunaPP = j;
                    break;
                }
            }
        }

        if (linhaPP != -1 && colunaPP != -1) {
            int[][] direcoes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            // Verifica se o PP está cercado
            for (int[] direcao : direcoes) {
                int novaLinha = linhaPP + direcao[0];
                int novaColuna = colunaPP + direcao[1];
                if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 5 && tabuleiro[novaLinha][novaColuna] == 0) {
                    return false; // PP ainda pode se mover
                }
            }
            return true; // PP está cercado
        }

        return false; // Nenhuma vitória
    }
}
