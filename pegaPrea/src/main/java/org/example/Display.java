package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display {

    // Definindo os componentes da interface
    private JFrame frame;
    private JButton botao;

    // Construtor da classe Display
    public Display() {
        // Inicializando a janela (JFrame)
        frame = new JFrame("Minha Primeira GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializando o botão
        botao = new JButton("Clique em mim!");

        // Adicionando uma ação ao botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você clicou no botão!");
            }
        });

        // Adicionando o botão à janela
        frame.getContentPane().add(botao);
    }

    // Método para mostrar a janela
    public void mostrar() {
        frame.setVisible(true);
    }
}
