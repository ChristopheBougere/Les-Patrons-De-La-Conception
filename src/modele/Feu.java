
public class Feu {
	private boolean _estRouge;
	
	public Feu(){
		_estRouge=true;
	}
	
	public Boolean feuRouge(){
		return _estRouge;
	}
	
	public Boolean feuVert(){
		return !_estRouge;
	}
}
