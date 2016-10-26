package plane;

import util.GameUtil;
import util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by hzq on 16-10-26.
 */
public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);
    ArrayList bulletList = new ArrayList();

    public void paint(Graphics g) {
        /*Color c = g.getColor();
        g.setColor(Color.red);
        g.drawOval(100,100,50,50);*/
        g.drawImage(bg, 0, 0, null);
        plane.draw(g);

        for(int i = 0; i < bulletList.size(); i++){
            Bullet b = (Bullet)bulletList.get(i);
            b.draw(g);

//            检测飞机的碰撞
            boolean collision = plane.getRect().intersects(b.getRect());//矩形对象是否相交
            if(collision){
                plane.setLive(false);   //飞机被子弹打到，死掉
                System.out.println("###############碰！！！");
            }
        }
    }

    //    定义为内部类，可以方便的使用外部类的普通属性
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下：" + e.getKeyCode());
//            plane.move(e);
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("释放：" + e.getKeyCode());
            plane.releaseDirection(e);
        }
    }

    @Override
    public void launchFrame() {
        super.launchFrame();
        //增加键盘的监听
        addKeyListener(new KeyMonitor());

        //生成一堆子弹，放到容器中
        for(int i = 0; i<=10; i++){
            Bullet b = new Bullet();
            bulletList.add(b);
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
