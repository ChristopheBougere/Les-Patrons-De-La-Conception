package modele;

/**
 * 
 * @author IBARBACHANE Walid
 *
 */
public class GrandVehicule extends Vehicule{
	
	
	public GrandVehicule(boolean peutPayer,int numeroVoie,int typePaiement) throws PaiementException{
		if(typePaiement>3 || typePaiement<0)
			throw new PaiementException("type non valable");
		_peutPayer=peutPayer;
		_typePaiement=typePaiement;
		_numeroVoie=numeroVoie;
	}

}
