package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Dessert;

public class ProductsPanel extends BackgroundPanel {
	private ArrayList<JLabel> imgDessert;
	private ArrayList<JLabel> nameDessert;
	private ArrayList<JComboBox<Integer>> quantity;
	private JButton btnBuyDessert;

	public ProductsPanel(ArrayList<Dessert> dessertList, ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initComponents(dessertList, listener);
	}

	public void initComponents(ArrayList<Dessert> dessertList, ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		imgDessert = initImgDessert(dessertList);
		quantity = initQuantity(dessertList);
		nameDessert = initNameDessert(dessertList);
		for (int i = 0; i < dessertList.size(); i++) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.insets = new Insets(1, 2, 1, 50);
			add(nameDessert.get(i), gbc);
			gbc.gridx = 1;
			gbc.gridy = i;
			add(imgDessert.get(i), gbc);
			gbc.gridx = 2;
			gbc.gridy = i;
			add(quantity.get(i), gbc);
		}
		btnBuyDessert = new JButton("Comprar");
		btnBuyDessert.setActionCommand("buyDessert");
		btnBuyDessert.addActionListener(listener);
		btnBuyDessert.setFont(new Font("Forte", Font.PLAIN, 18));
		btnBuyDessert.setBackground(new Color(145, 239, 205));
		gbc.gridx = 0;
		gbc.gridy = dessertList.size();
		gbc.gridwidth = 3;
		add(btnBuyDessert, gbc);
	}

	private ArrayList<JLabel> initImgDessert(ArrayList<Dessert> dessertList){
		imgDessert = new ArrayList<JLabel>();
		for (int i = 0; i < dessertList.size(); i++) {
			Image img = new ImageIcon(dessertList.get(i).getUrlImage()).getImage();
			imgDessert.add(new JLabel());
			imgDessert.get(i).setBounds(0, 0, 150, 100);
			imgDessert.get(i).setIcon(new ImageIcon(img.getScaledInstance(imgDessert.get(i).getWidth(), imgDessert.get(i).getHeight(), Image.SCALE_SMOOTH)));
		}
		return imgDessert;
	}
	
	private ArrayList<JLabel> initNameDessert(ArrayList<Dessert> dessertList){
		nameDessert = new ArrayList<JLabel>();
		for (int i = 0; i < dessertList.size(); i++) {
			JLabel label = new JLabel(dessertList.get(i).getName());
			label.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
			nameDessert.add(label);
		}
		return nameDessert;
	}
	
	private ArrayList<JComboBox<Integer>> initQuantity(ArrayList<Dessert> dessertList){
		quantity = new ArrayList<JComboBox<Integer>>();
		for (int i = 0; i < dessertList.size(); i++) {
			JComboBox<Integer> auxQuantity = new JComboBox<Integer>();
			for (int j = 0; j <= dessertList.get(i).getQuatity(); j++) {
				auxQuantity.addItem(j);
			}
			quantity.add(auxQuantity);
		}
		return quantity;
	}
	
	public ArrayList<ArrayList<Object>> returnDessertShop(ArrayList<Dessert> dessertList){
		ArrayList<ArrayList<Object>> listOfDessertShop = new ArrayList<>();
		ArrayList<Object> dessert = new ArrayList<>();
		ArrayList<Object> quantityOfDessert = new ArrayList<>();
		for (int i = 0; i < quantity.size(); i++) {
			if(quantity.get(i).getSelectedItem() != (Object)0) {
				dessert.add(dessertList.get(i));
				quantityOfDessert.add(quantity.get(i).getSelectedItem());
				listOfDessertShop.add(dessert);
				listOfDessertShop.add(quantityOfDessert);
			}
		}
		return listOfDessertShop;
	}
}

