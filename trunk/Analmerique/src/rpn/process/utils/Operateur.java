package rpn.process.utils;

public class Operateur extends Element {

	private int priority;

	@Override
	public String toString() {
		return "Operateur [valeur=" + valeur + "]";
	}

	private String valeur;

	/**
	 * 
	 * @param valeur
	 */
	public Operateur(String valeur) {
		this.valeur = valeur;
		if ("+".equals(valeur)) {
			priority = 0;
		} else if ("-".equals(valeur)) {
			priority = 0;
		} else if ("*".equals(valeur)) {
			priority = 1;
		} else if ("^".equals(valeur)) {
			priority = 1;
		} else if ("/".equals(valeur)) {
			priority = 1;
		} else if ("sin".equals(valeur)) {
			priority = 2;
		} else if ("cos".equals(valeur)) {
			priority = 2;
		} else if ("e".equals(valeur)) {
			priority = 2;
		} else if ("ln".equals(valeur)) {
			priority = 2;
		} else if ("log".equals(valeur)) {
			priority = 2;
		} else if ("(".equals(valeur)) {
			priority = -1;
		} else if (")".equals(valeur)) {
			priority = -1;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getValeur() {
		return valeur;
	}

	public String getString() {
		return valeur;
	}

	/**
	 * Retourne vrai si l'opérateur est prioritaire à celui passé en paramètre
	 * @param op
	 * @return
	 */
	public boolean isPrioritaire(Operateur op){
		return (this.priority > op.priority);
	}
	
}
