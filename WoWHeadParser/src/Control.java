import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.SocketTimeoutException;

import org.jsoup.HttpStatusException;

public class Control implements KeyListener, FocusListener, MouseListener {

	private Gui g;

	public Control() {
		g = new Gui(this);
	}

	public String startRequest(String link) throws IOException {
		WoWHeadParser wow = new WoWHeadParser(link);
		return "(" + wow.getProfession() + "," + wow.getProfessionSpellId() + "," + wow.getProfessionCost() + ","
				+ wow.getProfession() + "Skill," + wow.getProfessionLevel() + "," + wow.getCharLevel() + "), -- Spell "
				+ wow.getProfessionName();
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}

	/**
	 * Not needed so far
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getSource().equals(g.getEingabe())) {
			if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
				try {
					String output = this.startRequest(g.getEingabe().getText());
					g.getEingabe().setText("");
					g.getEingabe().transferFocus();
					g.setOutput(output + "\r\n");
				} catch (HttpStatusException e) {
					g.setError(e.toString() + "\r\n" + e.getStatusCode());
					if (e.getStatusCode() == 500) {
						g.setError("HTTP: " + e.getStatusCode()
								+ "\r\nEs kam zu einem nicht erwarteten serverseitigem Fehler der Website!");
					} else if (e.getStatusCode() == 503) {
						g.setError("HTTP: " + e.getStatusCode()
								+ "\r\nDer verlangte Dienst ist zur Zeit nicht verfügbar!");
					}
				} catch (StringIndexOutOfBoundsException e) {
					g.setError(e.toString());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					g.setError("This Spells is not compatible so far!");
				} catch (SocketTimeoutException e) {
					g.setError(e.toString());
				} catch (IllegalArgumentException e) {
					g.setError(e.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Control();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(g.getEingabe())) {
			g.getEingabe().setText("");
		}
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(g.getEingabe())) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				Clipboard zwischenablage = Toolkit.getDefaultToolkit().getSystemClipboard();
				Transferable transferData = zwischenablage.getContents("");
				for (DataFlavor dataFlavor : transferData.getTransferDataFlavors()) {
					try {
						Object content = transferData.getTransferData(dataFlavor);
						if (content instanceof String) {
							g.getEingabe().setText((String) content);
							g.getEingabe().requestFocusInWindow();
							break;
						}
					} catch (UnsupportedFlavorException | IOException e1) {
						e1.printStackTrace();
					}

				}

			}
		}
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	/**
	 * Not needed so far
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
