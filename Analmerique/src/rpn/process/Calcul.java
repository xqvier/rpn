package rpn.process;

import rpn.process.utils.Element;
import rpn.process.utils.MyDouble;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;
import rpn.process.utils.Operande;
import rpn.process.utils.Operateur;


public class Calcul extends Thread{

	private MyStack<Element> processStack;
	
	private MyQueue<Element> fileSortie;

	private MyDouble resultat;
	
	public Calcul(MyStack<Element> pPileProcess, MyQueue<Element> pFileSortie, MyDouble pResultat) {
		processStack = pPileProcess;
		fileSortie = pFileSortie;
		resultat = pResultat;
	}
	

	public void run() {

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
				}else if (((Operateur) currentElement).getValeur().equals("sin")){
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.sin(op1.getValeur())));
				}else if (((Operateur) currentElement).getValeur().equals("cos")){
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.cos(op1.getValeur())));
				}else if (((Operateur) currentElement).getValeur().equals("log")){
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.log(op1.getValeur())));
				}else if (((Operateur) currentElement).getValeur().equals("ln")){
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.log10(op1.getValeur())));
				}else if (((Operateur) currentElement).getValeur().equals("e")){
					op1 = (Operande) processStack.pop();
					processStack.push(new Operande(Math.exp(op1.getValeur())));
				}
			}
		}

		resultat.setValue(((Operande) processStack.pop()).getValeur());
	}


	public MyDouble getResultat() {
		return resultat;
	}


	public void setResultat(MyDouble resultat) {
		this.resultat = resultat;
	}

}
