package graphTheory.ui.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class GraphPanel extends JPanel { static final long serialVersionUID = 1L;

	public GraphPanel() {
		Graph<Integer, String> graph = new SparseMultigraph<Integer, String>();
		
		graph.addVertex((Integer)1);
		graph.addVertex((Integer)2);
		graph.addVertex((Integer)3);
		graph.addEdge("Edge-A", 1, 2); 
		graph.addEdge("Edge-B", 2, 3);
		
		
		Layout<Integer, String> layout = new CircleLayout<Integer, String>(graph);
		layout.setSize(new Dimension(300,300));
		BasicVisualizationServer<Integer, String> vv = new BasicVisualizationServer<Integer, String>(layout);
		vv.setPreferredSize(new Dimension(350,350));
		this.add(vv);
		
		
		
	}
}
