package fr.unilim.iut.spaceinvader.model;

public abstract class Sprite {

	protected Position origine;
	protected Dimension dimension;
	protected int vitesse;

	public Sprite() {
		super();
	}

	public Sprite(Dimension dimension, Position origine, int vitesse) {
		super();
		this.origine = origine;
		this.dimension = dimension;
		this.vitesse = vitesse;
	}

	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public boolean occupeLaPosition(int x, int y) {
		return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	public int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	public int ordonneeLaPlusBasse() {
		return ordonneeLaPlusHaute() - this.dimension.hauteur() + 1;
	}

	private boolean estAbscisseCouverte(int x) {
		return abscisseLaPlusAGauche() <= x && x <= abscisseLaPlusADroite();
	}

	public int abscisseLaPlusADroite() {
		return (this.origine.abscisse() + this.dimension.longueur() - 1);
	}

	public int longueur() {
		return (this.dimension.longueur);
	}

	public int hauteur() {
		return this.dimension.hauteur();
	}

	public void deplacerVersLeHaut() {
		this.origine.changerOrdonnee(this.origine.ordonnee() - vitesse);
	}

	public void deplacerVerticalementVers(Direction direction) {
		this.origine.changerOrdonnee(this.origine.ordonnee() + direction.valeur() * vitesse);
	}

	public void deplacerHorizontalementVers(Direction direction) {
		this.origine.changerAbscisse(this.origine.abscisse() + direction.valeur() * vitesse);
	}

}