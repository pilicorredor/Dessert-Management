package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import persistence.FileOperationJSON;

public class Owner {
	private static final String NAME = "LUIS FLORES";
	private ArrayList<Dessert> listDessert;
	private FileOperationJSON file;
	
	public Owner(ArrayList<Dessert> listDessert) {
		this.listDessert = listDessert;
	}
	
	public Owner() {
		file = new FileOperationJSON();
	}
//Metodo para adicionar un postre	
	public void addDessert(int id, String name, int price, int quantity, String urlImage, String description) throws FileNotFoundException {
		file.addDessertShopRecord(id, name, 0, 0);
		file.addDessert(id, name, price, quantity, urlImage, description);
	}
//Metodo para editar el historial de compras (cuando el cliente compre algún producto)
	public void editShopRecord(ArrayList<ArrayList<Object>> dessertBuy) throws FileNotFoundException {
		file.editQuantityShopRecord(dessertBuy);
		file.editDessertWhenBuy(dessertBuy);
	}
//Metodo para eliminar un postre	
	public void deleteDessert(String name) throws FileNotFoundException {
		file.deleteDessertShopRecord(name);
		file.deleteDessert(name);
	}
//Metodo para editar las especificaciones de un postre	
	public void editDessert(String name, String tag, String value) throws FileNotFoundException {
		file.editDessert(name, tag, value);
		file.editShopDessert(name, tag, value);
	}
//Metodo para recuperar la lista con los totales de los postres comprados
	public ArrayList<Integer> getTotals() throws FileNotFoundException{
		ArrayList<Dessert> auxListDes = file.readFileShopRecord();
		ArrayList<Integer> totals = new ArrayList<Integer>();
		for (int i = 0; i < auxListDes.size(); i++) {
			totals.add(auxListDes.get(i).getQuatity());
		}
		return totals;
	}

	public ArrayList<Dessert> getListDessert() {
		return listDessert;
	}

	public void setListDessert(ArrayList<Dessert> listDessert) {
		this.listDessert = listDessert;
	}

	public String getNameUser() {
		return NAME;
	}
	
	public void setFile(FileOperationJSON file) {
		this.file = file;
	}
	
}
