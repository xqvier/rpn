package rpn.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;
import rpn.process.utils.Operande;
import rpn.process.utils.Operateur;

public class Decoupe extends Thread{
	

	private MyQueue<Element> equationTraitee;
	
	private String equation; 
	
	public Decoupe(MyQueue<Element> fileEntree,String pEquation){
		equationTraitee = fileEntree;
		setEquation(pEquation);
	}

	public void run() {
		String temp;
		equationTraitee.clear();
		Pattern pattern = Pattern.compile("[0-9]+|[-+*/]|[\\^()]");
		Matcher matcher = pattern.matcher(equation);
		/*
		 * Tant que l'on trouve des "morceaux" de notre équation, on instancie
		 * en opérateur ou en opérande Ces Operateur et Operande sont ensuite
		 * stocké dans une file, c'est sur cette file que l'on va appliquer
		 * l'algorithme de transformation en notation polonaise inversée
		 */
		while (matcher.find())
		{
			temp = matcher.group(0);
			//System.out.println(temp);
			// TODO yea yea, go tester les nombre negatif ( a partir de la fin si - rencontré suivit d'un - c'est que 
			// c'est un nombre negatif
			if (Decoupe.isNumber(temp)) {
				equationTraitee.add(new Operande(Double.valueOf(temp)));
			} else {
				equationTraitee.add(new Operateur(temp));
			}
			
		}
		
	}

	/**
	 * Controle si l'argument est un nombre ou non
	 * 
	 * @param string
	 *            String dont on veut vérifier si elle contient un nombre. La
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

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

}
