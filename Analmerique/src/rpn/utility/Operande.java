package rpn.utility;

public class Operande extends Element {
	
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
}
