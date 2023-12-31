package cartes;

import cartes.Probleme.Type;
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
		if (j.possedeBotteType(Type.FEU) && j.getPileLimite().isEmpty()) {
			j.getPileLimite().add(this);
			return true;
		}
		return false;
	}
	
	
}
