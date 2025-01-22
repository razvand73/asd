package mvp.model.state;

import java.io.Serializable;

import mvp.model.observer.Notificare;

public class Comanda implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Notificare notificare;
	private Stare stare;
	
	public Comanda(int id, Notificare notificare) {
		super();
		this.id = id;
		this.notificare = notificare;
	}
	
	public int getId() {
		return id;
	}
	
	public Stare getStare() {
		return stare;
	}
	
	void setStare(Stare stare) {
		this.stare = stare;
		notificare.notificaClienti(this);
	}
	
	public void inregistreazaComanda() {
		Inregistrata inregistrata = new Inregistrata();
		inregistrata.schimbaStare(this);
	}
	
	public void livreazaComanda() {
		Livrata livrata = new Livrata();
		livrata.schimbaStare(this);
	}
	
	public void pregatesteComanda() {
		Pregatita pregatita = new Pregatita();
		pregatita.schimbaStare(this);
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", stare=" + stare + "]";
	}
	
}
