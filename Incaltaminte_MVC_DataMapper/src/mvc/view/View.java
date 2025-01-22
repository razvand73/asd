package mvc.view;

import java.util.Scanner;

import mvc.model.state.Comanda;
import mvc.model.observer.Client;
import mvc.model.observer.Notificare;

public class View {

	private Scanner scanner = new Scanner(System.in);
	private Notificare notificare = new Notificare();
	Client client = new Client(1, "Popescu", 18);
	Client client2 = new Client(2, "Ionescu", 18);
	
	public View() {
		notificare.adaugaObserver(client);
		notificare.adaugaObserver(client2);
	}

    public Notificare getNotificare() {
		return notificare;
	}

	public void displayOrder(Comanda order) {
        System.out.println("ID: " + order.getId());
        System.out.println("Stare: " + order.getStare());
    }

    public int getOrderIdFromUser() {
        System.out.print("Enter Order ID: ");
        return scanner.nextInt();
    }

}
