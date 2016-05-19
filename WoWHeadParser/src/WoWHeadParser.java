import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WoWHeadParser {

	private Document doc;

	private String profession; //The name of the profession
	private String professionLevel; //The needed level in that profession
	private String charLevel; //The needed level of the character
	private String professionName; //The name of the spell for this profession
	private String professionSpellId; //The DB id of this spell
	private String professionCost; //The cost to learn this spellsgit

	public WoWHeadParser(String link) throws IOException {
		this.doc = Jsoup.connect(link).get();
		this.setProfession("");
		setProfessionLevel("");
		setCharLevel("0");
		setProfessionName("");
		setProfessionSpellId("");
		setProfessionCost("");

		Element el = doc.getElementsByClass("infobox").first();

		Element script = el.getElementsByTag("script").first();
		String html = script.toString();
		String[] splits = html.split("x20");
		this.setProfession(splits[1].substring(0, splits[1].length() - 1));

		String[] hilfe = splits[2].split("5B");
		this.setProfessionLevel(hilfe[0].substring(4, hilfe[0].length() - 6));

		hilfe = splits[5].split("3D")[1].split("5D");
		this.setProfessionCost(hilfe[0].substring(0, hilfe[0].length() - 2));

		Elements meta = doc.getElementsByTag("meta");

		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:title")) {
				this.setProfessionName(metaelem.attr("content"));
			} else if (name.equals("og:url")) {
				String id = metaelem.attr("content");
				this.setProfessionSpellId(id.split("=")[1].split("/")[0]);
			}
		}
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionSpellId() {
		return professionSpellId;
	}

	public void setProfessionSpellId(String professionSpellId) {
		this.professionSpellId = professionSpellId;
	}

	public String getProfessionCost() {
		return professionCost;
	}

	public void setProfessionCost(String professionCost) {
		this.professionCost = professionCost;
	}

	public String getProfessionLevel() {
		return professionLevel;
	}

	public void setProfessionLevel(String professionLevel) {
		this.professionLevel = professionLevel;
	}

	public String getCharLevel() {
		return charLevel;
	}

	public void setCharLevel(String charLevel) {
		this.charLevel = charLevel;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
}
