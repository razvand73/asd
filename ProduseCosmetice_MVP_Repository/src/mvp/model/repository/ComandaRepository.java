package mvp.model.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mvp.model.state.Comanda;

public class ComandaRepository implements Repository<Comanda> {
	private List<Comanda> comenzi;

	public ComandaRepository() {
		this.comenzi = new ArrayList<>();
	}

	public void add(Comanda order, String fileName) {
		getAll(fileName);
		comenzi.add(order);
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update(Comanda order, String fileName) {
		if (comenzi.size() != 0) {
			for (int i = 0; i < comenzi.size(); i++) {
				if (comenzi.get(i).getId() == order.getId()) {
					comenzi.set(i, order);
					break;
				}
			}
		} else {
			getAll(fileName);
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(comenzi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Comanda> getAll(String fileName) {
		comenzi = new ArrayList<>();
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

	public Comanda get(int id, String fileName) {
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
}
