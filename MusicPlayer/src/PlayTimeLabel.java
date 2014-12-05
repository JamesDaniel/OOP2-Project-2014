
// I learned how to create threads like this from https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
public class PlayTimeLabel implements Runnable{
	private MusicManager manager;
	private String minutes;
	private String seconds;
	private String formattedSongLength;
	
	public PlayTimeLabel(MusicManager manager)
	{
			this.manager = manager;
	}
	public void run()  // unknown thread anomaly. Two threads are created when the thread oject is created.
	{
		System.out.println("Test 'update music time' label thread run");
		try
		{
			
			if (getSongFileLength()/1000212 < 60) // the getSongFileLength() method returns an accuracy of over a millionth of a second.
			{
				minutes = "00";
				if (getSongFileLength()/1000212 <10)
					seconds = "0" + getSongFileLength()/1000212;
				else
					seconds = getSongFileLength()/1000212 + "";
			}
			else if (getSongFileLength()/1000212 >= 60) 
			{
				minutes = "0" + ((int)((getSongFileLength()/1000212)/60)) + "";   // this is assuming no song will be longer than 9mins 59 secs
				seconds = (getSongFileLength()/1000212)-(((getSongFileLength()/1000212)/60)*60) + "";
				if (Integer.parseInt(seconds) < 10)
					seconds = "0" + seconds;
			}
			formattedSongLength = minutes + ":" + seconds;
			
			
			
			
			while (getCheckPlayCondition())
			{
				if (getPlayDuration()/1000 < 60)
				{
					minutes = "00";
					if (getPlayDuration()/1000 <10)
						seconds = "0" + getPlayDuration()/1000;
					else
						seconds = getPlayDuration()/1000 + "";
				}
				else if (getPlayDuration()/1000 >= 60) 
				{
					minutes = "0" + ((int)((getPlayDuration()/1000)/60)) + "";   // this is assuming no song will be longer than 9mins 59 secs
					seconds = (getPlayDuration()/1000)-(((getPlayDuration()/1000)/60)*60) + "";
					if (Integer.parseInt(seconds) < 10)
						seconds = "0" + seconds;
				}
				setPlayTimeLabelText(minutes + ":" + seconds + "-" + formattedSongLength);   
				Thread.sleep(10);   // this updates the play time label every 10 milliseconds
			}
			setPlayTimeLabelText("00:00-00:00");
		}
		catch (Exception ex)
		{
		}
	}
	private synchronized int getPlayDuration()
	{
		return manager.playDuration;
	}
	private synchronized boolean getCheckPlayCondition()
	{
		return manager.checkPlayCondition;
	}
	private synchronized void setPlayTimeLabelText(String newText)
	{
		manager.setPlayTimeLabelText(newText);
	}
	private synchronized Long getSongFileLength()      
	{
		return manager.getSongFileLength();
	}
}
