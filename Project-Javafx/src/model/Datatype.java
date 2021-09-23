package model;
import javafx.animation.Animation;  
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
public abstract class Datatype  {
	private static final int MAX_SIZE = 10;
	public java.util.LinkedList<Node> nodelist = new java.util.LinkedList<Node>();
	Node tmp;
			
	public Datatype() {
		// TODO Auto-generated constructor stub
	}

	public java.util.LinkedList<Node> getNodelist() {
		return nodelist;
	}
	
	public abstract SequentialTransition addAni(Node node, double displayWidth, double displayHeight);
	public abstract SequentialTransition AddAni2(Node node, double displayWidth, double displayHeight);
	public abstract Animation fillBackground(Node node, Color c);
	
	public FadeTransition delAni(Node node) {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(500));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setNode(node.getLabel());
		return ft;
	}

	public abstract void addNode(Node node);
	
	public abstract void removeNode(Node node);

	public boolean isEmpty() {
		return (nodelist.size() == 0);
	}
	
	public int sizeDt() {
		return nodelist.size();
	}

	public boolean isFull() {
		return (nodelist.size() == MAX_SIZE);
	}

	public abstract Node findNode(int d);
}
