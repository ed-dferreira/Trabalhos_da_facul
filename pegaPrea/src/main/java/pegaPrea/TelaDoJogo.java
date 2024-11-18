package pegaPrea;

import Entidades.JogadorAzul;

import javax.swing.*;
import java.awt.*;

public class TelaDoJogo extends JPanel implements Runnable {
    // configurações da tela
    final int originTileSize = 16; // 16x16
    final int scale = 3;
    public final int tileSize = originTileSize * scale; // 48x48
    final int maxScreenCol = 20;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol * tileSize; // 960
    final int screenHeight = maxScreenRow * tileSize; // 576

    int fps = 144;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // mantem o programa funcionando
    JogadorAzul jogadorAzul = new JogadorAzul(this, keyH);

    public TelaDoJogo() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void run(){
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta --;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        jogadorAzul.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        jogadorAzul.draw(g2);

        g2.dispose();
    }
}
/*
  @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {
            // 1 att informação sobre a posição do boneco
            update();

            // 2 Desenha tela e att
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000000.0;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

 */