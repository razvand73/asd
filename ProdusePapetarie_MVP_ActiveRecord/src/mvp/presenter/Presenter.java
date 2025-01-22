package mvp.presenter;

import java.util.List;

import mvp.model.state.Comanda;
import mvp.view.View;

public class Presenter {
	
	private View view;
	
	public Presenter(View view) {
		super();
		this.view = view;
	}
	
	public void getComenzi(String fileName) {
		List<Comanda> comenzi = Comanda.getComenzi(fileName);
		view.showInterventii(comenzi);
	}
	
	public void addComanda(Comanda order, String fileName) {
		order.addComanda(fileName);
		view.addComanda(order, fileName);
	}
	
	public void getComanda(int id, String fileName) {
		view.showComanda(Comanda.getComanda(id, fileName));
	}
	
	public void preiaComanda(Comanda comanda, String fileName) {
		comanda.preiaComanda();
		comanda.updateComanda(fileName);
	}
	
	public void platesteComanda(Comanda comanda, String fileName) {
		comanda.platesteComanda();
		comanda.updateComanda(fileName);
	}
	
	public void pregatesteComanda(Comanda comanda, String fileName) {
		comanda.pregatesteComanda();
		comanda.updateComanda(fileName);
	}
	
	public void onoreazaComanda(Comanda comanda, String fileName) {
		comanda.onoreazaComanda();
		comanda.updateComanda(fileName);
	}
	
}
