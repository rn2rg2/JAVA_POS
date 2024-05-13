package com.kosa.pos.swing.Admin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    private double[] yData;
    private String[] xData;

    public GraphPanel(String[] xData, double[] yData) {
        this.xData = xData;
        this.yData = yData;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.drawLine(50, height - 50, width - 50, height - 50); // X축
        g2d.drawLine(50, height - 50, 50, 50); // Y축

        int xIncrement = (width - 100) / (xData.length - 1);
        for (int i = 0; i < xData.length; i++) {
            int x = 50 + i * xIncrement;
            g2d.drawString(xData[i], x - 5, height - 40); // X축 레이블
        }

        double maxValue = getMaxValue();
        double minValue = getMinValue();
        double range = maxValue - minValue;
        int yStep = (int) Math.ceil(range / 6); // y 데이터의 범위를 7개로 나누어 레이블을 표시

        int yIncrement = (height - 100) / 6; // 7개의 레이블을 표시하므로 간격을 나눔
        for (int i = 0; i <= 6; i++) {
            int yLabel = height - 50 - i * yIncrement;
            g2d.drawLine(45, yLabel, 50, yLabel); // Y축 눈금
            g2d.drawString(String.valueOf((int) (minValue + i * yStep)), 20, yLabel + 5); // Y축 레이블
        }

        g2d.setColor(Color.BLUE);
        int yScale = height - 100;
        for (int i = 0; i < yData.length - 1; i++) {
            int x1 = 50 + i * xIncrement;
            int y1 = height - 50 - (int) ((yData[i] - minValue) * yScale / range);
            int x2 = 50 + (i + 1) * xIncrement;
            int y2 = height - 50 - (int) ((yData[i + 1] - minValue) * yScale / range);
            g2d.drawLine(x1, y1, x2, y2); // 선 그리기

            if (y1 != y2) {
                g2d.drawRect(x1 - 2, y1 - 2, 4, 4); // 꺾이는 지점에 사각형 그리기
            }
        }
    }

    private double getMaxValue() {
        double max = yData[0];
        for (double value : yData) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private double getMinValue() {
        double min = yData[0];
        for (double value : yData) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
