import javazoom.jl.player.Player;


// I learned how to create threads like this from https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
public class Music extends Player implements Runnable{
	MusicManager manager;
	public Music(MusicManager manager) throws Exception
	{
			super(manager.getFileInputStream(manager.getFile()));
			this.manager = manager;
	}
	public void run()
	{
		System.out.println("Test thread run");
		try
		{
			while (super.play(1))
			{
				setPlayDuration();
				if (!manager.getCheckPlayCondition())
				{
					super.close();
				}
			}
			manager.changeBtnImage(manager.getImage1());
			manager.setCheckPlayCondition(false);
		}
		catch (Exception ex)
		{
		}
	}
	private synchronized void setPlayDuration()
	{
		manager.playDuration = super.getPosition();
	}
}
