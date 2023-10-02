package cartes;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}

	public boolean equals(Object obj) {
		if (obj instanceof FinLimite) return true;
		return false;
	}
}
