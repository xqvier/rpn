package rpn.main;

import java.util.Queue;

import rpn.process.Calcul;
import rpn.process.ReversePoloneseNotation;

public class MainProcess extends Thread {

	@Override
	public void run() {
		Queue<rpn.process.Element> list;
		String grosseVerge = "56*((6+2)/(8-7)*2^3)";
		list = rpn.process.Decoupe.decoupe(grosseVerge);
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
