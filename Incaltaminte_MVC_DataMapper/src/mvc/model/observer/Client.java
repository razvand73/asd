package mvc.model.observer;

import mvc.model.state.Comanda;

public class Client implements Observer {

	private int id;
	private String nume;
	private int varsta;

	public Client(int id, String nume, int varsta) {
		super();
		this.id = id;
		this.nume = nume;
		this.varsta = varsta;
	}

	@Override
	public void primesteNotificare(Comanda comanda) {
		System.out.println("Clientul " + nume + " a primit notificare: comanda " + comanda.getId() + " a fost "
				+ comanda.getStare());
	}
}
