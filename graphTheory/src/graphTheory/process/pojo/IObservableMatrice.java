package graphTheory.process.pojo;

import graphTheory.ui.panel.IObservateurMatrice;

public interface IObservableMatrice {
	void addObservateur(IObservateurMatrice obs);
	void updateObservateur();
}
