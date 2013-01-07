package rpn.ui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rpn.main.Params;
import rpn.process.utils.Element;
import rpn.process.utils.MyDouble;
import rpn.process.utils.MyQueue;
import rpn.process.utils.MyStack;
import rpn.ui.button.CalculButton;
import rpn.ui.button.DecoupeButton;
import rpn.ui.button.MinusButton;
import rpn.ui.button.PlusButton;
import rpn.ui.button.ProcessRPNButton;
import rpn.ui.button.StepByStepActivateButton;
import rpn.ui.button.StepByStepNextButton;
import rpn.ui.field.MyResultatField;

public class CommandPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandPanel(MyQueue<Element> fileEntree, MyQueue<Element> fileSortie, MyStack<Element> pileProcess, MyStack<Element> pilePoubelle, MyDouble pResultat) {
		this.setLayout(new BorderLayout());
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.setPreferredSize(new Dimension(500,100));
		

		JPanel vitessePanel = new JPanel();
		vitessePanel.setLayout(new GridLayout(1, 3));

		JTextField vitesse = new JTextField(Double.toString(Params.WAIT_TIME/1000.0));
		vitesse.setHorizontalAlignment(JTextField.CENTER);
		vitesse.setPreferredSize(new Dimension(50,50));
		
		JButton minus = new MinusButton(vitesse);
		minus.setPreferredSize(new Dimension(50,50));
		
		JButton plus = new PlusButton(vitesse);
		plus.setPreferredSize(new Dimension(50,50));
		
		vitessePanel.add(minus);
		vitessePanel.add(vitesse);
		vitessePanel.add(plus);
		

		inputPanel.add(vitessePanel, BorderLayout.NORTH);
		
		
		
		
		
		
		JTextField calculField = new JTextField();
		calculField.setHorizontalAlignment(JTextField.CENTER);
		calculField.setPreferredSize(new Dimension(500,50));
		
		inputPanel.add(calculField,BorderLayout.CENTER);

		this.add(inputPanel, BorderLayout.NORTH);
		
		
		MyResultatField resultatField = new MyResultatField(pResultat);
		resultatField.setHorizontalAlignment(JTextField.CENTER);
		resultatField.setPreferredSize(new Dimension(500,50));
		
		this.add(resultatField, BorderLayout.SOUTH);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 3));
		
		JButton decoupe = new DecoupeButton(fileEntree, calculField, "Découpe");
		centerPanel.add(decoupe);
		
		JButton traitement = new ProcessRPNButton(fileEntree,fileSortie,pileProcess, pilePoubelle, "Traitement RPN");
		centerPanel.add(traitement);
		
		JButton calcul = new CalculButton(fileSortie, pileProcess,pResultat, resultatField,  "Calcul");
		centerPanel.add(calcul);
		
		
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		
		// stepBystepPanel
		JPanel stepByStepPanel = new JPanel();
		stepByStepPanel.setPreferredSize(new Dimension(500,50));
		stepByStepPanel.setLayout(new GridLayout(1, 2));
		
		JButton activateStepByStep = new StepByStepActivateButton();
		stepByStepPanel.add(activateStepByStep);
		
		JButton nextStepByStep = new StepByStepNextButton();
		stepByStepPanel.add(nextStepByStep);
		
		centerPanel.add(stepByStepPanel);
		
		
		
		
		
	}
	
}
