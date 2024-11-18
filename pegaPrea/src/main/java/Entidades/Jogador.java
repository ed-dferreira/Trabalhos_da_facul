package Entidades;

import pegaPrea.KeyHandler;
import pegaPrea.TelaDoJogo;

import java.awt.*;

public class Jogador extends Entidade {
    TelaDoJogo gp;
    KeyHandler keyH;

    public Jogador(TelaDoJogo gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.valoresPadrao();
    }
// 7:30 3
    public void valoresPadrao() {
        x = 100;
        y = 100;
        speed = 2;
    }

    public void update() {
        if (keyH.upPressed) {
            y -= speed;
        } else if (keyH.downPressed) {
            y += speed;
        } else if (keyH.leftPressed) {
            x -= speed;
        } else if (keyH.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}