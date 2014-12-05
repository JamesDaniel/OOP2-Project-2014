import java.awt.event.*;
import javax.swing.*;

public class FileMenuOpenListener implements ActionListener{
	private MusicManager manager;
	public FileMenuOpenListener(MusicManager manager)
	{
		this.manager = manager;
	}
	public void actionPerformed(ActionEvent event)
	{
		manager.openFile();
	}
}
