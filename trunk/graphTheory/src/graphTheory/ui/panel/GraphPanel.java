package graphTheory.ui.panel;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import graphTheory.process.pojo.Matrice;
import graphTheory.process.pojo.MatriceCase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.apache.commons.collections15.Transformer;

public class GraphPanel extends JPanel {
	static final long serialVersionUID = 1L;

	private Matrice matrice;

	private ArrayList<Integer> levels;

	private static final Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN,
			Color.PINK, Color.ORANGE, Color.YELLOW };

	public GraphPanel() {

	}

	public void drawGraph(Matrice pMatrice) {
		matrice = pMatrice;
		matrice.addObservateur(new IObservateurMatrice() {

			@Override
			public void update(Matrice matrice) {
				myDraw();
			}
		});
		myDraw();
	}

	private void myDraw() {
		this.removeAll();
		Graph<String, String> graph = createGraph();

		Layout<String, String> layout = new CircleLayout<String, String>(
				graph);
		layout.setSize(new Dimension(300, 300));
		BasicVisualizationServer<String, String> vv = new BasicVisualizationServer<String, String>(
				layout);
		vv.setPreferredSize(new Dimension(350, 350));		
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
		
		
		if(levels!=null){
			Transformer<String,Paint> vertexPaint = new Transformer<String, Paint>() {

				@Override
				public Paint transform(String arg0) {
					return COLORS[levels.get(arg0.charAt(0) - 'A')];
				}
			}; 
	        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		}
		
		
		
		this.add(vv);
		this.validate();
	}

	private Graph<String, String> createGraph() {
		Graph<String, String> graph = new DirectedOrderedSparseMultigraph<String, String>();
		for (int i = 1; i <= matrice.getSize(); i++) {
			graph.addVertex(Character.toString((char) ('A' - 1 + i)));
			i++;
		}
		int i = 1;
		for (ArrayList<MatriceCase> column : matrice.getCaseList()) {
			int j = 1;
			for (MatriceCase casee : column) {
				if (casee.getValue() == 1) {
					graph.addEdge(i + " " + j, (Character.toString((char) ('A' - 1 + i))), (Character.toString((char) ('A' - 1 + j))));
				}
				j++;
			}
			i++;
		}
		return graph;
	}

	public void drawGraphByLevel(Matrice pMatrice, ArrayList<Integer> pLevels) {
		matrice = pMatrice;
		levels = pLevels;
		drawGraph(matrice);
	}
}
