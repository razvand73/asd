package mvp.model.state;

public class Pregatita implements Stare {

	@Override
	public void schimbaStare(Comanda comanda) {
		comanda.setStare(this);
	}

	@Override
	public String toString() {
		return "Pregatita";
	}

}
