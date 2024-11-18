package org.example;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class IniciadorJogo {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(TelaJogo.SCREEN_WIDTH, TelaJogo.SCREEN_HEIGHT);
        new Lwjgl3Application(new Isometrico(), config);

    }
}

/*
Jogo jogo = new Jogo();
        jogo.iniciar();
        Display display = new Display();
        display.mostrar();
 */





