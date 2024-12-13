package PegaPreaPack;

public class Tabuleiro {
    private final int[][] tabuleiro = new int[3][5];

    public Tabuleiro() {
        inicializar();
    }

    public void inicializar() {
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
    } // manda o tabuleiro pra JogoInterface

    public boolean podeMover(int linha, int coluna, int peca) {
        // Verifica se é um Jogador (peças 1, 2, 3)
        if (peca == 1 || peca == 2 || peca == 3) {
            return movimentoEstudante(linha, coluna, peca);
        }

        // Verifica se é um Preá (peça 4)
        if (peca == 4) {
            return movimentoPrea(linha, coluna, peca);
        }
        return false; // Caso a peça não seja reconhecida
    }

    public boolean movimentoEstudante(int linha, int coluna, int peca) {
        // Verifica se a célula inicial é válida para o jogador (0 ou -1)
        if (tabuleiro[linha][coluna] != 0 && tabuleiro[linha][coluna] != -1) { // aqui é por garantia
            return false;
        }

        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;

        if (tabuleiro[linha][coluna] == 0) {
            if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
                // movimento cima direita
                return true;
            }
            if (linha + 1 < linhas && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
                // movimento baixo direita
                return true;
            }
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // movimento cima
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                // movimento baixo
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                // movimento direita
                return true;
            }
        } else {  // se o quadrante for difente de zero muda a movimentação
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // movimento cima
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                // movimento baixo
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                // movimento esquerda
                return true;
            }
        }
        // Se nenhum movimento válido for encontrado
        return false;
    }

    public boolean movimentoPrea(int linha, int coluna, int peca) {
        if (tabuleiro[linha][coluna] != 0 && tabuleiro[linha][coluna] != -1) {
            return false;
        }

        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;

        if (tabuleiro[linha][coluna] == 0) {
            if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
                return true;
            }
            if (linha - 1 >= 0 && coluna + 1 < colunas && tabuleiro[linha - 1][coluna + 1] == peca) {
                return true;
            }
            if (linha + 1 < linhas && coluna + 1 < colunas && tabuleiro[linha + 1][coluna + 1] == peca) {
                return true;
            }
            if (linha + 1 < linhas && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
                return true;
            }
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                return true;
            }
            if (coluna + 1 < colunas && tabuleiro[linha][coluna + 1] == peca) {
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                return true;
            }
        } else { // se o quadrante for difente de zero muda a movimentação
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                return true;
            }
            if (coluna + 1 < colunas && tabuleiro[linha][coluna + 1] == peca) {
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                return true;
            }
        }
        return false;
    }

    public void moverPeca(int linha, int coluna, int peca) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    if (tabuleiro[linha][coluna] != 1 || tabuleiro[linha][coluna] != 2 || tabuleiro[linha][coluna] != 3 || tabuleiro[linha][coluna] != 4) {
                        tabuleiro[i][j] = 0; // Remove a peça da posição antiga
                        espacoEspecial();
                    }
                }
            }
        }
        tabuleiro[linha][coluna] = peca; // Coloca a peça na nova posição
        espacoEspecial();
    }

    public void espacoEspecial() { // metodo para por -1 no tabuleiro que indica o quadrante especial
        if (tabuleiro[0][2] == 0) {
            tabuleiro[0][2] = -1;
        }
        if (tabuleiro[2][2] == 0) {
            tabuleiro[2][2] = -1;
        }
        if (tabuleiro[1][1] == 0) {
            tabuleiro[1][1] = -1;
        }
        if (tabuleiro[1][3] == 0) {
            tabuleiro[1][3] = -1;
        }
    }

    public boolean vitoriaPrea() { // funciona
        if (tabuleiro[1][0] == 4) {
            if (tabuleiro[1][4] != 4) { // realmente precisa disso para não bugar
                return true; // O Preá venceu
            }
        }
        return false; // O Preá ainda não venceu
    }

    public boolean verificarVitoria() {
        if (vitoriaPrea()) { // Verifica se o Preá venceu
            return true;
        } else if (vitoriaEstudantes()) { // Verifica se os estudantes venceram
            return true;
        }
        return false; // Retorna false se não houver vitória ou verificarEmpate
    }

    public boolean vitoriaEstudantes() { // basicamente o prea é um rei com possibilidade de ficar limitado
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 4) { // Localiza o preá
                    boolean cercado = true;

                    // cima, baixo, esquerda e direita
                    int[] cardeaisX = {-1, 1, 0, 0};
                    int[] cardeaisY = {0, 0, -1, 1};

                    for (int k = 0; k < cardeaisX.length; k++) {
                        int novaLinha = i + cardeaisX[k];
                        int novaColuna = j + cardeaisY[k];

                        if (movimentoValido(novaLinha, novaColuna)) {
                            cercado = false; // O preá pode se mover
                            break;
                        }
                    }

                    // verifica as diagonais, por algum motivo dava bug quando era uma unica coisa
                    if (cercado && (tabuleiro[i][j] == -1 || tabuleiro[i][j] == 0)) {
                        int[] diagonaisX = {-1, -1, 1, 1};
                        int[] diagonaisY = {-1, 1, -1, 1};

                        for (int k = 0; k < diagonaisX.length; k++) {
                            int novaLinha = i + diagonaisX[k];
                            int novaColuna = j + diagonaisY[k];

                            if (movimentoValido(novaLinha, novaColuna)) {
                                cercado = false; // O Preá pode se mover diagonalmente
                                break;
                            }
                        }
                    }
                    // Retorna verdadeiro se o Preá estiver completamente cercado
                    if (cercado) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean movimentoValido(int linha, int coluna) { // vê se o proximo movimento está valido na matriz e nas casas
        return linha >= 0 && linha < tabuleiro.length
                && coluna >= 0 && coluna < tabuleiro[0].length
                && (tabuleiro[linha][coluna] == 0 || tabuleiro[linha][coluna] == -1);
    }

    public boolean verificarEmpate() { // Verifica o empate nas situações onde o preá chega no objetivo mas não tem como voltar
        if ((eEstudante(tabuleiro[0][3]) && eEstudante(tabuleiro[1][3]) && eEstudante(tabuleiro[1][4])) ||
                (eEstudante(tabuleiro[2][3]) && eEstudante(tabuleiro[1][3]) && eEstudante(tabuleiro[1][4])) ||
                (eEstudante(tabuleiro[0][3]) && eEstudante(tabuleiro[1][3]) && eEstudante(tabuleiro[2][3]))) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }

    private boolean eEstudante(int valor) {  // Metodo para dimiuir o tamanho de certos IFs retornando todos os Estudantes
        return valor == 1 || valor == 2 || valor == 3;
    }
}