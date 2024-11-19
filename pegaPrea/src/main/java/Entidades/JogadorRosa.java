package Entidades;

import pegaPrea.KeyHandler;
import pegaPrea.TelaDoJogo;

import javax.imageio.ImageIO;
import java.awt.*;

public class JogadorRosa extends Entidade {
    TelaDoJogo gp;
    KeyHandler keyH;

    public JogadorRosa(TelaDoJogo gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.valoresPadrao();
    }
    // 7:30 3
    public void valoresPadrao() {
        entidadeX = 100;
        entidadeY = 100;
        speed = 2;
    }

    public void getPlayerImage(){
        try{
            stay = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("E:\\GitHub\\Trabalhos_da_facul\\pegaPrea\\src\\main\\assets\\Azul\\Azul 1.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed) {
            entidadeY -= speed;
        } else if (keyH.downPressed) {
            entidadeY += speed;
        } else if (keyH.leftPressed) {
            entidadeX -= speed;
        } else if (keyH.rightPressed) {
            entidadeX += speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(entidadeX, entidadeY, gp.tileSize, gp.tileSize);
    }
}