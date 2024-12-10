package Logica;

public class Tabuleiro {

    private String[][] tabuleiro;
    private PosicaoLogica prea;
    private PosicaoLogica[] estudantes;

    public Tabuleiro() {
        tabuleiro = new String[3][5];
        criarTabuleiro();
    }

    private void criarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = " ";
            }
        }

        tabuleiro[0][0] = "#";
        tabuleiro[2][0] = "#";
        tabuleiro[0][4] = "#";
        tabuleiro[2][4] = "#";

        estudantes = new PosicaoLogica[]{new PosicaoLogica(0, 1), new PosicaoLogica(1, 0), new PosicaoLogica(2, 1)};
        prea = new PosicaoLogica(1, 4);

        for (PosicaoLogica e : estudantes) {
            tabuleiro[e.linha][e.coluna] = "E";
        }

        tabuleiro[prea.linha][prea.coluna] = "P";
    }

    public boolean moverPeca(String peca, String direcao, boolean vezEstudante) {
        boolean vezQuem = false;
        if (vezEstudante) {
            while (!vezEstudante) {
                if (peca.startsWith("E")) {
                    int indice = Integer.parseInt(peca.substring(1)) - 1;
                    vezQuem = moverEstudante(indice, direcao);
                    if (vezQuem) {
                        System.out.println("Posição alterada.");
                        vezEstudante = true;
                    }

                } else {
                    System.out.println("Peça inválida para o estudante.");
                    vezEstudante = false;
                }
            }
        } else {
            while (vezEstudante) {
                if (peca.equals("P")) {
                    if (moverPrea(direcao)) {
                    } else {
                        System.out.println("Posição alterada");
                    }
                } else {
                    System.out.println("Peça inválida para a preá.");
                    return false;
                }
            }

            return vezEstudante;
        }
        return vezQuem;
    }

    private boolean moverEstudante(int indice, String direcao) {
        if (indice < 0 || indice >= estudantes.length) {
            System.out.println("Estudante não encontrado.");
            return false;
        }

        PosicaoLogica novaPosicao = mudarPosicao(estudantes[indice], direcao);

        if (posicaoValida(novaPosicao) && (direcao.equals("direita") || direcao.equals("baixo") || direcao.equals("cima") || direcao.equals("baixo direita")
                || direcao.equals("alto direita"))) {
            atualizarPosicao(estudantes[indice], novaPosicao, "E");
            estudantes[indice] = novaPosicao;
            return verificarVitoriaEstudantes();
        }
        return false;
    }

    private boolean moverPrea(String direcao) {  // funciona
        PosicaoLogica novaPosicao = mudarPosicao(prea, direcao);
        if (posicaoValida(novaPosicao)) {
            atualizarPosicao(prea, novaPosicao, "P");
            prea = novaPosicao;
            return verificarVitoriaPrea();
        }
        return false;
    }

    private PosicaoLogica mudarPosicao(PosicaoLogica posicao, String direcao) {
        switch (direcao) {
            case "cima":
                return new PosicaoLogica(posicao.linha - 1, posicao.coluna);
            case "baixo":
                return new PosicaoLogica(posicao.linha + 1, posicao.coluna);
            case "esquerda":
                return new PosicaoLogica(posicao.linha, posicao.coluna - 1);
            case "direita":
                return new PosicaoLogica(posicao.linha, posicao.coluna + 1);
            case "cima esquerda":
                return new PosicaoLogica(posicao.linha - 1, posicao.coluna - 1);
            case "cima direita":
                return new PosicaoLogica(posicao.linha - 1, posicao.coluna + 1);
            case "baixo esquerda":
                return new PosicaoLogica(posicao.linha + 1, posicao.coluna - 1);
            case "baixo direita":
                return new PosicaoLogica(posicao.linha + 1, posicao.coluna + 1);
            default:
                return posicao;
        }
    }

    public int[][] copiaTabuleiro() {
        int[][] tabuleiroCopy = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiroCopy[i][j] = Integer.parseInt(this.tabuleiro[i][j]);
            }
        }
        return tabuleiroCopy;
    }

    // Setter para o tabuleiro
    public void setTabuleiro(String[][] novoTabuleiro) {
        // Verifica se o novo tabuleiro tem o tamanho correto antes de substituir
        if (novoTabuleiro != null && novoTabuleiro.length == 3 && novoTabuleiro[0].length == 5) {
            tabuleiro = novoTabuleiro;
        } else {
            System.out.println("Tabuleiro inválido.");
        }
    }

    private boolean posicaoValida(PosicaoLogica posicao) {
        // Verifica se a posição está dentro dos limites do tabuleiro e se a célula está vazia
        boolean dentroLimites = posicao.linha >= 0 && posicao.linha < 3 && posicao.coluna >= 0 && posicao.coluna < 5;
        boolean posicaoInvalida = (posicao.linha == 0 && posicao.coluna == 0) ||
                (posicao.linha == 2 && posicao.coluna == 0) ||
                (posicao.linha == 0 && posicao.coluna == 4) ||
                (posicao.linha == 2 && posicao.coluna == 4);
        return dentroLimites && !posicaoInvalida && tabuleiro[posicao.linha][posicao.coluna].equals(" ");
    }

    private void atualizarPosicao(PosicaoLogica posicaoAtual, PosicaoLogica novaPosicao, String peca) {
        tabuleiro[posicaoAtual.linha][posicaoAtual.coluna] = " ";
        tabuleiro[novaPosicao.linha][novaPosicao.coluna] = peca;
    }

    private boolean verificarVitoriaPrea() {
        return prea.coluna == 0;  // A preá vence ao alcançar a primeira coluna
    }

    private boolean verificarVitoriaEstudantes() {
        for (PosicaoLogica adj : new PosicaoLogica[]{
                new PosicaoLogica(prea.linha - 1, prea.coluna),
                new PosicaoLogica(prea.linha + 1, prea.coluna),
                new PosicaoLogica(prea.linha, prea.coluna - 1),
                new PosicaoLogica(prea.linha, prea.coluna + 1)
        }) {
            if (posicaoValida(adj)) return false;
        }
        System.out.println("Estudantes venceram!");
        return true;
    }

    // metodo empate

    public boolean verificarVitoria() {
        if (verificarVitoriaPrea()) {
            System.out.println("A preá venceu!");
            return true;
        } else if (verificarVitoriaEstudantes()) {
            System.out.println("Estudantes venceram!");
            return true;
        }
        return false;
    }

    public void exibirTabuleiro() {
        for (String[] linha : tabuleiro) {
            for (String celula : linha) {
                System.out.print("[" + celula + "]");
            }
            System.out.println();
        }
    }
}
