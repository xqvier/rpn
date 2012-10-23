import java.util.Queue;
import java.util.Stack;

import rpn.utility.Element;
import rpn.utility.Operande;
import rpn.utility.Operateur;

public class Calcul {

	private Queue<Element> file;

	private Stack<Element> processStack;

	public Calcul(Queue<Element> pFile) {
		file = pFile;
		processStack = new Stack<Element>();
	}

	public double process() {
		Element currentElement;
		while (!file.isEmpty()) {
			currentElement = file.poll();
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
				}
			}
		}

		return ((Operande) processStack.pop()).getValeur();
	}

}
