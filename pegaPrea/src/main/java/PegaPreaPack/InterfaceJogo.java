package PegaPreaPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceJogo extends JFrame {
    private final Tabuleiro tabuleiro = new Tabuleiro(); // Classe que controla a lógica do jogo
    private final JButton[][] botoesTabuleiro = new JButton[3][5]; // Botões que representam a interface gráfica
    private boolean vezEstudantes = true;
    private int pecaSelecionada = 0;
    private JLabel etiquetaTurno; // LAbel para mostrar quem joga

    public InterfaceJogo() {
        setTitle("Pega Preá");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
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

        sairMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }  // Sair do Jogo
        });

        verNomesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe os nomes dos autores
                JOptionPane.showMessageDialog(InterfaceJogo.this, "Criadores do Jogo: Eduardo Dutra Ferreira e Alessando Velasques");
            }
        });
        inicializarInterface();
    } // termina o construtor

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
        int[][] tabuleiroTemp = this.tabuleiro.getTabuleiro(); // Obtém o estado atual do tabuleiro
        if (pecaSelecionada == 0) {
            atualizarInterface();
            if ((vezEstudantes && tabuleiroTemp[linha][coluna] >= 1 && tabuleiroTemp[linha][coluna] <= 3) ||
                    (!vezEstudantes && tabuleiroTemp[linha][coluna] == 4)) { // verifica se selecionou alguma peça valida que no caso é um botão
                pecaSelecionada = tabuleiroTemp[linha][coluna];
                if (pecaSelecionada == 1 || pecaSelecionada == 2 || pecaSelecionada == 3) { // esse if e else é só para label
                    etiquetaTurno.setText("Estudante " + pecaSelecionada + " selecionado");
                } else {
                    etiquetaTurno.setText("Preá Selecionado");
                }
            }
        } else { // mudanças de turno
            if (this.tabuleiro.podeMover(linha, coluna, pecaSelecionada)) {  // aqui é bruxaria das mais malignas
                this.tabuleiro.moverPeca(linha, coluna, pecaSelecionada); // Manda a peça para o metodo moverPeca que separa entre os estudante e prea que faz toda a verificação de movimento
                if (this.tabuleiro.verificarVitoria()) { // Verifica se houve vitória
                    mostrarVitoria(); // Mostra a mensagem
                }else if (this.tabuleiro.verificarEmpate()) {
                    mostrarEmpate();
                } else {
                    tabuleiro.espacoEspecial(); // garante que vai por o -1
                    vezEstudantes = !vezEstudantes; // Alterna o turno
                    etiquetaTurno.setText(vezEstudantes ? "Vez dos Estudantes" : "Vez do Preá"); // muda a label
                }
                pecaSelecionada = 0; // Reseta a peça
                atualizarInterface();
            }
        }
    }

    private void atualizarInterface() { // no geral só le o tabuleiro e pôe a cor e numero
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
                        tabuleiro.espacoEspecial();
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
        boolean empate = tabuleiro.verificarEmpate();
        String mensagem = empate ? "Empate!" : " ";
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
        etiquetaTurno.setText("Vez dos Estudantes"); // Atualiza a label
        atualizarInterface(); // Atualiza a interface
    }
}