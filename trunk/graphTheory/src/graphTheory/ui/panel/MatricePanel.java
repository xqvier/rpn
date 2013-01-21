package graphTheory.ui.panel;

import graphTheory.process.pojo.Matrice;
import graphTheory.process.pojo.MatriceCase;
import graphTheory.ui.param.Params;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatricePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Matrice matrice;
	
	private ArrayList<ArrayList<JTextField>> listField;
	
	public MatricePanel() {
	}
	
	public void setMatrice(Matrice pMatrice) {
		matrice = pMatrice;
		matrice.addObservateur(new IObservateurMatrice() {
			
			@Override
			public void update(Matrice matrice) {
				drawMatrice();				
			}
		});
		drawMatrice();

		System.out.println(matrice);

	}

	private void drawMatrice() {
		this.removeAll();
		int size = matrice.getSize() + 1;
		this.setPreferredSize(new Dimension(size * Params.SIZE_CASE_MATRICE, size * Params.SIZE_CASE_MATRICE));
		this.setLayout(new GridLayout(matrice.getSize() + 1,
				matrice.getSize() + 1));
		this.removeAll();
		JTextField textArea;
		Character letter = 'A';
		textArea = new JTextField();
		textArea.setHorizontalAlignment(JTextField.CENTER);
		textArea.setEditable(false);
		this.add(textArea);
		listField = new ArrayList<ArrayList<JTextField>>();
		for (int i = 0; i < matrice.getSize(); i++) {

			textArea = new JTextField(letter.toString());
			textArea.setHorizontalAlignment(JTextField.CENTER);
			textArea.setFont(new Font(null, 0, 25));
			textArea.setEditable(false);
			this.add(textArea);
			letter++;
		}

		letter = 'A';
		for (ArrayList<MatriceCase> column : matrice.getCaseList()) {
			textArea = new JTextField(letter.toString());
			textArea.setHorizontalAlignment(JTextField.CENTER);
			textArea.setFont(new Font(null, 0, 25));
			textArea.setEditable(false);
			this.add(textArea);
			
			ArrayList<JTextField> columnTextField = new ArrayList<JTextField>();
			listField.add(columnTextField);
			for (MatriceCase casee : column) {
				final JTextField textFieldd = new JTextField(Integer.toString(casee.getValue()));
				textFieldd.setFont(new Font(null, 0, 25));
				textFieldd.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						textFieldd.selectAll();						
					}
				});
				textFieldd.setHorizontalAlignment(JTextField.CENTER);
				if (!casee.isEnabled()) {
					textFieldd.setBackground(Color.RED);
				}
				columnTextField.add(textFieldd);
				this.add(textFieldd);
			}
			letter++;
		}
		this.validate();
	}
	
	public Matrice getMatrice(){
		int i = 0;
		for(ArrayList<MatriceCase> column : matrice.getCaseList()){
			int j = 0;
			for(MatriceCase casee : column){
				Integer value = Integer.valueOf(listField.get(i).get(j).getText());
				if(value != 0 && value != 1){
					throw new NumberFormatException();
				}
				casee.setValue(value);
				j++;
			}
			i++;
		}

		System.out.println(matrice);
		return matrice;
	}
	
	
}
