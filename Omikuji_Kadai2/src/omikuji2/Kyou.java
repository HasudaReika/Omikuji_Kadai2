package omikuji2;

public class Kyou extends Omikuji implements Fortune {
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
