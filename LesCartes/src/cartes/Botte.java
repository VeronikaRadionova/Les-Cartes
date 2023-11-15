package cartes;

import jeu.Joueur;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case FEU: 
			return "Véhicule prioritaire";
		case ESSENCE: 
			return "Citerne d'essence";
		case ACCIDENT: 
			return "As du volant";
		case CREVAISON:
			return "Increvable";
		}
		return "Erreur";
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Botte) {
			Botte botte = (Botte) obj;
			return type == botte.getType();
		}
		return false;
	}

	@Override
	boolean appliquer(Joueur j) {
		for (Bataille attaque : j.getPileBataille()) {
			if (attaque instanceof Attaque) {
				if (this.getType() == attaque.getType()) {
					j.getPileBataille().remove(attaque);
				}
			}
		}
		j.getEnsembleBotte().add(this);
		return true;
	}

}
