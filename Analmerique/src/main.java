import java.util.Queue;

class FirstApp {
	public static void main(String[] args) {

		Queue<rpn.utility.Element> list;
		ReversePoloneseNotation revPoNo;
		String grosseVerge = "56*((6+2)/(8-7)*2^3)";
		Calcul calc;
		list = rpn.utility.Decoupe.decoupe(grosseVerge);
		System.out.println(list);
		revPoNo = new ReversePoloneseNotation(list);
		list = revPoNo.traitement();
		System.out.println(list);
		
		calc = new Calcul(list);
		
		System.out.println(calc.process());

	}
}