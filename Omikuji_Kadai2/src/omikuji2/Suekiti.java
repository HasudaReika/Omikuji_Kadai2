package omikuji2;

import java.io.Serializable;

public class Suekiti extends Omikuji implements Serializable {
	public Suekiti(String negaigoto, String akinai, String gakumon) {
		setUnsei();
		setNegaigoto(negaigoto);
		setAkinai(akinai);
		setGakumon(gakumon);
	}

	@Override
	public void setUnsei() {
		this.unsei = "末吉";
	}

}
