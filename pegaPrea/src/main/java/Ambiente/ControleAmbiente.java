package Ambiente;

import pegaPrea.TelaDoJogo;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ControleAmbiente {
    TelaDoJogo gp;
    Ambiente[] ambientes;

    public ControleAmbiente(TelaDoJogo gp) {
        this.gp = gp;
        ambientes = new Ambiente[10];
        getAmbienteImagens();
    }

    public void getAmbienteImagens(){
        try {
            ambientes[0] = new Ambiente();
            ambientes[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));


        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(ambientes[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }
}
