package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public interface Main {
	
	Iterator<Carte> iterateur();
	
	void prendre(Carte carte);
	
	void jouer(Carte carte);
}
