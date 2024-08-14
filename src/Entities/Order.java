package Entities;

import java.time.LocalDateTime;
import Entities.enums.OrderStatus;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import Entities.Client;
import Entities.OrderItem;

public class Order {
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private Client client;
	
	public Order() {
	}
	
	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public void addItem(OrderItem item) {
		
		items.add(item);
		
	}
	
	public void removeItem(OrderItem item) {
		
		items.remove(item);
	}
	
	public double total() {
		
		double sumTotalOfItems = 0.0;
		
		for(OrderItem it: items) {
			
			sumTotalOfItems += it.subTotal();
		}
		
		return sumTotalOfItems;
	}
	
	@Override
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + dtf.format(moment) + "\n");
		sb.append(client.toString() + "\n");
		sb.append("Order items:\n");
		
		for(OrderItem ot : items) {
			sb.append(ot.toString() + "\n");
		}
		
		sb.append("Total price: " + String.format("%.2f", total()) );
		
		return sb.toString();
		
	}
	
	
	
	
}
