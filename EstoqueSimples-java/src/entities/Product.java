package entities;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private Double price;
	private Integer quantity;

	// Lista de produtos gerenciada pela classe
	private static List<Product> productList = new ArrayList<>();

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// GETTERS e SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	public void removeQuantity(int quantity) {
		if (this.quantity >= quantity) {
			this.quantity -= quantity;
		} else {
			System.out.println("Quantidade insuficiente no estoque!");
		}
	}

	// Adiciona um produto na lista
	public static void addProduct(Product product) {
		productList.add(product);
	}

	// Remove um produto pelo nome
	public static void removeProduct(String name) {
		Product product = findProductByName(name);
		if (product != null) {
			productList.remove(product);
			System.out.println("Produto removido!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	// Busca um produto pelo nome
	public static Product findProductByName(String name) {
		for (Product p : productList) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}

	// Lista todos os produtos cadastrados
	public static void listAllProducts() {
		if (productList.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
			return;
		}
		for (Product p : productList) {
			System.out.println(p);
		}
	}

	@Override
	public String toString() {
		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units";
	}
}
