package PegaPreaEntregaEdition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGUI extends JFrame {
    private final Tabuleiro tabuleiro = new Tabuleiro(); // Classe que controla a lógica do jogo
    private final JButton[][] botoesTabuleiro = new JButton[3][5]; // Botões que representam o tabuleiro na interface gráfica
    private boolean vezEstudantes = true; // Indica de quem é a vez: true = time azul, false = time vermelho
    private int pecaSelecionada = 0; // Identifica a peça atualmente selecionada
    private JLabel etiquetaTurno; // Label que exibe informações sobre o turno atual

    public JogoGUI() {
        setTitle("PEGA PREÁ"); // Define o título da janela
        setSize(1000, 700); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza o programa ao fechar a janela
        setLayout(new BorderLayout()); // Define o layout principal
        JMenuBar barraMenu = new JMenuBar();
        JMenu jogoMenu = new JMenu("Menu jogo");
        JMenuItem reiniciarMenu = new JMenuItem("Reiniciar");
        JMenuItem sairMenu = new JMenuItem("Sair");
        jogoMenu.add(reiniciarMenu);
        jogoMenu.add(sairMenu);
        JMenuItem verNomesItem = new JMenuItem("Creditos");
        barraMenu.add(jogoMenu);
        barraMenu.add(verNomesItem);
        setJMenuBar(barraMenu);

        reiniciarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo(); // Reinicia o jogo
            }
        });

        // Ação do menu "Sair"
        sairMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        verNomesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe os nomes dos autores
                JOptionPane.showMessageDialog(JogoGUI.this, "Criadores do Jogo: Eduardo Dutra Ferreira e Alessando Velasques");
            }
        });
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
        etiquetaTurno = new JLabel("Vez dos Estudantes");
        add(etiquetaTurno, BorderLayout.NORTH);

        atualizarInterface();
    }

    private void tratarClique(int linha, int coluna) {
        int[][] tabuleiroTemp = this.tabuleiro.getTabuleiro(); // Obtém o estado atual do tabuleiroTemp

        if (pecaSelecionada == 0) {
            if ((vezEstudantes && tabuleiroTemp[linha][coluna] >= 1 && tabuleiroTemp[linha][coluna] <= 3) ||
                    (!vezEstudantes && tabuleiroTemp[linha][coluna] == 4)) {
                pecaSelecionada = tabuleiroTemp[linha][coluna];
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada);
            }
        } else {
            if (this.tabuleiro.podeMover(linha, coluna, pecaSelecionada)) {
                this.tabuleiro.moverPeca(linha, coluna, pecaSelecionada); // Move a peça
                if (this.tabuleiro.verificarVitoria()) { // Verifica se houve vitória
                    mostrarVitoria(); // Mostra a mensagem de vitória
                } else {
                    vezEstudantes = !vezEstudantes; // Alterna o turno
                    etiquetaTurno.setText(vezEstudantes ? "Vez dos Estudantes" : "Vez do Preá");
                }
                pecaSelecionada = 0; // Reseta a peça selecionada
                atualizarInterface(); // Atualiza a interface gráfica
            }
        }
    }

    private void atualizarInterface() {
        int[][] tabuleiroTemp = this.tabuleiro.getTabuleiro();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton botao = botoesTabuleiro[i][j]; // Botão correspondente
                botao.setEnabled(true); // Habilita o botão
                botao.setText(""); // Limpa o texto do botão
                switch (tabuleiroTemp[i][j]) {
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
                        botao.setText("Jogador " + tabuleiroTemp[i][j]);
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

    private void mostrarEmpate() {
        String mensagem = "Os jogadores empataram";
        JOptionPane.showMessageDialog(this, mensagem);
        reiniciarJogo();
    }

    private void mostrarVitoria() {
        String mensagem = vezEstudantes
                ? "Parabéns, Os estudantes venceram!"
                : "Parabéns, O preá venceu!";
        JOptionPane.showMessageDialog(this, mensagem);
        reiniciarJogo();
    }

    private void reiniciarJogo() {
        tabuleiro.inicializar(); // Reseta o tabuleiro
        vezEstudantes = true; // Reseta o turno
        pecaSelecionada = 0; // Reseta a peça selecionada
        etiquetaTurno.setText("Vez dos Estudantes"); // Atualiza o rótulo inicial
        atualizarInterface(); // Atualiza a interface gráfica
    }
}
