package omikuji2;

import java.io.Serializable;

public class Shokichi extends Omikuji implements Serializable {

	public Shokichi(String negaigoto, String akinai, String gakumon) {
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
