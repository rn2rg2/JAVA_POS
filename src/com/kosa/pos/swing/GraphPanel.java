package com.kosa.pos.swing;

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
        initialize();
    }

    private void initialize() {
		setBounds(30, 170, 671, 426);
		setLayout(null);
		
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 그래프의 가로 세로 사이즈
        int width = getWidth();
        int height = getHeight();

        // X축, Y축을 그립니다.
        g2d.drawLine(50, height - 50, width - 50, height - 50); // X축
        g2d.drawLine(50, height - 50, 50, 50); // Y축

        // X축 눈금과 레이블을 그립니다.
        int xIncrement = (width - 100) / (xData.length - 1);
        for (int i = 0; i < xData.length; i++) {
            int x = 50 + i * xIncrement;
            g2d.drawString(xData[i], x - 5, height - 40); // 레이블
        }

        // Y축 눈금과 레이블을 그립니다.
        int yIncrement = (int) ((height - 100) / getMaxValue());
        
        
        for (int i = (int) getMinValue() - 1; i <= getMaxValue(); i += 5) {
            int y = height - 50 - i * yIncrement;
            g2d.drawLine(45, y, 50, y); // 눈금
            g2d.drawString(String.valueOf(i), 20, y + 5); // 레이블
        }

        // 그래프의 각 점을 연결하는 선과 꺾이는 지점의 사각형을 그립니다.
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < yData.length - 1; i++) {
            int x1 = 50 + i * xIncrement;
            int y1 = height - 50 - (int) (yData[i] * yIncrement);
            int x2 = 50 + (i + 1) * xIncrement;
            int y2 = height - 50 - (int) (yData[i + 1] * yIncrement);
            g2d.drawLine(x1, y1, x2, y2); // 선 그리기

            // 꺾이는 지점에 사각형 그리기
            if (y1 != y2) {
                g2d.drawRect(x1 - 2, y1 - 2, 4, 4);
            }
        }
    }
    
    // 데이터 중에서 최대값을 찾습니다.
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
