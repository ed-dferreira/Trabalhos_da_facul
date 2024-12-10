package PegaPreaEntregaEdition;

import javax.swing.*;
import java.awt.*;

/**
 * Classe JogoGUI representa a interface gráfica do jogo "Pega Preá".
 */
public class JogoGUI extends JFrame {
    private final TabuleiroLogica tabuleiroLogica = new TabuleiroLogica(); // Classe que controla a lógica do jogo
    private final JButton[][] botoesTabuleiro = new JButton[3][5]; // Botões que representam o tabuleiro na interface gráfica
    private boolean vezEsquerda = true; // Indica de quem é a vez: true = time azul, false = time vermelho
    private int pecaSelecionada = 0; // Identifica a peça atualmente selecionada
    private JLabel etiquetaTurno; // Label que exibe informações sobre o turno atual

    /**
     * Construtor que inicializa a interface gráfica do jogo.
     */
    public JogoGUI() {
        setTitle("Jogo de Tabuleiro"); // Define o título da janela
        setSize(800, 600); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza o programa ao fechar a janela
        setLayout(new BorderLayout()); // Define o layout principal

        inicializarInterface(); // Configura os componentes da interface gráfica
    }

    /**
     * Configura a interface do tabuleiro e outros elementos.
     */
    private void inicializarInterface() {
        // Cria um painel para o tabuleiro com layout de grade (3 linhas por 5 colunas)
        JPanel painelTabuleiro = new JPanel(new GridLayout(3, 5));

        // Cria os botões do tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                final int linha = i; // Linha do botão
                final int coluna = j; // Coluna do botão
                JButton botao = new JButton(); // Cria um botão
                botoesTabuleiro[i][j] = botao; // Armazena o botão na matriz
                botao.addActionListener(e -> tratarClique(linha, coluna)); // Adiciona ação ao clique do botão
                painelTabuleiro.add(botao); // Adiciona o botão ao painel
            }
        }

        add(painelTabuleiro, BorderLayout.CENTER); // Adiciona o painel do tabuleiro à janela

        // Configura o rótulo de turno
        etiquetaTurno = new JLabel("Vez de: Time Azul (P1, P2, P3)");
        add(etiquetaTurno, BorderLayout.NORTH); // Adiciona o rótulo na parte superior da janela

        atualizarInterface(); // Atualiza a interface inicial com o estado do tabuleiro
    }

    /**
     * Trata os cliques nos botões do tabuleiro.
     * @param linha Linha do botão clicado.
     * @param coluna Coluna do botão clicado.
     */
    private void tratarClique(int linha, int coluna) {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro(); // Obtém o estado atual do tabuleiro

        // Verifica se nenhuma peça está selecionada
        if (pecaSelecionada == 0) {
            // Seleciona uma peça válida do jogador atual
            if ((vezEsquerda && tabuleiro[linha][coluna] >= 1 && tabuleiro[linha][coluna] <= 3) ||
                    (!vezEsquerda && tabuleiro[linha][coluna] == 4)) {
                pecaSelecionada = tabuleiro[linha][coluna]; // Seleciona a peça clicada
                etiquetaTurno.setText("Peça selecionada: P" + pecaSelecionada); // Atualiza o rótulo
            }
        } else {
            // Tenta mover a peça selecionada para a posição clicada
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

    /**
     * Atualiza a interface gráfica com base no estado do tabuleiro.
     */
    private void atualizarInterface() {
        int[][] tabuleiro = tabuleiroLogica.getTabuleiro(); // Obtém o estado atual do tabuleiro

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton botao = botoesTabuleiro[i][j]; // Botão correspondente
                botao.setEnabled(true); // Habilita o botão
                botao.setText(""); // Limpa o texto do botão

                // Configura o botão com base no estado do tabuleiro
                switch (tabuleiro[i][j]) {
                    case -1 -> { // Posição bloqueada
                        botao.setBackground(Color.GRAY);
                        botao.setEnabled(false);
                    }
                    case 1, 2, 3 -> { // Peças do time azul
                        botao.setBackground(Color.BLUE);
                        botao.setForeground(Color.WHITE);
                        botao.setText("P" + tabuleiro[i][j]);
                    }
                    case 4 -> { // Peça do time vermelho
                        botao.setBackground(Color.RED);
                        botao.setForeground(Color.WHITE);
                        botao.setText("PP");
                    }
                    default -> botao.setBackground(Color.WHITE); // Posição vazia
                }
            }
        }
    }

    /**
     * Exibe uma mensagem de vitória e reinicia o jogo.
     */
    private void mostrarVitoria() {
        String mensagem = vezEsquerda
                ? "Parabéns, Time Azul venceu! Preá foi capturado ou cercado."
                : "Parabéns, Time Vermelho venceu! Preá alcançou a posição (1, 0).";
        JOptionPane.showMessageDialog(this, mensagem); // Exibe a mensagem de vitória
        reiniciarJogo(); // Reinicia o jogo
    }

    /**
     * Reinicia o estado do jogo para uma nova partida.
     */
    private void reiniciarJogo() {
        tabuleiroLogica.inicializarTabuleiro(); // Reseta o tabuleiro
        vezEsquerda = true; // Reseta o turno
        pecaSelecionada = 0; // Reseta a peça selecionada
        etiquetaTurno.setText("Vez de: Time Azul (P1, P2, P3)"); // Atualiza o rótulo inicial
        atualizarInterface(); // Atualiza a interface gráfica
    }

    /**
     * Método principal para iniciar a interface gráfica.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Executa na thread do Swing
            JogoGUI jogo = new JogoGUI(); // Cria a interface do jogo
            jogo.setVisible(true); // Torna a janela visível
        });
    }
}
