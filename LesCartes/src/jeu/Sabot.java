package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot {
	private Carte[] pioche;
	private int nbCartes = 0;
	private int nbMax = 110; 
	
	// classe interne ITERATOR
	
	private class Iterateur implements Iterator <Carte> {
		private int indiceItrateur = 0;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Carte next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void remove() {
			// TODO 
		}
		
	}
	
	public Iterator <Sabot> iterator() { // il y a des problemes
		return new Iterateur();
	}
	
	public Sabot(Carte[] pioche, int nbCartes) {
		this.nbCartes = nbCartes;
		this.pioche = new Carte[nbCartes];
	}
	
	public boolean estVide() { // ? nujno li dobavlyat' v scobki chtoto
		if (nbCartes == 0) return true;
		return false;
	}
	
	private void ajouterCarte(Carte carte) {
		if (nbCartes < nbMax) {
			nbCartes++;
			pioche[nbCartes-1] = carte;
		} else throw new NoSuchElementException();
	}
	
	public void ajouterFamilleCarte (Carte carte, int nombre) {
		int i = 0;
		while (i < nombre) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte (Carte...cartes) {
		int i = 0;
		while (i < cartes.length) {
			ajouterCarte(cartes[i]);
		}
	}
}
