package rpn.process.utils;

public class Operande extends Element {
	
	@Override
	public String toString() {
		return "Operande [valeur=" + valeur + "]";
	}


	private Double valeur;
	
	/**
	 * 
	 * @param valeur
	 */
	public Operande (Double valeur){
		this.valeur=valeur;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Double getValeur() {
		return valeur;
	}
	
	public String getString(){
		return valeur.toString();
	}

}
