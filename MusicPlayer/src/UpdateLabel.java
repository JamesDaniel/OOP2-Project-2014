import javax.swing.*;
public class UpdateLabel extends Thread{
	private Thread t;
	private String threadName;
	private JLabel playTime;
	private String minutes;
	private String seconds;
	
	public UpdateLabel(String threadName, JLabel playTime)
	{
		this.threadName = threadName;
		this.playTime = playTime;
	}
	public void run()
	{
		try
		{
			while (Music.getCheckPlayCondition())
			{
				if (Music.getPlayDuration()/1000 < 60)
				{
					minutes = "00";
					if (Music.getPlayDuration()/1000 <10)
						seconds = "0" + Music.getPlayDuration()/1000;
					else
						seconds = Music.getPlayDuration()/1000 + "";
				}
				else if (Music.getPlayDuration()/1000 >= 60)
				{
					minutes = "0" + ((int)((Music.getPlayDuration()/1000)/60)) + "";   // this is assuming no song will be longer than 9mins 59 secs
					seconds = (Music.getPlayDuration()/1000)-(((Music.getPlayDuration()/1000)/60)*60) + "";
					if (Integer.parseInt(seconds) < 10)
						seconds = "0" + seconds;
				}
				playTime.setText(minutes + ":" + seconds + "-00:00");    
				//System.out.println(Music.getPlayDuration()/1000);
				Thread.sleep(10);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Doh! JLabel");
		}
	}
	public void start()  // I got this method from http://www.tutorialspoint.com/java/java_multithreading.htm
	{
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start();
		}
	}
}
