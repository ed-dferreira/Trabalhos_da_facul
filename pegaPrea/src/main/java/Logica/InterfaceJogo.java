package Logica;

import javax.swing.*;
import java.awt.*;

/**
 * Classe JogoGUI representa a interface gráfica do jogo "Pega Preá".
 */
public class InterfaceJogo extends JFrame {
    private final Tabuleiro tabuleiroLogica = new Tabuleiro();
    private final JButton[][] botoesTabuleiro = new JButton[3][5];
    private boolean vezEsquerda = true; // true = time azul, false = time vermelho
    private int pecaSelecionada = 0; // Peça atualmente selecionada
    private JLabel etiquetaTurno; // Exibe informações sobre o turno atual
    private JButton botaoReiniciar; // Botão para reiniciar o jogo

    public InterfaceJogo() {
        setTitle("Jogo de Tabuleiro");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarInterface();
    }

    private void inicializarInterface() {
        JPanel painelTabuleiro = new JPanel(new GridLayout(3, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                final int linha = i;
                final int coluna = j;
                JButton botao = new JButton();
                botoesTabuleiro[i][j] = botao;
                botao.addActionListener(e -> tratarClique(linha, coluna));
                painelTabuleiro.add(botao);
            }
        }

        add(painelTabuleiro, BorderLayout.CENTER);

        etiquetaTurno = new JLabel("Vez de: Time Azul (P1, P2, P3)");
        add(etiquetaTurno, BorderLayout.NORTH);

        // Botão para reiniciar o jogo
        botaoReiniciar = new JButton("Reiniciar Jogo");
        botaoReiniciar.addActionListener(e -> reiniciarJogo());
        add(botaoReiniciar, BorderLayout.SOUTH);

        atualizarInterface();
    }

    private void tratarClique(int linha, int coluna) {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro();

        if (pecaSelecionada == 0) {
            // Seleciona uma peça válida
            if ((vezEsquerda && tabuleiro[linha][coluna] >= 1 && tabuleiro[linha][coluna] <= 3) ||
                    (!vezEsquerda && tabuleiro[linha][coluna] == 4)) {
                pecaSelecionada = tabuleiro[linha][coluna];
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada);
            }
        } else {
            // Tenta mover a peça
            if (tabuleiroLogica.podeMover(linha, coluna, pecaSelecionada)) {
                tabuleiroLogica.moverPeca(linha, coluna, pecaSelecionada);
                if (tabuleiroLogica.verificarVitoria()) {
                    mostrarVitoria();
                } else {
                    vezEsquerda = !vezEsquerda;
                    etiquetaTurno.setText(vezEsquerda ? "Vez de: Time Azul (P1, P2, P3)" : "Vez de: Time Vermelho (PP)");
                }
                pecaSelecionada = 0;
                atualizarInterface();
            }
        }
    }

    private void atualizarInterface() {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro();

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

    private void mostrarVitoria() {
        String mensagem = vezEsquerda
                ? "Parabéns, Time Azul venceu! Preá foi capturado ou cercado."
                : "Parabéns, Time Vermelho venceu! Preá alcançou a posição (1, 0).";
        JOptionPane.showMessageDialog(this, mensagem);
        reiniciarJogo();
    }

    private void reiniciarJogo() {
        tabuleiroLogica.inicializarTabuleiro();
        vezEsquerda = true;
        pecaSelecionada = 0;
        etiquetaTurno.setText("Vez de: Time Azul (P1, P2, P3)");
        atualizarInterface();
    }
}