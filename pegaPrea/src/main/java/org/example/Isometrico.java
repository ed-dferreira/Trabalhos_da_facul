package org.example;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Isometrico extends Game{
    private SpriteBatch batch;
    private TelaJogo gScreen;

    @Override
    public void create(){
        batch = new SpriteBatch();
        gScreen = new TelaJogo(batch);
        setScreen(gScreen);
    }
    @Override
    public void render(){
        super.render();
    }
    @Override
    public void dispose(){
        batch.dispose();
        super.dispose();
    }
}
