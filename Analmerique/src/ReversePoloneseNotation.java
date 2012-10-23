import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import rpn.utility.Element;
import rpn.utility.Operande;
import rpn.utility.Operateur;

public class ReversePoloneseNotation {

	private Queue<Element> fileEntree;
	private Queue<Element> fileSortie;
	private Stack<Element> pileOperateur;
	private Stack<Element> poubelle;

	public ReversePoloneseNotation(Queue<Element> pFileEntree) {

		fileEntree = pFileEntree;
		fileSortie = new LinkedList<Element>();
		pileOperateur = new Stack<Element>();
		poubelle = new Stack<Element>();

	}

	// Commentaire

	public Queue<Element> traitement() {
		Element currentToken;
		Element currentOperator;
		while (!fileEntree.isEmpty()) {
			currentToken = fileEntree.poll();
			if (currentToken instanceof Operande) {
				fileSortie.add(currentToken);
			} else if (currentToken instanceof Operateur) {
				if (((Operateur) currentToken).getValeur().equals("(")) {
					pileOperateur.add(currentToken);
				} else if (((Operateur) currentToken).getValeur().equals(")")) {
					currentOperator = pileOperateur.pop();
					while (!((Operateur) currentOperator).getValeur().equals(
							"(")) {
						fileSortie.add(currentOperator);
						currentOperator = pileOperateur.pop();
					}
					poubelle.add(pileOperateur.pop());
				} else {

					if (pileOperateur.isEmpty()
							|| (((Operateur) currentToken).getValeur().equals(
									"*") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("+") || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("-")))
							|| (((Operateur) currentToken).getValeur().equals(
									"/") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("+") || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("-")))
							|| (((Operateur) currentToken).getValeur().equals(
									"(") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("+") || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("-")))) {
						pileOperateur.add(currentToken);
					} else {
						fileSortie.add(pileOperateur.pop());
						pileOperateur.add(currentToken);
					}
				}

			}
		}
		return fileSortie;
	}
}
