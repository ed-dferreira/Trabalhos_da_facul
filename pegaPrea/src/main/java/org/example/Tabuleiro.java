package org.example;

public class Tabuleiro {
    private String[][] tabuleiro;
    private Posicao prea;
    private Posicao[] estudantes;

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

        estudantes = new Posicao[]{new Posicao(0, 1), new Posicao(1, 0), new Posicao(2, 1)};
        prea = new Posicao(1, 4);

        for (Posicao e : estudantes) {
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

    Posicao novaPosicao = mudarPosicao(estudantes[indice], direcao);

    if (posicaoValida(novaPosicao) && (direcao.equals("direita") || direcao.equals("baixo") || direcao.equals("cima") || direcao.equals("baixo direita")
            || direcao.equals("alto direita"))) {
        atualizarPosicao(estudantes[indice], novaPosicao, "E");
        estudantes[indice] = novaPosicao;
        return verificarVitoriaEstudantes();
    }
    return false;
}

private boolean moverPrea(String direcao) {  // funciona
    Posicao novaPosicao = mudarPosicao(prea, direcao);
    if (posicaoValida(novaPosicao)) {
        atualizarPosicao(prea, novaPosicao, "P");
        prea = novaPosicao;
        return verificarVitoriaPrea();
    }
    return false;
}

private Posicao mudarPosicao(Posicao posicao, String direcao) {
    switch (direcao) {
        case "cima":
            return new Posicao(posicao.linha - 1, posicao.coluna);
        case "baixo":
            return new Posicao(posicao.linha + 1, posicao.coluna);
        case "esquerda":
            return new Posicao(posicao.linha, posicao.coluna - 1);
        case "direita":
            return new Posicao(posicao.linha, posicao.coluna + 1);
        case "cima esquerda":
            return new Posicao(posicao.linha - 1, posicao.coluna - 1);
        case "cima direita":
            return new Posicao(posicao.linha - 1, posicao.coluna + 1);
        case "baixo esquerda":
            return new Posicao(posicao.linha + 1, posicao.coluna - 1);
        case "baixo direita":
            return new Posicao(posicao.linha + 1, posicao.coluna + 1);
        default:
            return posicao;
    }
}

private boolean posicaoValida(Posicao posicao) {
    // Verifica se a posição está dentro dos limites do tabuleiro e se a célula está vazia
    boolean dentroLimites = posicao.linha >= 0 && posicao.linha < 3 && posicao.coluna >= 0 && posicao.coluna < 5;
    boolean posicaoInvalida = (posicao.linha == 0 && posicao.coluna == 0) ||
            (posicao.linha == 2 && posicao.coluna == 0) ||
            (posicao.linha == 0 && posicao.coluna == 4) ||
            (posicao.linha == 2 && posicao.coluna == 4);
    return dentroLimites && !posicaoInvalida && tabuleiro[posicao.linha][posicao.coluna].equals(" ");
}

private void atualizarPosicao(Posicao posicaoAtual, Posicao novaPosicao, String peca) {
    tabuleiro[posicaoAtual.linha][posicaoAtual.coluna] = " ";
    tabuleiro[novaPosicao.linha][novaPosicao.coluna] = peca;
}

private boolean verificarVitoriaPrea() {
    return prea.coluna == 0;  // A preá vence ao alcançar a primeira coluna
}

private boolean verificarVitoriaEstudantes() {
    for (Posicao adj : new Posicao[]{
            new Posicao(prea.linha - 1, prea.coluna),
            new Posicao(prea.linha + 1, prea.coluna),
            new Posicao(prea.linha, prea.coluna - 1),
            new Posicao(prea.linha, prea.coluna + 1)
    }) {
        if (posicaoValida(adj)) return false;
    }
    System.out.println("Estudantes venceram!");
    return true;
}

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
/*
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
                }
            } else{
                System.out.println("Peça inválida para o estudante.");
                vezEstudante = false;
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
    }
 */