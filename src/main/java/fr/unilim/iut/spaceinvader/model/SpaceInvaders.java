package fr.unilim.iut.spaceinvader.model;

import fr.unilim.iut.spaceinvader.moteurjeu.Commande;
import fr.unilim.iut.spaceinvader.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvader.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvader.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvader.utils.MissileException;

public class SpaceInvaders implements Jeu {
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	Missile missile;

	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(y, x))
			marque = Constante.MARQUE_VAISSEAU;
		else if (this.aUnMissileQuiOccupeLaPosition(y, x))
				marque = Constante.MARQUE_MISSILE;
		else marque = Constante.MARQUE_VIDE;
		return marque;
	}

	private boolean aUnMissileQuiOccupeLaPosition(int y, int x) {
		return this.aUnMissile() && missile.occupeLaPosition(x, y);
	}

	public boolean aUnMissile() {
		return missile != null;
	}
	
	public Missile recupererMissile() {
		return this.missile;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return vaisseau != null;
	}

	public Vaisseau recupererVaisseau() {
		return this.vaisseau;
	}

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	private boolean positionVaisseauInferieurLongueurJeu() {
		return vaisseau.abscisseLaPlusAGauche() < (longueur - 1);
	}

	private boolean positionVaisseauSuperieurLongueurJeu() {
		return vaisseau.abscisseLaPlusAGauche() > 0;
	}

	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
			}
		}

	}

	public void deplacerVaisseauVersLaGauche() {
		if (0 < vaisseau.abscisseLaPlusAGauche())
			vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
			vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
		}
	}

	public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {

		int x = position.abscisse();
		int y = position.ordonnee();

		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		int longueurVaisseau = dimension.longueur();
		int hauteurVaisseau = dimension.hauteur();

		if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

		vaisseau = new Vaisseau(dimension, position, vitesse);
	}

	@Override
	public String toString() {
		return recupererEspaceJeuDansChaineASCII();
	}

	// INTERFACE GRAPHIQUE //

	public void evoluer(Commande commandeUser) {

		if (commandeUser.gauche) {
			deplacerVaisseauVersLaGauche();
		}

		if (commandeUser.droite) {
			deplacerVaisseauVersLaDroite();
		}
		if(commandeUser.tirer) {
			Dimension dimensionMissile = new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR);
			tirerUnMissile(dimensionMissile, Constante.MISSILE_VITESSE);
			
		}
		if(this.aUnMissile()) {
			this.missile.deplacerVersLeHaut();
		}
			
		
		

	}

	public boolean etreFini() {
		return false;
	}

	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur / 2, this.hauteur - 1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
	}

    public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		
		   if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
							
		   this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
      }

	public void deplacerMissile() {
		if(this.missile.ordonneeLaPlusHaute() + Direction.HAUT_ECRAN.valeur() <= 0) {
			this.missile = null;
		}else {
			this.missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		}
		
	}
   
}
