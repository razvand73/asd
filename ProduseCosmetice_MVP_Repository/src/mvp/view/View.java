package mvp.view;

import java.util.List;

import mvp.model.state.Comanda;

public interface View {
	void showComenzi(List<Comanda> comenzi);
	void addComanda(Comanda order, String fileName);
	void showComanda(Comanda comanda);
}
