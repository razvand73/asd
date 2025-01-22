package mvc.model.observer;

import java.io.Serializable;

import mvc.model.state.Comanda;

public class Notificare extends Subiect implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public void notificaClienti(Comanda comanda) {
		super.notificaClienti(comanda);
	}

	@Override
	public String toString() {
		return "Notificare []";
	}

}
