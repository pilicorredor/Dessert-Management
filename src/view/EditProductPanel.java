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
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Dessert;

public class EditProductPanel extends BackgroundPanel {
	private JComboBox<String> dessertEdit;
	private JComboBox<String> atributeEdit;
	private JLabel txtGuia;
	private JTextField txtChange;
	private JButton btnAccept;
	
	public EditProductPanel(ArrayList<Dessert> dessertList, ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		initComponents(dessertList, listener);
	}
	
	public void initComponents(ArrayList<Dessert> dessertList, ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		txtGuia = new JLabel("Nombre del postre que desea editar: ");
		personalizationLabel(txtGuia);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 10);
		add(txtGuia, gbc);
		
		dessertEdit = new JComboBox<String>();
		for (int i = 0; i < dessertList.size(); i++) {
			dessertEdit.addItem(dessertList.get(i).getName());
		}
		gbc.gridx = 1;
		add(dessertEdit, gbc);
		
		txtGuia = new JLabel("Atributo del postre que desea editar: ");
		personalizationLabel(txtGuia);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(txtGuia, gbc);
		
		atributeEdit = new JComboBox<String>();
		atributeEdit.addItem("id");
		atributeEdit.addItem("name");
		atributeEdit.addItem("price");
		atributeEdit.addItem("quantity");
		atributeEdit.addItem("urlImage");
		atributeEdit.addItem("description");
		gbc.gridx = 1;
		add(atributeEdit, gbc);
		
		txtGuia = new JLabel("Atributo nuevo: ");
		personalizationLabel(txtGuia);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(txtGuia, gbc);
		
		txtChange = new JTextField(30);
		gbc.gridx = 1;
		add(txtChange, gbc);
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setActionCommand("acceptEdit");
		btnAccept.addActionListener(listener);
		btnAccept.setFont(new Font("Forte", Font.PLAIN, 18));
		btnAccept.setBackground(new Color(145, 239, 205));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		add(btnAccept, gbc);
	}
	
	public JLabel personalizationLabel(JLabel label) {
		Font font = new Font("Harlow Solid Italic", Font.PLAIN, 25);
		label.setFont(font);
		label.setForeground(Color.BLACK);
		return label;
	}
	
	public String getDessertName() {
		return (String) dessertEdit.getSelectedItem();
	}
	
	public String getAtributeChange() {
		return (String) atributeEdit.getSelectedItem();
	}
	
	public String getValueChange() {
		return txtChange.getText();
	}
	
}
