package controllers;

import model.AVLTree;   
import model.Btree;
import model.Datatype;
import model.LinkedList;
import model.Node;
import model.Stack;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Collections;
import application.GlobalVar;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FinalControler {
	@FXML
	AnchorPane displayPane;
	@FXML
	TextField InputField;
	@FXML
	TextField inputIndex;
	@FXML
	Button btnInsert;
	@FXML
	Button btnDelete;
	@FXML
	MenuButton menuInsert, menuDelete;
	@FXML
	Button selectionSort;
	@FXML
	Button bubbleSort;
	Node newnode;
	double offset,fixset;
	int indi = 0;
	int numLL = 0;
	int value;
	Datatype dt;
	SequentialTransition se;
	ParallelTransition para;
	FillTransition ft;
	private void setFixset(double i) { 
		this.fixset = displayPane.getHeight()*i-GlobalVar.LABEL_HEIGHT/2; 
	}
	private void setOffset(double i){
		this.offset = displayPane.getWidth()*i;
	}
	public void initLL() throws InterruptedException {	
		btnInsert.setVisible(false);
		btnDelete.setVisible(false);
		selectionSort.setVisible(true);
		bubbleSort.setVisible(true);
		menuInsert.setVisible(true);
		menuDelete.setVisible(true);
		
		inputIndex.setVisible(true);
		
		dt = new LinkedList();
		this.indi = 1;
		setFixset(0.5);
		displayPane.getChildren().clear();
		dt.nodelist.clear();
	}
	
	public void initStk() {
		btnInsert.setVisible(true);
		btnDelete.setVisible(true);
		selectionSort.setVisible(false);
		bubbleSort.setVisible(false);
		menuInsert.setVisible(false);
		menuDelete.setVisible(false);
		
		inputIndex.setVisible(false);
		
		dt = new Stack();
		this.indi = 2;
		displayPane.getChildren().clear();
		dt.nodelist.clear();
	}

	public void initAvl() {
		selectionSort.setVisible(false);
		bubbleSort.setVisible(false);
		btnInsert.setVisible(true);
		btnDelete.setVisible(true);
		
		menuInsert.setVisible(false);
		menuDelete.setVisible(false);
		
		inputIndex.setVisible(false);
		
		dt = new AVLTree();
    	this.indi = 3;
		setFixset(0.1);
		displayPane.getChildren().clear();
		dt.nodelist.clear();
		dt.isEmpty();
		setOffset(0.5);
		newnode = new Node();
		newnode.setData(10);
		((AVLTree)dt).insert(newnode.getData());
		
		newnode.setData(20);
		((AVLTree)dt).insert(newnode.getData());
		
		newnode.setData(30);
		((AVLTree)dt).insert(newnode.getData());
		
		((AVLTree)dt).preorder();
				
		((AVLTree)dt).drawNotAni(dt.nodelist,offset,fixset);
		for(int i=0;i<dt.nodelist.size();i++) {
			displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
			if(dt.nodelist.get(i).getArrowl()!=null&&dt.nodelist.get(i).getLeft()!=null)
			displayPane.getChildren().add(dt.nodelist.get(i).getArrowl());
			if(dt.nodelist.get(i).getArrowr()!=null&&dt.nodelist.get(i).getRight()!=null)
			displayPane.getChildren().add(dt.nodelist.get(i).getArrowr());
		}		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void initBtree() {
		selectionSort.setVisible(false);
		bubbleSort.setVisible(false);
		btnInsert.setVisible(true);
		btnDelete.setVisible(true);
		
		menuInsert.setVisible(false);
		menuDelete.setVisible(false);
		
		inputIndex.setVisible(false);
		
		dt = new Btree(3);
		this.indi = 4;
		setFixset(0.1);
		displayPane.getChildren().clear();
		dt.nodelist.clear();
		dt.isEmpty();
		setOffset(0.5);
		
		((Btree)dt).insert(20);
		((Btree)dt).insert(40);
		((Btree)dt).insert(10);
		((Btree)dt).insert(3);
		((Btree)dt).insert(8);
		((Btree)dt).insert(29);
		((Btree)dt).insert(12);
		((Btree)dt).insert(39);
		((Btree)dt).insert(9);
		((Btree)dt).insert(25);
		((Btree)dt).insert(2);
		((Btree)dt).insert(59);
		((Btree)dt).insert(7);
		((Btree)dt).insert(6);
	
		((Btree)dt).preorder();		
		((Btree)dt).drawAni(dt.nodelist, offset, fixset);		
		
		for(int i = 0 ; i < dt.nodelist.size(); i++) {
			displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
			if(dt.nodelist.get(i).getArrows() != null && dt.nodelist.get(i).getChild().length != 0){
				displayPane.getChildren().remove(dt.nodelist.get(i).getArrows());
				displayPane.getChildren().addAll(dt.nodelist.get(i).getArrows());
			}			
		}
		
	}
	
	public static boolean isNumeric(String str) { //kiem tra xem co phai la so hay khong
		return str.matches("-?\\d+(\\.\\d+)?"); 
	}
	
	public void insert() {
		switch (indi) {
			case 1:
				break;
			case 2: 
				insertStack();
				break;
			case 3: 
				insertAvlTree();
				break;
			case 4:
				insertBtree();
				break;
			default:
				showError();
				break;
		}
		
	}
	
	private void showError() {
		Alert alert= new Alert(Alert.AlertType.INFORMATION,"You must select a function! please select function.",ButtonType.OK);
		alert.showAndWait()	
		.filter(response -> response == ButtonType.OK)
		.ifPresent(response->alert.close());
		InputField.clear();
	}
	
	//check the number you want to insert or remove
	private boolean checkInputNumber() {
		String checkInput = InputField.getText();
		if(checkInput.equals("")) {
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"You have not entered anything! Please input a number.",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}else if(isNumeric(checkInput) == false){
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"You must enter a number! Please enter again.",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}else if (dt.isFull()) {
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"Stack is full",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}
		
		return true;
	}
	
	//check format of the position that you want to insert or remove
	private boolean checkInputIndex() {
		String checkInputIndex = inputIndex.getText();
		
		if(checkInputIndex.equals("") == true) {
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"You must enter 2 fields completely! Please input again.",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}else if(Integer.parseInt(inputIndex.getText()) > dt.sizeDt()) {
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"Input position exceeds the number of elements in the linked list! Please input again.",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}else if(isNumeric(checkInputIndex) == false){
			Alert alert= new Alert(Alert.AlertType.INFORMATION,"You must enter a number! Please enter again.",ButtonType.OK);
			alert.showAndWait()	
			.filter(response -> response == ButtonType.OK)
			.ifPresent(response->alert.close());
			return false;
		}
		return true;
	}
	
	private void insertStack() {
		if(checkInputNumber() == true){
			int d = Integer.parseInt(InputField.getText());
			newnode = new Node(d);
			dt.addNode(newnode);
			newnode.setLabel(newnode.form());
			displayPane.getChildren().add(newnode.getLabel());
			dt.addAni(newnode,displayPane.getWidth(),displayPane.getHeight()).play();
		}
		InputField.clear();
	}
	
	private void insertAvlTree() {
		if(checkInputNumber() == true) {
			int d = Integer.parseInt(InputField.getText());
			newnode = new Node(d);
			displayPane.getChildren().clear();
			((AVLTree)dt).insert(newnode.getData());
			((AVLTree)dt).nodelist.clear();
			((AVLTree)dt).preorder();
			((AVLTree)dt).drawNotAni(dt.nodelist,offset,fixset);
			for(int i=0;i<dt.nodelist.size();i++) {
				displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
				if(dt.nodelist.get(i).getArrowl()!=null&&dt.nodelist.get(i).getLeft()!=null)
				displayPane.getChildren().add(dt.nodelist.get(i).getArrowl());
				if(dt.nodelist.get(i).getArrowr()!=null&&dt.nodelist.get(i).getRight()!=null)
				displayPane.getChildren().add(dt.nodelist.get(i).getArrowr());
			}
		}
		InputField.clear();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void insertBtree() {
		if(checkInputNumber() == true) {
			int d = Integer.parseInt(InputField.getText());
			displayPane.getChildren().clear();
			((Btree)dt).insert(d);
			((Btree)dt).nodelist.clear();
			((Btree)dt).preorder();
			((Btree)dt).drawAni(dt.nodelist, offset - 50, fixset);
			for(int i = 0 ; i < dt.nodelist.size(); i++) {
				displayPane.getChildren().remove(dt.nodelist.get(i).getLabel());
				displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
				if(dt.nodelist.get(i).getArrows() != null && dt.nodelist.get(i).getChild().length != 0){
					displayPane.getChildren().remove(dt.nodelist.get(i).getArrows());
					displayPane.getChildren().addAll(dt.nodelist.get(i).getArrows());
				}		
			}
		}
		InputField.clear();
	}
	
	public void insertLinkedList() {
		boolean checkIndex = true;
		if(checkInputNumber() == true){
			int d = Integer.parseInt(InputField.getText());
			newnode = new Node(d);
			switch (numLL) {
			case 1:
				dt.nodelist.addFirst(newnode);
				break;
			case 2:
				dt.nodelist.addLast(newnode);
				break;
			case 3:
				if(checkInputIndex() == true) {
					int position = Integer.parseInt(inputIndex.getText());
					dt.nodelist.add(position, newnode);	
				}else {
					checkIndex = false;
				}
				break;
			default:
				break;
			}
			if(checkIndex == true) {
				newnode.setLabel(newnode.form());
				displayPane.getChildren().add(newnode.getLabel());
				fixset = displayPane.getWidth()/2 - GlobalVar.LABEL_WIDTH/2;
				offset= displayPane.getHeight()-(dt.nodelist.size()*(GlobalVar.LABEL_HEIGHT+25));
				dt.addAni(newnode,displayPane.getWidth(),displayPane.getHeight()).play();
				this.reInsertFirst();				
			}
		}
		InputField.clear();
		inputIndex.clear();
		
	}
	public void selectionSorting() throws InterruptedException {
		System.out.println("Start sorting!");
		se = new SequentialTransition();
		se.setRate(2);
		 for (int i = 0; i < dt.getNodelist().size()-1; i++) {
			 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.LIGHTGRAY));
			 se.getChildren().add(dt.AddAni2(dt.getNodelist().get(i),25+i*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()-200));
			 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.YELLOW));
			 int minIndex = i;
			 for (int j = i + 1; j < dt.getNodelist().size(); j++) {
				 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.LIGHTGRAY));
				 se.getChildren().add(dt.AddAni2(dt.getNodelist().get(j),25+j*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()-200));
				 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.YELLOW));
				 if (dt.getNodelist().get(minIndex).getData()<=dt.getNodelist().get(j).getData()){
					 se.getChildren().add(dt.AddAni2(dt.getNodelist().get(j),25+j*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()));
					 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.LIGHTGRAY));
				 }
				 else {
					 se.getChildren().add(dt.AddAni2(dt.getNodelist().get(minIndex),25+minIndex*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()));
					 se.getChildren().add(dt.fillBackground(dt.getNodelist().get(minIndex), Color.LIGHTGRAY));
					 minIndex = j;
				 }
			 }
			para = new ParallelTransition();
			para.getChildren().add(dt.AddAni2(dt.getNodelist().get(i),25+minIndex*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()));
			para.getChildren().add(dt.AddAni2(dt.getNodelist().get(minIndex),25+i*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()));
			se.getChildren().add(para);
			se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.LIGHTGRAY));
			se.getChildren().add(dt.fillBackground(dt.getNodelist().get(minIndex), Color.LIGHTGRAY));
			Collections.swap(dt.getNodelist(), i, minIndex);
	     }
		 se.play();
		 System.out.println("End sorting!");
	}
	public void bubbleSorting() {
		System.out.println("Start sorting!");
		se = new SequentialTransition();
		se.setRate(2);
		for(int i=0;i<dt.getNodelist().size()-1;i++) {
			se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.LIGHTGRAY));
			se.getChildren().add(dt.AddAni2(dt.getNodelist().get(i),25+i*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()-200));
			se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.YELLOW));
			for(int j=i+1;j<dt.getNodelist().size();j++) {
				se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.LIGHTGRAY));
				se.getChildren().add(dt.AddAni2(dt.getNodelist().get(j),25+j*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()-200));
				se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.YELLOW));
				if(dt.getNodelist().get(i).getData()<=dt.getNodelist().get(j).getData()) {
					se.getChildren().add(dt.AddAni2(dt.getNodelist().get(j),25+j*(GlobalVar.LABEL_WIDTH+25),displayPane.getHeight()));
					se.getChildren().add(dt.fillBackground(dt.getNodelist().get(j), Color.LIGHTGRAY));
				}
				else {
					para = new ParallelTransition();
					para.getChildren().add(dt.AddAni2(dt.getNodelist().get(i),25+j*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()));
					para.getChildren().add(dt.AddAni2(dt.getNodelist().get(j),25+i*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()-200));
					se.getChildren().add(para);
					se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.LIGHTGRAY));
					Collections.swap(dt.getNodelist(), i, j);
				}
				
			}
			se.getChildren().add(dt.AddAni2(dt.getNodelist().get(i),25+i*(GlobalVar.LABEL_WIDTH+25), displayPane.getHeight()));
			se.getChildren().add(dt.fillBackground(dt.getNodelist().get(i), Color.LIGHTGRAY));
		}
		se.play();
		System.out.println("End sorting!");
	}
	public void insertHead() {
		numLL = 1;
		insertLinkedList();
	}
	
	public void insertLast() {
		numLL = 2;
		insertLinkedList();
	}
	
	public void insertAnyPosition(){
		numLL = 3;
		insertLinkedList();
	}
	
	public void deleteLinkedList() {
		boolean checkDelete = true;
    	if (dt.isEmpty()) {
    		Alert alert= new Alert(Alert.AlertType.INFORMATION,"LinkedList is empty",ButtonType.OK);
    		alert.showAndWait()
    		.filter(response -> response == ButtonType.OK)
    		.ifPresent(response->alert.close());
    	}else{
    		System.out.println("Delele");
    		switch (numLL) {
			case 1:
				newnode = dt.nodelist.getFirst();
				break;
			case 2:
				newnode = dt.nodelist.getLast();    
				break;
			case 3:
				if(checkInputNumber() == true) {
					int d = Integer.parseInt(InputField.getText());
					int findIndex = ((LinkedList)dt).findIndexOfNode(d);
					if(findIndex == -1) {
						Alert alert= new Alert(Alert.AlertType.INFORMATION,"Can't find node to delete!",ButtonType.OK);
						alert.showAndWait()
						.filter(response -> response == ButtonType.OK)
						.ifPresent(response->alert.close());
						checkDelete = false;
					}else {
						newnode = dt.nodelist.get(findIndex);
					}
				}
				break;
			default:
				break;
			}
    		if(checkDelete == true) {
    			dt.removeNode(newnode);
    			dt.delAni(newnode).setOnFinished(finishHim ->{
    				displayPane.getChildren().remove(newnode.getLabel());
    			}
    					);
    			dt.delAni(newnode).play();
    			this.reArrangeLL();
    		}
    	}
    	InputField.clear();
    	
	}
	
	public void deleteHead() {
		numLL = 1;
		deleteLinkedList();
	}
	
	public void deleteLast() {
		numLL = 2;
		deleteLinkedList();
	}
	
	public void deleteAnyPosition() {
		numLL = 3;
		deleteLinkedList();
	}
	
	public void delete() throws InterruptedException {
		switch (this.indi) {
		case 1:
			break;
		case 2:
			deleteStk();
			break;
		case 3:
			deleteAvlTree();
			break;
		case 4:
			deleteBtree();
			break;
		}
			
	}
	

	private void deleteStk() {
		try {
			newnode = dt.nodelist.getFirst();            
        } catch (ArithmeticException e) {

        }finally {
        	if (dt.isEmpty()) {
        		Alert alert= new Alert(Alert.AlertType.INFORMATION,"Stack is empty",ButtonType.OK);
        		alert.showAndWait()
        		.filter(response -> response == ButtonType.OK)
        		.ifPresent(response->alert.close());
        	}
        	else {
        		System.out.println("Delele");
        		dt.removeNode(newnode);
        		dt.delAni(newnode).setOnFinished(finishHim ->{
        			displayPane.getChildren().remove(newnode.getLabel());
        		}
        				);
        		dt.delAni(newnode).play();
        	}
		}
	}
	
	private void deleteAvlTree() {
		if(checkInputNumber() == true) {
			int d = Integer.parseInt(InputField.getText());
			displayPane.getChildren().clear();
			((AVLTree)dt).remove(d);
			dt.nodelist.clear();
			((AVLTree)dt).preorder();
			((AVLTree)dt).drawNotAni(dt.nodelist,offset,fixset);
			System.out.println(dt.nodelist.size());
			for(int i=0;i<dt.nodelist.size();i++) {
				displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
				if(dt.nodelist.get(i).getArrowl()!=null&&dt.nodelist.get(i).getLeft()!=null)
				displayPane.getChildren().add(dt.nodelist.get(i).getArrowl());
				if(dt.nodelist.get(i).getArrowr()!=null&&dt.nodelist.get(i).getRight()!=null)
				displayPane.getChildren().add(dt.nodelist.get(i).getArrowr());
			}
		}
		InputField.clear();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void deleteBtree() {
		if(checkInputNumber() == true) {
			int d = Integer.parseInt(InputField.getText());
			displayPane.getChildren().clear();
			((Btree)dt).remove(d);
			dt.nodelist.clear();
			((Btree)dt).preorder();
			((Btree)dt).drawAni(dt.nodelist, offset, fixset);
			for(int i = 0 ; i < dt.nodelist.size(); i++) {
				displayPane.getChildren().remove(dt.nodelist.get(i).getLabel());
				displayPane.getChildren().add(dt.nodelist.get(i).getLabel());
				if(dt.nodelist.get(i).getArrows() != null && dt.nodelist.get(i).getChild().length != 0){
					displayPane.getChildren().remove(dt.nodelist.get(i).getArrows());
					displayPane.getChildren().addAll(dt.nodelist.get(i).getArrows());
				}			
			}
		}
		InputField.clear();
	}
	
	public void reArrangeLL() {
		Node node;
		for (int i = 0 ; i < dt.nodelist.size() ; i++) {
			node = dt.nodelist.get(i);
			offset = 25+(i)*(GlobalVar.LABEL_WIDTH+25);
			TranslateTransition move = new TranslateTransition();
			move.setDuration(Duration.millis(1000));
			move.setNode(node.getLabel());
			move.setToX(offset);
			move.setAutoReverse(false);
			move.play();
		}
	}
	
	public void reInsertFirst() {
		Node node;
		for(int i = 0 ; i < dt.nodelist.size() ; i++){
			node = dt.nodelist.get(i);
			offset = 25+(i)*(GlobalVar.LABEL_WIDTH+25);
			TranslateTransition move = new TranslateTransition();
			move.setDuration(Duration.millis(1000));
			move.setNode(node.getLabel());
			move.setToX(offset);
			move.setAutoReverse(false);
			move.play();
		}
	}

	public void exit(ActionEvent event){
		Platform.exit();
	}
	
	public void about() throws IOException {
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AboutPage.fxml"));
//		Parent root1 = (Parent) fxmlLoader.load();
//		Stage stage = new Stage();
//		stage.setScene(new Scene(root1));  
//		stage.show();
	}
	
	public void tutorial() throws IOException{
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Tutorial.fxml"));
//		Parent root1 = (Parent) fxmlLoader.load();
//		Stage stage = new Stage();
//		stage.setScene(new Scene(root1));  
//		stage.show();
	}

}

