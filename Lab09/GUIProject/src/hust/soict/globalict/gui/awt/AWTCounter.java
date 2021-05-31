package hust.soict.globalict.gui.awt;
import java.awt.*;
import java.awt.event.*;
public class AWTCounter extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Label lblCount;
	private TextField tfCount;
	private Button btnCount;
	private int count=0;
	public AWTCounter() {
		setLayout(new FlowLayout());
		
		lblCount = new Label("Counter");
		add(lblCount);
		
		tfCount = new TextField(count + "",10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCount = new Button("Count");
		add(btnCount);
		btnCount.addActionListener(this);
		setTitle("AWT Counter");
		setSize(250,100);
		
		setVisible(true);
	}
	public void CloseWindow() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		AWTCounter app = new AWTCounter();
		app.CloseWindow();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		++count;
		tfCount.setText(count + "");
	}
}
