package omikuji2;

import java.io.Serializable;

public class Kiti extends Omikuji implements Serializable{
	public Kiti (String negaigoto, String akinai, String gakumon) {
        setUnsei(); 
        setNegaigoto(negaigoto);
        setAkinai(akinai);
        setGakumon(gakumon);
    }


	@Override
	public void setUnsei() {
		this.unsei = "吉";		
	}

}
