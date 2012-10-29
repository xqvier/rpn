package rpn.process;

import java.util.LinkedList;

import rpn.ui.FilePanel;


public class MyQueue<T> extends LinkedList<T> {

	private static final long serialVersionUID = 1L;

	FilePanel panel = null;
	public void setPanel(FilePanel pPanel){
		panel = pPanel;
	}
	
	@Override
	public T poll() {
		T result =  super.poll();
		panel.changed();
		return result;
	}
	
	@Override
	public boolean add(T e) {
		boolean result = super.add(e);
		panel.changed();
		return result;
	}

}
