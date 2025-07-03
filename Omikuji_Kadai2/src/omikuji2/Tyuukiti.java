package omikuji2;

public class Tyuukiti extends Omikuji implements Fortune {

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
