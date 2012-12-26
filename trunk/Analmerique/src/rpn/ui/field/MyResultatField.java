package rpn.ui.field;

import javax.swing.JTextField;

import rpn.main.IObservateurField;
import rpn.main.IObservateurList;
import rpn.process.utils.MyDouble;

public class MyResultatField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MyDouble resultat;
	
	
	public MyResultatField(MyDouble pResultat) {
		resultat = pResultat;
		resultat.addObservateur(new IObservateurField() {
			
			@Override
			public void update(String value) {
				MyResultatField.this.setText(value);
			}
		});
		
	}

	public MyDouble getMyDouble() {
		return resultat;
	}
	
}
