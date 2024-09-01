package model;

import java.util.ArrayList;
public class Client {
	private String name;
	private ArrayList<ArrayList<Object>> dessertBuy;
	
	public Client() {
		this.name = "";
		this.dessertBuy = new ArrayList<>();
	}
	
	public Client(String name) {
		this.name = name;
		this.dessertBuy = new ArrayList<>();
	}
	
	public int calculateTotal(ArrayList<ArrayList<Object>> dessertBuy) {
		this.dessertBuy = dessertBuy;
		int total = 0;
		ArrayList<Dessert> auxList = new ArrayList<Dessert>();
		ArrayList<Integer> auxListQuantity = new ArrayList<>();
		for (int i = 0; i < this.dessertBuy.get(0).size(); i++) {
			auxList.add(i, (Dessert) this.dessertBuy.get(0).get(i));
			auxListQuantity.add(i, (Integer) this.dessertBuy.get(1).get(i));
		}
		
		for (int i = 0; i < auxList.size(); i++) {
			if(auxListQuantity.get(i) != null && auxList.get(i).getPrice() != 0) {
				total += auxList.get(i).getPrice() * auxListQuantity.get(i); 
			}
			
		}
		return total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ArrayList<Object>> getDessertBuy() {
		return dessertBuy;
	}

	public void setDessertBuy(ArrayList<ArrayList<Object>> dessertBuy) {
		this.dessertBuy = dessertBuy;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", dessertBuy=" + dessertBuy + "]";
	}
	
}
