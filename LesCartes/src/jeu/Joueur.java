package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Main main = new MainAsListe();
	
	private List <Limite> pileLimite = new ArrayList <Limite>();
	private List <Bataille> pileBataille = new ArrayList <Bataille>();
	private Collection <Borne> collectionBorne = new ArrayList <Borne>();
	private Set <Botte> ensembleBotte = new HashSet <Botte>();
	
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
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
		assert main.contientCarte(carte): "la carte n'est pas dans la main";
	}
	
	public Carte prendreCarte(List<Carte>sabot) {
		if (sabot.isEmpty()) {
			return null;
		}
		donner(sabot.get(0));
		return sabot.get(0);
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
		Carte sommetPile = pileLimite.get(pileLimite.size() - 1);
		if (pileLimite.isEmpty() || (sommetPile instanceof FinLimite) || possedeBotteType(Type.FEU)) {
			return 200;
		}
		return 50;
	}
	
	
	
	
	
	
	
	
	
	
	
}
