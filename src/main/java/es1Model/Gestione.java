package es1Model;

import es.db.ParoleDAO;

public class Gestione {

	public int addParola(String s) {
		return ParoleDAO.add(s);
	}
	
	public int getN() {
		return ParoleDAO.n;
	}

}
