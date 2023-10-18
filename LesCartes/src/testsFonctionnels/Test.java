package testsFonctionnels;

//import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Sabot;
import utils.Utils;

public class Test {

	public static void main(String[] args) {
		System.out.println("TEST TP1 :\n");
		
		// initialisation
		Sabot sabot = new Sabot(10);
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asVolant = new Botte(1, Type.ACCIDENT);
		
		// ajouter des cartes et piocher
		sabot.ajouterFamilleCarte(accident, reparation, asVolant);
		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println("je pioche " + carte);
		}
		System.out.println("\n");
		
		System.out.println("TEST TP2 : \n");
		
		// initialisation
		Borne borne = new Borne(2, 5);
		FinLimite fin = new FinLimite(4);
		FinLimite fin2 = new FinLimite(5);
		//DebutLimite debut = new DebutLimite(3);
		Botte asVolant2 = new Botte(3, Type.ACCIDENT);
		
		// equals
		boolean egaux = fin.equals(fin2);
		System.out.println("finLimite et finLimite : " + egaux);
		boolean egaux1 = accident.equals(borne);
		System.out.println("accident et borne : " + egaux1);
		boolean egaux2 = reparation.equals(fin);
		System.out.println("parade et finLimite : " + egaux2);
		boolean egaux3 = asVolant.equals(asVolant2);
		System.out.println("botte et botte : " + egaux3 + "\n");
		
		// liste des cartes et checkCount
		JeuDeCartes cartes = new JeuDeCartes();
		System.out.println("tout les cartes:" + cartes.getCartes());
		System.out.println("vérification nombre de cartes: " + cartes.checkCount() + "\n");
		
		// extraire et avec iterateur
		System.out.println(Utils.extraire(cartes.getCartes()));
		System.out.println(Utils.extraire(cartes.getCartes()));
		
		System.out.println(Utils.extraireIterator(cartes.getCartes()));
		System.out.println(Utils.extraireIterator(cartes.getCartes()) + "\n");
		
		// rassemblement
		Integer[] tableau0 = {};
        List<Integer> liste0 = Arrays.asList(tableau0);
        System.out.println("[]: " + Utils.verifierRassemblement(liste0));
        liste0 = Utils.rassembler(liste0);
        System.out.println(liste0.toString() + ": " + Utils.verifierRassemblement(liste0) + "\n");
        
		Integer[] tableau1 = {1, 1, 2, 1, 3};
        List<Integer> liste1 = Arrays.asList(tableau1);
        System.out.println("[1, 1, 2, 1, 3]: " + Utils.verifierRassemblement(liste1));
        liste1 = Utils.rassembler(liste1);
        System.out.println(liste1.toString() + ": " + Utils.verifierRassemblement(liste1) + "\n");
        
        Integer[] tableau2 = {1, 4, 3, 2};
        List<Integer> liste2 = Arrays.asList(tableau2);
        System.out.println("[1, 4, 3, 2]: " + Utils.verifierRassemblement(liste2));
        liste2 = Utils.rassembler(liste2);
        System.out.println(liste2.toString() + ": " + Utils.verifierRassemblement(liste2) + "\n");
        
        Integer[] tableau3 = {1, 1, 2, 3, 1};
        List<Integer> liste3 = Arrays.asList(tableau3);
        System.out.println("[1, 1, 2, 3, 1]: " + Utils.verifierRassemblement(liste3));
        liste3 = Utils.rassembler(liste3);
        System.out.println(liste3.toString() + ": " + Utils.verifierRassemblement(liste3) + "\n");
	}

}
