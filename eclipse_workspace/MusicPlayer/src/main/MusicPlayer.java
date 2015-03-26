package main;
//MusicPlayer.java
//James McGarr

public class MusicPlayer {
  
  public static void main(String[] args) {
  	
  	Gui gui = new Gui();
  	gui.setVisible(true);  // strange anomaly. If I set Visible to true in the Gui class, then everything is hidden until I resize the window.
  }
}
