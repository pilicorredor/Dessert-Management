package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Client;
import model.Dessert;
import model.InfoEnterprise;

public class MainPanel extends BackgroundPanel {
	private JButton btnStart, btnProducts, btnLogIn, btnAddProduct, btnDeleteProduct, btnEditProduct, btnTable, btnGraphics;
	private LogInDialog logIn;
	private DialogBill bill;
	private JLabel imgLogo, schedule;
	private JPanel contacts;
	private CardPanel card;
	
	
	public MainPanel(ActionListener listener, InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		this.setLayout(new GridBagLayout());
		this.setPreferredSize(new Dimension(1000, 950));
		this.setOpaque(false);
		initComponents(listener, info, imgList, dessertList, dataDesserts, listTitles, totals);
	}
	
	public void initComponents(ActionListener listener, InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		GridBagConstraints gbc = new GridBagConstraints();
		this.setInfoEnterprise(info);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(imgLogo, gbc);

		btnStart = new JButton("Inicio");
		btnStart.setActionCommand("start");
		btnStart.addActionListener(listener);
		this.personalizationBtn(btnStart);
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(btnStart, gbc);
		
		btnProducts = new JButton("Comprar Productos");
		btnProducts.setVisible(false);
		btnProducts.setActionCommand("products");
		btnProducts.addActionListener(listener);
		this.personalizationBtn(btnProducts);
		gbc.gridx = 1;
		add(btnProducts, gbc);
		
		btnAddProduct = new JButton("Adicionar Producto");
		btnAddProduct.setVisible(false);
		btnAddProduct.setActionCommand("addProduct");
		btnAddProduct.addActionListener(listener);
		this.personalizationBtn(btnAddProduct);
		gbc.gridx = 1;
		add(btnAddProduct, gbc);
		
		btnDeleteProduct = new JButton("Eliminar Producto");
		btnDeleteProduct.setVisible(false);
		btnDeleteProduct.setActionCommand("deleteProduct");
		btnDeleteProduct.addActionListener(listener);
		this.personalizationBtn(btnDeleteProduct);
		gbc.gridx = 2;
		add(btnDeleteProduct, gbc);
		
		btnEditProduct = new JButton("Editar Producto");
		btnEditProduct.setVisible(false);
		btnEditProduct.setActionCommand("editProduct");
		btnEditProduct.addActionListener(listener);
		this.personalizationBtn(btnEditProduct);
		gbc.gridx = 3;
		add(btnEditProduct, gbc);
		
		btnTable = new JButton("Mostrar Inventario");
		btnTable.setVisible(false);
		btnTable.setActionCommand("showInventary");
		btnTable.addActionListener(listener);
		this.personalizationBtn(btnTable);
		gbc.gridx = 4;
		add(btnTable, gbc);
		
		btnGraphics = new JButton("Gráfico Historial de Compras");
		btnGraphics.setVisible(false);
		btnGraphics.setActionCommand("showShopRecord");
		btnGraphics.addActionListener(listener);
		this.personalizationBtn(btnGraphics);
		gbc.gridx = 5;
		add(btnGraphics, gbc);
		
		btnLogIn = new JButton("Iniciar Sesión");
		btnLogIn.setActionCommand("logIn");
		btnLogIn.addActionListener(listener);
		this.personalizationBtn(btnLogIn);
		gbc.gridx = 6;
		add(btnLogIn, gbc);
		
		card = new CardPanel(info, imgList, dessertList, listener, dataDesserts, listTitles, totals);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(card, gbc);
		
		gbc.gridy = 3;
		add(schedule, gbc);	
		
		gbc.gridy = 4;
		add(contacts, gbc);
	}
	
	public JButton personalizationBtn(JButton btn) {
		Font font = new Font("Forte", Font.PLAIN, 18);
		Color color = new Color(180, 24, 87);
		btn.setFont(font);
		btn.setBackground(color);
		btn.setForeground(Color.WHITE);
		return btn;
	}
	
	public void setInfoEnterprise(InfoEnterprise info) {
		Font font = new Font("Harlow Solid Italic", Font.PLAIN, 20);
		imgLogo = new JLabel();
		imgLogo.setSize(new Dimension (350, 200));
		imgLogo.setIcon(this.setImageSize(info.getLogo(), imgLogo));
		contacts = this.getContactsList(info.getContacts());
		contacts.setFont(font);
		schedule = new JLabel(info.getSchedule());
		schedule.setFont(font);
	}
	
	private JPanel getContactsList(long[] contactsList) {
		contacts = new JPanel();
		contacts.setOpaque(false);
		contacts.setLayout(new BoxLayout(contacts, BoxLayout.Y_AXIS));
		contacts.add(new JLabel("Llama y Pide"));
		for (int i = 0; i < contactsList.length; i++) {
			contacts.add(new JLabel("" + contactsList[i]));
		}
		return contacts;
	}
	
	
	public ImageIcon setImageSize(String url, JLabel label) {
		ImageIcon icon = new ImageIcon(url);
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		return newImc;
	}
	
	public void logIn(ActionListener listener) {
		logIn = new LogInDialog(listener);
	}
	
	public void showBill(InfoEnterprise infoEnt, Client client, int total, ArrayList<ArrayList<Object>> orderClient, ActionListener listener) {
		bill = new DialogBill(infoEnt, client, total, orderClient, listener);
	}
	
	public void closeBill() {
		bill.closeBill();
	}
	
	public void close() {
		logIn.close();
	}
	
	public String getNameUser(){
		return logIn.getNameUser();
	}
	
	public void changeTextBtnLogIn(String name) {
		btnLogIn.setText(name);
	}
	
	public void setVisibleBtnClient(boolean visible) {
		btnProducts.setVisible(visible);
	}
	
	public void setVisibleBtnOwner(boolean visible) {
		btnAddProduct.setVisible(visible);
		btnDeleteProduct.setVisible(visible);
		btnEditProduct.setVisible(visible);
		btnTable.setVisible(visible);
		btnGraphics.setVisible(visible);
	}
	
	public void change(String button) {
		card.changePanel(button);
	}
	
	public int getIdProd() {
		return card.getIdProd();
	}

	public String getNameProd() {
		return card.getNameProd();
	}

	public int getPriceProd() {
		return card.getPriceProd();
	}

	public int getQuantityProd() {
		return card.getQuantityProd();
	}

	public String getUrlImageProd() {
		return card.getUrlImageProd();
	}

	public String getDescriptionProd() {
		return card.getDescriptionProd();
	}

// metodos para editar un producto
	public String getDessertName() {
		return card.getDessertName();
	}

	public String getAtributeChange() {
		return card.getAtributeChange();
	}

	public String getValueChange() {
		return card.getValueChange();
	}
//metodo para elimar un producto
	public String getDessertDelete() {
		return card.getDessertDelete();
	}
//metodo para recuperar las commpras del cliente
	public ArrayList<ArrayList<Object>> returnDessertShop(ArrayList<Dessert> dessertList){
		return card.returnDessertShop(dessertList);
	}
	
}
