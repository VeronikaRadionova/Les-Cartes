package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public interface Main {
	
	void prendre(Carte carte);
	
	void jouer(Carte carte);
	
	boolean contientCarte(Carte carte);
}
