package PegaPreaEntregaEdition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGUI extends JFrame {
    private final TabuleiroLogica tabuleiroLogica = new TabuleiroLogica(); // Classe que controla a lógica do jogo
    private final JButton[][] botoesTabuleiro = new JButton[3][5]; // Botões que representam o tabuleiro na interface gráfica
    private boolean vezEsquerda = true; // Indica de quem é a vez: true = time azul, false = time vermelho
    private int pecaSelecionada = 0; // Identifica a peça atualmente selecionada
    private JLabel etiquetaTurno; // Label que exibe informações sobre o turno atual

    public JogoGUI() {
        setTitle("Jogo de Tabuleiro"); // Define o título da janela
        setSize(1000, 700); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza o programa ao fechar a janela
        setLayout(new BorderLayout()); // Define o layout principal
        JMenuBar menuBar = new JMenuBar();
        JMenu jogoMenu = new JMenu("Jogo");
        JMenuItem reiniciarItem = new JMenuItem("Reiniciar");
        JMenuItem sairItem = new JMenuItem("Sair");
        jogoMenu.add(reiniciarItem);
        jogoMenu.add(sairItem);
        JMenu autoriaMenu = new JMenu("Autoria");
        JMenuItem verNomesItem = new JMenuItem("Ver Nomes");
        autoriaMenu.add(verNomesItem);
        menuBar.add(jogoMenu);
        menuBar.add(autoriaMenu);
        setJMenuBar(menuBar);

        reiniciarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(); // Reinicia o jogo
            }
        });

        // Ação do menu "Sair"
        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        verNomesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe os nomes dos autores
                JOptionPane.showMessageDialog(JogoGUI.this, "Autores do Jogo: Eduardo Dutra Ferreira e Alessando Velasques");
            }
        });

        inicializarInterface(); // Configura os componentes da interface gráfica
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
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro(); // Obtém o estado atual do tabuleiro

        if (pecaSelecionada == 0) {
            if ((vezEsquerda && tabuleiro[linha][coluna] >= 1 && tabuleiro[linha][coluna] <= 3) ||
                    (!vezEsquerda && tabuleiro[linha][coluna] == 4)) {
                pecaSelecionada = tabuleiro[linha][coluna];
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada);
            }
        } else {
            if (tabuleiroLogica.podeMover(linha, coluna, pecaSelecionada)) {
                tabuleiroLogica.moverPeca(linha, coluna, pecaSelecionada); // Move a peça
                if (tabuleiroLogica.verificarVitoria()) { // Verifica se houve vitória
                    mostrarVitoria(); // Mostra a mensagem de vitória
                } else {
                    vezEsquerda = !vezEsquerda; // Alterna o turno
                    etiquetaTurno.setText(vezEsquerda ? "Vez de: Time Azul (P1, P2, P3)" : "Vez de: Time Vermelho (PP)");
                }
                pecaSelecionada = 0; // Reseta a peça selecionada
                atualizarInterface(); // Atualiza a interface gráfica
            }
        }
    }

    private void atualizarInterface() {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro(); // Obtém o estado atual do tabuleiro

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton botao = botoesTabuleiro[i][j]; // Botão correspondente
                botao.setEnabled(true); // Habilita o botão
                botao.setText(""); // Limpa o texto do botão

                switch (tabuleiro[i][j]) {
                    case -2 -> { // Posição bloqueada
                        botao.setBackground(Color.BLACK);
                        botao.setEnabled(false);
                    }
                    case -1 -> { // Posição com movimento limitado
                        botao.setBackground(Color.LIGHT_GRAY);
                    }
                    case 1, 2, 3 -> {
                        botao.setBackground(Color.GREEN);
                        botao.setForeground(Color.DARK_GRAY);
                        botao.setText("Jogador " + tabuleiro[i][j]);
                    }
                    case 4 -> {
                        botao.setBackground(Color.RED);
                        botao.setForeground(Color.DARK_GRAY);
                        botao.setText("Preá");
                    }
                    default -> botao.setBackground(Color.WHITE); // Posição vazia
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
        tabuleiroLogica.inicializarTabuleiro(); // Reseta o tabuleiro
        vezEsquerda = true; // Reseta o turno
        pecaSelecionada = 0; // Reseta a peça selecionada
        etiquetaTurno.setText("Vez de: Time Azul (P1, P2, P3)"); // Atualiza o rótulo inicial
        atualizarInterface(); // Atualiza a interface gráfica
    }
}
