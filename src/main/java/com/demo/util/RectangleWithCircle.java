package com.demo.util;

import javax.swing.*;
import java.awt.*;
public class RectangleWithCircle extends JFrame{
    public RectangleWithCircle() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        // 获取窗口的宽度和高度
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();

        // 设置长方形的坐标和大小
        int rectWidth = 100;
        int rectHeight = 75;
        int rectX = (windowWidth - rectWidth) / 2;
        int rectY = (windowHeight - rectHeight) / 2;

        // 绘制长方形
        g.drawRect(rectX, rectY, rectWidth, rectHeight);

        // 设置圆的坐标和大小
        int circleSize = 20;
        int circleX = rectX + (rectWidth - circleSize) / 2;
        int circleY = rectY + (rectHeight - circleSize) / 2;

        // 绘制圆
        g.drawOval(circleX, circleY, circleSize, circleSize);
    }

    public static void main(String[] args) {
        new RectangleWithCircle();
    }
}
