package program;

import mvp.model.observer.Client;
import mvp.model.observer.Notificare;
import mvp.model.repository.ComandaRepository;
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
		ComandaRepository repository = new ComandaRepository();
		Presenter presenter = new Presenter(view, repository);
		String fileName = "comenzi.dat";
//		presenter.addComanda(comanda2, fileName);
		presenter.getComenzi(fileName);
		presenter.getComanda(2, fileName);
		presenter.inregistreazaComanda(comanda2, fileName);
		presenter.getComanda(2, fileName);
	}
	
}
