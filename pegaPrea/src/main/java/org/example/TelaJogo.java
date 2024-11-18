package org.example;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TelaJogo extends ScreenAdapter {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private IsometricoRenderer renderer;

    public TelaJogo(SpriteBatch batch) {
        this.batch = batch;
    }
    @Override
    public void show(){
        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.position.set(SCREEN_WIDTH / 2 - 380, SCREEN_HEIGHT / 2, 10);
        renderer = new IsometricoRenderer();
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        handleInput();
        batch.begin();
        renderer.desenharFundo(batch);
        batch.end();
    }
    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.Q)){ camera.zoom -= 0.01f;}
        if (Gdx.input.isKeyPressed(Input.Keys.E)){ camera.zoom += 0.01f;}

        if (Gdx.input.isKeyPressed(Input.Keys.P)){ System.out.println(camera.position); }//local da camera

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){ camera.position.y += 4;}
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ camera.position.y -= 4;}
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){ camera.position.x -= 4;}
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ camera.position.x += 4;}
    }

    @Override
    public void dispose() {

    }
}
