package rpn.utility;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoupe {

	public static Queue<Element> decoupe(String pEquation) {
		String equation = pEquation;
		LinkedList<Element> equationTraitee = new LinkedList<Element>();
		Pattern pattern = Pattern.compile("[0-9]+|[-+*/]|[()]");
		Matcher matcher = pattern.matcher(equation);
		/*
		 * Tant que l'on trouve des "morceaux" de notre �quation, on instancie
		 * en op�rateur ou en op�rande Ces Operateur et Operande sont ensuite
		 * stock� dans une file, c'est sur cette file que l'on va appliquer
		 * l'algorithme de transformation en notation polonaise invers�e
		 */
		while (matcher.find())
			System.out.println("" + matcher.group(0));
		if (Decoupe.isNumber(matcher.group(0))) {
			equationTraitee.add(new Operande(Double.valueOf(matcher.group(0))));
		} else {
			equationTraitee.add(new Operateur(matcher.group(0)));
		}
		return equationTraitee;
	}

	/**
	 * Controle si l'argument est un nombre ou non
	 * 
	 * @param string
	 *            String dont on veut v�rifier si elle contient un nombre. La
	 *            String peut contenir un point (Double)
	 * @return true si la chaine est un nombre false sinon
	 */
	private static boolean isNumber(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)) && string.charAt(i) != '.')
				return false;
		}
		return true;
	}

}
