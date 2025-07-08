package omikuji2;

import java.io.Serializable;

public class Suekichi extends Omikuji implements Serializable {
	public Suekichi(String negaigoto, String akinai, String gakumon) {
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
