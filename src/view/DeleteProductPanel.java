package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.Dessert;

public class DeleteProductPanel extends BackgroundPanel {
	private JComboBox<String> dessertDelete;
	private JLabel txtGuia;
	private JButton btnDelete;
	
	public DeleteProductPanel(ArrayList<Dessert> dessertList, ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initComponents(dessertList, listener);
	}
	
	public void initComponents(ArrayList<Dessert> dessertList, ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		txtGuia = new JLabel("Nombre del postre que desea eliminar: ");
		txtGuia.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 20, 30);
		add(txtGuia, gbc);
		
		dessertDelete = new JComboBox<String>();
		for (int i = 0; i < dessertList.size(); i++) {
			dessertDelete.addItem(dessertList.get(i).getName());
		}
		gbc.gridx = 1;
		add(dessertDelete, gbc);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setActionCommand("acceptDelete");
		btnDelete.addActionListener(listener);
		btnDelete.setFont(new Font("Forte", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(145, 239, 205));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		add(btnDelete, gbc);
	}
	
	public String getDessertDelete() {
		return (String) dessertDelete.getSelectedItem();
	}
	
}
