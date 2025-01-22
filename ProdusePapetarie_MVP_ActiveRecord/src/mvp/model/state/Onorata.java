package mvp.model.state;

public class Onorata implements Stare {

	@Override
	public void schimbaStare(Comanda comanda) {
		comanda.setStare(this);
	}

	@Override
	public String toString() {
		return "Onorata";
	}

}
