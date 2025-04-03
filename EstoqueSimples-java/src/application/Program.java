package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int option;
		do {
			System.out.println("\nMenu:");
			System.out.println("1 - Adicionar Produto");
			System.out.println("2 - Remover Produto");
			System.out.println("3 - Atualizar Estoque");
			System.out.println("4 - Listar Produtos");
			System.out.println("5 - Sair");
			System.out.print("Escolha uma opção: ");
			option = sc.nextInt();
			sc.nextLine(); // Consumir quebra de linha

			switch (option) {
				case 1:
					System.out.print("Nome do produto: ");
					String name = sc.nextLine();
					System.out.print("Preço: ");
					Double price = sc.nextDouble();
					System.out.print("Quantidade: ");
					Integer quantity = sc.nextInt();
					Product.addProduct(new Product(name, price, quantity));
					System.out.println("Produto adicionado!");
					break;

				case 2:
					System.out.print("Nome do produto a remover: ");
					String nameToRemove = sc.nextLine();
					Product.removeProduct(nameToRemove);
					break;

				case 3:
					System.out.print("Nome do produto: ");
					String nameToUpdate = sc.nextLine();
					Product product = Product.findProductByName(nameToUpdate);
					if (product != null) {
						System.out.print("Quantidade a adicionar/remover (ex: 10 ou -5): ");
						int qty = sc.nextInt();
						if (qty > 0) {
							product.addQuantity(qty);
						} else {
							product.removeQuantity(-qty);
						}
						System.out.println("Estoque atualizado!");
					} else {
						System.out.println("Produto não encontrado!");
					}
					break;

				case 4:
					System.out.println("Lista de Produtos:");
					Product.listAllProducts();
					break;

				case 5:
					System.out.println("Saindo...");
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		} while (option != 5);

		sc.close();
	}
}
