package plane;

import util.GameUtil;

import java.awt.*;

/**
 * plane、bullet共同的属性、方法封装到一起
 * Created by hzq on 16-10-26.
 */
public class GameObject {
    Image img = GameUtil.getImage("images/plane.png");
    double x, y;
    int speed = 2;   //跨度
    int width, height;

    public GameObject() {
    }

    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public GameObject(Image img, int speed, int height, int width, double x, double y) {
        this.height = height;
        this.img = img;
        this.speed = speed;
        this.width = width;
        this.x = x;
        this.y = y;
    }
}
