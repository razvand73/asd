package mvc.model.state;

public class Preluata implements Stare {

	@Override
	public void schimbaStare(Comanda comanda) {
		comanda.setStare(this);
	}

	@Override
	public String toString() {
		return "Preluata";
	}

}
