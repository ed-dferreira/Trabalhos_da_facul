package Ambiente;

import pegaPrea.TelaDoJogo;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ControleAmbiente {
    TelaDoJogo gp;
    Ambiente[] ambientes;
    int numAmbientesPisos[][];

    public ControleAmbiente(TelaDoJogo gp) {
        this.gp = gp;
        ambientes = new Ambiente[10];
        numAmbientesPisos = new int[gp.maxScreenRow][gp.maxScreenCol];
        getAmbienteImagens();
        carregarMapa("Mapas/mapa.txt");
    }

    public void getAmbienteImagens() {
        try {
            ambientes[0] = new Ambiente();
            ambientes[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[1] = new Ambiente();
            ambientes[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[2] = new Ambiente();
            ambientes[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[3] = new Ambiente();
            ambientes[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[4] = new Ambiente();
            ambientes[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[5] = new Ambiente();
            ambientes[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[6] = new Ambiente();
            ambientes[6].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[7] = new Ambiente();
            ambientes[7].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[8] = new Ambiente();
            ambientes[8].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            ambientes[9] = new Ambiente();
            ambientes[9].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Piso/Piso.png"));
            if (ambientes[0].image == null) {
                throw new IOException("Imagem 'Piso/Piso.png' não encontrada.");
            }
            System.out.println("Imagem carregada com sucesso: Piso/Piso.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarMapa(String filePath){
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String linha = br.readLine();

                while (col < gp.maxScreenCol) {
                    String numeros[] = linha.split(" ");
                    int num = Integer.parseInt(numeros[col]);
                    numAmbientesPisos[row][col] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {// PISO BRUTO

            int tileNum = numAmbientesPisos[row][col]; //erro aqui

            g2.drawImage(ambientes[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
