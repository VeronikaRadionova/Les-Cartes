package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;
import utils.Utils;

public class Joueur {
	private String nom;
	private MainAsListe main;
	
	private List <Limite> pileLimite;
	private List <Bataille> pileBataille;
	private List <Borne> collectionBorne;
	private Set <Botte> ensembleBotte;
	
	
	public Joueur(String nom) {
		this.nom = nom;
		main = new MainAsListe();
		
		pileLimite = new ArrayList <Limite>();
		pileBataille = new ArrayList <Bataille>();
		collectionBorne = new ArrayList <Borne>();
		ensembleBotte = new HashSet <Botte>();
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public Set<Botte> getEnsembleBotte() {
		return ensembleBotte;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return nom == joueur.toString();
		}
		return false;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
		// post-condition est déjà dans le méthode prendre()
	}
	
	public Carte prendreCarte(List<Carte>sabot) {
		if (sabot.isEmpty()) {
			return null;
		}
		Carte carte = sabot.get(0);
		sabot.remove(carte);
		donner(carte);
		
		if (carte instanceof Bataille) {
			pileBataille.add((Bataille) carte);
		}
		else if (carte instanceof Limite) {
			pileLimite.add((Limite) carte);
		}
		else if (carte instanceof Borne) {
			collectionBorne.add((Borne) carte);
		}
		else if (carte instanceof Botte) {
			ensembleBotte.add((Botte) carte);
		}
		return carte;
	}
	
	public int getKM() {
		int kmParcouru = 0;
		for (Borne borne : collectionBorne) {
			kmParcouru = kmParcouru + borne.getKm();
		}
		return kmParcouru;
	}
	
	
	public boolean possedeBotteType (Type type) {
		for (Botte botte : ensembleBotte) {
			if (botte.getType() == type) {
				return true;
			}
		}
		return false;
	}
	
	public int getLimite() {
		if (pileLimite.isEmpty()) { return 200; }
		
		Carte sommetPile = pileLimite.get(pileLimite.size() - 1);
		if ((sommetPile instanceof FinLimite) || possedeBotteType(Type.FEU)) {
			return 200;
		}
		return 50;
	}
	
	
	public boolean estBloque() {
		boolean prioritaire = possedeBotteType(Type.FEU);
		
		if (pileBataille.isEmpty() && prioritaire) {
			return false;
		}
		
		Bataille sommetPile = pileBataille.get(pileBataille.size()-1);
		
		if (sommetPile.equals(new Parade(1, Type.FEU))) {
			return false;
		} else if (prioritaire) {
			if (sommetPile  instanceof Parade) {
				return false;
			} else if (sommetPile.equals(new Attaque(1, Type.FEU))) {
				return false;
			} else if (possedeBotteType(sommetPile.getType())) {
				return false;
			}
		}
		return true;
		}
		
	
	
	
	
	
	
	
}
