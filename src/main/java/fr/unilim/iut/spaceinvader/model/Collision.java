package fr.unilim.iut.spaceinvader.model;

public class Collision {

	public static boolean detecterCollision(Sprite sprite1, Sprite sprite2){
		if (collisionBasEtHaut(sprite1, sprite2)) {
				if (collisionDroiteEtGauche(sprite1, sprite2)) {
					return true;
				}
		}
		return false;
	}

	private static boolean collisionDroiteEtGauche(Sprite sprite1, Sprite sprite2) {
		return sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite()
			&& sprite1.abscisseLaPlusADroite() >= sprite2.abscisseLaPlusAGauche()
			|| sprite1.abscisseLaPlusAGauche() <= sprite2.abscisseLaPlusADroite()
					&& sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche();
	}

	private static boolean collisionBasEtHaut(Sprite sprite1, Sprite sprite2) {
		return sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute()
				&& sprite1.ordonneeLaPlusBasse() >= sprite2.ordonneeLaPlusBasse()
				|| sprite1.ordonneeLaPlusHaute() <= sprite2.ordonneeLaPlusHaute()
						&& sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse();
	}
}
