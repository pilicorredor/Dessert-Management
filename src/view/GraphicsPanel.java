package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
	private String[] titles;
	private ArrayList<Integer> total;
	
	public GraphicsPanel(String[] titles, ArrayList<Integer> total) {
		this.setOpaque(false);
		this.titles = titles;
		this.total = total;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		int i = 50;
		int biggerNumber = this.getBiggerNumber();
		int coordinate = 0;

		g2d.setColor(Color.BLACK);
		g2d.drawLine(20, 20, 20, (biggerNumber*10)+40);//eje Y
		g2d.drawLine(20, (biggerNumber*10)+40, total.size()*50+50, (biggerNumber*10)+40);//eje X
//dibuja las columnas
		for (int j = 0; j < total.size(); j++) {
			coordinate = biggerNumber - total.get(j);
			g2d.drawString("" + total.get(j), i+5, (coordinate*10)+35);
			g2d.setColor(this.generateColor());
			g2d.fillRect(i, (coordinate*10)+40, 30, total.get(j)*10);
			
//cuadro de convenciones		
			g2d.fillRect(total.size()*50+70, i-40, 20, 20);
			g2d.setColor(Color.BLACK);
			g2d.drawString(titles[j], total.size()*50+100, i-30);
			i += 50;
		}
		g2d.drawString("Postres", total.size()*50+10, (biggerNumber*10)+70);
	}
	
//hayar el valor mayor de los datos	
	private int getBiggerNumber() {
		int biggerNumber = 0;
		for (int j = 0; j < total.size(); j++) {
			if(total.get(j) > biggerNumber) {
				biggerNumber = total.get(j);
			}
		}
		return biggerNumber;
	}
	
	private Color generateColor() {
		int red = 0;
		int green = 0;
		int blue = 0;
		Random randomGenerator = new Random();
		red = randomGenerator.nextInt(255);
		green = randomGenerator.nextInt(255);
		blue = randomGenerator.nextInt(255);
		Color randomColor = new Color(red,green,blue);
		return randomColor;
	}
}