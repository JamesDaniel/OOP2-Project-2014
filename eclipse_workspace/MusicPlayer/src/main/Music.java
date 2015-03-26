package main;
//Music.java
import javazoom.jl.player.Player;
	/*****************************************************
*    Title:  jl1.0.jar , line 2
*    Author: JLayer
*    Site owner/sponsor:  http://www.java2s.com/
*    Date: 07/12/2014 10:00:00
*    Code version:  1.0
*    Availability:  http://www.java2s.com/Code/Jar/j/Downloadjl10jar.htm
*    Modified:  Code used (library used)
*****************************************************/

	/*****************************************************
*    Title:  jl1.0.jar , line 22-53
*    Author: The Java Tutorials
*    Site owner/sponsor:  https://docs.oracle.com
*    Date: 07/12/2014 10:00:00
*    Code version:  1.0
*    Availability:  https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
*    Modified:  Code refactored (This is where I learned to make a thread this way)
*****************************************************/
public class Music extends Player implements Runnable{
	MusicManager manager;
	public Music(MusicManager manager) throws Exception
	{
			super(manager.getFileInputStream(manager.getFile()));
			this.manager = manager;
	}
	public void run()
	{
		System.out.println("t1.run() CALLED");
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
