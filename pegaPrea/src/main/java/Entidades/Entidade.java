package Entidades;

import java.awt.image.BufferedImage;

public class Entidade {
    public int x,y;
    public int speed;

    public BufferedImage stay, up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spritNum = 1;
}
