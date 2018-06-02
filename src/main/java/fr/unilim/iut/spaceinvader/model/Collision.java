package fr.unilim.iut.spaceinvader.model;

public class Collision {
	
	public void Collision() {
		
	}
	
	public static boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		boolean coli = false;
		if(sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse() && sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() ) {
			coli = true;
		}
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusBasse() && sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse()) {
			coli = true;
		}
		
		return coli;
	}
	
	
}
