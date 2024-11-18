package org.example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IsometricoRenderer {

    public static final int TITLE_WIDTH = 34;
    public static final int TITLE_HEIGHT = 34;

    private Texture grass;
    private Texture sky;


    public IsometricoRenderer() {
        grass = new Texture("E:\\Codigos\\pegaPrea\\assets\\isometric_block(12).png");
       // sky = new Texture("sky.png");

    }
    public void desenharFundo(SpriteBatch batch) {
        for(int row = 15; row >= 0; row--) {
            for(int col = 15; col >= 0; col--) {
                float x = (col - row) * (TITLE_WIDTH / 2f);
                float y = (col + row) * (TITLE_HEIGHT / 4f); //quanto maior o numero mais plano

                batch.draw(grass, x, y, TITLE_WIDTH, TITLE_HEIGHT);
            }
        }
    }
}
/*
public void desenharFundo(SpriteBatch batch) {
        for(int row = 15; row >= 0; row--) {
            for(int col = 15; col >= 0; col--) {
                float x = (col - row) * (TITLE_WIDTH / 2f);
                float y = (col + row) * (TITLE_HEIGHT / 2f);

                batch.draw(grass, x, y, TITLE_WIDTH, TITLE_HEIGHT);
            }
        }
    }
}

 */