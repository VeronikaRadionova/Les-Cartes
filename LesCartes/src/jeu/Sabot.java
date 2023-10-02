package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable <Carte> {
	private Carte[] cartes;
	private int nbCartes = 0;
	private int nbMax;
	private int nbOperations = 0;
	
	
	
	/* CLASSE INTERNE ITERATEUR */
	
	public Iterator <Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator <Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsI = nbOperations;

		@Override
		public boolean hasNext() {
			if (indiceIterateur < nbCartes) return true;
			return false;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			Carte carte = cartes[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return carte;
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes == 0 || !nextEffectue) {
				throw new IllegalStateException();
			}
			int i = indiceIterateur;
			while (i < nbCartes) {
				cartes[i-1] = cartes[i];
				i++;
			}
			nbCartes--;
			nextEffectue = false;
			nbOperations++;
			nbOperationsI++;
		}
		
		private void verificationConcurrence() {
			if (nbOperationsI != nbOperations) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	/* FIN CLASSE INTERNE ITERATEUR */
	
	
	public Sabot(int nbMax) {
		this.nbCartes = nbCartes;
		this.cartes = new Carte[nbMax];
	}
	
	public boolean estVide() {
		if (nbCartes == 0) return true;
		return false;
	}
	
	private void ajouterCarte(Carte carte) {
		if (nbCartes < this.cartes.length) {
			this.cartes[nbCartes] = carte;
			nbCartes++;
			nbOperations++;
		} else throw new ArrayIndexOutOfBoundsException("Plus de place");
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		int i = 0;
		while (i < carte.getNombre()) {
			ajouterCarte(carte);
			i++;
		}
	}
	
	public void ajouterFamilleCarte(Carte...cartes) {
		int i = 0;
		while (i < cartes.length) {
			Carte carte = cartes[i];
			ajouterFamilleCarte(carte);
			i++;
		}
	}
	
	public Carte piocher() {
		Carte carte = null;
		Iterator<Carte> iterCarte = iterator();
		if (iterCarte.hasNext()) {
			carte = iterCarte.next();
			iterCarte.remove();
		}
		return carte;
	}
}
