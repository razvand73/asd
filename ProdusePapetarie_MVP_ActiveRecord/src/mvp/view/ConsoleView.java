package mvp.view;

import java.util.List;

import mvp.model.state.Comanda;

public class ConsoleView implements View {

	@Override
	public void showInterventii(List<Comanda> comenzi) {
		for (Comanda comanda : comenzi) {
			System.out.println(comanda);
		}
	}

	@Override
	public void addComanda(Comanda order, String fileName) {
		System.out.println("Comanda a fost adaugata");
	}

	@Override
	public void showComanda(Comanda comanda) {
		if(comanda != null) {
			System.out.println(comanda);
		} else {
			System.out.println("Comanda nu a fost gasita");
		}
	}

}
