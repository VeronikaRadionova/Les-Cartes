package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	private Carte carte;
	private Joueur cible;
	
	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getCible() {
		return cible;
	}
	
	public boolean estValide(Joueur j) {
		if (carte instanceof Attaque || carte instanceof DebutLimite) {
			return !j.equals(cible);
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coup) {
			Coup coup = (Coup) obj;
			return coup.carte.equals(carte) && coup.cible.equals(cible);
		}
		return false;
	}
	
	@Override 
	public int hashCode() {
		return carte.hashCode() + cible.hashCode();
	}
}
