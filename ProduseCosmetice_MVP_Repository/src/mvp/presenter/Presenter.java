package mvp.presenter;

import java.util.List;

import mvp.model.repository.ComandaRepository;
import mvp.model.state.Comanda;
import mvp.view.View;

public class Presenter {
	
	private View view;
	private ComandaRepository repository;
	
	public Presenter(View view, ComandaRepository repository) {
		super();
		this.view = view;
		this.repository = repository;
	}
	
	public void getComenzi(String fileName) {
		List<Comanda> comenzi = repository.getAll(fileName);
		view.showComenzi(comenzi);
	}
	
	public void addComanda(Comanda order, String fileName) {
		repository.add(order, fileName);
		view.addComanda(order, fileName);
	}
	
	public void getComanda(int id, String fileName) {
		Comanda comanda = repository.get(id, fileName);
		view.showComanda(comanda);
	}
	
	public void inregistreazaComanda(Comanda comanda, String fileName) {
		comanda.inregistreazaComanda();
		repository.update(comanda, fileName);
	}
	
	public void livreazaComanda(Comanda comanda, String fileName) {
		comanda.livreazaComanda();
		repository.update(comanda, fileName);
	}
	
	public void pregatesteComanda(Comanda comanda, String fileName) {
		comanda.pregatesteComanda();
		repository.update(comanda, fileName);
	}
	
}
