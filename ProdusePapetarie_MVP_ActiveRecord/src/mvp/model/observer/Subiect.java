package mvp.model.observer;

import java.util.ArrayList;
import java.util.List;

import mvp.model.state.Comanda;

public abstract class Subiect {
	private List<Observer> observeri;

	public Subiect() {
		super();
		this.observeri = new ArrayList<>();
	}
	
	public void adaugaObserver(Observer observer) {
		observeri.add(observer);
	}
	
	public void stergeObserver(Observer observer) {
		observeri.remove(observer);
	}
	
	public void notificaClienti(Comanda comanda) {
		for(Observer o : observeri) {
			o.primesteNotificare(comanda);
		}
	}
}
