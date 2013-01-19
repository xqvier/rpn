package graphTheory.process.pojo;

import graphTheory.ui.panel.IObservateurLevels;

public interface IObservableLevels {
	void addObservateur(IObservateurLevels obs);
	void updateObservateur();
}
