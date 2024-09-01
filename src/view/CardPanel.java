package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Dessert;
import model.InfoEnterprise;

public class CardPanel extends BackgroundPanel {
	private CardLayout card;
	private JPanel container;
	private DessertCarouselPanel panelStart;
	private ProductsPanel panelProducts;
	private AddProductPanel panelAddProd;
	private DeleteProductPanel panelDelProd;
	private EditProductPanel panelEditProd;
	private TablePanel panelTable;
	private GraphicsPanel panelGraphics;
	
	public CardPanel(InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, ActionListener listener, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		container = new JPanel();
		card = new CardLayout();
		container.setLayout(card);
		setLayout(new CardLayout());
		this.setOpaque(false);
		initComponents(info, imgList, dessertList, listener, dataDesserts, listTitles, totals);
		add(container);
	}
	
	public void initComponents(InfoEnterprise info, String[] imgList, ArrayList<Dessert> dessertList, ActionListener listener, Object[][] dataDesserts, String[] listTitles, ArrayList<Integer> totals) {
		panelStart = new DessertCarouselPanel(imgList);
		container.add(panelStart, "1");
		panelProducts = new ProductsPanel(dessertList, listener);
		container.add(panelProducts, "2");
		panelAddProd = new AddProductPanel(listener);
		container.add(panelAddProd, "3");
		panelDelProd = new DeleteProductPanel(dessertList, listener);
		container.add(panelDelProd, "4");
		panelEditProd = new EditProductPanel(dessertList, listener);
		container.add(panelEditProd, "5");
		panelTable = new TablePanel(dataDesserts);
		container.add(panelTable, "6");
		panelGraphics = new GraphicsPanel(listTitles, totals);
		container.add(panelGraphics, "7");
	}
	
	public void changePanel(String button) {
		switch (button){
			case "1":
				card.show(container, "1");
				break;
			case "2":
				card.show(container, "2");
				break;
			case "3":
				card.show(container, "3");
				break;
			case "4":
				card.show(container, "4");
				break;
			case "5":
				card.show(container, "5");
				break;
			case "6":
				card.show(container, "6");
				break;
			case "7":
				card.show(container, "7");
				break;
		}	
	}
//metodos para agregar un producto	
	public int getIdProd() {
		return panelAddProd.getIdProd();
	}
	
	public String getNameProd() {
		return panelAddProd.getNameProd();
	}
	
	public int getPriceProd() {
		return panelAddProd.getPriceProd();
	}
	
	public int getQuantityProd() {
		return panelAddProd.getQuantityProd();
	}
	
	public String getUrlImageProd() {
		return panelAddProd.getUrlImageProd();
	}
	
	public String getDescriptionProd() {
		return panelAddProd.getDescriptionProd();
	}
//metodos para editar un producto	
	public String getDessertName() {
		return panelEditProd.getDessertName();
	}
	
	public String getAtributeChange() {
		return panelEditProd.getAtributeChange();
	}
	
	public String getValueChange() {
		return panelEditProd.getValueChange();
	}
//metodo para eliminar un producto
	public String getDessertDelete() {
		return panelDelProd.getDessertDelete();
	}
//metodo para recuperar las commpras del cliente
	public ArrayList<ArrayList<Object>> returnDessertShop(ArrayList<Dessert> dessertList){
		return panelProducts.returnDessertShop(dessertList);
	}
	
}
