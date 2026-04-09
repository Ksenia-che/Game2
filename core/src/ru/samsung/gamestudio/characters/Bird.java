package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;

public class Bird {
    public int width = 150;
    public int height = 150;
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    int x, y;
    int speed;
    Texture[] framesArray;
    int frameCounter;
    public Bird(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        framesArray = new Texture[]{
                new Texture("bird/bird0.png"),
                new Texture("bird/bird1.png"),
                new Texture("bird/bird2.png"),
                new Texture("bird/bird1.png"),
        };
    }
    public boolean isInField() {
        if (y + height < 0) return false;
        if (y > SCR_HEIGHT) return false;
        return true;
    }

    public void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }
    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }
    public void draw(Batch batch) {
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
