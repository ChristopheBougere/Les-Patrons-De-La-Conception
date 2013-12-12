
public class BarrierePhysique {
	private boolean _estLevee;
	
	public BarrierePhysique(){
	_estLevee=false;
	}

	public void leverBarriere(){
		_estLevee=true;
	}
	
	public void abaisserBarriere(){
		_estLevee=false;
	}
	
	public boolean estLevee(){
		return _estLevee;
	}
}
