package org;

import javax.swing.*;
import java.awt.*;

public class PreaMk1 extends JFrame {

    // Declaração do tabuleiro suas peças

    private final JButton[][] botoesTabuleiro = new JButton[3][5]; // Botões que representam as células do tabuleiro
    private final int[][] tabuleiro = new int[3][5]; // Representação lógica do tabuleiro
    private boolean vezEsquerda = true; // Indica de quem é a vez (time azul começa)
    private int pecaSelecionada = 0; // Armazena qual peça foi selecionada pelo jogador
    private JLabel etiquetaTurno; // Mostra de quem é a vez no momento

    public PreaMk1() {
        setTitle("Jogo de Tabuleiro");
        setSize(800, 600); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Usa o layout Border para organizar os componentes

        inicializarTabuleiro(); // Inicializa a lógica do tabuleiro

        // Painel para o tabuleiro (botões)
        JPanel painelTabuleiro = new JPanel(new GridLayout(3, 5)); // Tabuleiro de 3 linhas e 5 colunas
        inicializarBotoes(painelTabuleiro); // Cria os botões do tabuleiro
        add(painelTabuleiro, BorderLayout.CENTER); // Adiciona o tabuleiro no centro da janela

        // Painel superior para exibir o turno
        JPanel painelInfo = new JPanel();
        etiquetaTurno = new JLabel("Vez de: Time Azul (P1, P2, P3)"); // Mostra quem joga
        painelInfo.add(etiquetaTurno);
        add(painelInfo, BorderLayout.NORTH); // Adiciona o painel no topo da janela
    }

