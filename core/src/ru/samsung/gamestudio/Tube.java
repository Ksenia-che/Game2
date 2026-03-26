package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

import static com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpriteMode.random;
import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;

public class Tube {
    Texture textureUpperTube;
    Texture textureDownTube;
    private float x;
    private int gapHeight = 400;
    private int padding;
    private int gapY;
    private int distanceBetweenTubes;
    private int width = 200;
    private int height = 750;
    float speed = 5;
    boolean isPointReceived;
    Random r = new Random();

    public boolean needAddPoint(Bird bird) {
        return bird.x >= x + width && !isPointReceived;
    }
    public void setPointReceived() {
        isPointReceived = true;
    }

    public Tube(int tubeCount, int tubeIdx) {
        textureUpperTube = new Texture("tube/tube_flipped.png");
        textureDownTube = new Texture("tube/tube.png");

        gapY = gapHeight / 2 + padding + r.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        distanceBetweenTubes = (SCR_WIDTH + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIdx + SCR_WIDTH;
    }

    void draw(Batch batch) {
        batch.draw(textureUpperTube, x, gapY + gapHeight / 2, width, height);
        batch.draw(textureDownTube, x, gapY - gapHeight / 2 - height, width, height);
    }
    void move() {
        x -= speed;
        if (x < -width) {
            isPointReceived = false;
            x = SCR_WIDTH + distanceBetweenTubes;
            gapY = gapHeight / 2 + padding + r.nextInt(SCR_HEIGHT - 2 * (padding + gapHeight / 2));
        }
    }
    void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }

    public boolean isHit(Bird bird) {

        if (bird.y <= gapY - gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        if (bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x)
            return true;
        return false;
    }
}
