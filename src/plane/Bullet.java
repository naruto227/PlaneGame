package plane;

import util.Constant;

import java.awt.*;

/**
 * Created by hzq on 16-10-26.
 */
public class Bullet extends GameObject {

    double degree;

    public Bullet() {
        width = 10;
        height = 10;
        degree = Math.random() * Math.PI * 2;   //[0,360]度
        x = Constant.GAME_WIDTH / 2;
        y = Constant.GAME_HEIGHT / 2;
    }
//矩形对象
    public Rectangle getRect() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int) x, (int) y, (int) width, (int) height);

        x += speed * Math.cos(degree);    //沿着degree角度移动
        y += speed * Math.sin(degree);

        if (y > Constant.GAME_HEIGHT - height || y < 35) {  //35为窗口白边高度
            degree = -degree;
        }
        if (x < 0 || x > Constant.GAME_WIDTH - width) {
            degree = Math.PI - degree;
        }
        g.setColor(c);
    }
}