    // Método para configurar o estado inicial do tabuleiro
    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) { // Limpa o tabuleiro (0 = célula vazia)
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        // Define os cantos como áreas bloqueadas (-1)
        tabuleiro[0][0] = -1;
        tabuleiro[0][4] = -1;
        tabuleiro[2][0] = -1;
        tabuleiro[2][4] = -1;

        // Coloca as peças em suas posições iniciais
        tabuleiro[0][1] = 1; // P1 (Peça do time azul)
        tabuleiro[1][0] = 2; // P2
        tabuleiro[2][1] = 3; // P3
        tabuleiro[1][4] = 4; // PP (Peça do time vermelho)
    }

    // Método para criar os botões que representam o tabuleiro
    private void inicializarBotoes(JPanel painelTabuleiro) {
        for (int i = 0; i < 3; i++) { // Percorre as linhas do tabuleiro
            for (int j = 0; j < 5; j++) { // Percorre as colunas
                botoesTabuleiro[i][j] = new JButton(); // Cria um botão para cada célula
                atualizarAparenciaBotao(i, j); // Define a aparência inicial do botão

                final int linha = i, coluna = j; // Salva a posição do botão
                botoesTabuleiro[i][j].addActionListener(e -> tratarClique(linha, coluna)); // Adiciona o evento de clique

                painelTabuleiro.add(botoesTabuleiro[i][j]); // Adiciona o botão ao painel
            }
        }
    }

    // Define a aparência dos botões com base no estado atual do tabuleiro
    private void atualizarAparenciaBotao(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == -1) { // Canto bloqueado
            botoesTabuleiro[linha][coluna].setBackground(Color.GRAY);
            botoesTabuleiro[linha][coluna].setText("");
            botoesTabuleiro[linha][coluna].setEnabled(false); // Bloqueia o botão
        } else if (tabuleiro[linha][coluna] == 1) { // P1
            botoesTabuleiro[linha][coluna].setBackground(Color.BLUE);
            botoesTabuleiro[linha][coluna].setText("P1");
        } else if (tabuleiro[linha][coluna] == 2) { // P2
            botoesTabuleiro[linha][coluna].setBackground(Color.BLUE);
            botoesTabuleiro[linha][coluna].setText("P2");
        } else if (tabuleiro[linha][coluna] == 3) { // P3
            botoesTabuleiro[linha][coluna].setBackground(Color.BLUE);
            botoesTabuleiro[linha][coluna].setText("P3");
        } else if (tabuleiro[linha][coluna] == 4) { // PP
            botoesTabuleiro[linha][coluna].setBackground(Color.RED);
            botoesTabuleiro[linha][coluna].setText("PP");
        } else { // Célula vazia
            botoesTabuleiro[linha][coluna].setBackground(Color.WHITE);
            botoesTabuleiro[linha][coluna].setText("");
        }
    }

    // Lida com os cliques nos botões do tabuleiro
    private void tratarClique(int linha, int coluna) {
        if (pecaSelecionada == 0) { // Se nenhuma peça foi selecionada
            if (vezEsquerda && (tabuleiro[linha][coluna] >= 1 && tabuleiro[linha][coluna] <= 3)) {
                pecaSelecionada = tabuleiro[linha][coluna]; // Seleciona a peça do time azul
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada);
            } else if (!vezEsquerda && tabuleiro[linha][coluna] == 4) { // Seleciona a peça PP
                pecaSelecionada = 4;
                etiquetaTurno.setText("Peça selecionada: PP");
            }
        } else { // Se uma peça já foi selecionada
            if (tabuleiro[linha][coluna] == 0 && podeMoverPara(linha, coluna, pecaSelecionada)) {
                moverPeca(linha, coluna, pecaSelecionada); // Move a peça selecionada
                if (verificarFimDeJogo()) { // Verifica se o jogo acabou
                    mostrarDialogoVitoria();
                } else {
                    vezEsquerda = !vezEsquerda; // Alterna o turno
                    pecaSelecionada = 0;
                    etiquetaTurno.setText(vezEsquerda ? "Vez de: Time Azul (P1, P2, P3)" : "Vez de: Time Vermelho (PP)");
                }
            }
        }
    }

    // Verifica se uma peça pode ser movida para a posição clicada
    private boolean podeMoverPara(int linha, int coluna, int peca) {
        int[][] direcoes;
        if (peca == 4) { // PP pode mover para todos os lados
            direcoes = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        } else { // P1, P2, P3 podem mover para a direita e diagonais à direita
            direcoes = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {-1, 1}, {1, 1}};
        }

        for (int[] direcao : direcoes) { // Verifica todas as direções permitidas
            int novaLinha = linha - direcao[0];
            int novaColuna = coluna - direcao[1];
            if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 5 && tabuleiro[novaLinha][novaColuna] == peca) {
                return true; // Movimento válido
            }
        }
        return false; // Movimento inválido
    }

    private void moverPeca(int linha, int coluna, int peca) {
        // Remove a peça da posição antiga
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == peca) {
                    tabuleiro[i][j] = 0;
                    break;
                }
            }
        }
        tabuleiro[linha][coluna] = peca; // Coloca a peça na nova posição
        atualizarTabuleiro(); // Atualiza a interface
    }

    private void atualizarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                atualizarAparenciaBotao(i, j);
            }
        }
    }

    private boolean verificarFimDeJogo() {
        return tabuleiro[1][0] == 4; // O jogo termina quando PP alcança a célula (1, 0)
    }

    private void mostrarDialogoVitoria() {
        int resposta = JOptionPane.showConfirmDialog(this, "Parabéns, você ganhou!\nDeseja reiniciar o jogo?", "Fim de Jogo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            reiniciarJogo();
        } else {
            System.exit(0);
        }
    }

    private void reiniciarJogo() {
        inicializarTabuleiro(); // Redefine o tabuleiro para o estado inicial
        atualizarTabuleiro(); // Atualiza a interface
        vezEsquerda = true;
        pecaSelecionada = 0;
        etiquetaTurno.setText("Vez de: Time Azul (P1, P2, P3)");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PreaMk1 frame = new PreaMk1();
            frame.setVisible(true); // Torna a janela visível
        });
    }
}
