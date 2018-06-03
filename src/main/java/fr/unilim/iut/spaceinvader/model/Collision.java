package fr.unilim.iut.spaceinvader.model;

public class Collision {

	public static boolean detecterCollision(Sprite sprite1, Sprite sprite2){
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute()
				&& sprite1.ordonneeLaPlusBasse() >= sprite2.ordonneeLaPlusBasse()
				|| sprite1.ordonneeLaPlusHaute() <= sprite2.ordonneeLaPlusHaute()
						&& sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse()) {

				if (sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite()
					&& sprite1.abscisseLaPlusADroite() >= sprite2.abscisseLaPlusAGauche()
					|| sprite1.abscisseLaPlusAGauche() <= sprite2.abscisseLaPlusADroite()
							&& sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche()) {
					return true;
				}
		}
		return false;
	}
}
