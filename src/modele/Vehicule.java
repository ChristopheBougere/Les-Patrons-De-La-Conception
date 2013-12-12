package modele;

/**
 * 
 * @author IBARBACHANE Walid
 *
 */
public abstract class Vehicule {

	protected boolean _estPasse=false;
	protected boolean _peutPayer;
	protected int _numeroVoie;
	protected int _typePaiement;
	
	
	public static final int CARTE_PAIEMENT=3;
	public static final int CARTE_ABONNEMENT=2;
	public static final int MONNAIE=1;
	public static final int SPECIAL=0;
	
	
	
	public boolean peutPayer(){
		return _peutPayer;
	}

	public void passerBarriere(){
		_estPasse=true;
	}
	
	public boolean estPasse(){
		return _estPasse;
	}
	
}
