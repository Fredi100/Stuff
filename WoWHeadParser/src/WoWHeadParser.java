import java.io.IOException;
import java.net.SocketTimeoutException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WoWHeadParser {

	private Document doc;

	private String profession; //Der Name des Jobs
	private String professionLevel; //Die Stufe des Jobs
	private String charLevel; //Die benötigte Stufe des Charakters
	private String professionName; //
	private String professionSpellId; //Die Spell ID dieses Spells
	private String professionCost; //Die Kosten zum lernen dieses Spells

	public WoWHeadParser(String link) throws IOException {
		this.doc = Jsoup.connect(link).get();
		this.profession = "";
		professionLevel = "";
		charLevel = "0";
		professionName = "";
		professionSpellId = "";
		professionCost = "";

		Element el = doc.getElementsByClass("infobox").first();

		Element script = el.getElementsByTag("script").first();
		String html = script.toString();
		String[] splits = html.split("x20");
		this.profession = splits[1].substring(0, splits[1].length() - 1);

		String[] hilfe = splits[2].split("5B");
		this.professionLevel = hilfe[0].substring(4, hilfe[0].length() - 6);

		hilfe = splits[5].split("3D")[1].split("5D");
		this.professionCost = hilfe[0].substring(0, hilfe[0].length() - 2);

		Elements meta = doc.getElementsByTag("meta");

		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:title")) {
				this.professionName = metaelem.attr("content");
			} else if (name.equals("og:url")) {
				String id = metaelem.attr("content");
				this.professionSpellId = id.split("=")[1].split("/")[0];
			}
		}
	}

	public static void main(String[] args) {
		boolean running = true;
		String eingabe = "";
		String ausgabe = "";
		while (running) {
			eingabe = Eingabe.getEingabe("Bitte den Link zur Website geben.\r\nOder \"Exit\" schreiben um zu beenden.");
			if(eingabe == null || eingabe.equals("Exit")){
				System.out.println("Programm wird beendet!");
				System.exit(0);
			}
			try {
				WoWHeadParser wow = new WoWHeadParser(eingabe);
				ausgabe = "(" + wow.profession + "," + wow.professionSpellId + "," + wow.professionCost + ","
						+ wow.profession + "Skill," + wow.professionLevel + "," + wow.charLevel + "), -- Spell "
						+ wow.professionName;
				System.out.println(ausgabe);
			} catch (HttpStatusException e) {
				System.err.println(e.toString());
				System.out.println(e.getStatusCode());
				if (e.getStatusCode() == 500) {
					System.err.println("HTTP: " + e.getStatusCode()
							+ "\r\nEs kam zu einem nicht erwarteten serverseitigem Fehler der Website!");
				} else if (e.getStatusCode() == 503) {
					System.err.println(
							"HTTP: " + e.getStatusCode() + "\r\nDer verlangte Dienst ist zur Zeit nicht verfügbar!");
				}
			} catch (SocketTimeoutException e) {
				System.err.println(e.toString());
			} catch (IllegalArgumentException e){
				System.err.println(e.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
