package core;

/**
 * Dient als Game Loop um einen kontinuierlichen Spielablauf zu gewährleisten.
 * 
 * @author Fredi100
 *
 */
public class GameLoop implements Runnable{
	
	private boolean running;
	private long delta;
	private long oldMilli, newMilli;
	
	public GameLoop(){
		delta = 1000 / 30;
	}
	
	public void setFPS(int fps){
		delta = 1000 / fps;
	}
	
	public void run(){
		running = true;
		oldMilli = System.currentTimeMillis();
		newMilli = System.currentTimeMillis();
		while(running){
			
			//--- Stuff that gets looped ---//
			
			
			//TODO Hier alles rein schreiben, dass gelooped werden soll.
			
			
			
			this.fillTick();
			oldMilli = newMilli;
		}
	}
	
	/**
	 * Waits until enough time has passed to stay inside the given FPS
	 */
	private void fillTick(){
		while(newMilli - oldMilli < delta){
			newMilli = System.currentTimeMillis();
		}
	}
	
	public void stop(){
		running = false;
	}
	
	
	
	public static void main(String[] args) {
		//TODO Muss GameLoop noch in eigenen Thread verpacken
		GameLoop gl = new GameLoop();
		gl.setFPS(60);
		new Thread(gl).start();
	}
}
