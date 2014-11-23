//TestDrawing.java
//James McGarr
/*  */
import javax.swing.*;
public class TestDrawing extends JFrame{
	TestDrawing()
	{
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		add(panel);
	}
	public void paint()
	{
		
	}
	public static void main(String args[])
	{
		TestDrawing guiApp = new TestDrawing();
		guiApp.setVisible(true);
	}
}