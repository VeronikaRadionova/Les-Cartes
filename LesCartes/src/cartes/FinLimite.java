package cartes;

import cartes.Probleme.Type;
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
		if (!j.possedeBotteType(Type.FEU) && !j.getPileLimite().isEmpty()) {
			j.getPileLimite().add(this);
			return true;
		}
		return false;
	}
	
	
}
