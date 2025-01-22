package mvc.controller;

import java.util.List;

import mvc.model.ComandaDataMapper;
import mvc.model.state.Comanda;

public class Controller {

	private final ComandaDataMapper comandaDataMapper;

	public Controller(ComandaDataMapper comandaDataMapper) {
		super();
		this.comandaDataMapper = comandaDataMapper;
	}
	
	public void addComanda(Comanda order, String fileName) {
		comandaDataMapper.addComanda(order, fileName);
	}
	
	public void updateComanda(Comanda order, String fileName) {
		comandaDataMapper.updateComanda(order, fileName);
	}
	
	public List<Comanda> getComenzi(String fileName) {
		return comandaDataMapper.getComenzi(fileName);
	}
	
	public Comanda getComanda(int id, String fileName) {
		return comandaDataMapper.getComanda(id, fileName);
	}
	
	public void preiaComanda(Comanda comanda, String fileName) {
		comanda.preiaComanda();
		comandaDataMapper.updateComanda(comanda, fileName);
	}
	
	public void platesteComanda(Comanda comanda, String fileName) {
		comanda.platesteComanda();
		comandaDataMapper.updateComanda(comanda, fileName);
	}
	
	public void pregatesteComanda(Comanda comanda, String fileName) {
		comanda.pregatesteComanda();
		comandaDataMapper.updateComanda(comanda, fileName);
	}
	
	public void plaseazaComanda(Comanda comanda, String fileName) {
		comanda.plaseazaComanda();
		comandaDataMapper.updateComanda(comanda, fileName);
	}
}
