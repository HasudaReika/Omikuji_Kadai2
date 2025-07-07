package omikuji2;

import java.io.Serializable;

public class Shoukiti extends Omikuji implements Serializable {

	public Shoukiti(String negaigoto, String akinai, String gakumon) {
		setUnsei();
		setNegaigoto(negaigoto);
		setAkinai(akinai);
		setGakumon(gakumon);
	}

	@Override
	public void setUnsei() {
		this.unsei = "小吉";
	}

}
