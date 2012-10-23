package rpn.utility;

import java.io.ObjectInputStream.GetField;

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
	
}
