package PegaPreaEntregaEdition;

/*
Falta Movimentos inválidos não são
permitidos e o controle é feito
por meio de exceções

Na pratica usar as exceções

Falta verificar a vitoria dos estudante o que é critico
 */



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
    }

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
        if (tabuleiro[linha][coluna] != 0 && tabuleiro[linha][coluna] != -1) {
            return false;  // A célula de origem não é válida para o movimento
        }

        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;

        // Verifica as posições adjacentes (diagonais, verticais e horizontais)
        if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
            return true;
        }
        if (linha + 1 < linhas && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
            // Movimento Baixo Esquerda
            return true;
        }
        // Verifica os movimentos verticais e horizontais
        if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
            // Movimento Cima
            return true;
        }
        if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
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

    public boolean movimentoPrea(int linha, int coluna, int peca) {
        // Verifica se a célula inicial é válida para o jogador (0 ou -1)
        if (tabuleiro[linha][coluna] != 0 && tabuleiro[linha][coluna] != -1) {
            return false;  // A célula de origem não é válida para o movimento
        }

        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;

        if (tabuleiro[linha][coluna] == 0) {
            // Verifica as posições adjacentes (diagonais, verticais e horizontais)
            if (linha - 1 >= 0 && coluna - 1 >= 0 && tabuleiro[linha - 1][coluna - 1] == peca) {
                // Movimento Cima Esquerda
                return true;
            }
            if (linha - 1 >= 0 && coluna + 1 < colunas && tabuleiro[linha - 1][coluna + 1] == peca) {
                // Movimento Cima Direita
                return true;
            }
            if (linha + 1 < linhas && coluna + 1 < colunas && tabuleiro[linha + 1][coluna + 1] == peca) {
                // Movimento Baixo Direita
                return true;
            }
            if (linha + 1 < linhas && coluna - 1 >= 0 && tabuleiro[linha + 1][coluna - 1] == peca) {
                // Movimento Baixo Esquerda
                return true;
            }

            // Verifica os movimentos verticais e horizontais
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // Movimento Cima
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                // Movimento Baixo
                return true;
            }
            if (coluna + 1 < colunas && tabuleiro[linha][coluna + 1] == peca) {
                // Movimento Direita
                return true;
            }
            if (coluna - 1 >= 0 && tabuleiro[linha][coluna - 1] == peca) {
                // Movimento Esquerda
                return true;
            }
        }
        if (tabuleiro[linha][coluna] == -1) {
            // Verifica os movimentos verticais e horizontais
            if (linha - 1 >= 0 && tabuleiro[linha - 1][coluna] == peca) {
                // Movimento Cima
                return true;
            }
            if (linha + 1 < linhas && tabuleiro[linha + 1][coluna] == peca) {
                // Movimento Baixo
                return true;
            }
            if (coluna + 1 < colunas && tabuleiro[linha][coluna + 1] == peca) {
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

    public void espacoEspecial() { // aqui tá torto
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
            return true; // O Preá venceu
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

    public boolean vitoriaEstudantes() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 4) {
                    // Verificar se está cercada nas 4 direções cardeais (sem diagonais)
                    boolean cercada = true;

                    // Definir as 4 direções ao redor da peça (cima, baixo, esquerda, direita)
                    int[] dx = {-1, 1, 0, 0}; // Movimentos para cima, baixo, esquerda e direita
                    int[] dy = {0, 0, -1, 1}; // Movimentos para cima, baixo, esquerda e direita

                    for (int k = 0; k < 4; k++) {
                        int novaLinha = i + dx[k];
                        int novaColuna = j + dy[k];

                        // Verificar se a posição está dentro dos limites do tabuleiro (evitar -1 e -2)
                        if (novaLinha >= 0 && novaLinha < tabuleiro.length && novaColuna >= 0 && novaColuna < tabuleiro[i].length) {
                            // Verificar se a posição ao redor é ocupada por um jogador
                            if (!eJogador(tabuleiro[novaLinha][novaColuna])) {
                                cercada = false;
                                break;
                            }
                        } else {
                            // Se a posição estiver fora dos limites, considerar como não cercada
                            cercada = false;
                            break;
                        }
                    }

                    // Retorna se a peça está cercada
                    if (cercada) {
                        return true;
                    }
                }
            }
        }
        return false; // Se não encontrar nenhuma peça 4 cercada
    }



        public boolean verificarEmpate() {
        if ((eJogador(tabuleiro[0][3]) && eJogador(tabuleiro[1][3]) && eJogador(tabuleiro[1][4])) ||
                (eJogador(tabuleiro[2][3]) && eJogador(tabuleiro[1][3]) && eJogador(tabuleiro[1][4])) ||
                (eJogador(tabuleiro[0][3]) && eJogador(tabuleiro[1][3]) && eJogador(tabuleiro[2][3]))) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }

    private boolean eJogador(int valor) {
        return valor == 1 || valor == 2 || valor == 3;
    }
}
/*
0 1 2 3 4
1
2
 */