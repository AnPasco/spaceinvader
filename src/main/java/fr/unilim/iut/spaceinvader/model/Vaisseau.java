package fr.unilim.iut.spaceinvader.model;

public class Vaisseau extends Sprite {
	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
		this.vitesse = 1;
	}

	public Vaisseau(int longueur, int hauteur, int x, int y) {
		this.dimension = new Dimension(longueur, hauteur);
		this.origine = new Position(x, y);
		this.vitesse = 1;
	}

	public Vaisseau(Dimension dimension, Position positionOrigine) {
		this(dimension, positionOrigine, 1);
	}

	public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		this.dimension = dimension;
		this.origine = positionOrigine;
		this.vitesse = vitesse;
	}
}
