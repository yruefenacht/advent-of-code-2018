package Day10;

import javafx.scene.shape.Rectangle;

class Star extends Rectangle {

    private int x, y, vx, vy;

    Star(int x, int y, int vx, int vy) {

        super(x*10, y*10, 10, 10);
        this.x = x*10 - 1000;
        this.y = y*10 - 1000;
        this.vx = vx*10;
        this.vy = vy*10;
    }


    void move() {

        this.x += this.vx;
        this.y += this.vy;
        this.setX(this.x);
        this.setY(this.y);
    }


}
