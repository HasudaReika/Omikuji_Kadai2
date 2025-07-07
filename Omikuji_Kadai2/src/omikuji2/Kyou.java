package omikuji2;

import java.io.Serializable;

public class Kyou extends Omikuji implements Serializable {
	public Kyou(String negaigoto, String akinai, String gakumon) {
		setUnsei();
		setNegaigoto(negaigoto);
		setAkinai(akinai);
		setGakumon(gakumon);
	}

	@Override
	public void setUnsei() {
		this.unsei = "凶";
	}

}
