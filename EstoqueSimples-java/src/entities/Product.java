package entities;

public class Product {

	private String name;
	private double price;
	private int quantity;

	// Construtor padrão (caso seja necessário criar um produto sem dados iniciais)
	public Product() {
	}

	// Construtor principal (name, price, quantity)
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Sobrecarga do Construtor (caso a quantidade não seja informada, assume 0)
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantity = 0; // Inicializando com zero
	}

	// Métodos Getters e Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) { // Evita nome vazio
			this.name = name;
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) { // Evita preço negativo
			this.price = price;
		}
	}

	public int getQuantity() {
		return quantity; // Apenas retorna, sem set pois a quantidade é controlada pelos métodos
							// add/remove
	}

	// Método para calcular valor total do estoque
	public double totalValueInStock() {
		return price * quantity;
	}

	// Adiciona produtos ao estoque
	public void addProducts(int quantity) {
		if (quantity > 0) { // Evita adicionar quantidade negativa
			this.quantity += quantity;
		}
	}

	public void removeProducts(int quantity) {
		if (quantity > 0 && quantity <= this.quantity) { // Evita remover mais do que tem
			this.quantity -= quantity;
		}
	}

	public String toString() {
		return name
				+ ", $ "
				+ String.format("%.2f", price)
				+ ", "
				+ quantity
				+ " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}
