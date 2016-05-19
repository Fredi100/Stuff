import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;

public class Control implements KeyListener{
	
	private Gui g;
	
	public Control(){
		g = new Gui(this);
	}
	
	public String abfrageDurchführen(String link) throws IOException{
		WoWHeadParser wow = new WoWHeadParser(link);
		return "(" + wow.getProfession() + "," + wow.getProfessionSpellId() + "," + wow.getProfessionCost() + ","
				+ wow.getProfession() + "Skill," + wow.getProfessionLevel() + "," + wow.getCharLevel() + "), -- Spell "
				+ wow.getProfessionName();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if(ke.getSource().equals(g.eingabe)){
			if(ke.getKeyChar() == KeyEvent.VK_ENTER){
				try {
					String output = this.abfrageDurchführen(g.getEingabe().getText());
					g.getEingabe().setText("");
					g.setOutput(output);
				} catch (HttpStatusException e) {
					g.setError(e.toString() + "\r\n" + e.getStatusCode());
					if (e.getStatusCode() == 500) {
						g.setError("HTTP: " + e.getStatusCode()
								+ "\r\nEs kam zu einem nicht erwarteten serverseitigem Fehler der Website!");
					} else if (e.getStatusCode() == 503) {
						g.setError(
								"HTTP: " + e.getStatusCode() + "\r\nDer verlangte Dienst ist zur Zeit nicht verfügbar!");
					}
				} catch (SocketTimeoutException e) {
					g.setError(e.toString());
				} catch (IllegalArgumentException e){
					g.setError(e.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Control c = new Control();
	}
}
