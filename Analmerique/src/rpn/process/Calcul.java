package rpn.process;
import java.util.Queue;
import java.util.Stack;


public class Calcul {

	private static Queue<Element> file = ReversePoloneseNotation.getFileSortie();

	private static Stack<Element> processStack = ReversePoloneseNotation.getPileOperateur();


	public static double process() {

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
