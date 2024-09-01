package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import persistence.FileOperationJSON;

public class InitApp {
	private FileOperationJSON file;
	private ArrayList<Dessert> listDesserts;
	private InfoEnterprise infoEnt;
	private Client client;
	private Owner owner;
	
	public InitApp() throws FileNotFoundException {
		file = new FileOperationJSON();
		this.setListDesserts();
		this.setInfoEnt();
		client = new Client();
		owner = new Owner();
	}

	public ArrayList<Dessert> getListDesserts() {
		return listDesserts;
	}

	public void setListDesserts() throws FileNotFoundException {
		this.listDesserts = file.readFile();
	}
	
	public void setInfoEnt() throws FileNotFoundException {
		this.infoEnt = file.readFileInfo();
	}
	
	public void editShopRecord(ArrayList<ArrayList<Object>> dessertBuy) throws FileNotFoundException {
		file.editQuantityShopRecord(dessertBuy);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
		owner.setFile(file);
	}

	public InfoEnterprise getInfoEnt() {
		return infoEnt;
	}
//Metodo que retorna un arreglo con las imagenes de los postres
	public String[] getImgList() {
		String[] imgList = new String[listDesserts.size()];
		for (int i = 0; i < imgList.length; i++) {
			imgList[i] = listDesserts.get(i).getUrlImage();
		}
		return imgList;
	}
//Metodo que retorna un arreglo con los nombres de los postres	
	public String[] getTitlesList() {
		String[] titlesList = new String[listDesserts.size()];
		for (int i = 0; i < titlesList.length; i++) {
			titlesList[i] = listDesserts.get(i).getName();
		}
		return titlesList;
	}
//Metodo que retorna una matriz con los datos de los postres (para la tabla de inventario)	
	public Object[][] generateDataDesserts(){
		Object[][] dataDesserts = new Object[listDesserts.size()][4];
		for (int i = 0; i < dataDesserts.length; i++) {
			dataDesserts[i][0] = listDesserts.get(i).getName();
			dataDesserts[i][1] = listDesserts.get(i).getUrlImage();
			dataDesserts[i][2] = listDesserts.get(i).getPrice();
			dataDesserts[i][3] = listDesserts.get(i).getQuatity();
		}
		return dataDesserts;
	}
//Metodo para generar los datos que van en la factura
	public Object[][] generateDataBill() throws FileNotFoundException {
		Object[][] dataDesserts = new Object[listDesserts.size()][3];
		for (int i = 0; i < dataDesserts.length; i++) {
			dataDesserts[i][0] = listDesserts.get(i).getName();
			dataDesserts[i][1] = listDesserts.get(i).getPrice();
			dataDesserts[i][2] = listDesserts.get(i).getQuatity();
		}
		return dataDesserts;
	}
//Metodo para recuperar la lista con los totales de los postres comprados, para dibujar la grafica
	public ArrayList<Integer> getTotals() {
		ArrayList<Integer> totals = new ArrayList<Integer>();
		try {
			totals =  owner.getTotals();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return totals;
	}
}
