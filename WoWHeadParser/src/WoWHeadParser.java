import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WoWHeadParser {

	private Document doc;
	private String[] splits;

	private String profession; // The name of the profession
	private String professionLevel; // The needed level in that profession
	private String charLevel; // The needed level of the character
	private String professionName; // The name of the spell for this profession
	private String professionSpellId; // The DB id of this spell
	private String professionCost; // The cost to learn this spell

	public WoWHeadParser(String link) throws IOException {
		this.doc = Jsoup.connect(link).get();
		this.profession = "";
		this.professionLevel = "";
		this.charLevel = "0";
		this.professionName = "";
		this.professionSpellId = "";
		this.professionCost = "";

		Element el = doc.getElementsByClass("infobox").first();
		Element script = el.getElementsByTag("script").first();

		this.splits = script.toString().split("x20");

		this.prepareProfession();

		this.prepareProfessionLevel();

		this.prepareProfessionCost();

		this.prepareProfessionName();
		
		this.prepareProfessionSpellId();
		
		this.prepareCharLevel();
	}

	/**
	 * Returns the extracted name of the profession of the given spell
	 * 
	 * @return The extracted name of the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * Extracts the profession of the given spell
	 */
	public void prepareProfession() {

		this.profession = this.splits[1].substring(0, this.splits[1].length() - 1);
	}

	/**
	 * Returns the extracted spell id of the given spell
	 * 
	 * @return The spell id
	 */
	public String getProfessionSpellId() {
		return professionSpellId;
	}

	/**
	 * Extracts the spell id of the given spell
	 */
	public void prepareProfessionSpellId() {
		Elements meta = doc.getElementsByTag("meta");
		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:url")) {
				String id = metaelem.attr("content");
				this.professionSpellId = id.split("=")[1].split("/")[0];
			}
		}
	}

	/**
	 * Returns the extracted cost of this spell to learn it
	 * 
	 * @return The extracted cost
	 */
	public String getProfessionCost() {
		return professionCost;
	}

	/**
	 * Extracts the cost of the given spell to learn it
	 */
	public void prepareProfessionCost() {
		String[] hilfe = splits[2].split("5B");
		hilfe = splits[5].split("3D")[1].split("5D");
		this.professionCost = hilfe[0].substring(0, hilfe[0].length() - 2);
	}

	/**
	 * Returns the extracted level of the profession needed to learn this spell
	 * 
	 * @return The extracted profession level
	 */
	public String getProfessionLevel() {
		return professionLevel;
	}

	/**
	 * Extracts the level of the profession needed to learn this spell
	 */
	public void prepareProfessionLevel() {
		String[] hilfe = splits[2].split("5B");
		this.professionLevel = hilfe[0].substring(4, hilfe[0].length() - 6);
	}

	/**
	 * Returns the needed char level to learn this spell
	 * 
	 * @return The needed char level
	 */
	public String getCharLevel() {
		return charLevel;
	}

	/**
	 * Currently sets the char level to 0
	 */
	public void prepareCharLevel() {
		this.charLevel = "0";
	}

	/**
	 * Returns the extracted name of the given spell
	 * 
	 * @return the name of the given spell
	 */
	public String getProfessionName() {
		return professionName;
	}

	/**
	 * Extracts the name of the given spell
	 */
	public void prepareProfessionName() {
		Elements meta = doc.getElementsByTag("meta");
		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:title")) {
				this.professionName = metaelem.attr("content");
			}
		}
	}
}
