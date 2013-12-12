package modele;

/**
 * 
 * @author IBARBACHANE Walid
 *
 */
public class PetitVehicule extends Vehicule {
	
	
	public PetitVehicule(boolean peutPayer,int numeroVoie,int typePaiement) throws PaiementException{
		if(typePaiement>3 || typePaiement<0)
			throw new PaiementException("type non valable");
		_typePaiement=typePaiement;
		_peutPayer=peutPayer;
		_numeroVoie=numeroVoie;
	}
	
	
}
