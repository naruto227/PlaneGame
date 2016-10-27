package plane;

import util.GameUtil;

import java.awt.*;

/**
 * 爆炸效果类
 * Created by hzq on 16-10-27.
 */
public class Explode {
    double x, y;
    static Image[] imgs = new Image[16];    //处理图片数组
    static {
        for(int i = 0; i < 16; i++){    //i从0开始，因为数组下标为0开始
            imgs[i] = GameUtil.getImage("images/e" + (i+1) + ".gif");
            System.out.println(imgs[i].getWidth(null));
        }
    }
    int count;

    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(imgs[count], (int) x, (int) y, null);
            count++;
        }
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
