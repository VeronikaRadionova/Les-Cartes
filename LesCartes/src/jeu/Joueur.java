package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;

public class Joueur {
	private String nom;
	private Main main;
	private List <Limite> pileLimite = new ArrayList <Limite>();
	private List <Bataille> pileBataille = new ArrayList <Bataille>();
	// sdelat' shtuku s collection de bornes i ensemble de bottes

	
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
	
	
}
