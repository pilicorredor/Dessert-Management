package model;

public class Dessert {
	private int id;
	private String name;
	private int price;
	private int quantity;
	private String urlImage;
	private String description;
	
	public Dessert(int id, String name, int price, int quantity, String urlImage, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.urlImage = urlImage;
		this.description = description;
	}
	
	public Dessert(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuatity() {
		return quantity;
	}

	public void setQuantity(int quatity) {
		this.quantity = quatity;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Dessert [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", urlImage="
				+ urlImage + ", description=" + description + "]";
	}
	
	
}
