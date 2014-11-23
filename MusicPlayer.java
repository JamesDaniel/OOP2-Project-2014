//MusicPlayer.java
//James McGarr
/*   This program will:
 *   load mp3 file,
 *   remember where those files are stored,
 *   play those files.
 *   OPTIONALLY:
 *   have a play bar to show play progress.*/
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.File;
 import java.awt.image.BufferedImage;
 import javax.imageio.ImageIO;
 import java.io.IOException;
public class MusicPlayer extends JFrame implements ActionListener{
	//attributes
	private static int checkPlayCondition=0;
	JMenu file;
	JMenu edit;
	private BufferedImage image1;
	private BufferedImage image2;
	private JButton playPause;
	
	MusicPlayer(){
		setTitle("Music Player");
		setSize(600,100);
		setResizable(false);
		setVisible(true);
		setLocation(300,200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c1 = getContentPane();
		c1.setLayout(new FlowLayout());
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		createFileMenu();
		createEditMenu();
		menuBar.add(file);
		menuBar.add(edit);
		
		image1 = scaleImage(39, 39, "button_blue_play.png");  //   http://findicons.com/icon/176085/button_blue_pause
		image2 = scaleImage(39, 39, "button_blue_pause.png"); //   http://findicons.com/icon/175990/button_blue_play
		
		playPause = new JButton(new ImageIcon(image1));
		playPause.setPreferredSize(new Dimension(39,39));
		playPause.addActionListener(this);
		
	//	playPause.setTitle(new ImageIcon(image));
		c1.add(playPause);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(472,39));
		panel.setBackground(Color.RED);
		c1.add(panel);
		
		JLabel playTime = new JLabel("00:00-00:00");
		c1.add(playTime);
	}
	public void createFileMenu(){
		file = new JMenu("File");
		JMenuItem item;
		item = new JMenuItem("Open");
		item.addActionListener(this);
		file.add(item);
		
		item = new JMenuItem("Exit");
		item.addActionListener(this);
		file.add(item);
	}
	public void createEditMenu(){
		edit = new JMenu("Edit");
		JMenuItem item;
		item = new JMenuItem("Next Song");
		item.addActionListener(this);
		edit.add(item);
		
		item = new JMenuItem("Prev Song");
		item.addActionListener(this);
		edit.add(item);
	}
	public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename)  // this method code is from stackoverflow.com/questions/12475503/how-to-change-the-size-of-an-image
	{
    	BufferedImage bi = null;
    	try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
        	bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        	Graphics2D g2d = (Graphics2D) bi.createGraphics();
        	g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        	g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
    		} catch (Exception e) 
    			{
        			e.printStackTrace();
	        		return null;
    			}
    	return bi;
    }    
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == playPause)
		{
			if (checkPlayCondition == 0)
			{
		    	playPause.setIcon(new ImageIcon(image2));
		    	checkPlayCondition = 1;
			}
			else
			{
		    	playPause.setIcon(new ImageIcon(image1));
		    	checkPlayCondition = 0;
			}
				
		}
	}
	public static void main(String args[])
	{
		MusicPlayer guiApp = new MusicPlayer();
		guiApp.setVisible(true);
	}
}