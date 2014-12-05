//MusicPlayer.java
//James McGarr
 
// to do: test if I can access the methods of 
// the Music class through the object reference 
// from when the thread is created.

// to do: there is a but when you try to play
// a new song while a song is already playing.

// to do: add a playlist class


public class MusicPlayer {
    
    public static void main(String[] args) {
    	
    	Gui gui = new Gui();
    	gui.setVisible(true);  // strange anomaly. If I set Visible to true in the Gui class, then everything is hidden until I resize the window.
    }
}
