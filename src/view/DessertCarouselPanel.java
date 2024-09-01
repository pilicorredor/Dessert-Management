package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DessertCarouselPanel extends BackgroundPanel implements ActionListener {
	private JLabel label;
	private Timer time;
	private int x;
	private String[] list;

	public DessertCarouselPanel(String[] list) {
		this.list = list;
	    x = 0;
	    setLayout(new BorderLayout());
	    label = new JLabel();
	    label.setBounds(0, 0, 700, 550);
	    setImageSize(4);
	    time = new Timer(3000, this);
	    this.setOpaque(false);
	    add(label, BorderLayout.CENTER);
	    time.start();   
	 }

	public void setImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		label.setIcon(newImc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setImageSize(x);
		x++;
		if (x >= list.length)
			x = 0;
	}
}

