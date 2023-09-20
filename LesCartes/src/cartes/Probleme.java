package cartes;

public abstract class Probleme extends Carte {
	public enum Type {FEU, ESSENCE, CREVAISON, ACCIDENT};
	private Type type;

	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	

}
