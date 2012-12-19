package rpn.process;

import rpn.main.Params;
import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;
import rpn.process.utils.Operande;
import rpn.process.utils.Operateur;



public class ReversePoloneseNotation {

	private  MyQueue<Element> fileEntree;
	private  MyQueue<Element> fileSortie;
	private  MyStack<Element> pileOperateur;
	private  MyStack<Element> poubelle;


	
	
public ReversePoloneseNotation(MyQueue<Element> fileEntree,
			MyQueue<Element> fileSortie, MyStack<Element> pileOperateur,
			MyStack<Element> poubelle) {
		this.fileEntree = fileEntree;
		this.fileSortie = fileSortie;
		this.pileOperateur = pileOperateur;
		this.poubelle = poubelle;
	}





	public void run() throws InterruptedException {
		
		fileSortie.clear();
		pileOperateur.clear();
		poubelle.clear();
		
		
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
									&& (((Operateur) pileOperateur.getLast()).getValeur().equals(
											"+") || ((Operateur) pileOperateur
											.getLast()).getValeur().equals(
											"-")) || ((Operateur) pileOperateur
									.getLast()).getValeur().equals("("))
							|| (((Operateur) currentToken).getValeur()
									.equals("^"))
							|| (((Operateur) currentToken).getValeur().equals(
									"/")
									&& (((Operateur) pileOperateur
											.getLast()).getValeur().equals(
											"+") || ((Operateur) pileOperateur
											.getLast()).getValeur().equals(
											"-")) || ((Operateur) pileOperateur
									.getLast()).getValeur().equals("("))
							|| (((Operateur) currentToken).getValeur().equals(
									"(") && (((Operateur) pileOperateur
									.getLast()).getValeur().equals("+") || ((Operateur) pileOperateur
									.getLast()).getValeur().equals("-")))
							|| (((Operateur) currentToken).getValeur().equals(
									"+") && (((Operateur) pileOperateur
									.getLast()).getValeur().equals("(")))
							|| (((Operateur) currentToken).getValeur().equals(
									"-") && (((Operateur) pileOperateur
									.getLast()).getValeur().equals("(")))) {
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
		
	}

}
