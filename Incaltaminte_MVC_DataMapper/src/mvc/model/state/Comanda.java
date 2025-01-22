package mvc.model.state;

import java.io.Serializable;

import mvc.model.observer.Notificare;

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
	
	public void preiaComanda() {
		Preluata inregistrata = new Preluata();
		inregistrata.schimbaStare(this);
	}
	
	public void platesteComanda() {
		Platita livrata = new Platita();
		livrata.schimbaStare(this);
	}
	
	public void pregatesteComanda() {
		Pregatita pregatita = new Pregatita();
		pregatita.schimbaStare(this);
	}
	
	public void plaseazaComanda() {
		Plasata pregatita = new Plasata();
		pregatita.schimbaStare(this);
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", stare=" + stare + "]";
	}
	
}
