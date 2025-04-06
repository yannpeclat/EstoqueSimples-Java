package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;
import java.util.List;
import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();

		int option;
		do {
			System.out.println("\nMenu:");
			System.out.println("1 - Adicionar Produto");
			System.out.println("2 - Remover Produto");
			System.out.println("3 - Atualizar Estoque");
			System.out.println("4 - Listar Produtos");
			System.out.println("5 - Sair");
			System.out.print("Escolha uma opção: ");
			option = sc.nextInt(); // Consumir quebra de linha

			switch (option) {
				case 1:
					addProduct(products, sc);
					break;
				case 2:
					removeProduct(products, sc);
					break;
				case 3:
					updateStock(products, sc);
					break;
				case 4:
					listProducts(products);
					break;
				case 0:
					System.out.println("Encerrando programa.");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		} while (option != 0);

		sc.close();
	}

	public static void addProduct(List<Product> products, Scanner sc) {
		System.out.print("ID: ");
		int id = sc.nextInt();
		if (findProductById(products, id) != null) {
			System.out.println("ID já existente.");
			return;
		}

		System.out.print("Nome: ");
		sc.nextLine(); // limpar buffer
		String name = sc.nextLine();
		System.out.print("Preço: ");
		double price = sc.nextDouble();
		System.out.print("Quantidade: ");
		int quantity = sc.nextInt();

		products.add(new Product(id, name, price, quantity));
		System.out.println("Produto adicionado!");

	}

	public static void removeProduct(List<Product> products, Scanner sc) {
		System.out.print("Digite o ID do produto a remover: ");
		int id = sc.nextInt();
		Product p = findProductById(products, id);
		if (p == null) {
			System.out.println("Produto não encontrado.");
		} else {
			products.remove(p);
			System.out.println("Produto removido.");
		}
	}

	public static void updateStock(List<Product> products, Scanner sc) {
		System.out.print("ID do produto: ");
		int id = sc.nextInt();
		Product p = findProductById(products, id);
		if (p == null) {
			System.out.println("Produto não encontrado.");
			return;
		}
		System.out.print("Adicionar ou remover quantidade? (a/r): ");
		char tipo = sc.next().charAt(0);
		System.out.print("Quantidade: ");
		int qty = sc.nextInt();

		if (tipo == 'a') {
			p.addQuantity(qty);
		} else if (tipo == 'r') {
			p.removeQuantity(qty);
		} else {
			System.out.println("Tipo inválido.");
		}
	}

	public static void listProducts(List<Product> products) {
		System.out.println("\nProdutos no estoque:");
		for (Product p : products) {
			System.out.println(p);
		}
	}

	public static Product findProductById(List<Product> products, int id) {
		return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
}
