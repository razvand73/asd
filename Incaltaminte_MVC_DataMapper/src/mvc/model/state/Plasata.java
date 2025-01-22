package mvc.model.state;

public class Plasata implements Stare {

	@Override
	public void schimbaStare(Comanda comanda) {
		comanda.setStare(this);
	}

	@Override
	public String toString() {
		return "Plasata";
	}

}
