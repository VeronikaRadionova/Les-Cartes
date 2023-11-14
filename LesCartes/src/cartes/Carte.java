package cartes;

import cartes.Probleme.Type;

public abstract class Carte {
	public int nombre;

	public Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Carte [nombre=" + nombre + ", toString()=" + super.toString() + "]";
	}

	//public abstract Type getType();
	
	
}
