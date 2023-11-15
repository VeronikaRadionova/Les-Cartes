package cartes;

import jeu.Joueur;
import utils.Utils;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}

	public boolean equals(Object obj) {
		if (obj instanceof FinLimite) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Fin Limite de vitesse: " + nombre;
	}

	@Override
	boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
