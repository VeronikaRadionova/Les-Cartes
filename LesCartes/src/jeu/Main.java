package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public interface Main {
	void prendre(Carte carte);
	void jouer(Carte carte);
	
	
	class MainAsListe implements Main {
		private List <Carte> listeMain = new ArrayList <Carte>();

		
		// tam bylo chtoto pro ITERATOR - nado glyanut' potom
		@Override
		public void prendre(Carte carte) {
			listeMain.add(carte);	
		}

		@Override
		public void jouer(Carte carte) {
			listeMain.remove(carte);
		}
		
	}
}
