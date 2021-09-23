package model;
import application.GlobalVar;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class LinkedList extends Datatype{
	public LinkedList() {

	}
	
	private double setOffsetX() {
		return 25+(this.nodelist.size()-1)*(GlobalVar.LABEL_WIDTH+25);
	}
	private double setOffsetX(double i) {
		return i;
	}
	private double setOffsetY(Double displayHeight,double d) {
		return displayHeight*d-GlobalVar.LABEL_HEIGHT/2;
	}
	
	public void addFirst(Node node) {
		nodelist.addFirst(node);
	}
	
	@Override
	public void addNode(Node node) {
		Node newNode = new Node();
		nodelist.add(newNode);
	}
	
	@Override
	public void removeNode(Node node) {
		nodelist.remove(node);
	}
	
	@Override
	public Node findNode(int d) {
		for (int i = 0 ; i < nodelist.size() ; i++) {
			tmp = nodelist.get(i);
			if (tmp.getData() == d) return tmp;
		}
		return null;
	}
	
	private int findIndexNode(int d) {
		for (int i = 0 ; i < nodelist.size() ; i++) {
			tmp = nodelist.get(i);
			if (tmp.getData() == d) return i;
		}
		return -1;
	}
	
	public int findIndexOfNode(int d) {
		return findIndexNode(d);
	}

	@Override
	public SequentialTransition addAni(Node node, double displayWidth, double displayHeight) {
		
		SequentialTransition st = new SequentialTransition();
		
		TranslateTransition moveX = new TranslateTransition();
		moveX.setDuration(Duration.millis(900));
		moveX.setNode(node.getLabel());
		moveX.setToX(setOffsetX());
		moveX.setAutoReverse(false);
		
		TranslateTransition moveY = new TranslateTransition();
		moveY.setDuration(Duration.millis(900));
		moveY.setNode(node.getLabel());
		moveY.setToY(setOffsetY(displayHeight,0.5));
		moveY.setAutoReverse(false);
		
		st.getChildren().addAll(moveX,moveY);
		return st;
	}
	public SequentialTransition AddAni2(Node node, double displayWidth, double displayHeight) {
		
		SequentialTransition st = new SequentialTransition();
		
		TranslateTransition moveX = new TranslateTransition();
		moveX.setDuration(Duration.millis(900));
		moveX.setNode(node.getLabel());
		moveX.setToX(setOffsetX(displayWidth));
		moveX.setAutoReverse(false);
		
		TranslateTransition moveY = new TranslateTransition();
		moveY.setDuration(Duration.millis(900));
		moveY.setNode(node.getLabel());
		moveY.setToY(setOffsetY(displayHeight,0.5));
		moveY.setAutoReverse(false);
		
		st.getChildren().addAll(moveX,moveY);
		return st;
	}
	public Animation fillBackground(Node node, Color c) {
		Animation animation = new Transition() {
	        {
	            setCycleDuration(Duration.millis(300));
	        }
	        @Override
	        protected void interpolate(double frac) {
	            node.getLabel().setBackground(new Background(new BackgroundFill(c, null, null)));
	        }
	    };
	    return animation;
	}
}
