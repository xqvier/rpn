package rpn.process;

import java.util.Stack;

import rpn.ui.PilePanel;

public class MyStack<T> extends Stack<T> {

	private static final long serialVersionUID = 1L;
	
	
	PilePanel panel = null;
	public void setPanel(PilePanel pPanel){
		panel = pPanel;
	}
	@Override
	public synchronized boolean add(T e) {
		
		boolean result = super.add(e);
		panel.changed();
		return result;
	}
	
	@Override
	public synchronized T pop() {
		T result =  super.pop();
		panel.changed();
		return result;		
	}
}
