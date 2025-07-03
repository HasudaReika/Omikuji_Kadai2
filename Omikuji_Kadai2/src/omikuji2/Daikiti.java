package omikuji2;

public class Daikiti extends Omikuji{

	
	public Daikiti(String negaigoto, String akinai, String gakumon) {
        setUnsei(); 
        setNegaigoto(negaigoto);
        setAkinai(akinai);
        setGakumon(gakumon);
    }

	@Override
	public void setUnsei() {
		this.unsei = "大吉";
		
	}


}
