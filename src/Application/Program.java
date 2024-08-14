package Application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import Entities.Client;
import Entities.enums.OrderStatus;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;


public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), dtf);	
		
		System.out.println();
		
		Client client = new Client(name,email,birthDate);
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(LocalDateTime.now(),status, client);
		
		System.out.println();
		
		System.out.print("How many items to this order: ");
		int quantityOfItems = sc.nextInt();
		
		System.out.println();
		
		for(int i = 0; i <  quantityOfItems; i++) {
			
			System.out.println("Enter #" + (i+1) + " item data:");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			order.addItem(
					new OrderItem(quantity, productPrice, new Product(productName, productPrice))
					);
			
			System.out.println();
		}
		
		
		System.out.println();
		
		System.out.println(order.toString());
		
		
		
		
		sc.close();
		
	}

}
