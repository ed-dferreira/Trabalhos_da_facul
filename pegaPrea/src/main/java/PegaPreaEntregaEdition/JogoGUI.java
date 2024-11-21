package PegaPreaEntregaEdition;

import javax.swing.*;
import java.awt.*;

public class JogoGUI extends JFrame {
    private final TabuleiroLogica tabuleiroLogica = new TabuleiroLogica();
    private final JButton[][] botoesTabuleiro = new JButton[3][5];
    private boolean vezEsquerda = true; // Azul começa
    private int pecaSelecionada = 0;
    private JLabel etiquetaTurno;

    public JogoGUI() {
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

        atualizarInterface();
    }

    private void tratarClique(int linha, int coluna) {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro();

        if (pecaSelecionada == 0) {
            if ((vezEsquerda && tabuleiro[linha][coluna] >= 1 && tabuleiro[linha][coluna] <= 3) ||
                    (!vezEsquerda && tabuleiro[linha][coluna] == 4)) {
                pecaSelecionada = tabuleiro[linha][coluna];
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada);
            }
        } else {
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
                botao.setText(""); // Limpa o texto do botão

                switch (tabuleiro[i][j]) {
                    case -1 -> {
                        botao.setBackground(Color.GRAY);
                        botao.setEnabled(false);
                    }
                    case 1 -> {
                        botao.setBackground(Color.BLUE);
                        botao.setForeground(Color.WHITE);
                        botao.setText("P1");
                    }
                    case 2 -> {
                        botao.setBackground(Color.BLUE);
                        botao.setForeground(Color.WHITE);
                        botao.setText("P2");
                    }
                    case 3 -> {
                        botao.setBackground(Color.BLUE);
                        botao.setForeground(Color.WHITE);
                        botao.setText("P3");
                    }
                    case 4 -> {
                        botao.setBackground(Color.RED);
                        botao.setForeground(Color.WHITE);
                        botao.setText("PP");
                    }
                    default -> botao.setBackground(Color.WHITE);
                }
            }
        }
    }

    private void mostrarVitoria() {
        String mensagem = vezEsquerda
                ? "Parabéns, Time Azul venceu! Prea foi capturado ou cercado."
                : "Parabéns, Time Vermelho venceu! Prea alcançou a posição (1, 0).";
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoGUI jogo = new JogoGUI();
            jogo.setVisible(true);
        });
    }
}
