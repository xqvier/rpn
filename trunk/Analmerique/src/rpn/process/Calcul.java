package rpn.process;

import rpn.process.utils.Element;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;
import rpn.process.utils.Operande;
import rpn.process.utils.Operateur;


public class Calcul {

	private MyStack<Element> processStack;
	
	private MyQueue<Element> fileSortie;

	public Calcul(MyStack<Element> pPileProcess, MyQueue<Element> pFileSortie) {
		processStack = pPileProcess;
		fileSortie = pFileSortie;
	}
	

	public double run() {

		Element currentElement;
		while (!fileSortie.isEmpty()) {
			currentElement = fileSortie.poll();
			if (currentElement instanceof Operande) {
				processStack.push(currentElement);
			} else if (currentElement instanceof Operateur) {
				Operande op2;
				Operande op1;
				if (((Operateur) currentElement).getValeur().equals("+")) {
					op2 = (Operande) processStack.pop();
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(op1.getValeur()
							+ op2.getValeur()));
				} else if (((Operateur) currentElement).getValeur().equals("-")) {
					op2 = (Operande) processStack.pop();
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(op1.getValeur()
							- op2.getValeur()));
				} else if (((Operateur) currentElement).getValeur().equals("*")) {
					op2 = (Operande) processStack.pop();
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(op1.getValeur()
							* op2.getValeur()));
				} else if (((Operateur) currentElement).getValeur().equals("/")) {
					op2 = (Operande) processStack.pop();
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(op1.getValeur()
							/ op2.getValeur()));
				}else if (((Operateur) currentElement).getValeur().equals("^")) {
					op2 = (Operande) processStack.pop();
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.pow(op1.getValeur(), op2.getValeur())));
				}
			}
		}

		return ((Operande) processStack.pop()).getValeur();
	}

}
