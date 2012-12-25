package rpn.ui.field;

import javax.swing.JTextField;

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
		resultat.addObservateur(new IObservateurList() {
			
			
			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void add(String value) {
				MyResultatField.this.setText(value);
			}
		});
		
	}

	public MyDouble getMyDouble() {
		return resultat;
	}
	
}
