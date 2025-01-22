package mvc.model.observer;

import mvc.model.state.Comanda;

public interface Observer {
	void primesteNotificare(Comanda comanda);
}
