package PegaPreaEntregaEdition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoGUI jogo = new JogoGUI();
            jogo.setVisible(true);
        });
    }
}
/*
        // Criação da janela (JFrame)
        JFrame frame = new JFrame("Jogo com Barra de Menus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Criando os botões de opção
        JRadioButton button1 = new JRadioButton("Opção 1");
        JRadioButton button2 = new JRadioButton("Opção 2");
        JRadioButton button3 = new JRadioButton("Opção 3");

        // Criando um ButtonGroup para que apenas um botão de opção possa ser selecionado por vez
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);

        // Adicionando os botões à janela
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        // Criando um botão para exibir a opção selecionada
        JButton showButton = new JButton("Mostrar Seleção");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = "Nenhuma opção selecionada";
                if (button1.isSelected()) {
                    selectedOption = "Opção 1";
                } else if (button2.isSelected()) {
                    selectedOption = "Opção 2";
                } else if (button3.isSelected()) {
                    selectedOption = "Opção 3";
                }
                JOptionPane.showMessageDialog(frame, "Você selecionou: " + selectedOption);
            }
        });

        frame.add(showButton);

        // Criando a barra de menus
        JMenuBar menuBar = new JMenuBar();

        // Menu "Jogo"
        JMenu jogoMenu = new JMenu("Jogo");
        JMenuItem reiniciarItem = new JMenuItem("Reiniciar");
        JMenuItem sairItem = new JMenuItem("Sair");
        jogoMenu.add(reiniciarItem);
        jogoMenu.add(sairItem);

        // Menu "Autoria"
        JMenu autoriaMenu = new JMenu("Autoria");
        JMenuItem verNomesItem = new JMenuItem("Ver Nomes");
        autoriaMenu.add(verNomesItem);

        // Adicionando menus à barra
        menuBar.add(jogoMenu);
        menuBar.add(autoriaMenu);

        // Atribuindo a barra de menus ao JFrame
        frame.setJMenuBar(menuBar);

        // Ação do menu "Reiniciar"
        reiniciarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setSelected(false);
                button2.setSelected(false);
                button3.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Jogo reiniciado!");
            }
        });

        // Ação do menu "Sair"
        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Ação do menu "Ver Nomes"
        verNomesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe uma caixa de diálogo com os nomes dos autores
                JOptionPane.showMessageDialog(frame, "Autores do Jogo: João, Maria, Pedro");
            }
        });

        // Exibindo a janela
        frame.setVisible(true);
    }
}


/*

 */
