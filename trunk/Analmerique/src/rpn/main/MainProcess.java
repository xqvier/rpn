package rpn.main;

import rpn.process.Calcul;
import rpn.process.Decoupe;
import rpn.process.Element;
import rpn.process.MyQueue;
import rpn.process.ReversePoloneseNotation;

public class MainProcess extends Thread {

	@Override
	public void run() {
		MyQueue<Element> list = ReversePoloneseNotation.getFileSortie();
		String grosseVerge = "56*((6+2)/(8-7)*2^3)";
		Decoupe.decoupe(grosseVerge);
		System.out.println(list);
		try {
			list = ReversePoloneseNotation.traitement(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list);
				
		System.out.println(Calcul.process());
	}

}
