package omikuji2;

import java.io.Serializable;

public class Daikichi extends Omikuji implements Serializable{

	
	public Daikichi(String negaigoto, String akinai, String gakumon) {
        setUnsei(); 
        setNegaigoto(negaigoto);
        setAkinai(akinai);
        setGakumon(gakumon);
    }

	@Override
	public void setUnsei() {
		this.unsei = "大吉";
		
	}


}
