package Entidades;

import pegaPrea.KeyHandler;
import pegaPrea.TelaDoJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JogadorLaranja extends Entidade {
    TelaDoJogo gp;
    KeyHandler keyH;

    public JogadorLaranja(TelaDoJogo gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        colisaoEntidade = new Rectangle(8, 16, 32, 32);

        this.valoresPadrao();
        getPlayerImage();
    }

    // 7:30 3
    public void valoresPadrao() {
        entidadeX = 300; // local onde aparece o boneco
        entidadeY = 450; // local onde aparece o boneco
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            stay = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulStay1.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulUp1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulUp2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulDown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulDown2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulLeft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulLeft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulRight1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("JogadorAzul/AzulRight2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            // Checar colisão
            collisionOn = false;
            gp.checaColisao.checarPiso(this); //aqui
            if (collisionOn == false) {
                switch (direction) {
                    case "up": entidadeY -= speed; break;
                    case "down": entidadeY += speed; break;
                    case "left": entidadeX -= speed; break;
                    case "Right": entidadeX += speed; break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 14) {
                spritNum = (spritNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }


    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spritNum == 1) {
                    image = up1;
                }
                if (spritNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spritNum == 1) {
                    image = down1;
                }
                if (spritNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spritNum == 1) {
                    image = left1;
                }
                if (spritNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spritNum == 1) {
                    image = right1;
                }
                if (spritNum == 2) {
                    image = right2;
                }
                break;
            default:
        }
        g2.drawImage(image, entidadeX, entidadeY, gp.tileSize, gp.tileSize, null);
    }
}