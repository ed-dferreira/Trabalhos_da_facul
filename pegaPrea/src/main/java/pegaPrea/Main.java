package pegaPrea;

import javax.swing.*;

/**
 * Classe principal que inicializa o jogo "Pega Preá".
 */
public class Main {
    /**
     * Método principal do programa.
     * @param args Argumentos de linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {
        // Cria uma nova janela para o jogo
        JFrame janela = new JFrame();

        // Define o comportamento de encerramento da aplicação ao fechar a janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Impede que a janela seja redimensionada
        janela.setResizable(false);

        // Define o título da janela
        janela.setTitle("Pega Preá");

        // Cria o painel do jogo que contém os elementos gráficos e lógica do jogo
        TelaDoJogo gamePanel = new TelaDoJogo();

        // Adiciona o painel do jogo à janela
        janela.add(gamePanel);

        // Ajusta o tamanho da janela com base no conteúdo do painel
        janela.pack();

        // Centraliza a janela na tela
        janela.setLocationRelativeTo(null);

        // Torna a janela visível para o usuário
        janela.setVisible(true);

        // Inicia a thread principal do jogo para controle de eventos e atualizações
        gamePanel.startGameThread();
    }
}
