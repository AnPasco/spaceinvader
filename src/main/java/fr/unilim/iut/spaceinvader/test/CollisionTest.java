package fr.unilim.iut.spaceinvader.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvader.model.Collision;
import fr.unilim.iut.spaceinvader.model.Dimension;
import fr.unilim.iut.spaceinvader.model.Position;
import fr.unilim.iut.spaceinvader.model.SpaceInvaders;

public class CollisionTest {

	private SpaceInvaders spaceinvaders;

	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
	}

	@Test
	public void test_TirCollisionMissileEnvahisseurSurLaPartieInferieur() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(4, 2), new Position(6, 9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(4, 1), new Position(7, 5), 1);
		spaceinvaders.tirerUnMissile(new Dimension(1, 2), 1);
		spaceinvaders.deplacerMissile();

		assertEquals(
				Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()),
				true);
	}

	@Test
	public void test_TirCollisionMissileEnvahisseurSurLaPartieSuperieur() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(8, 2), new Position(3, 9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 1), new Position(7, 5), 1);
		spaceinvaders.tirerUnMissile(new Dimension(4, 2), 1);
		spaceinvaders.deplacerMissile();

		assertEquals(
				Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()),
				true);
	}

	@Test
	public void test_TirMissilePasDeCollisionAvecEnvahisseur() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(8, 9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 1), new Position(6, 0), 1);
		spaceinvaders.tirerUnMissile(new Dimension(1, 1), 1);
		spaceinvaders.deplacerMissile();

		assertEquals(
				Collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()),
				false);
	}
}
