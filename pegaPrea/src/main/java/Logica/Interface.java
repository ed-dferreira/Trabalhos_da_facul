/*
package Logica;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Interface extends JFrame {
    private Tabuleiro tabuleiro;
    private boolean fimDeJogo;
    private boolean vezEstudante;
    private final JButton[][] botoesTabuleiro = new JButton[3][5];

    public Interface() {
        tabuleiro = new Tabuleiro();
        fimDeJogo = false;
        setTitle("Jogo de Tabuleiro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private void atualizarInterface() {
        int[][] tabuleiro = tabuleiro.copiaTabuleiro();  // Use 'tabuleiro' ao invés de 'tabuleiroLogica'

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton botao = botoesTabuleiro[i][j];
                botao.setEnabled(true);
                botao.setText("");

                switch (tabuleiro[i][j]) {
                    case -1:
                        botao.setBackground(Color.GRAY);
                        botao.setEnabled(false);
                        break;
                    case 1, 2, 3:
                        botao.setBackground(Color.BLUE);
                        botao.setForeground(Color.WHITE);
                        botao.setText("P" + tabuleiro[i][j]);
                        break;
                    case 4:
                        botao.setBackground(Color.RED);
                        botao.setForeground(Color.WHITE);
                        botao.setText("PP");
                        break;
                    default:
                        botao.setBackground(Color.WHITE);
                }
            }
        }
    }

    private void atualizarMatriz() {
        int[][] tabuleiro = tabuleiro.getTabuleiro();  // Use 'tabuleiro' aqui também

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                String texto = botoesTabuleiro[i][j].getText();

                // Verifica o texto de cada botão e atualiza a matriz de acordo
                if ("P1".equals(texto)) {
                    tabuleiro[i][j] = 1;
                } else if ("P2".equals(texto)) {
                    tabuleiro[i][j] = 2;
                } else if ("P3".equals(texto)) {
                    tabuleiro[i][j] = 3;
                } else if ("PP".equals(texto)) {
                    tabuleiro[i][j] = 4;
                } else {
                    tabuleiro[i][j] = 0; // Vazio
                }
            }
        }

        // Atualiza o estado no jogo
        tabuleiro.setTabuleiro(tabuleiro);
    }

}


 */