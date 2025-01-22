package mvp.model.observer;

import mvp.model.state.Comanda;

public interface Observer {
	void primesteNotificare(Comanda comanda);
}
