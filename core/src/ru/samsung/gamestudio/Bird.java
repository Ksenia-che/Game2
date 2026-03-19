package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;

public class Bird {
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    int x, y;
    int speed;
    Texture[] framesArray;
    public Bird(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
        int frameCounter;
    }

    void onClick() {
        jump = true;
        int y = 0;
        jumpHeight = maxHeightOfJump + y;
    }
    void fly() {
        int y = 0;
        if (y >= jumpHeight) {
            jump = false;
        }

        int speed = 0;
        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }
}
