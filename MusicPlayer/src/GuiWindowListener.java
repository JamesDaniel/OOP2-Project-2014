import java.awt.event.*;

public class GuiWindowListener extends WindowAdapter{
	private int answer;
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
