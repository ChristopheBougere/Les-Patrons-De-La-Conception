package modele;

/**
 * @author Sofiane BOUKHEBELT
 * @author Christophe BOUGERE
 * Structure de données qui nous permet de stocker les paramètres 
 * mises en place par l'utilisateur
 */
public class Parametre {
	public int nbManuelles, nbAutomatiques, nbTelepeages;
	public int nbVoitures, nbCamions, nbCaravanes,
	nbBus, nbMotos, nbSpeciaux;
	public int flux;
	public int nbVoies;
	
	
	/**
	 * Constructeur
	 * @param nbManuelles
	 * @param nbAutomatiques
	 * @param nbTelepeages
	 * @param pourcentVoitures
	 * @param pourcentCamions
	 * @param pourcentCaravanes
	 * @param pourcentBus
	 * @param pourcentMotos
	 * @param pourcentSpeciaux
	 * @param flux
	 */
	public Parametre(int nbManuelles, int nbAutomatiques, int nbTelepeages,
			int pourcentVoitures, int pourcentCamions, int pourcentCaravanes,
			int pourcentBus, int pourcentMotos, int pourcentSpeciaux, int flux) {
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
		nbSpeciaux = percentToNumber(pourcentSpeciaux);
		nbVoies = this.nbManuelles + this.nbAutomatiques + this.nbTelepeages;
	}
	
	/**
	 * Obtenir le nombre de voiture à partir du flux
	 * @param percent Le pourcentage de véhicules
	 * @return flux * percent / 100
	 */
	private int percentToNumber(int percent) {
		return flux * percent / 100;
	}
	
}
