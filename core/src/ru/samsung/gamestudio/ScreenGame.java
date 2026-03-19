package ru.samsung.gamestudio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

class ScreenGame implements Screen {
    MyGdxGame myGdxGame;
    Texture birdTexture;
    float birdSpeed = 5;
    float birdX = 0;
    float birdY = 0;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        birdTexture = new Texture("bird/bird0.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        if (Gdx.input.justTouched()) {
            System.out.println("Just touched");
        }


        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        myGdxGame.batch.draw(birdTexture, birdX, birdY);
        myGdxGame.batch.end();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
