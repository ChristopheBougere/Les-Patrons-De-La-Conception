package modele;

public class Parametre {
	public int nbManuelles, nbAutomatiques, nbTelepeages;
	public int pourcentVoitures, pourcentCamions, pourcentCaravanes,
	pourcentBus, pourcentMotos;
	public int flux;
	
	public Parametre(int nbManuelles, int nbAutomatiques, int nbTelepeages,
			int pourcentVoitures, int pourcentCamions, int pourcentCaravanes,
			int pourcentBus, int pourcentMotos, int flux) {
		super();
		this.nbManuelles = nbManuelles;
		this.nbAutomatiques = nbAutomatiques;
		this.nbTelepeages = nbTelepeages;
		this.pourcentVoitures = pourcentVoitures;
		this.pourcentCamions = pourcentCamions;
		this.pourcentCaravanes = pourcentCaravanes;
		this.pourcentBus = pourcentBus;
		this.pourcentMotos = pourcentMotos;
		this.flux = flux;
	}
	
	
}
