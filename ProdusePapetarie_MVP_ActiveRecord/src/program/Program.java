package program;

import mvp.model.observer.Client;
import mvp.model.observer.Notificare;
import mvp.model.state.Comanda;
import mvp.presenter.Presenter;
import mvp.view.ConsoleView;
import mvp.view.View;

public class Program {

	public static void main(String[] args) {
		Notificare notificare = new Notificare();
		Client client = new Client(1, "Popescu", 18);
		Client client2 = new Client(2, "Ionescu", 18);
		notificare.adaugaObserver(client);
		notificare.adaugaObserver(client2);
		Comanda comanda = new Comanda(1, notificare);
		Comanda comanda2 = new Comanda(2, notificare);
		
		View view = new ConsoleView();
		Presenter presenter = new Presenter(view);
		String fileName = "comenzi.dat";
		presenter.addComanda(comanda, fileName);
		presenter.getComenzi(fileName);
		presenter.getComanda(1, fileName);
		presenter.preiaComanda(comanda2, fileName);
		presenter.getComanda(1, fileName);
	}
	
}
