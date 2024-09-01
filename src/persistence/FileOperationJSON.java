package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import model.Dessert;
import model.InfoEnterprise;

public class FileOperationJSON {
	private ArrayList<Dessert> dessertList;

	public FileOperationJSON() {
		dessertList = new ArrayList<>();
	}
	
	public ArrayList<Dessert> getDessertList() {
		return dessertList;
	}

	public void setDessertList(ArrayList<Dessert> dessertList) {
		this.dessertList = dessertList;
	}

//Método para validar si el postre ya existe
	private boolean validateExist(String name) {
		boolean validate = false;
		for (int i = 0; i < dessertList.size(); i++) {
			if (dessertList.get(i).getName().equals(name)) {
				validate = true;
			}
		}
		return validate;
	}
//Metodo para leer el archivo de los postres
	public ArrayList<Dessert> readFile() throws FileNotFoundException {
		JsonReader reader = new Gson().newJsonReader(new FileReader("data/desserts.json"));
		Dessert[] des = new Gson().fromJson(reader, Dessert[].class);
		for (int i = 0; i < des.length; i++) {
			dessertList.add(des[i]);
		}
		return dessertList;
	}
//Metodo para leer el archivo de la información de la empresa
	public InfoEnterprise readFileInfo() throws FileNotFoundException {
		JsonReader reader = new Gson().newJsonReader(new FileReader("data/infoEnt.json"));
		InfoEnterprise info = new Gson().fromJson(reader, InfoEnterprise.class);
		return info;
	}
//Método para leer el archivo del historial de compras
	public ArrayList<Dessert> readFileShopRecord() throws FileNotFoundException {
		JsonReader reader = new Gson().newJsonReader(new FileReader("data/shopRecord.json"));
		Dessert[] des = new Gson().fromJson(reader, Dessert[].class);
		ArrayList<Dessert> auxListDessertShop = new ArrayList<Dessert>();
		for (int i = 0; i < des.length; i++) {
			auxListDessertShop.add(des[i]);
		}
		return auxListDessertShop;
	}
//Metodo para adicionar un postre
	public void addDessert(int id, String name, int price, int quantity, String urlImage, String description)
			throws FileNotFoundException {
		Dessert newDessert = new Dessert(id, name, price, quantity, urlImage, description);
		boolean validation = false;
		int i = 0;
		while (validation == false && i < dessertList.size()) {
			if (dessertList.get(i).getId() == newDessert.getId()) {
				validation = true;
			} else if (dessertList.get(i).getName().equals(newDessert.getName())) {
				validation = true;
			}
			i++;
		}
		if (validation == false) {
			dessertList.add(newDessert);
		}
		String json = new Gson().toJson(dessertList);
		PrintWriter print = new PrintWriter("data/desserts.json");
		print.write(json);
		print.close();
	}
//Metodo para eliminar un postre
	public boolean deleteDessert(String name) throws FileNotFoundException {
		if (this.validateExist(name) == true) {
			ArrayList<Dessert> auxList = new ArrayList<>();
			for (int i = 0; i < dessertList.size(); i++) {
				if (dessertList.get(i).getName() != name)
					auxList.add(dessertList.get(i));
			}
			this.setDessertList(auxList);
			String json = new Gson().toJson(dessertList);
			PrintWriter print = new PrintWriter("data/desserts.json");
			print.write(json);
			print.close();
		}
		return this.validateExist(name);
	}
//Metodo para editar las especificaciones de uno de los postres
	public void editDessert(String name, String tag, String value) throws FileNotFoundException {
		if (this.validateExist(name) == true) {
			for (int i = 0; i < dessertList.size(); i++) {
				if (dessertList.get(i).getName() == name) {
					switch (tag) {
					case "id":
						dessertList.get(i).setId(Integer.valueOf(value));
						break;
					case "name":
						dessertList.get(i).setName(value);
						break;
					case "price":
						dessertList.get(i).setPrice(Integer.valueOf(value));
						break;
					case "quantity":
						dessertList.get(i).setQuantity(Integer.valueOf(value));
						break;
					case "urlImage":
						dessertList.get(i).setUrlImage(value);
						break;
					case "description":
						dessertList.get(i).setDescription(value);
						break;
					}
				}

			}
			String json = new Gson().toJson(dessertList);
			PrintWriter print = new PrintWriter("data/desserts.json");
			print.write(json);
			print.close();
		}
	}
//Metodo para editar la cantidad de los postres del archivo desserts.json despues de que el cliente compre 
	public void editDessertWhenBuy(ArrayList<ArrayList<Object>> dessertBuy) throws FileNotFoundException {
		ArrayList<Integer> auxListQuantity = new ArrayList<>();
		dessertList = readFile();
		int value = 0;
		for (int i = 0; i < dessertBuy.get(0).size(); i++) {
			auxListQuantity.add(i, (Integer) dessertBuy.get(1).get(i));
		}
		for (int i = 0; i < dessertBuy.get(0).size(); i++) {
			value = dessertList.get(i).getQuatity()-auxListQuantity.get(i);
			dessertList.get(i).setQuantity(Integer.valueOf(value));
		}
		String json = new Gson().toJson(dessertList);
		PrintWriter print = new PrintWriter("data/desserts.json");
		print.write(json);
		print.close();
		
	}
//Metodo para editar el historial de compras (cuando el cliente compre algún producto)
	public void editQuantityShopRecord(ArrayList<ArrayList<Object>> dessertBuy) throws FileNotFoundException {
		ArrayList<Dessert> listDessertShop = this.readFileShopRecord();
		ArrayList<Dessert> auxListDessert = new ArrayList<Dessert>();
		ArrayList<Integer> auxListQuantity = new ArrayList<>();
		int quantity = 0;
		for (int i = 0; i < dessertBuy.get(0).size(); i++) {
			auxListDessert.add(i, (Dessert) dessertBuy.get(0).get(i));
			auxListQuantity.add(i, (Integer) dessertBuy.get(1).get(i));
		}
		for (int i = 0; i < listDessertShop.size(); i++) {
			for (int j = 0; j < auxListDessert.size(); j++) {
				if (listDessertShop.get(i).getName().equals(auxListDessert.get(j).getName())) {
					quantity = listDessertShop.get(i).getQuatity();
					listDessertShop.get(i).setQuantity(quantity + auxListQuantity.get(j));
				}
			}
		}
		String json = new Gson().toJson(listDessertShop);
		PrintWriter print = new PrintWriter("data/shopRecord.json");
		print.write(json);
		print.close();
	}
//Metodo para que cuando el dueño adicione un nuevo postre, también lo adicione al historial de compras	
	public void addDessertShopRecord(int id, String name, int price, int quantity) throws FileNotFoundException {
		ArrayList<Dessert> listDessertShop = this.readFileShopRecord();
		Dessert newDessert = new Dessert(id, name, price, quantity);
		boolean validation = false;
		int i = 0;
		while (validation == false && i < listDessertShop.size()) {
			if (listDessertShop.get(i).getId() == newDessert.getId()) {
				validation = true;
			} else if (listDessertShop.get(i).getName().equals(newDessert.getName())) {
				validation = true;
			}
			i++;
		}
		if (validation == false) {
			listDessertShop.add(newDessert);
		}
		String json = new Gson().toJson(listDessertShop);

		PrintWriter print = new PrintWriter("data/shopRecord.json");
		print.write(json);
		print.close();
	}
//Metodo para que cuando el dueño elimine un postre, también lo elimine del historial de compras		
	public boolean deleteDessertShopRecord(String name) throws FileNotFoundException {
		if (this.validateExist(name) == true) {
			ArrayList<Dessert> listDessertShop = this.readFileShopRecord();
			ArrayList<Dessert> auxList = new ArrayList<>();
			for (int i = 0; i < listDessertShop.size(); i++) {
				if (listDessertShop.get(i).getName().equals(name) == false) {
					auxList.add(listDessertShop.get(i));
				}
			}
			String json = new Gson().toJson(auxList);
			PrintWriter print = new PrintWriter("data/shopRecord.json");
			print.write(json);
			print.close();
		}
		return this.validateExist(name);
	}
//Metodo para editar el historial de compras si se edita el nombre o id del postre
	public void editShopDessert(String nameDessert, String tag, String value) throws FileNotFoundException {
		ArrayList<Dessert> listDessertShop = this.readFileShopRecord();
		for (int i = 0; i < listDessertShop.size(); i++) {
			if (listDessertShop.get(i).getName().equals(nameDessert)) {
				switch (tag) {
				case "id":
					listDessertShop.get(i).setId(Integer.valueOf(value));
					break;
				case "name":
					listDessertShop.get(i).setName(value);
					break;
				default:
					break;
				}
			}
			String json = new Gson().toJson(listDessertShop);
			PrintWriter print = new PrintWriter("data/shopRecord.json");
			print.write(json);
			print.close();
		}
	}
	
}
