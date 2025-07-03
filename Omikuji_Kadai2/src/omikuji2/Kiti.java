package omikuji2;

public class Kiti extends Omikuji implements Fortune{
	public Kiti (String negaigoto, String akinai, String gakumon) {
        setUnsei(); 
        setNegaigoto(negaigoto);
        setAkinai(akinai);
        setGakumon(gakumon);
    }


	@Override
	public void setUnsei() {
		this.unsei = "吉";		
	}

}
