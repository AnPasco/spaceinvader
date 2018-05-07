package fr.unilim.iut.spaceinvader;

public class Vaisseau {

	int x;
	int y;

	public Vaisseau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int abscisse() {
		return x;
	}

	public boolean occupeLaPosition(int x, int y) {
		return (this.x == x) && (this.y == y);
	}

	public void seDeplacerVersLaDroite() {
		this.x = this.x + 1;
	}
	
	public void seDeplacerVersLaGauche() {
		this.x = this.x - 1;
	}
}
