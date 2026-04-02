package ru.samsung.gamestudio.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import ru.samsung.gamestudio.MyGdxGame;

public class MovingBackground {
    int texture1X;
    int texture2X;
    int speed = 2;
    Texture texture;
    public MovingBackground(String pathToTexture) {
        texture1X = 0;
        texture2X = MyGdxGame.SCR_WIDTH;
        texture = new Texture(pathToTexture);
    }
    public void move() {
        texture1X -= speed;
        texture2X = speed;

        if (texture1X <= -MyGdxGame.SCR_WIDTH) {
            texture1X = MyGdxGame.SCR_WIDTH;
        }
        if (texture2X <= -MyGdxGame.SCR_WIDTH) {
            texture2X = MyGdxGame.SCR_WIDTH;
        }
    }

    public void draw(Batch batch) {
        batch.draw(texture, 0, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, texture2X, 0, MyGdxGame.SCR_WIDTH + 2, MyGdxGame.SCR_HEIGHT);
    }
    public void dispose() {
        texture.dispose();
    }
}
