package omikuji2;

public class Suekiti extends Omikuji implements Fortune {
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
