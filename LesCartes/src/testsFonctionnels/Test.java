package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;

public class Test {

	public static void main(String[] args) {
		Sabot sabot = new Sabot(10);
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("je pioche " + carte);
		}
	}

}
