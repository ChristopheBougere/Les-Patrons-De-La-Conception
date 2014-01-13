package modele;

import java.util.Random;

public class BarrierePhysique {
	private boolean _estLevee;
	private final int _alea2 = 50;
	
	public BarrierePhysique(){
		_estLevee = false;
	}

	public void leverBarriere(){
		_estLevee = true;
	}
	
	public void abaisserBarriere(){
		_estLevee = false;
	}
	
	public boolean estLevee(){
		return _estLevee;
	}
	
	public boolean barriereLevee(){
		Random rand = new Random();
		return rand.nextInt(_alea2) + 1 == _alea2;
	}
}
