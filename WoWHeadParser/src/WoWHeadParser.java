import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WoWHeadParser {
	
	public static String parseLink(String link) throws IOException{
		Document doc = Jsoup.connect(link).get();

		Element el = doc.getElementsByClass("infobox").first();
		Element script = el.getElementsByTag("script").first();

		String[] splits = script.toString().split("x20");

		String profession = prepareProfession(splits);

		String professionlevel = prepareProfessionLevel(splits);

		String professionCost = prepareProfessionCost(splits);

		String professionName = prepareProfessionName(doc);
		
		String professionSpellId = prepareProfessionSpellId(doc);
		
		String charLevel = prepareCharLevel();
		
		return "(" + profession + "," + professionSpellId + "," + professionCost + "," + profession + "Skill," + professionlevel + "," + charLevel + "), -- Spell " + professionName;
	}

	/**
	 * Extracts the profession of the given spell
	 */
	public static String prepareProfession(String[] splits) {
		return splits[1].substring(0, splits[1].length() - 1);
	}

	/**
	 * Extracts the spell id of the given spell
	 */
	public static String prepareProfessionSpellId(Document doc) {
		Elements meta = doc.getElementsByTag("meta");
		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:url")) {
				String id = metaelem.attr("content");
				return id.split("=")[1].split("/")[0];
			}
		}
		return "NOTFOUND";
	}

	/**
	 * Extracts the cost of the given spell to learn it
	 */
	public static String prepareProfessionCost(String[] splits) {
		String[] hilfe = splits[2].split("5B");
		hilfe = splits[5].split("3D")[1].split("5D");
		return hilfe[0].substring(0, hilfe[0].length() - 2);
	}

	/**
	 * Extracts the level of the profession needed to learn this spell
	 */
	public static String prepareProfessionLevel(String[] splits) {
		String[] hilfe = splits[2].split("5B");
		return hilfe[0].substring(4, hilfe[0].length() - 6);
	}

	/**
	 * Currently sets the char level to 0
	 */
	public static String prepareCharLevel() {
		return "0";
	}

	/**
	 * Extracts the name of the given spell
	 * @return 
	 */
	public static String prepareProfessionName(Document doc) {
		Elements meta = doc.getElementsByTag("meta");
		for (Element metaelem : meta) {
			String name = metaelem.attr("property");
			if (name.equals("og:title")) {
				return metaelem.attr("content");
			}
		}
		return "NOTFOUND";
	}
	
	public static ArrayList<String> parseArrayList(ArrayList<String> links) throws IOException{
		ArrayList<String> output = new ArrayList<String>();
		for(String line : links){
			output.add(parseLink(line));
		}
		return output;
	}
}
