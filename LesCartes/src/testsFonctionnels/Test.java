package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;

public class Test {

	public static void main(String[] args) {
		System.out.println("TEST TP1 :\n");
		
		Sabot sabot = new Sabot(10);
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("je pioche " + carte);
		}
		System.out.println("\n");
		System.out.println("TEST TP2 : \n");
		
		Borne borne = new Borne(2, 5);
		FinLimite fin = new FinLimite(4);
		FinLimite fin2 = new FinLimite(5);
		DebutLimite debut = new DebutLimite(3);
		Botte asVolant2 = new Botte(3, Type.ACCIDENT);
		
		boolean egaux = fin.equals(fin2);
		System.out.println("finLimite et finLimite : " + egaux);
		boolean egaux1 = accident.equals(borne);
		System.out.println("accident et borne : " + egaux1);
		boolean egaux2 = reparation.equals(fin);
		System.out.println("parade et finLimite : " + egaux2);
		boolean egaux3 = asVolant.equals(asVolant2);
		System.out.println("botte et botte : " + egaux3);
	}

}
