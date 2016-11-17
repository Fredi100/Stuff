package pokimon;

/**
 * Represents one graphical tile inside the game
 * 
 * @author Fredi100
 *
 */
public class Tile {

	private static Tile defaultTile;

	// TODO Verlinkung auf eine grafik

	public Tile(int tileSet, int x, int y) {
		//TODO Hier anhand der übergebenen Koordinaten das richtige File finden
		//Hätte es so gemacht, ein tileset ist einfach ein Ordner
		//Jedes tile hat einfach nur ne Nummer
	}

	public Tile getDefault() {
		if (defaultTile == null) {
			defaultTile = new Tile(0, 0, 0);
		}
		return defaultTile;
	}
}
