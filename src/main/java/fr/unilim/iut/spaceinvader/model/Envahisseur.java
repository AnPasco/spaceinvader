package fr.unilim.iut.spaceinvader.model;

public class Envahisseur extends Sprite {
	private boolean dernierDeplacementVersLaDroite;

	public Envahisseur(Dimension dimension, Position origine, int vitesse) {
		super(dimension, origine, vitesse);
		this.dernierDeplacementVersLaDroite = true;
	}

	public boolean isDernierDeplacementVersLaDroite() {
		return dernierDeplacementVersLaDroite;
	}

	public void setDernierDeplacementVersLaDroite(boolean dernierDeplacementVersLaDroite) {
		this.dernierDeplacementVersLaDroite = dernierDeplacementVersLaDroite;
	}
	
	
	
}
