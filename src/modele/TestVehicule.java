package modele;

/**
 * 
 * @author IBARBACHANE Walid
 *
 */
public class TestVehicule {

	public static void main(String [] args) throws PaiementException{
		
			GrandVehicule Camion=new GrandVehicule(true,20,2);
			Vehicule VoitureDePolice=new VehiculeSpecial(true,10);
			Vehicule voiture = new PetitVehicule(true,5,3);
			
			if (voiture.estPasse())
				System.out.println(" :-D");
			else
				System.out.println(" :-'( ");
			
			voiture.passerBarriere();

			if (voiture.estPasse())
				System.out.println(" :-D");
			else
				System.out.println(" :-'( ");
			
	}
}
