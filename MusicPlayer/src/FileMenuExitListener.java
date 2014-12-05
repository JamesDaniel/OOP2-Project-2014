import java.awt.event.*;

class FileMenuExitListener implements ActionListener{
	private MusicManager manager;
	public FileMenuExitListener(MusicManager manager)
	{
		this.manager = manager;
	}
	public void actionPerformed(ActionEvent event)
	{
		manager.closeProgramAction();
	}
}
