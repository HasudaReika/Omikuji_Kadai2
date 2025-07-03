package omikuji2;
/*
 * 運勢クラス
 */

public abstract class Omikuji implements Fortune {

	protected String unsei;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;

	public String getUnsei() {
		return unsei;
	}

	public void setUnsei() {
		//個別クラスでセット
	}

	public String getNegaigoto() {
		return negaigoto;
	}

	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	public String getAkinai() {
		return akinai;
	}

	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	public String getGakumon() {
		return gakumon;
	}

	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

	@Override
	public String disp() {
		StringBuilder builer = new StringBuilder();
		builer.append(String.format(DSIP_STR, this.unsei)).append("\n");
		builer.append("願い事：").append(this.negaigoto).append("\n");
		builer.append("商い：").append(this.akinai).append("\n");
		builer.append("学問：").append(this.gakumon);
		return builer.toString();
	}

}
