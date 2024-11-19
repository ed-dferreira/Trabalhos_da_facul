package Entidades;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidade {
    public int entidadeX, entidadeY;
    public int speed;

    public BufferedImage stay, up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spritNum = 1;

    public Rectangle colisaoEntidade = new Rectangle();
    public boolean collisionOn = false;
}
