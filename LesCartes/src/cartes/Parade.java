package cartes;

import jeu.Joueur;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (getType()) {
		case FEU: 
			return "Feu vert";
		case ESSENCE: 
			return "Essence";
		case ACCIDENT: 
			return "Réparations";
		case CREVAISON:
			return "Roue de secours";
		}
		return "Erreur";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Parade) {
			Parade parade = (Parade) obj;
			return type == parade.getType();
		}
		return false;
	}

	@Override
	boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
