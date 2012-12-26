package rpn.process.utils;


public class Operateur extends Element {
	
	@Override
	public String toString() {
		return "Operateur [valeur=" + valeur + "]";
	}

	private String valeur;
	
	/**
	 * 
	 * @param valeur
	 */
	public Operateur (String valeur){
		this.valeur=valeur;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getValeur() {
		return valeur;
	}
	
	public String getString(){
		return valeur;
	}

	
}
