package main;
//GuiWindowListener.java
import java.awt.event.*;

public class GuiWindowListener extends WindowAdapter{
	private int answer;// this line is probably from an older version of my code
	private MusicManager manager;
	GuiWindowListener(MusicManager manager)
	{
		this.manager = manager;
	}
	public void windowClosing(WindowEvent event)
	{
		manager.closeProgramAction();
	}
}
