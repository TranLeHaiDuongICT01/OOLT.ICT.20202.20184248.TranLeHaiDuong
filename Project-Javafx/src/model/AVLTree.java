package model;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class AVLTree extends Datatype implements DSFunc{
    private Node root;     
    /* Constructor */
    public AVLTree(){
        root = null;
    }
    
    /* Function to check if tree is empty */
//    public boolean isEmpty(){
//        return root == null;
//    }
    
    /* Make the tree logically empty */
//    public void makeEmpty(){
//        root = null;
//    }
    
    /* Function to insert data */
    @Override
    public void insert(int d){
        root = insert(d, root);
    }
    
    /* Function to get height of node */ 
    private int height(Node t ){
        return t == null ? -1 : t.getHeight();
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    
    private Node minValueNode(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }
    
    private Node insert(int x, Node t){
        if (t == null)
            t = new Node(x);
        else if (x < t.getData())
        {
            t.setLeft(insert( x, t.getLeft() )) ;
            if( height( t.getLeft()) - height( t.getRight() ) == 2 )
                if( x < t.getLeft().getData() )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x > t.getData() )
        {
        	t.setRight( insert( x, t.getRight() ));
            if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                if( x > t.getRight().getData())
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          ;  
        t.setHeight( max( height( t.getLeft() ), height( t.getRight() ) ) + 1);
        return t;
    }
      
    private Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.getLeft();
        k2.setLeft( k1.getRight()) ;
        k1.setRight( k2);
        k2.setHeight( max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1);
        k1.setHeight( max( height( k1.getLeft() ), k2.getHeight() ) + 1);
        return k1;
    }

    
    private Node rotateWithRightChild(Node k1){
        Node k2 = k1.getRight();
        k1.setRight( k2.getLeft()) ;
        k2.setLeft (k1);
        k1.setHeight ( max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1);
        k2.setHeight (max( height( k2.getRight() ), k1.getHeight() ) + 1);
        return k2;
    }
   
    private Node doubleWithLeftChild(Node k3){
        k3.setLeft( rotateWithRightChild( k3.getLeft() ));
        return rotateWithLeftChild( k3 );
    }
      
    private Node doubleWithRightChild(Node k1){
        k1.setRight( rotateWithLeftChild( k1.getRight() )) ;
        return rotateWithRightChild( k1 );
    }    
    
    public boolean search(int val){
        return search(root, val);
    }
    
    private boolean search(Node r, int val){
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    
    public void preorder(){
        preorder(root);
    }
    
    private void preorder(Node r){
        if (r != null){
        	addNode(r);
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
	
	public Node findNode(int data) {
		for (int i=0;i<nodelist.size();i++) {
			tmp = nodelist.get(i);
			if (tmp.getData() == data) return tmp;
		}
		return null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	@Override
	public void remove(int d){
		deleteNode(root,d);
	}
	
	private Node deleteNode(Node root, int value) {
	        if (root == null)
	            return root;
	        
	        if ( value < root.getData() )
	            root.setLeft( deleteNode(root.getLeft(), value));
	        
	        else if( value > root.getData() )
	            root.setRight( deleteNode(root.getRight(), value));

	        else {
	            if( (root.getLeft() == null) || (root.getRight() == null) ) {

	                Node temp = null;
	                if (root.getLeft() != null)
	                        temp = root.getLeft();
	                else
	                    temp = root.getRight();

	                if(temp == null) {
	                    temp = root;
	                    root = null;
	                }
	                else 
	                    root = temp; 
	            }
	            else {
	            	Node temp = minValueNode(root.getRight());
	                root.setData( temp.getData()) ;
	                root.setRight (deleteNode(root.getRight(), temp.getData()));
	            }
	        }
	        if (root == null)
	            return root;
	        root.setHeight( Math.max(height(root.getLeft()), height(root.getRight())) + 1);
	        int balance = getBalance(root);
	        if (balance > 1 && getBalance(root.getLeft()) >= 0)
	            this.root= rotateWithLeftChild(root);

	        if (balance > 1 && getBalance(root.getLeft()) < 0) {
	            this.root= doubleWithLeftChild(root);
	        }

	        if (balance < -1 && getBalance(root.getRight()) <= 0)
	             this.root=rotateWithRightChild(root);

	        if (balance < -1 && getBalance(root.getRight()) > 0) {
	        	this.root=doubleWithRightChild(root);
	        }
	        return root;
	    }
	 
	private int getBalance(Node N) {
	        if (N == null)
	            return 0;
	        return height(N.getLeft()) - height(N.getRight());
	}
	
	public void drawNotAni(java.util.LinkedList<Node> nodelist1,double offsetX, double offsetY){
		if (nodelist1.size()==0) 
			return;
		java.util.LinkedList<Node> nodelist2 = new java.util.LinkedList<Node>();
		java.util.LinkedList<Node> nodelist3 = new java.util.LinkedList<Node>();
		
		nodelist1.get(0).setLabel(nodelist1.get(0).form());
		
		addAni(nodelist1.get(0),offsetX,offsetY).play();
		
		for (int i = 1 ; i < nodelist1.size() ; i++) {
			
			if(nodelist1.get(i).getData() > nodelist1.get(0).getData()) {
				nodelist2.add(nodelist1.get(i));				
			}else 
				nodelist3.add(nodelist1.get(i));
			
		}
		if(nodelist2.size() == 1 ){
			
			drawNotAni(nodelist2, offsetX + 95, offsetY + 70);
			Arrow  arrowr=new Arrow(offsetX + 100/2, offsetY + 50, offsetX + 140, offsetY + 70);
			nodelist1.get(0).setArrowr(arrowr);
			
		} else if(nodelist2.size() != 0){
			
			drawNotAni(nodelist2, offsetX + 160, offsetY + 110);
		    Arrow  arrowr=new Arrow(offsetX+100/2, offsetY + 50, offsetX + 200, offsetY + 110);
		    nodelist1.get(0).setArrowr(arrowr);
		    
		}
		if(nodelist3.size() == 1){
			
			drawNotAni(nodelist3, offsetX - 95, offsetY + 70);
			Arrow arrowl=new Arrow(offsetX  + 100/2, offsetY+50, offsetX-55, offsetY+70);
			nodelist1.get(0).setArrowl(arrowl);
			
		}else if(nodelist3.size() != 0) {
			
			drawNotAni(nodelist3, offsetX - 160, offsetY + 110);
			Arrow arrowl=new Arrow(offsetX + 100/2, offsetY+50, offsetX-120, offsetY+110);
			nodelist1.get(0).setArrowl(arrowl);
			
		}
	}
	
	@Override
	public SequentialTransition addAni(Node node, double offsetX, double offsetY) {
		
		SequentialTransition st = new SequentialTransition();
		
		TranslateTransition moveX = new TranslateTransition();
		moveX.setDuration(Duration.millis(1));
		moveX.setNode(node.getLabel());
		moveX.setToX(offsetX);
		moveX.setAutoReverse(false);
		
		TranslateTransition moveY = new TranslateTransition();
		moveY.setDuration(Duration.millis(0));
		moveY.setNode(node.getLabel());
		moveY.setToY(offsetY);
		moveY.setAutoReverse(false);
		
		st.getChildren().addAll(moveX,moveY);
		return st;
	}
	
	@Override
	public void addNode(Node node) {
		nodelist.add(node);
	}

	@Override
	public void removeNode(Node node) {
		nodelist.remove(node);
	}

	@Override
	public SequentialTransition AddAni2(Node node, double displayWidth, double displayHeight) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Animation fillBackground(Node node, Color c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

