package org.example;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private boolean fimDeJogo;
    private boolean vezEstudante;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        fimDeJogo = false;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo Pega Preá!");
        while (!fimDeJogo) {
            tabuleiro.exibirTabuleiro();
            System.out.println("Escolha uma peça para mover (Ex: E1, P): ");
            String peca = scanner.nextLine();
            System.out.println("Digite o movimento (Ex: cima, baixo, direita, esquerda, cima-direita, cima esquerda, baixo direita e baixo esquerda): ");
            String direcao = scanner.nextLine();
            tabuleiro.moverPeca(peca, direcao, vezEstudante);
            if (!fimDeJogo) {
                vezEstudante = !vezEstudante; // Alterna entre Estudante e Preá
            }
            fimDeJogo = tabuleiro.verificarVitoria();
        }
        scanner.close();
        System.out.println("Fim de jogo!");
    }
}


