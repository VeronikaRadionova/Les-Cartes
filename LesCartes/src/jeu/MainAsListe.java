package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main {
	private List <Carte> listeMain = new ArrayList <Carte>();

	@Override
	public void prendre(Carte carte) {
		listeMain.add(carte);
		
	}

	@Override
	public void jouer(Carte carte) {
		assert listeMain.contains(carte): "la carte n'est pas dans la main du joueur";
		listeMain.remove(carte);
		
	}

	@Override
	public boolean contientCarte(Carte carte) {
		if (listeMain.contains(carte)) {
			return true;
		}
		return false;
	}

	
}
