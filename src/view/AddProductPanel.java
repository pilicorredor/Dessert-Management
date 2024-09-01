package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddProductPanel extends BackgroundPanel {
	private JLabel txtIntro, txtId, txtName, txtPrice, txtQuantity, txtUrlImage, txtDescription;
	private JTextField id, name, price, quantity, urlImage, description;
	private JButton btnAdd;
	
	public AddProductPanel(ActionListener listener) {
		initComponents(listener);
		this.setOpaque(false);
	}
	
	public void initComponents(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		txtIntro = new JLabel("Por favor llene los siguientes datos");
		personalizationLabel(txtIntro);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 5, 10);
		gbc.gridwidth = 2;
		add(txtIntro, gbc);
		
		txtId = new JLabel("Id: ");
		personalizationLabel(txtId);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(txtId, gbc);
		
		id = new JTextField(30);
		gbc.gridx = 1;
		add(id, gbc);
		
		txtName = new JLabel("Nombre: ");
		personalizationLabel(txtName);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(txtName, gbc);
		
		name = new JTextField(30);
		gbc.gridx = 1;
		add(name, gbc);
		
		txtPrice = new JLabel("Precio: ");
		personalizationLabel(txtPrice);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(txtPrice, gbc);
		
		price = new JTextField(30);
		gbc.gridx = 1;
		add(price, gbc);
		
		txtQuantity = new JLabel("Cantidad: ");
		personalizationLabel(txtQuantity);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(txtQuantity, gbc);
		
		quantity = new JTextField(30);
		gbc.gridx = 1;
		add(quantity, gbc);
		
		txtUrlImage = new JLabel("Url de la imagen: ");
		personalizationLabel(txtUrlImage);
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(txtUrlImage, gbc);
		
		urlImage = new JTextField(30);
		gbc.gridx = 1;
		add(urlImage, gbc);
		
		txtDescription = new JLabel("Descripción: ");
		personalizationLabel(txtDescription);
		gbc.gridx = 0;
		gbc.gridy = 6;
		add(txtDescription, gbc);
		
		description = new JTextField(30);
		gbc.gridx = 1;
		add(description, gbc);
		
		btnAdd = new JButton("Adicionar Postre");
		btnAdd.setActionCommand("addDessert");
		btnAdd.addActionListener(listener);
		btnAdd.setFont(new Font("Forte", Font.PLAIN, 18));
		btnAdd.setBackground(new Color(145, 239, 205));
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		add(btnAdd, gbc);
	}
	
	public JLabel personalizationLabel(JLabel label) {
		Font font = new Font("Harlow Solid Italic", Font.PLAIN, 25);
		label.setFont(font);
		label.setForeground(Color.BLACK);
		return label;
	}
	
	public int getIdProd() {
		return Integer.parseInt(id.getText());
	}
	
	public String getNameProd() {
		return name.getText();
	}
	
	public int getPriceProd() {
		return Integer.parseInt(price.getText());
	}
	
	public int getQuantityProd() {
		return Integer.parseInt(quantity.getText());
	}
	
	public String getUrlImageProd() {
		return urlImage.getText();
	}
	
	public String getDescriptionProd() {
		return description.getText();
	}
}
