package omikuji2;

import java.io.Serializable;

public class Tyuukiti extends Omikuji implements Serializable {

	public Tyuukiti(String negaigoto, String akinai, String gakumon) {
		setUnsei();
		setNegaigoto(negaigoto);
		setAkinai(akinai);
		setGakumon(gakumon);
	}

	@Override
	public void setUnsei() {
		this.unsei = "中吉";
	}

}
