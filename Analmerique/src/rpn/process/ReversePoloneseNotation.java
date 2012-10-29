package rpn.process;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReversePoloneseNotation {

	private static Queue<Element> fileEntree = new LinkedList<Element>();
	private static Queue<Element> fileSortie = new LinkedList<Element>();
	private static MyStack<Element> pileOperateur = new MyStack<Element>();
	private static MyStack<Element> poubelle = new MyStack<Element>();


	// Commentaire

	public static Queue<Element> getFileEntree() {
		return fileEntree;
	}


	public static Queue<Element> getFileSortie() {
		return fileSortie;
	}


	public static MyStack<Element> getPileOperateur() {
		return pileOperateur;
	}


	public static MyStack<Element> getPoubelle() {
		return poubelle;
	}


	public static Queue<Element> traitement(Queue<Element> pFileEntree) throws InterruptedException {
		fileEntree = pFileEntree;
		
		Element currentToken;
		Element currentOperator;
		while (!fileEntree.isEmpty()) {
			Thread.sleep(Params.WAIT_TIME);
			currentToken = fileEntree.poll();
			if (currentToken instanceof Operande) {
				fileSortie.add(currentToken);
			} else if (currentToken instanceof Operateur) {
				if (((Operateur) currentToken).getValeur().equals("(")) {
					pileOperateur.add(currentToken);
				} else if (((Operateur) currentToken).getValeur().equals(")")) {
					poubelle.add(currentToken);
					currentOperator = pileOperateur.pop();
					while (!((Operateur) currentOperator).getValeur().equals(
							"(")) {
						fileSortie.add(currentOperator);
						currentOperator = pileOperateur.pop();
					}
					poubelle.add(currentOperator);
				} else {

					if (pileOperateur.isEmpty()
							|| (((Operateur) currentToken).getValeur().equals(
									"*")
									&& (((Operateur) pileOperateur
											.lastElement()).getValeur().equals(
											"+") || ((Operateur) pileOperateur
											.lastElement()).getValeur().equals(
											"-")) || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("("))
							|| (((Operateur) currentToken).getValeur()
									.equals("^"))
							|| (((Operateur) currentToken).getValeur().equals(
									"/")
									&& (((Operateur) pileOperateur
											.lastElement()).getValeur().equals(
											"+") || ((Operateur) pileOperateur
											.lastElement()).getValeur().equals(
											"-")) || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("("))
							|| (((Operateur) currentToken).getValeur().equals(
									"(") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("+") || ((Operateur) pileOperateur
									.lastElement()).getValeur().equals("-")))
							|| (((Operateur) currentToken).getValeur().equals(
									"+") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("(")))
							|| (((Operateur) currentToken).getValeur().equals(
									"-") && (((Operateur) pileOperateur
									.lastElement()).getValeur().equals("(")))) {
						pileOperateur.add(currentToken);
					} else {
						fileSortie.add(pileOperateur.pop());
						pileOperateur.add(currentToken);
					}
				}

			}
		}
		while (! pileOperateur.isEmpty()){
			fileSortie.add(pileOperateur.pop());
		}
		
		return fileSortie;
	}
}
