package util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by hzq on 16-10-25.
 */
public class MyFrame extends Frame {

    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start();  //启动重画线程
        addWindowListener(new WindowAdapter() {//ctrl+o，调出该类的所有方法并选择性重写
            @Override
            /**
             * 使窗口叉号可用
             * */
            public void windowClosing(WindowEvent e) {  //关闭窗口按钮
                System.exit(0);
            }
        });
    }
    /**
     * 定义一个重画窗口的线程类，是一个内部类
     * 达到动态图片的效果
     */
    class PaintThread extends Thread {
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);   //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
