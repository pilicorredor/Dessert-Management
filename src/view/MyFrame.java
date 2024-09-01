	package view;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.Client;
import model.Dessert;
import model.InfoEnterprise;

public class MyFrame extends JFrame {
	private MainPanel mainPanel;
	private JScrollPane scrollPane;

	public MyFrame(ActionListener listener, InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		super("La Tartine");
		this.setSize(1250, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents(listener, info, imgList, dessertList, dataDesserts, listTitles, totals);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void initComponents(ActionListener listener, InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 10, 1200, 650);
		mainPanel = new MainPanel(listener, info, imgList, dessertList, dataDesserts, listTitles, totals);
		scrollPane.setViewportView(mainPanel);
		add(scrollPane);
		
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void change(String button) {
		mainPanel.change(button);
	}

	public void logIn(ActionListener listener) {
		mainPanel.logIn(listener);
	}

	public void showBill(InfoEnterprise infoEnt, Client client, int total, ArrayList<ArrayList<Object>> orderClient, ActionListener listener) {
		mainPanel.showBill(infoEnt, client, total, orderClient, listener);
	}
	
	public void close() {
		mainPanel.close();
	}

	public String getNameUser() {
		return mainPanel.getNameUser().toUpperCase();
	}

	public void changeTextBtnLogIn(String name) {
		mainPanel.changeTextBtnLogIn(name);
	}

	public void setVisibleBtnClient(boolean visible) {
		mainPanel.setVisibleBtnClient(visible);
	}

	public void setVisibleBtnOwner(boolean visible) {
		mainPanel.setVisibleBtnOwner(visible);
	}

	public int getIdProd() {
		return mainPanel.getIdProd();
	}

	public String getNameProd() {
		return mainPanel.getNameProd();
	}

	public int getPriceProd() {
		return mainPanel.getPriceProd();
	}

	public int getQuantityProd() {
		return mainPanel.getQuantityProd();
	}

	public String getUrlImageProd() {
		return mainPanel.getUrlImageProd();
	}

	public String getDescriptionProd() {
		return mainPanel.getDescriptionProd();
	}

// metodos para editar un producto
	public String getDessertName() {
		return mainPanel.getDessertName();
	}

	public String getAtributeChange() {
		return mainPanel.getAtributeChange();
	}

	public String getValueChange() {
		return mainPanel.getValueChange();
	}
//metodo para elimar un producto
	public String getDessertDelete() {
		return mainPanel.getDessertDelete();
	}
//metodo para recuperar las commpras del cliente
	public ArrayList<ArrayList<Object>> returnDessertShop(ArrayList<Dessert> dessertList){
		return mainPanel.returnDessertShop(dessertList);
	}
	
	public void closeFrame() {
		this.dispose();
	}
	
	public void closeBill() {
		mainPanel.closeBill();
	}
}
