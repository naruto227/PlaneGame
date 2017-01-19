package plane;

import util.GameUtil;
import util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hzq on 16-10-26.
 */
public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane plane = new Plane("images/plane.png", 50, 50);
    ArrayList bulletList = new ArrayList();

    Explode explosion;

    Date startTime, endTime;
    int period;

    public void paint(Graphics g) {
        /*Color c = g.getColor();
        g.setColor(Color.red);
        g.drawOval(100,100,50,50);*/
        g.drawImage(bg, 0, 0, null);
        plane.draw(g);

        for (int i = 0; i < bulletList.size(); i++) {
            Bullet b = (Bullet) bulletList.get(i);
            b.draw(g);

//            检测飞机的碰撞
            boolean collision = plane.getRect().intersects(b.getRect());//矩形对象是否相交
            if (collision) {
                plane.setLive(false);   //飞机被子弹打到，死掉
                if(explosion == null){  //第一次explosion为null，新建一个对象，后面不为空了，就不再建对象了
                    endTime = new Date();
                    explosion = new Explode(plane.x, plane.y);
                    System.out.println("###############碰！！！");
                }
                explosion.draw(g);

                break;
            }
            if (!plane.isLive()) {
                printInfo(g, "GAME OVER", 20, 150, 250, Color.white);
                period = (int) (endTime.getTime() - startTime.getTime()) / 1000;//秒
                printInfo(g, "存活时间：" + period + "秒", 20, 150, 270, Color.white);

                switch (period / 10) {
                    case 0:
                        /*printInfo(g, "菜鸟", 15, 150, 290, Color.white);
                        break;*/
                    case 1:
                        printInfo(g, "小鸟", 15, 150, 290, Color.white);
                        break;
                    case 2:
                        printInfo(g, "大鸟", 15, 150, 290, Color.white);
                        break;
                    case 3:
                        printInfo(g, "老鸟", 15, 150, 290, Color.white);
                        break;
                    case 4:
                        printInfo(g, "鸟王子", 15, 150, 290, Color.white);
                        break;
                    default:
                        printInfo(g, "鸟人", 15, 150, 290, Color.white);

                }
            }
            /*endTime = new Date();
            period = (int) (endTime.getTime() - startTime.getTime()) / 1000;//秒*/
            printInfo(g, "存活时间：" + period + "秒", 15, 230, 50, Color.red);

            printInfo(g, "分数：100", 15, 150, 50, Color.red);
        }
    }

    /**
     * 在窗口上打印消息
     *
     * @param g
     * @param str
     * @param size
     */
    public void printInfo(Graphics g, String str, int size, int x, int y, Color color) {
        Color c = g.getColor();
        g.setColor(color);
//                g.drawString("GAME OVER", (int) plane.x, (int) plane.y);
        Font f = new Font("宋体", Font.BOLD, size);
        g.setFont(f);
        g.drawString(str, x, y);
        g.setColor(c);
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
        startTime = new Date();
        super.launchFrame();
        //增加键盘的监听
        addKeyListener(new KeyMonitor());

        //生成一堆子弹，放到容器中
        for (int i = 0; i <= 10; i++) {
            Bullet b = new Bullet();
            bulletList.add(b);
        }
    }

    public static void main(String[] args) {
        new PlaneGameFrame().launchFrame();
    }
}
