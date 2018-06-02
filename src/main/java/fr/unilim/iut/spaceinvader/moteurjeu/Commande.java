package fr.unilim.iut.spaceinvader.moteurjeu;

/**
 * permet de representer une commande de l'utilisateur
 * 
 * @author vthomas
 *
 */
public class Commande {

	/**
	 * boolean representant la commande de l'utilisateur
	 */
	public boolean gauche;
	public boolean droite;
	public boolean haut;
	public boolean bas;
	public boolean tirer;
	
	public Commande()
	{
		
	}
	
	public Commande(Commande commandeACopier)
	{
		this.bas=commandeACopier.bas;
		this.haut=commandeACopier.haut;
		this.gauche=commandeACopier.gauche;
		this.droite=commandeACopier.droite;	
		this.tirer=commandeACopier.tirer;
	}
	
}
