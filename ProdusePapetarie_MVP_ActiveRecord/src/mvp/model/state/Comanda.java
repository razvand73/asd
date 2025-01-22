package mvp.model.state;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public void onoreazaComanda() {
		Onorata pregatita = new Onorata();
		pregatita.schimbaStare(this);
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", stare=" + stare + "]";
	}

	public void addComanda(String fileName) {
		List<Comanda> comenzi = getComenzi(fileName);
		if(comenzi != null ) {
			comenzi.add(this);
		} else {
			comenzi = new ArrayList<>();
			comenzi.add(this);
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Comanda> getComenzi(String fileName) {
		List<Comanda> comenzi = new ArrayList<>();
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
				comenzi.addAll((List<Comanda>) in.readObject());
				return comenzi;
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Comanda getComanda(int id, String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			@SuppressWarnings("unchecked")
			List<Comanda> comenzi = (List<Comanda>) in.readObject();
			for (Comanda comanda : comenzi) {
				if (comanda.getId() == id) {
					return comanda;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateComanda(String fileName) {
		List<Comanda> comenzi = getComenzi(fileName);
		if (comenzi.size() != 0) {
			for (int i = 0; i < comenzi.size(); i++) {
				if (comenzi.get(i).getId() == this.getId()) {
					comenzi.set(i, this);
					break;
				}
			}
		} else {
			getComenzi(fileName);
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
