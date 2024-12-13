package PegaPreaPack;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceJogo jogo = new InterfaceJogo();
            jogo.setVisible(true);
        });
    }
}
