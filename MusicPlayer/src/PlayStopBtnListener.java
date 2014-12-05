import java.awt.event.*;

public class PlayStopBtnListener implements ActionListener{
	private MusicManager manager;
	public PlayStopBtnListener(MusicManager manager)
	{
		this.manager = manager;
	}
	public void actionPerformed(ActionEvent event)
	{
		if (!manager.getCheckPlayCondition())
		{
			if (!manager.getFileExists())
			{
				manager.openFile();
			}
			if (manager.getFileExists())
			{
				manager.playMusic();
				manager.startUpdateLabel();
				manager.changeBtnImage(manager.getImage2());
				manager.setCheckPlayCondition(true);
			}
		}
		else
		{
		//	System.out.println("test2");
			manager.stopPlay();
			manager.changeBtnImage(manager.getImage1());
			manager.setCheckPlayCondition(false);
		}
	}
}