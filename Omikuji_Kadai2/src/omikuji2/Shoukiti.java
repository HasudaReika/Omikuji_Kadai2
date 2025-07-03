package omikuji2;

public class Shoukiti extends Omikuji implements Fortune {

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
