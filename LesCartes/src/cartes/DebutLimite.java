package cartes;

import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}

	public boolean equals(Object obj) {
		if (obj instanceof DebutLimite) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Debut Limite de vitesse: " + nombre;
	}

	@Override
	boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
