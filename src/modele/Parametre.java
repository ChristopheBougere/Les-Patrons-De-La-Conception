package modele;

/**
 * 
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 *
 */
public class Parametre {
	public int nbManuelles, nbAutomatiques, nbTelepeages;
	public int nbVoitures, nbCamions, nbCaravanes,
	nbBus, nbMotos;
	public int flux;
	public int nbVoies;
	
	public Parametre(int nbManuelles, int nbAutomatiques, int nbTelepeages,
			int pourcentVoitures, int pourcentCamions, int pourcentCaravanes,
			int pourcentBus, int pourcentMotos, int flux) {
		super();
		this.flux = flux;
		this.nbManuelles = nbManuelles;
		this.nbAutomatiques = nbAutomatiques;
		this.nbTelepeages = nbTelepeages;
		nbVoitures = percentToNumber(pourcentVoitures);
		nbCamions = percentToNumber(pourcentCamions);
		nbCaravanes = percentToNumber(pourcentCaravanes);
		nbBus = percentToNumber(pourcentBus);
		nbMotos = percentToNumber(pourcentMotos);
		nbVoies = this.nbManuelles + this.nbAutomatiques + this.nbTelepeages;
	}
	
	/**
	 * 
	 * @param percent Le pourcentage de véhicules
	 * @return
	 */
	private int percentToNumber(int percent) {
		return flux * percent / 100;
	}
	
}
