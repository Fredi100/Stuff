import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import view.Window;

public class Logic {
	private static final String TOKEN = "a9dbded8c8e844c898e698795d4fd642";
	private static final String PLAYER_MATCHES = "https://www.haloapi.com/stats/h5/players/%s/matches";

	public static String playerMatches(String gt) throws IOException {
		return api(String.format(PLAYER_MATCHES, gt));
	}

	private static String api(String url) throws IOException {
		URL apiUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection) apiUrl.openConnection();
		urlConn.setRequestMethod("GET");
		urlConn.setRequestProperty("Ocp-Apim-Subscription-Key", TOKEN);
		String output = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			output += inputLine + "\n";
		}
		in.close();
		String printString = "";
		String indent = "";
		for(int i = 0;i < output.length();i++){
			char c = output.charAt(i);
			if(c == '{'){
				printString += c + "\n";
				indent += "  ";
				printString += indent;
			}else if(c == '}'){
				printString += c + "\n";
				indent = indent.substring(2);
				printString += indent;
			}else{
				printString += c;
			}
		}
		return printString;
	}

	public static void main(String[] args) {
		//TODO Rewrite the whole logic to incorporate with the new design
		Window w = new Window();
		w.pb.addPlayer("Test1");
		w.pb.addPlayer("Test2");
		w.pb.addPlayer("Test3");
		w.pb.addPlayer("Test4");
		w.pb.addPlayer("Test5");
		w.refreshWindow();
		w.displayPlayerView();
		w.setVisible(true);
		try {
			String stats = playerMatches("Fredi100");
			//JsonParser.parseString(stats);
		} catch (IOException e) {
			e.printStackTrace();
		}/* catch (ParseException e) {
			e.printStackTrace();
		}*/
	}
}