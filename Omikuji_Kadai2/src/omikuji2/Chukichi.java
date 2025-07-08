package omikuji2;

import java.io.Serializable;

public class Chukichi extends Omikuji implements Serializable {

	public Chukichi(String negaigoto, String akinai, String gakumon) {
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
