package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Carte;
import cartes.Limite;

public class Joueur {
	private String nom;
	private List <Limite> pileLimite = new ArrayList <Limite>();
	private List <Bataille> pileBataille = new ArrayList <Bataille>();
	// sdelat' shtuku s collection de bornes i ensemble de bottes

	public Joueur(String nom) {
		this.nom = nom;
		
	}
	
	
}
