package program;

import java.util.List;
import java.util.Scanner;

import mvc.controller.Controller;
import mvc.model.ComandaDataMapper;
import mvc.model.state.Comanda;
import mvc.view.View;

public class Program {

	public static void main(String[] args) {
		ComandaDataMapper orderMapper = new ComandaDataMapper();
        Controller orderController = new Controller(orderMapper);
        View orderView = new View();
        String fileName = "comenzi.dat";
        while (true) {
            System.out.println("1. View Order Details");
            System.out.println("2. Create Order");
            System.out.println("3. Inregistreaza Order");
            System.out.println("4. Exit");
            System.out.println("5. View all");
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    int id = orderView.getOrderIdFromUser();
                    Comanda order = orderController.getComanda(id, fileName);
                    if (order != null) {
                        orderView.displayOrder(order);
                    } else {
                        System.out.println("Order not found");
                    }
                    break;
                case 2:
                	id = orderView.getOrderIdFromUser();
                	order = new Comanda(id, orderView.getNotificare());
                    orderController.addComanda(order, fileName);
                    System.out.println("Order created successfully");
                    break;
                case 3:
                    id = orderView.getOrderIdFromUser();
                    order = orderController.getComanda(id, fileName);
                    if (order != null) {
                        orderController.preiaComanda(order, fileName);
                        System.out.println("Order updated successfully");
                    } else {
                        System.out.println("Order not found");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                case 5:
                	List<Comanda> comenzi = orderController.getComenzi(fileName);
                	if(comenzi != null) {
                		for(Comanda comanda : comenzi) {
                			System.out.println(comanda);
                		}
                	} else {
                		System.out.println("Nu exista comenzi");
                	}
                	break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
	}

}
