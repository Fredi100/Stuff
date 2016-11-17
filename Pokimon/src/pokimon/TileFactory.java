package pokimon;

/**
 * Used to create a tile with the given tileset information. Contains a 3D Array
 * to store any tile created
 * 
 * @author Fredi100
 *
 */
public class TileFactory {

	private Tile[][][] tiles;

	private static final int MAX_TILE_SETS = 10;
	private static final int MAX_TILE_SET_WIDTH = 10;
	private static final int MAX_TILE_SET_HEIGHT = 10;

	public TileFactory() {
		tiles = new Tile[MAX_TILE_SETS][MAX_TILE_SET_WIDTH][MAX_TILE_SET_HEIGHT];
	}

	public Tile getTile(int tileSet, int x, int y) {
		Tile tile = null;
		try {
			tile = tiles[tileSet][x][y];
			if (tile == null) {
				// TODO Hier jetzt tiles set korrdinaten verwenden, um aus dem
				// tileset das richtige bild zu extrahieren. dafür immer die
				// breite und höhe sowie position berechnen.
				// Davor aber abfragen, ob dieses tile schon mal erzeugt wurde
				// und dann zurück geben.
			}
		} catch (IndexOutOfBoundsException e) {
			//TODO Hier auf ein default Tile ändern
			tile = null;
		}
		return tile;
	}
}
