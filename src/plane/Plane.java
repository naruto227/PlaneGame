package plane;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by hzq on 16-10-26.
 */
public class Plane extends GameObject {

    private boolean left, up, right, down;
    boolean live = true;
    int span = 10;

    public void draw(Graphics g) {
        if(live){
            g.drawImage(img, (int) x, (int) y, null);
            move();
        }
    }

    public void move() {
        if (left) {
            x -= span;
        }
        if (right) {
            x += span;
        }
        if (up) {
            y -= span;
        }
        if (down) {
            y += span;
        }
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT://37
                left = true;
                break;
            case KeyEvent.VK_RIGHT://39
                right = true;
                break;
            case KeyEvent.VK_UP://38
                up = true;
                break;
            case KeyEvent.VK_DOWN://40
                down = true;
                break;
            default:
                break;

        }
    }

    public void releaseDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT://37
                left = false;
                break;
            case KeyEvent.VK_RIGHT://39
                right = false;
                break;
            case KeyEvent.VK_UP://38
                up = false;
                break;
            case KeyEvent.VK_DOWN://40
                down = false;
                break;
            default:
                break;

        }
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Plane(String imgPath, double x, double y) {
//        super();
//        this.img = GameUtil.getImage(imgPath);
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.x = x;
        this.y = y;
    }

    public Plane() {
    }

    public boolean isLive() {
        return live;
    }
}
