import java.sql.Date;


public class Rapport {
	private int _typeVehicule; 
	private int _numeroVole;
	private Date _heure; 
	private int _sommePercue; 
	
	public void faireRapport(int p_typeVehicule,int p_numeroVole,Date p_heure,int p_sommePercue){
		_typeVehicule=p_typeVehicule;
		_numeroVole=p_numeroVole;
		_heure=p_heure;
		_sommePercue=p_sommePercue;
	}
}
